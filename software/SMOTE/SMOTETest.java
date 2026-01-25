/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 * Copyright (C) 2005 University of Waikato, Hamilton, New Zealand
 */

package weka.filters.unsupervised.instance;

import weka.core.Instances;
import weka.core.Instance;
import weka.core.Attribute;
import weka.filters.AbstractFilterTest;
import weka.filters.Filter;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Tests SMOTE. Run from the command line with: <p/>
 * java weka.filters.unsupervised.instance.SMOTETest
 *
 * @author 
 * @version $Revision: 1.0 $
 */
public class SMOTETest 
  extends AbstractFilterTest {
  
  public SMOTETest(String name) { 
        super(name);  
  }
  /**
   * Same method than AbstractFilterTest::useFilter but without catching
   * exceptions. Used to try that exceptions are trown correctly
   *
   * @return the Instances after filtering through the filter we have set
   * up to test.  
   */
  protected Instances useFilterNoCatchEx()  throws Exception {
        Instances result = null;
        Instances icopy = new Instances(m_Instances);
        m_Filter.setInputFormat(icopy);
        result = Filter.useFilter(icopy, m_Filter);
          assertNotNull(result);
        return result;
  }

  /**
   * returns data generated for the FilteredClassifier test.  
   * To guarantee the existence of minority classes, the first instance is
   * added several times
   * 
   * @return		the dataset for the FilteredClassifier
   * @throws Exception	if generation of data fails
   */
  protected Instances getFilteredClassifierData() throws Exception {
        Instances result = super.getFilteredClassifierData();
        for(int nIns = result.numInstances(); nIns > 0; nIns--){
            result.add((Instance)result.instance(0).copy());
        }
        return result;
  }  
  
  /** 
   * To try the first argument must be nominal
   */
  protected void setUp() throws Exception {
        super.setUp();
        m_Instances.setClassIndex(1);
  }
  
  /** 
   * Creates a default SMOTE 
   *
   * @return the filter to test 
   */
  public Filter getFilter() {
        SMOTE f = new SMOTE();        
        return f;
  }

  /**
   * Test SMOTE with the default arguments
   */  
  public void testAlgorithm_WithDefaultArgs()
  {
        try{
            int nInstances = m_Instances.numInstances();
            m_Filter = getFilter();
            Instances resultIns = useFilter();    
            assertTrue(resultIns.numInstances() > nInstances);
        }
        catch(IllegalArgumentException ex) {
            fail("IllegalArgumentException thrown on SMOTETest::getFilter()\n"+
                 "Check filter data file: \n"+
                 "   - First attribute must be nominal\n"+
                 "   - There must be at least one minority class\n"+
                    ex.getMessage());       
        }

        catch(IllegalStateException ex) {
            ex.printStackTrace();
            fail("IllegalStateException thrown on SMOTETest::getFilter()\n"+
                    ex.getMessage());
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::getFilter():\n" + ex.getMessage());
        }   
  }
  /**
   * Test SMOTE with option -I that invert the percents of minority classes
   */
  public void testAlgorithm_WithOptionI()
  {
        try{
            int nInstances = m_Instances.numInstances();
            m_Filter = getFilter();
            ((SMOTE) m_Filter).setInvertMinorityWeights(true);
            Instances resultIns = useFilter();    
            assertTrue(resultIns.numInstances() > nInstances);
        }
        catch(IllegalArgumentException ex) {
            fail("IllegalArgumentException thrown on SMOTETest::getFilter()\n"+
                 "Check filter data file: \n"+
                 "   - First attribute must be nominal\n"+
                 "   - There must be at least one minority class\n"+
                    ex.getMessage());       
        }

        catch(IllegalStateException ex) {
            ex.printStackTrace();
            fail("IllegalStateException thrown on SMOTETest::getFilter()\n"+
                    ex.getMessage());
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::getFilter():\n" + ex.getMessage());
        }
  }

  /**
   * Test SMOTE forcing exception when all are minority classes 
   */
  public void testAlgorithm_WithAllMinorityClasses() {
        m_Filter = getFilter();
        try{
            ((SMOTE) m_Filter).setPercentForMinority(99.9);
            useFilterNoCatchEx();          
            fail("SMOTETest::testOptionP(): Error testing with -P = 99.9%");
        }
        catch(IllegalArgumentException ex)  { // OK
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::testOptionP():\n"+ex.getMessage());
        }
}
  /**
   * Test SMOTE forcing exception when not minority classes where founds 
   */
  public void testAlgorithm_WithNoMinorityClasses() {
        m_Filter = getFilter();
        try{
            ((SMOTE) m_Filter).setPercentForMinority(0.1);
            useFilterNoCatchEx();            
            fail("SMOTETest::testOptionP(): Error testing with -P = 99.9%");
        }
        catch(IllegalArgumentException ex){ // OK 
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::testOptionP():\n"+ex.getMessage());
        }
}
  /**
   * Test option range
   */
  public void testOptionN() {
        m_Filter = getFilter();
        try{
            // Try with extremme values --> must throw exceptions
            ((SMOTE) m_Filter).setSmoteFactor(0);
            useFilter();           
            fail("SMOTETest::testOptionN(): Error testing with -N = 0");
        }
        catch(IllegalArgumentException ex) { // OK
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::testOptionN():\n"+ex.getMessage());
        }
  }  
  /**
   * Test option range
   */
  public void testOptionK() {
        m_Filter = getFilter();
        try{
            // Try with extremme values --> must throw exceptions
            ((SMOTE) m_Filter).setKNeighborsFactor(0);
            useFilter();           
            fail("SMOTETest::testOptionK(): Error testing with -K = 0");
        }
        catch(IllegalArgumentException ex) { // OK
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::testOptionK():\n"+ex.getMessage());
        }
  } 
  /**
   * Test option range
   */
  public void testOptionP0() {
        m_Filter = getFilter();
        try{
            // Try with extremme values --> must throw exceptions
            ((SMOTE) m_Filter).setPercentForMinority(-0.9);
            useFilter();           
            fail("SMOTETest::testOptionP0(): Error testing with -P = -0.9%");
        }
        catch(IllegalArgumentException ex) { // OK
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::testOptionK():\n"+ex.getMessage());
        }
  }  
  /**
   * Test option range
   */
  public void testOptionP100() {
        m_Filter = getFilter();
        try{
            // Try with extremme values --> must throw exceptions
            ((SMOTE) m_Filter).setPercentForMinority(100.1);
            useFilter();           
            fail("SMOTETest::testOptionP0(): Error testing with -P = 100.1%");
        }
        catch(IllegalArgumentException ex) { // OK
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::testOptionK():\n"+ex.getMessage());
        }
  }
  /**
   * Test SMOTE for not nominal classes
   */
  public void testNotNominalClasses() {
        m_Filter = getFilter();
        try{            
            boolean bNotNominal = false;
            // set as class an attribute not nominal 
            for(int nAtt = 0; nAtt < m_Instances.numAttributes(); nAtt++) {
                Attribute attr = m_Instances.attribute(nAtt);
                if(!attr.isNominal()){
                    m_Instances.setClassIndex(nAtt);
                    bNotNominal = true;
                    break;
                }                    
            }
            useFilterNoCatchEx();
            if(bNotNominal){
                fail("SMOTETest::testNotNominalClasses(): Error testing with\n"+
                        "not nominal class");   
            }
            else{
                fail("SMOTETest::testNotNominalClasses(): Error: To run this\n"+
                        "test must be at least a not nominal attribute");
            }
        }
        catch(IllegalArgumentException ex) {// OK
        }
        catch(Exception ex) {
            ex.printStackTrace();
            fail("Exception thrown on SMOTETest::getFilter():\n" + ex.getMessage());
        }
  }

  public static Test suite() {
        return new TestSuite(SMOTETest.class);
  }

  public static void main(String[] args){
        junit.textui.TestRunner.run(suite());
  }
}