package weka.filters.unsupervised.instance;

import weka.filters.Filter;
import weka.filters.UnsupervisedFilter;
import weka.core.AttributeStats;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.neighboursearch.LinearNNSearch;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.OptionHandler;
import weka.core.Option;
import weka.core.Utils;
import java.util.Random;
import java.util.Enumeration;
import java.util.Vector;
/** 
 <!-- globalinfo-start -->
 * Implements a SMOTE over-sampling algorithm. The minority classes are over-sampled by creating “synthetic” examples
 * <p/>
 <!-- globalinfo-end -->
 * 
 <!-- options-start -->
 * Valid options are: <p/>
 * 
 * <pre> -N &lt;num&gt;
 *  Specify the SMOTE over-sampling factor (default 1)</pre>
 * 
 * <pre> -K &lt;num&gt;
 *  Specify the factor of nearest neighbors for each
 *  minority class sample (default 2)</pre>
 * 
 *  <pre> -I
 *  Inverts percent values for minority classes</pre>
 * 
 * <pre> -P &lt;num&gt;
 *  Specify a percent value to decide when a class  
 *  is a minority class (default 50)</pre>
 *  
 <!-- options-end -->
 *
 * @author 
 * @version $Revision: 1.0 $ 
 */

public class SMOTE 
  extends Filter 
  implements UnsupervisedFilter, OptionHandler {   

    /** for serialization */
    private static final long serialVersionUID = 10L;

    /** The random number generator seed */
    private int m_RandomSeed = 1;

    /**SMOTE over-sampling factor*/
    public int m_SmoteFactor = 1;

    /** Percent to decide if a class is a minority class */
    private double m_percentForMinority = 50.0;

    /** Inverts percent values for minority classes*/
    private boolean m_InvertMinorityWeights = false;

    /**Factor for nearest neighbors generation*/
    private int m_kNeighborsFactor = 5;

    /**
     * Returns a string describing this classifier
     * 
     * @return a description of the classifier suitable for
     * displaying in the explorer/experimenter gui
     */
    public String globalInfo() {		
            return "Produces “synthetic” examples for the imbalanced classes using SMOTE algorithm";
    }	
    
    /**
     * Returns an enumeration describing the available options.
     *
     * @return an enumeration of all the available options.
     */    
    public Enumeration listOptions() {          
        Vector newVector = new Vector();
        newVector.addElement(new Option(
            "\tSpecify the SMOTE over-sampling factor (default 1)",
            "N", 3, "-N <num>"));
        newVector.addElement(new Option(
            "\tSpecify the factor of nearest neighbors for each\n"
            +"\tminority class sample (default 5)",
            "K", 3, "-K <num>"));
        newVector.addElement(new Option(
            "\tInverts percent values for minority classes (default = no)",
            "I", 0, "-I "));
        newVector.addElement(new Option(
            "\tSpecify a percent value to decide when a class\n"
            +"\tis a minority class (default 50)",
            "P", 5, "-P <num>"));

        return newVector.elements();		
    }
    /**
     * Parses a given list of options. <p/>
     * 
     <!-- options-start -->
     * Valid options are: <p/>
     * 
     * <pre> -N &lt;num&gt;
     *  Specify the SMOTE over-sampling factor (default 1)</pre>
     * 
     * <pre> -K &lt;num&gt;
     *  Specify the factor of nearest neighbors for each
     *  minority class sample (default 2)</pre>
     * 
     * <pre> -P &lt;num&gt;
     *  Specify a percent value to decide when a class  
     *  is a minority class (default 50)</pre>
     *  
     * <pre> -I
     *  Inverts percent values for minority classes</pre>
     *    
     <!-- options-end -->
     *
     * @param options the list of options as an array of strings
     * @throws Exception if an option is not supported
     */
    public void setOptions(String[] options) throws Exception {
        String sOption = Utils.getOption('N', options);
        if (sOption.length() != 0) {
            setSmoteFactor(Integer.parseInt(sOption));
        } else {
            setSmoteFactor(1);
        }
        sOption = Utils.getOption('K', options);
        if (sOption.length() != 0) {
            setKNeighborsFactor(Integer.parseInt(sOption));
        } else {
            setKNeighborsFactor(5);
        }
        
        setInvertMinorityWeights(Utils.getFlag('I', options));
        
        sOption = Utils.getOption('P', options);
        if (sOption.length() != 0) {
            setPercentForMinority(Double.valueOf(sOption).doubleValue());
        } else {
            setPercentForMinority(5);
        }

        if (getInputFormat() != null) {
            setInputFormat(getInputFormat());
        }
    }
    /**
     * Gets the current settings of the filter.
     *
     * @return an array of strings suitable for passing to setOptions
    */
    public String[] getOptions() {
        Vector<String>	vOptions;
        vOptions = new Vector<String>();
        vOptions.add("-N"); 
        vOptions.add("" + getSmoteFactor());
        vOptions.add("-K"); 
        vOptions.add("" + getKNeighborsFactor());
        
        if(getInvertMinorityWeights()){
            vOptions.add("-I"); 
        }
        vOptions.add("-P"); 
        vOptions.add("" + getPercentForMinority());
        return vOptions.toArray(new String[vOptions.size()]);		
    }
   /**
    * Returns the tip text for this property
    * 
    * @return tip text for this property suitable for
    * displaying in the explorer/experimenter gui
    */
    public String randomSeedTipText() {
        return "The seed used for random sampling.";
    }
    /**
     * Gets the random number seed.
     *
     * @return the random number seed.
     */
    public int getRandomSeed() {
        return m_RandomSeed;
    }
    /**
     * Sets the random number seed.
     *
     * @param newSeed the new random number seed.
     */
    public void setRandomSeed(int newSeed) {
        m_RandomSeed = newSeed;
    }
   /**
    * Returns the tip text for this property
    * 
    * @return tip text for this property suitable for
    * displaying in the explorer/experimenter gui
    */
    public String smoteFactorTipText() {
        return "The SMOTE over-sampling factor.";
    }
    /**
     * Gets the SMOTE over-sampling factor
     *
     * @return the SMOTE over-sampling factor
     */
    public int getSmoteFactor() {
        return m_SmoteFactor;
    }
    /**
     * Sets the SMOTE over-sampling factor
     *
     * @param nSmoteFactor the SMOTE over-sampling factor
     */    
    public void setSmoteFactor(int nSmoteFactor) {
        if(nSmoteFactor > 0)
            m_SmoteFactor = nSmoteFactor;
        else
            throw new IllegalArgumentException("SMOTE factor must be at least 1");
    }
   /**
    * Returns the tip text for this property
    * 
    * @return tip text for this property suitable for
    * displaying in the explorer/experimenter gui
    */
    public String KNeighborsFactorTipText() {
        return "The factor of nearest neighbors for each minority class sample.";
    }    
    /**
     * Gets the factor of nearest neighbors for each minority class sample
     *
     * @return the factor of nearest neighbors for each minority class sample
     */    
    public int getKNeighborsFactor(){
        return m_kNeighborsFactor;
    }
    /**
     * Sets the factor of nearest neighbors for each minority class sample
     *
     * @param nKNF factor of nearest neighbors for each minority class sample
     */  
    public void setKNeighborsFactor(int nNeighbors){
        if(nNeighbors > 0)
            m_kNeighborsFactor = nNeighbors;
        else
            throw new IllegalArgumentException("k factor must be at least 1");       
    }
    /**
     * Returns the tip text for this property
     * 
     * @return tip text for this property suitable for
     * displaying in the explorer/experimenter gui
     */
    public String invertMinorityWeightsTipText() {
        return "Inverts percent values for minority classes.";
    }   
    /**
     * Gets if the percent values for minority classes must be inverted
     *
     * @return if the percent values for minority classes must be inverted
     */    
    public boolean getInvertMinorityWeights(){
        return m_InvertMinorityWeights;
    }
    /**
     * Sets if the percent values for minority classes must be inverted
     *
     * @param bInvert true if the percent values for minority classes must be inverted
     */     
    public void setInvertMinorityWeights(boolean bInvert){
        m_InvertMinorityWeights = bInvert;
    }
    /**
     * Returns the tip text for this property
     * 
     * @return tip text for this property suitable for
     * displaying in the explorer/experimenter gui
     */
    public String percentForMinorityTipText() {
        return "The percent value to decide when a class is a minority class.";
    }                   
    /**
     * Gets the percent value to decide when a class is a minority class
     *
     * @return the percent value to decide when a class is a minority class
     */           
    public double getPercentForMinority() {		
        return m_percentForMinority;		
    }
    /**
     * Sets the percent value to decide when a class is a minority class
     *
     * @param nPercent percent value to decide when a class is a minority class
     */ 
    public void setPercentForMinority(double nPercent) {
        if(nPercent >= 0.0 && nPercent <= 100.0)    
            m_percentForMinority = nPercent;
        else
            throw new IllegalArgumentException("Percent for minority out of range");
    }
    /** 
     * Returns the Capabilities of this filter.
     *
     * @return            the capabilities of this object
     * @see               Capabilities
     */        
    public Capabilities getCapabilities() {
        Capabilities result = super.getCapabilities();
        // attributes
        result.enableAllAttributes();
        result.enable(Capability.MISSING_VALUES);
        // class
        result.enableAllClasses();
        result.enable(Capability.MISSING_CLASS_VALUES);
        result.enable(Capability.NO_CLASS);            
        return result;
    }

    /**
     * Sets the format of the input instances.
     *
     * @param instanceInfo an Instances object containing the input 
     * instance structure (any instances contained in the object are 
     * ignored - only the structure is required).
     * @return true if the outputFormat may be collected immediately
     * @throws IllegalArgumentException if the input format can't be set 
     * successfully
     */
    public boolean setInputFormat(Instances instanceInfo) 
    throws Exception {	
        if (!instanceInfo.classAttribute().isNominal() || instanceInfo.classIndex() < 0) {
                throw new IllegalArgumentException("This filter requires nominal class");
        }
        m_FirstBatchDone = false;
        super.setInputFormat(instanceInfo);
        setOutputFormat(instanceInfo);        
        return true;
    }
    /**
     * Input an instance for filtering. Filter requires all
     * training instances be read before producing output.
     *
     * @param instance the input instance
     * @return true if the filtered instance may now be
     * collected with output().
     * @throws IllegalStateException if no input structure has been defined
     */	
    public boolean input(Instance instance) {
        if (getInputFormat() == null) {
            throw new IllegalStateException("No input instance format defined");
        }
        if (m_NewBatch) {
            resetQueue();
            m_NewBatch = false;
        }
        if (m_FirstBatchDone) {
            push(instance);
            return true;
        } else {
            bufferInput(instance);
            return false;
        }
    }
    /**
     * Signify that this batch of input to the filter is finished. 
     * If the filter requires all instances prior to filtering,
     * output() may now be called to retrieve the filtered instances.
     *
     * @return true if there are instances pending output
     * @throws IllegalStateException if no input structure has been defined
     */
    public boolean batchFinished() {
        if (getInputFormat() == null) {
            throw new IllegalStateException("No input instance format defined");
        }

        if (!isFirstBatchDone()) {
            // Do the subsample, and clear the input instances.			
            try {
                generateSyntenticInstances();
            } 
            catch(IllegalArgumentException iArgException) { 
                throw iArgException;   //progressing this kind of exceptions will show a error dialog box
            }
            catch (Exception ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
                for(int nInstance = 0; nInstance < getInputFormat().numInstances(); nInstance++)					
                    push((Instance)getInputFormat().instance(nInstance));
            }
        }
        flushInput();
        m_NewBatch = true;
        m_FirstBatchDone = true;
        return (numPendingOutput() != 0);
    }  
    /**
     * Looks for the minority classes and for each one calculates the number
     * of syntetic neighbors that must be created. 
     *
     * @return array with the number of neighbors per minority class or null if no minority classes founds
     * @throws IllegalArgumentException if no minority classes founds
     */     
    private int[] getSynteticNeighborsPerClass() {
        double nClassInstances = 0;  //numero de instancias en cada clase
        Double nNeighbors = 0.0;
        double nClassPercent = 0.0;
        int nMinClasses = 0;
        int nClass = 0;            
        double nIPercent;
        double nPercentForMinority = this.getPercentForMinority() / 100.0;
        Instances sourceInstances = getInputFormat();
        int nClassIndex = sourceInstances.classIndex(); // Get the class attribute 
        double nSourceInstances = sourceInstances.numInstances(); //Total number of instances
        // Get statistics for the class attribute 
        AttributeStats stats = sourceInstances.attributeStats(nClassIndex);
        int nClasses = stats.distinctCount; // Gets the number of distint classes
        int[] nSynNeighborsPerClass = new int[nClasses];  // array to return the number of syntetic neighbors
        
        
        if (m_InvertMinorityWeights){ 
            // If option -I selected, the percents are inverted for each class
            for (nClass = nClasses-1; nClass >= 0; nClass--){
                nSynNeighborsPerClass[nClass] = 0; //By default: No minority class
                nClassInstances = stats.nominalCounts[nClass]; 
                nClassPercent = nClassInstances/nSourceInstances; 
                
                if (nClassPercent < nPercentForMinority){ // Minority class
                    nIPercent = (1.0-nClassPercent)/(nClasses-1);   
                    nNeighbors = nIPercent * nSourceInstances;
                    if (nNeighbors > nClassInstances){
                        nNeighbors -= nClassInstances;
                        nNeighbors *= m_SmoteFactor / nClassInstances;
                        nSynNeighborsPerClass[nClass] = (int)Math.round(nNeighbors);                            
                    }
                }
                if(nSynNeighborsPerClass[nClass] > 0){
                    nMinClasses++;
                }
             }
        }
        else{  // smote original applied to n-classes
            for (nClass = nClasses-1; nClass >= 0; nClass--){
                nSynNeighborsPerClass[nClass] = 0;
                nClassInstances = stats.nominalCounts[nClass]; 
                nClassPercent = nClassInstances/nSourceInstances; 
                if (nClassPercent < nPercentForMinority){
                    nSynNeighborsPerClass[nClass] = m_SmoteFactor;
                    nMinClasses++;                    
                }
             }
        }
        // are there minority classes?
        if ((nMinClasses <= 0) || (nMinClasses >= nClasses)){
            nSynNeighborsPerClass = null;
            throw new IllegalArgumentException("No minority classes founds. Please check '-P' option");
        }
        return nSynNeighborsPerClass; 
    }

    /**
     * Generates sytetycs instances of the current set of input instances.
     * The output instances are pushed onto the output queue.
     */    
    private void generateSyntenticInstances() throws Exception {
        Double nClassValue = 0.0; 
        Instance currI = null; // current Instance
        int nRandomInstance = 0;
        int nClassI = 0;  // number of class of Instance
        int nIdx = 0;
        int nSynteticNeighborsGenerated = 0;
        int nNToFind = 0;  // number of Neighbors to find
        int nAt = 0;
        Random ranGap = null; 
        Random ranN = null;  //random Neighbor        
        int nISel = -1;   // number of Instance Selected
        Instance newSN = null; // new Syntetic Neighbor
        Instance newI = null; // new Instance
        int[] kNNIdx = null; //kNearest Neighbors indexes
        int[] nNIdx = null; //nearest neighbors indexes
        Instances sourceInstances = getInputFormat();
        int numSourceInstances  = sourceInstances.numInstances();

        //1. Calculate the syntetic neighbors to generate
        int[] nSynN = getSynteticNeighborsPerClass();
        
        if (nSynN != null){		
            LinearNNSearch linNSearch = new LinearNNSearch(sourceInstances);
            // 2. For each source instance
            for (int index = 0; index < numSourceInstances; index++){                
                currI = sourceInstances.instance(index);					
                nClassI = (int)currI.classValue();  // gets the class of this instance
                if (nSynN[nClassI] > 0){
                    nNToFind = nSynN[nClassI]* m_kNeighborsFactor;
                    //  2.1. Calculate their neighbors
                    linNSearch.kNearestNeighbours(currI, nNToFind);
                    //  2.2 Get the indexes of the neigbors founds
                    kNNIdx = linNSearch.getIndexes(); 
                    nNIdx = new int[nSynN[nClassI]];
                    ranN = new Random(m_RandomSeed*m_kNeighborsFactor*m_SmoteFactor); 
                    // 2.3 Choose nSynteticNeighbors[nClassInstance] instances from the kNearestNeighborsIndexes array
                    for (nIdx = nSynN[nClassI]; nIdx > 0;){
                        nRandomInstance = ranN.nextInt(nNToFind);
                        if (kNNIdx[nRandomInstance] > 0){
                            nIdx--;
                            nNIdx[nIdx] = kNNIdx[nRandomInstance];
                            kNNIdx[nRandomInstance] = -1;  
                        }
                    }
                    //2.4. Generate the syntetic neighbors for this instance. For each neigbor:
                    for (nIdx = nSynN[nClassI]-1; nIdx >= 0; nIdx--){
                        nISel = nNIdx[nIdx];
                        if (nISel >= 0){
                            //2.4.1. Get the neighbor instance
                            newI = sourceInstances.instance(nISel);
                            //2.4.2. Generate a random gap
                            ranGap = new Random(m_RandomSeed);
                            //2.4.3. Generate the syntetic neighbor
                            newSN = (Instance)currI.copy();
                            //2.4.4. Calculate new values for numeric attributes 
                            for (nAt = currI.numAttributes()-1; nAt >= 0; nAt--){
                                if (!currI.attribute(nAt).isNominal() &&
                                     currI.attribute(nAt).isAveragable() ){//numeric attribute
                                    newSN.setValue(nAt,currI.value(nAt)+(newI.value(nAt)-currI.value(nAt))*ranGap.nextDouble());
                                }
                            }
                            //2.4.5. Add the syntetic neighbor to the set of instances
                            push(newSN);
                            nSynteticNeighborsGenerated++; // for test only
                        }
                    }
                }
                //2.5. Always put the original instance
                push((Instance)currI.copy());
            }
        }
    }
        

    /**
     * runs the filter instance with the given options.
     * 
     * @param filter	the filter to run
     * @param options	the commandline options
     */
    protected static void runFilter(Filter filter, String[] options) {
        try {
            if (Utils.getFlag('b', options)) {
                Filter.batchFilterFile(filter, options);
            } 
            else {
                Filter.filterFile(filter, options);
            }
        } catch (Exception ex) {
            if((ex.toString().indexOf("Help requested") == -1) 
               && (ex.toString().indexOf("Filter options") == -1) ){
                ex.printStackTrace();
            }
            else{
                System.err.println(ex.getMessage());
            }
        }
    }        
    /**
     * Main method for testing this class.
     *
     * @param args should contain arguments to the filter: use -h for help
     */
    public static void main(String [] args) {
        try {
            if (args.length == 0) {
                throw new Exception("First argument must be the class name of a Filter");
            }
            String fname = args[0];
            Filter f = (Filter)Class.forName(fname).newInstance();
            args[0] = "";
            runFilter(f, args);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }
}