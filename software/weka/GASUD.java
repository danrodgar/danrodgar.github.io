/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package weka.classifiers.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;
import weka.classifiers.Classifier;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Option;
import weka.core.RevisionUtils;
import weka.core.TechnicalInformation;
import weka.core.TechnicalInformation.Field;
import weka.core.TechnicalInformation.Type;
import weka.core.Utils;

/**
 *
<!-- options-start -->
 * Valid options are: <p/>
 *
 * <pre> -N
 *  Use not refined rules.</pre>
 *
 * <pre> -I &lt;number of individuals&gt;
 *  Set the number of individuals for the evolutionary algorithm population.
 *  (default 400)</pre>
 *
 * <pre> -C &lt;number of individuals&gt;
 *  Set the number of individuals that will be copied in the next population.
 *  (default 40)</pre>
 *
 * <pre> -G &lt;number of generations&gt;
 *  Set the number of generations for the evolutionary algorithm.
 *  (default 500)</pre>
 *
 * <pre> -S
 *  Enables scalation.
 *  (default false)</pre>
 *
 * <pre> -M &lt;scale minimum&gt;
 *  Sets the minimum for scaling.
 *  (default 1)</pre>
 *
 * <pre> -X &lt;scale maximum&gt;
 *  Sets the maximum for scaling.
 *  (default 20)</pre>
 *
 * <pre> -R &lt;random seed&gt;
 *  Sets the random seed.</pre>
 *
 * <pre> -E &lt;error percentage&gt;
 *  Sets the error percentage.
 *  (default 0.2)</pre>
 *
 * <pre> -D
 *  If set, classifier is run in debug mode and
 *  may output additional info to the console</pre>
 *
<!-- options-end -->
 * @author Sergio Padrino Recio
 * @version $Revision: 1.0 $
 */
public class GASUD
		extends Classifier {

	/** for serialization */
	static final long serialVersionUID = -217733168393644443L;
	private double m_ErrorPercentage = 0.2;
	private int m_ScaleMax = 20;
	private int m_ScaleMin = 1;
	private boolean m_bScaleEnabled = false;
	private Random randomGenerator;
	private int m_NumIndividuals = 400;
	private int m_NumGenerations = 500;
	private int m_NumCopiedIndividuals = 40;
	private boolean m_UseRefined = true;
	private int m_TargetInstances = 0;
	private int m_NumAttributes;
	private float m_ProbMutation;
	private long m_RandomSeed = System.currentTimeMillis(); //26476518184518L;
	private Instances m_DataSetInstances;
	private ArrayList<Instance> m_Data, m_DataCopy;
	private ArrayList<GASUD_Rule> m_Rules;
	private double[] m_Min,  m_Max;
	private GASUD_Rule[] m_CurrentPopulation;
	private GASUD_Rule[] m_NextPopulation;
	private ArrayList<Integer> m_ClassOrder;
	private double[] m_PopulationFitness;
	private double m_TotalVolume;

	/**
	 * Returns the error percengage.
	 * @return Returns the error percengage.
	 */
	public double getErrorPercentage() {
		return m_ErrorPercentage;
	}

	/**
	 * Sets the error percentage.
	 * @param m_ErrorPercentage
	 */
	public void setErrorPercentage(double m_ErrorPercentage) {
		this.m_ErrorPercentage = m_ErrorPercentage;
	}

	/**
	 * Tip text for error percentage.
	 * @return Tip text for error percentage.
	 */
	public String errorPercentageTipText() {
		return "Percentage (expressed with a number between 0 and 1) of allowed incorrectly classified instances by each rule.";
	}

	/**
	 * Returns true if scaling is enabled.
	 * @return Returns true if scaling is enabled.
	 */
	public boolean getScaleEnabled() {
		return m_bScaleEnabled;
	}

	/**
	 * Enables or disables scaling.
	 * @param m_bScaleEnabled
	 */
	public void setScaleEnabled(boolean m_bScaleEnabled) {
		this.m_bScaleEnabled = m_bScaleEnabled;
	}

	/**
	 * Tip text for scaling.
	 * @return Tip text for scaling.
	 */
	public String scaleEnabledTipText() {
		return "Enables/disables scaling instances.";
	}

	/**
	 * Returns the maximum of scaling.
	 * @return Returns the maximum of scaling.
	 */
	public int getScaleMax() {
		return m_ScaleMax;
	}

	/**
	 * Sets the maximum of scaling.
	 * @param m_ScaleMax
	 */
	public void setScaleMax(int m_ScaleMax) {
		this.m_ScaleMax = m_ScaleMax;
	}

	/**
	 * Returns the minimum of scaling.
	 * @return Returns the minimum of scaling.
	 */
	public int getScaleMin() {
		return m_ScaleMin;
	}

	/**
	 * Sets the minimum of scaling.
	 * @param m_ScaleMin
	 */
	public void setScaleMin(int m_ScaleMin) {
		this.m_ScaleMin = m_ScaleMin;
	}

	/**
	 * Returns the random seed.
	 * @return Returns the random seed.
	 */
	public long getRandomSeed() {
		return m_RandomSeed;
	}

	/**
	 * Sets the random seed.
	 * @param m_RandomSeed
	 */
	public void setRandomSeed(long m_RandomSeed) {
		this.m_RandomSeed = m_RandomSeed;
	}

	/**
	 * Tip text for number of copied individuals.
	 * @return Tip text for number of copied individuals.
	 */
	public String numCopiedIndividualsTipText() {
		return "Number of individuals to be copied to the next generation.";
	}

	/**
	 * Get the number of copied individuals from one generation to the next one.
	 * @return Number of copied individuals from one generation to the next one.
	 */
	public int getNumCopiedIndividuals() {
		return m_NumCopiedIndividuals;
	}

	/**
	 * Set the number of copied individuals from one generation to the next one.
	 * @param m_NumCopiedIndividuals Number of individuals to be copied.
	 */
	public void setNumCopiedIndividuals(int m_NumCopiedIndividuals) {
		this.m_NumCopiedIndividuals = m_NumCopiedIndividuals;
	}

	/**
	 * Tip text for number of generations.
	 * @return Tip text for number of generations.
	 */
	public String numGenerationsTipText() {
		return "Number of generations for the evolutionary algorithm.";
	}

	/**
	 * Get the number of generations for the evolutionary algorithm.
	 * @return Number of generations for the evolutionary algorithm.
	 */
	public int getNumGenerations() {
		return m_NumGenerations;
	}

	/**
	 * Set the number of generations for the evolutionary algorithm.
	 * @param m_NumGenerations Number of generations for the evolutionary algorithm.
	 */
	public void setNumGenerations(int m_NumGenerations) {
		this.m_NumGenerations = m_NumGenerations;
	}

	/**
	 * Tip text for using refined rules.
	 * @return Tip text for using refined rules.
	 */
	public String useRefinedTipText() {
		return "Use refined rules for classifying?";
	}

	/**
	 * Get whether the classifier will use refined rules or not.
	 * @return Whether the classifier will use refined rules or not.
	 */
	public boolean isUseRefined() {
		return m_UseRefined;
	}

	/**
	 * Set whether the classifier will use refined rules or not.
	 * @param m_UseRefined True for using refined rules.
	 */
	public void setUseRefined(boolean m_UseRefined) {
		this.m_UseRefined = m_UseRefined;
	}

	/**
	 * Tip text for number of individuals.
	 * @return Tip text for number of individuals.
	 */
	public String numIndividualsTipText() {
		return "Number of individuals for the initial population.";
	}

	/**
	 * Set the number of individuals for the initial population of the evolutionary algorithm.
	 * @param num Number of individuals for the initial population of the evolutionary algorithm.
	 */
	public void setNumIndividuals(int num) {
		m_NumIndividuals = num;
	}

	/**
	 * Get the number of individuals for the initial population of the evolutionary algorithm.
	 * @return Number of individuals for the initial population of the evolutionary algorithm.
	 */
	public int getNumIndividuals() {
		return m_NumIndividuals;
	}

	/**
	 * Inits data according to a specified target class.
	 * @param target_class Target class to build the rules.
	 */
	private void initData(double target_class) {
		double rango;

		m_NumAttributes = m_DataSetInstances.numAttributes();

		m_Data = new ArrayList<Instance>();
		m_DataCopy = new ArrayList<Instance>();
		m_Min = new double[m_NumAttributes];
		m_Max = new double[m_NumAttributes];
		m_CurrentPopulation = new GASUD_Rule[m_NumIndividuals];
		m_NextPopulation = new GASUD_Rule[m_NumIndividuals];
		m_PopulationFitness = new double[m_NumIndividuals];

		//m_ScaledInstances = new Instances(m_DataSetInstances);

		for (int j = 0; j < m_NumAttributes; j++) {
			m_Min[j] = 999.0f;
			m_Max[j] = -999.0f;
		}

		m_TargetInstances = 0;

		for (int i = 0; i < m_DataSetInstances.numInstances(); i++) {
			Instance inst = m_DataSetInstances.instance(i);
//			mData.add(inst);

			if (inst.classValue() == target_class) {
				m_TargetInstances++;
			}

			for (int j = 0; j < m_NumAttributes; j++) {
				if (j == m_DataSetInstances.classIndex()) {
					continue;
				}

				if (m_Max[j] < inst.value(j)) {
					m_Max[j] = inst.value(j);
				}

				if (m_Min[j] > inst.value(j)) {
					m_Min[j] = inst.value(j);
				}

			}
		}

		for (int j = 0; j < m_NumAttributes; j++) {
			if (j == m_DataSetInstances.classIndex()) {
				continue;
			}

			rango = m_Max[j] - m_Min[j];
			m_Min[j] = m_Min[j] - rango * 0.03;
			m_Max[j] = m_Max[j] + rango * 0.03;
		}

		for (int i = 0; i < m_DataSetInstances.numInstances(); i++) {
			Instance inst = (Instance) m_DataSetInstances.instance(i).copy();

			if (m_bScaleEnabled) {
				scaleInstance(inst);
			}

			m_Data.add(inst);
			m_DataCopy.add((Instance) inst.copy());
		}


		m_TotalVolume = 1.0;

		for (int j = 0; j < m_NumAttributes; j++) {
			if (j == m_DataSetInstances.classIndex()) {
				continue;
			}

			if (m_bScaleEnabled) {
				m_TotalVolume *= Math.abs(m_ScaleMax - m_ScaleMin);
			} else {
				m_TotalVolume *= Math.abs(m_Max[j] - m_Min[j]);
			}
		}

	}

	/**
	 * Inits the population according to a target class.
	 * @param target_class Target class to build the rules.
	 */
	private void initPopulation(double target_class) {
		int q = 0;
		double a, b;
		Instance instance;

		for (int j = 0; j < m_NumIndividuals; j++) {

			for (;;) {
				q = randomGenerator.nextInt(m_Data.size());
				instance = m_Data.get(q);
				if (instance.classValue() == target_class) //aqui la clase a buscar
				{
					break;
				}
			}

			m_CurrentPopulation[j] = new GASUD_Rule(instance.classValue(), m_NumAttributes, instance.classIndex(), m_Max, m_Min, m_bScaleEnabled, m_ScaleMax, m_ScaleMin);

			for (int i = 0; i < m_NumAttributes; i++) {
				if (i == m_DataSetInstances.classIndex()) {
					continue;
				}

				if (!m_bScaleEnabled) {
					a = instance.value(i) - (m_Max[i] - m_Min[i]) / (100.0f) * randomGenerator.nextFloat();
					if (a < m_Min[i]) {
						a = m_Min[i];
					}

					b = instance.value(i) + (m_Max[i] - m_Min[i]) / (100.0f) * randomGenerator.nextFloat();
					if (b > m_Max[i]) {
						b = m_Max[i];
					}
				} else {
					a = instance.value(i) - (m_ScaleMax - m_ScaleMin) / (100.0f) * randomGenerator.nextFloat();
					if (a < m_ScaleMin) {
						a = m_ScaleMin;
					}

					b = instance.value(i) + (m_ScaleMax - m_ScaleMin) / (100.0f) * randomGenerator.nextFloat();
					if (b > m_ScaleMax) {
						b = m_ScaleMax;
					}
				}

				if (a < b) {
					m_CurrentPopulation[j].setLowerLimit(i, a);
					m_CurrentPopulation[j].setUpperLimit(i, b);
				} else {
					m_CurrentPopulation[j].setLowerLimit(i, b);
					m_CurrentPopulation[j].setUpperLimit(i, a);
				}
			}
		}

	}

	/**
	 * Refines a rule.
	 * @param individual Rule to be refined.
	 */
	private void refineRule(GASUD_Rule individual) {
		double[] mini = new double[m_NumAttributes], maxi = new double[m_NumAttributes], falmin = new double[m_NumAttributes], falmax = new double[m_NumAttributes];

		double rango = 0.0;
		for (int i = 0; i < m_NumAttributes; i++) {
			if (i == m_DataSetInstances.classIndex()) {
				continue;
			}

			if (!m_bScaleEnabled) {
				rango = m_Max[i] - m_Min[i];
				falmin[i] = m_Min[i] + rango * 0.02;
				falmax[i] = m_Max[i] - rango * 0.02;
			} else {
				rango = m_ScaleMax - m_ScaleMin;
				falmin[i] = m_ScaleMin + rango * 0.02;
				falmax[i] = m_ScaleMax - rango * 0.02;
			}

			mini[i] = 1e6f;
			maxi[i] = -1e6f;
		}

		int correct = 0, incorrect = 0;
		for (int i = 0; i < m_Data.size(); i++) {
			Instance instance = m_Data.get(i);

			if (individual.contains(instance)) {
				if (instance.classValue() == individual.getRuleClass()) {	//Si la clase es la misma que intentamos predecir...
					correct++;
					for (int j = 0; j < m_NumAttributes; j++) {
						if (maxi[j] < instance.value(j)) {
							maxi[j] = instance.value(j);
						}

						if (mini[j] > instance.value(j)) {
							mini[j] = instance.value(j);
						}
					}
				} else {
					incorrect++;
				}
			}
		}

		//System.out.printf("1: correct: %d, incorrect: %d\n", correct, incorrect);

		correct = 0; incorrect = 0;
		for (int i = 0; i < m_DataCopy.size(); i++) {
			Instance instance = m_DataCopy.get(i);

			if (individual.contains(instance)) {
				if (instance.classValue() == individual.getRuleClass()) {	//Si la clase es la misma que intentamos predecir...
					correct++;
				} else {
					incorrect++;
				}
			}
		}

		individual.setCorrect(correct);
		individual.setIncorrect(incorrect);

//		System.out.printf("2: correct: %d, incorrect: %d\n", correct, incorrect);

		for (int i = 0; i < m_NumAttributes; i++) {
			if (i == m_DataSetInstances.classIndex()) {
				continue;
			}

			if (m_UseRefined) {
				individual.setLowerRefinedLimit(i, mini[i]);
				individual.setUpperRefinedLimit(i, maxi[i]);
			}

			if (individual.getLowerLimit(i) <= falmin[i] && individual.getUpperLimit(i) <= falmax[i]) {
				individual.setAttributeComparison(i, individual.LESS_THAN);
			} else if (individual.getLowerLimit(i) >= falmin[i] && individual.getUpperLimit(i) >= falmax[i]) {
				individual.setAttributeComparison(i, individual.GREATER_THAN);
			} else if (individual.getLowerLimit(i) >= falmin[i] && individual.getUpperLimit(i) <= falmax[i]) {
				individual.setAttributeComparison(i, individual.BETWEEN);
			}
		}
	}

	/**
	 * Reduces data removing instances that are classified by a given rule.
	 * @param individual Rule to classify instances.
	 */
	private void reduceData(GASUD_Rule individual) {
		ArrayList<Instance> new_data = new ArrayList<Instance>();

		for (int i = 0; i < m_Data.size(); i++) {
			Instance instance = m_Data.get(i);
//			boolean is_contained = m_UseRefined ? individual.containsRefined(instance) : individual.contains(instance);
			boolean is_contained = individual.contains(instance);

			if (!is_contained) {
				new_data.add(instance);
			}
		}

		m_Data = new_data;
	}

	/**
	 * Calculates the fitness value of a given rule.
	 * @param individual Rule.
	 * @return Fitness value of the given rule.
	 */
	private double calculateRuleFitness(GASUD_Rule individual) {
		boolean dentro = true;
		double error = 0.0, acierto = 0.0, area = 1.0, result = 0.0;

		for (int i = 0; i < m_Data.size(); i++) {
			Instance instance = m_Data.get(i);

			dentro = true;
			for (int j = 0; j < m_NumAttributes; j++) {
				if (j == m_DataSetInstances.classIndex()) {
					continue;
				}

				if (individual.getLowerLimit(j) > instance.value(j) || individual.getUpperLimit(j) < instance.value(j)) {
					dentro = false;
					break;
				}
			}

			if (dentro) {
				if (instance.classValue() == individual.getRuleClass()) {
					acierto += 1.;
				} else {
					error += 1.;
				}
			}
		}

		for (int j = 0; j < m_NumAttributes; j++) {
			if (j == m_DataSetInstances.classIndex()) {
				continue;
			}

			area *= Math.abs(individual.getUpperLimit(j) - individual.getLowerLimit(j));
		}

		if (acierto > 0.0) {
			//if(error < 0.05*acierto)
			if (error < m_ErrorPercentage * acierto) {
				result = error - acierto - area / m_TotalVolume;
			} else {
				result = 3.0 * error - acierto - area / m_TotalVolume;
			}
		} else {
			result = -1.0 * area / m_TotalVolume;
		}

		return result;
	}

	/**
	 * Calculates the fitness value of the current population.
	 */
	private void calculatePopulationFitness() {
		double suma, a;

		suma = 0.0;
		for (int i = 0; i < m_NumIndividuals; i++) {
			a = calculateRuleFitness(m_CurrentPopulation[i]) + m_Data.size();
			if (a != -1.0) {
				m_PopulationFitness[i] = 1.0 / (1.0 + a);
			} else {
				m_PopulationFitness[i] = 0.0;
			}

			suma += m_PopulationFitness[i];
		}

		for (int i = 0; i < m_NumIndividuals; i++) {
			m_PopulationFitness[i] /= suma;
		}

	}

	/**
	 * Returns the index in the current population that indicates the best individual (rule).
	 * @return Returns the index in the current population that indicates the best individual (rule).
	 */
	private int getBestIndividual() {
		int i_max = 0;
		double max_value = m_PopulationFitness[0];

		for (int i = 0; i < m_NumIndividuals; i++) {
			if (m_PopulationFitness[i] > max_value) {
				i_max = i;
				max_value = m_PopulationFitness[i];
			}
		}

		return i_max;
	}

	/**
	 * Scales an instance to the interval defined by m_ScaleMax and m_ScaleMin.
	 * @param inst Instance to be scaled.
	 */
	private void scaleInstance(Instance inst) {
		for (int j = 0; j < m_NumAttributes; j++) {
			if (inst.classIndex() != j) {
				inst.setValue(j, (inst.value(j) - m_Min[j]) * (m_ScaleMax - m_ScaleMin) / (m_Max[j] - m_Min[j]) + m_ScaleMin);
			}
		}
	}

	/**
	 * Roulette-wheel selection
	 * @return The index of the selected individual.
	 */
	private int select() throws Exception {
		int valor = 0;
		double prob = 0.0, tot = 0.0;

		prob = randomGenerator.nextDouble();
		tot = 0.0;
		for (int i = 0; i < m_NumIndividuals; i++) {
			tot = tot + m_PopulationFitness[i];
			if (tot > prob) {
				valor = i;
				break;
			}
		}

		if (valor >= m_NumIndividuals) {
			System.out.printf("Error escogido valor mayor de N %d", valor);
			throw new Exception("Error: selected value greater than number of individuals: " + String.valueOf(valor));
		}

		return valor;

	}

	/**
	 * Makes crossover between 2 individuals.
	 * @param new_individual New rule to be created.
	 * @param parent1 Parent rule.
	 * @param parent2 Parent rule.
	 */
	private void crossover0(int new_individual, int parent1, int parent2) {
		//Si los dos individuos a cruzar tienen la misma clase...
		if (m_CurrentPopulation[parent1].getRuleClass() == m_CurrentPopulation[parent2].getRuleClass()) {
			m_NextPopulation[new_individual] = new GASUD_Rule(m_CurrentPopulation[parent1].getRuleClass(), m_NumAttributes, m_DataSetInstances.classIndex(), m_Max, m_Min, m_bScaleEnabled, m_ScaleMax, m_ScaleMin);

			//Los valores del hijo son la media de los padres
			for (int i = 0; i < m_NumAttributes; i++) {
				if (i == m_DataSetInstances.classIndex()) {
					continue;
				}

				m_NextPopulation[new_individual].setLowerLimit(i, (m_CurrentPopulation[parent1].getLowerLimit(i) + m_CurrentPopulation[parent2].getLowerLimit(i)) / 2.0f);
				m_NextPopulation[new_individual].setUpperLimit(i, (m_CurrentPopulation[parent1].getUpperLimit(i) + m_CurrentPopulation[parent2].getUpperLimit(i)) / 2.0f);
			}
		} else {	//...si no tienen la misma clase...
			//El hijo tiene los valores del primer padre
			for (int i = 0; i < m_NumAttributes; i++) {
				if (i == m_DataSetInstances.classIndex()) {
					continue;
				}

				m_NextPopulation[new_individual].setLowerLimit(i, m_CurrentPopulation[parent1].getLowerLimit(i));
				m_NextPopulation[new_individual].setUpperLimit(i, m_CurrentPopulation[parent1].getUpperLimit(i));
			}
		}
	}

	/**
	 * Makes crossover between 2 individuals.
	 * @param new_individual New rule to be created.
	 * @param parent1 Parent rule.
	 * @param parent2 Parent rule.
	 */
	private void crossover1(int new_individual, int parent1, int parent2) {
		float p;
		double anterior;

		m_NextPopulation[new_individual] = new GASUD_Rule(m_CurrentPopulation[parent1].getRuleClass(), m_NumAttributes, m_DataSetInstances.classIndex(), m_Max, m_Min, m_bScaleEnabled, m_ScaleMax, m_ScaleMin);

		//Los valores del nuevo individuo serán seleccionados cada uno aleatoriamente de un padre
		for (int i = 0; i < m_NumAttributes; i++) {
			if (i == m_DataSetInstances.classIndex()) {
				continue;
			}

			p = randomGenerator.nextFloat();
			if (p < 0.5) {
				m_NextPopulation[new_individual].setLowerLimit(i, m_CurrentPopulation[parent1].getLowerLimit(i));
			} else {
				m_NextPopulation[new_individual].setLowerLimit(i, m_CurrentPopulation[parent2].getLowerLimit(i));
			}


			p = randomGenerator.nextFloat();
			if (p < 0.5) {
				m_NextPopulation[new_individual].setUpperLimit(i, m_CurrentPopulation[parent1].getUpperLimit(i));
			} else {
				m_NextPopulation[new_individual].setUpperLimit(i, m_CurrentPopulation[parent2].getUpperLimit(i));
			}
		}

		//Si en algún caso del nuevo individuo, el valor 'par' (pequeño) es mayor que el valor 'impar' (grande), se intercambian
		for (int j = 0; j < m_NumAttributes; j++) {
			if (j == m_DataSetInstances.classIndex()) {
				continue;
			}

			if (m_NextPopulation[new_individual].getUpperLimit(j) < m_NextPopulation[new_individual].getLowerLimit(j)) {
				anterior = m_NextPopulation[new_individual].getLowerLimit(j);
				m_NextPopulation[new_individual].setLowerLimit(j, m_NextPopulation[new_individual].getUpperLimit(j));
				m_NextPopulation[new_individual].setUpperLimit(j, anterior);
			}
		}
	}

	/**
	 * Mutates a given individual.
	 * @param individual Individual to be mutated.
	 */
	private void mutate(int individual) {
		int p = m_DataSetInstances.classIndex();
		double anterior;

		while (p == m_DataSetInstances.classIndex()) {
			p = randomGenerator.nextInt(m_NumAttributes);
		}

		//Hay un 50% de probabilidades de modificar el valor 'par' y un 50% de modificar el 'impar'
		if (randomGenerator.nextFloat() < 0.5) {	//PAR
			anterior = m_NextPopulation[individual].getLowerLimit(p);
			if (!m_bScaleEnabled) {
				m_NextPopulation[individual].setLowerLimit(p, (anterior + (randomGenerator.nextInt(2) * 2 - 1) * ((m_Max[p] - m_Min[p]) / 20.) * randomGenerator.nextFloat()));

				//Si el nuevo valor es menor que el mínimo, nos quedamos con el mínimo
				if (m_NextPopulation[individual].getLowerLimit(p) < m_Min[p]) {
					m_NextPopulation[individual].setLowerLimit(p, m_Min[p]);
				}
			} else {
				m_NextPopulation[individual].setLowerLimit(p, (anterior + (randomGenerator.nextInt(2) * 2 - 1) * ((m_ScaleMax - m_ScaleMin) / 20.) * randomGenerator.nextFloat()));

				//Si el nuevo valor es menor que el mínimo, nos quedamos con el mínimo
				if (m_NextPopulation[individual].getLowerLimit(p) < m_ScaleMin) {
					m_NextPopulation[individual].setLowerLimit(p, m_ScaleMin);
				}
			}

			//Si el resultado no es 'par' < 'impar' se cancela la mutación
			if (m_NextPopulation[individual].getLowerLimit(p) > m_NextPopulation[individual].getUpperLimit(p)) {
				m_NextPopulation[individual].setLowerLimit(p, anterior);
			}

		} else {	//IMPAR
			anterior = m_NextPopulation[individual].getUpperLimit(p);
			if (!m_bScaleEnabled) {
				m_NextPopulation[individual].setUpperLimit(p, (anterior + (randomGenerator.nextInt(2) * 2 - 1) * ((m_Max[p] - m_Min[p]) / 20.) * randomGenerator.nextFloat()));

				//Si el nuevo valor es mayor que el máximo, nos quedamos con el máximo
				if (m_NextPopulation[individual].getUpperLimit(p) > m_Max[p]) {
					m_NextPopulation[individual].setUpperLimit(p, m_Max[p]);
				}
			} else {
				m_NextPopulation[individual].setUpperLimit(p, (anterior + (randomGenerator.nextInt(2) * 2 - 1) * ((m_ScaleMax - m_ScaleMin) / 20.) * randomGenerator.nextFloat()));

				//Si el nuevo valor es mayor que el máximo, nos quedamos con el máximo
				if (m_NextPopulation[individual].getUpperLimit(p) > m_ScaleMax) {
					m_NextPopulation[individual].setUpperLimit(p, m_ScaleMax);
				}
			}

			//Si el resultado no es 'par' < 'impar' se cancela la mutación
			if (m_NextPopulation[individual].getUpperLimit(p) < m_NextPopulation[individual].getLowerLimit(p)) {
				m_NextPopulation[individual].setUpperLimit(p, anterior);
			}
		}
	}

	/**
	 * Mutates a given individual.
	 * @param individual Individual to be mutated.
	 */
	private void mutate3(int individual) {
		int p = m_DataSetInstances.classIndex();
		float prob;

		while (p == m_DataSetInstances.classIndex()) {
			p = randomGenerator.nextInt(m_NumAttributes);
		}

		prob = randomGenerator.nextFloat();

		//Con probabilidad del 50% para cada opción, se muta un valor 'par' o 'impar'
		//Para el primer caso se cambia por el mínimo, y para el segundo por el máximo
		if (!m_bScaleEnabled) {
			if (prob < 0.5) {
				m_NextPopulation[individual].setLowerLimit(p, m_Min[p]);
			} else {
				m_NextPopulation[individual].setUpperLimit(p, m_Max[p]);
			}
		} else {
			if (prob < 0.5) {
				m_NextPopulation[individual].setLowerLimit(p, m_ScaleMin);
			} else {
				m_NextPopulation[individual].setUpperLimit(p, m_ScaleMax);
			}
		}
	}

	/**
	 * Calculates the order which has to be considered to build rules for a target class.
	 */
	public void calculateClassOrder() {
		m_ClassOrder = new ArrayList<Integer>();
		int[] class_counts = new int[m_DataSetInstances.classAttribute().numValues()];

		for (int i = 0; i < m_DataSetInstances.numInstances(); i++) {
			Instance inst = m_DataSetInstances.instance(i);
			class_counts[(int) inst.classValue()]++;
		}

		for (int i = 0; i < m_DataSetInstances.classAttribute().numValues(); i++) {
			int min_index = 0, min = Integer.MAX_VALUE;

			for (int j = 0; j < m_DataSetInstances.classAttribute().numValues(); j++) {
				if (class_counts[j] < min && class_counts[j] > -1) {
					min_index = j;
					min = class_counts[j];
				}
			}

			class_counts[min_index] = -1;
			m_ClassOrder.add(min_index);
		}
	}

	/**
	 * Builds rules.
	 * @throws java.lang.Exception
	 */
	public void buildRules() throws Exception {
		int ind, ind1, ind2;
		float prob;
		int class_value;

		for (int class_index = 0; class_index < m_DataSetInstances.classAttribute().numValues(); class_index++) {
			class_value = m_ClassOrder.get(class_index);
			initData((double) class_value);
//			for (int kk = 0; kk < 10 && mData.size() > 415; kk++) {
			for (int kk = 0; kk < 10 && m_Data.size() > m_DataSetInstances.numInstances() - m_TargetInstances; kk++) {
				initPopulation((double) class_value);
				for (int ii = 0; ii < m_NumGenerations; ii++) {
					calculatePopulationFitness();
					m_ProbMutation = 10.0f - 0.03f * ii;
					int best_individual = getBestIndividual();

					//Se copia al mejor individuo dos veces al principio de la nueva población
					m_NextPopulation[0] = m_CurrentPopulation[best_individual].clone();
					m_NextPopulation[1] = m_CurrentPopulation[best_individual].clone();

					//Se copia al mejor individuo NUM_REP veces en la nueva población?
					for (int j = 2; j < m_NumCopiedIndividuals; j++) {
						ind = select();

						m_NextPopulation[j] = m_CurrentPopulation[ind].clone();
					}

					//Se generan hijos para el resto de la población
					//El método de cruce se elige aleatoriamente, con un 50% de probabilidad para cada uno
					for (int j = m_NumCopiedIndividuals; j < m_NumIndividuals; j++) {
						ind1 = select();
						ind2 = select();
						prob = randomGenerator.nextFloat();
						if (prob < 0.5f) {
							if (ind1 < m_NumIndividuals && ind2 < m_NumIndividuals && 0 <= ind1 && 0 <= ind2) {
								crossover0(j, ind1, ind2);
							} else {
								crossover0(j, 0, randomGenerator.nextInt(m_NumIndividuals - 1) + 1);
							}
						} else {
							if (ind1 < m_NumIndividuals && ind2 < m_NumIndividuals && 0 <= ind1 && 0 <= ind2) {
								crossover1(j, ind1, ind2);
							} else {
								crossover1(j, 0, randomGenerator.nextInt(m_NumIndividuals - 1) + 1);
							}
						}
					}

					//Se mutan todos los individuos menos el primero
					//Hay dos métodos de mutación, el primero con una probabilidad del 85% y el segundo con el 15%
					for (int j = 1; j < m_NumIndividuals; j++) {
						prob = randomGenerator.nextFloat();
						if (prob < m_ProbMutation) {
							prob = randomGenerator.nextFloat();
							if (prob < 0.85f) {
								mutate(j);
							} else {
								mutate3(j);
							}
						}
					}

					//Se pasa la nueva población a la población actual
					for (int i = 0; i < m_NumIndividuals; i++) {
						if (m_NextPopulation[i] == null) {
							m_NextPopulation[i] = new GASUD_Rule(m_CurrentPopulation[i].getRuleClass(), m_NumAttributes, m_DataSetInstances.classIndex(), m_Max, m_Min, m_bScaleEnabled, m_ScaleMax, m_ScaleMin);
						}

						for (int j = 0; j < m_NumAttributes; j++) {
							if (j == m_DataSetInstances.classIndex()) {
								continue;
							}

							//Si los valores 'pares' son menores que el mínimo de ese atributo, se copia el mínimo
							//De lo contrario se pasa tal cual a la población actual
							if (!m_bScaleEnabled) {
								if (m_NextPopulation[i].getLowerLimit(j) < m_Min[j]) {
									m_CurrentPopulation[i].setLowerLimit(j, m_Min[j]);
								} else {
									m_CurrentPopulation[i].setLowerLimit(j, m_NextPopulation[i].getLowerLimit(j));
								}

								//Si los valores 'impares' son mayores que el máximo de ese atributo, se copia el máximo
								//De lo contrario se pasa tal cual a la población actual
								if (m_NextPopulation[i].getUpperLimit(j) > m_Max[j]) {
									m_CurrentPopulation[i].setUpperLimit(j, m_Max[j]);
								} else {
									m_CurrentPopulation[i].setUpperLimit(j, m_NextPopulation[i].getUpperLimit(j));
								}
							} else {
								if (m_NextPopulation[i].getLowerLimit(j) < m_ScaleMin) {
									m_CurrentPopulation[i].setLowerLimit(j, m_ScaleMin);
								} else {
									m_CurrentPopulation[i].setLowerLimit(j, m_NextPopulation[i].getLowerLimit(j));
								}

								//Si los valores 'impares' son mayores que el máximo de ese atributo, se copia el máximo
								//De lo contrario se pasa tal cual a la población actual
								if (m_NextPopulation[i].getUpperLimit(j) > m_ScaleMax) {
									m_CurrentPopulation[i].setUpperLimit(j, m_ScaleMax);
								} else {
									m_CurrentPopulation[i].setUpperLimit(j, m_NextPopulation[i].getUpperLimit(j));
								}
							}

							//Si el valor 'par' (se supone que es el pequeño) es mayor que el 'impar' (se supone que es el grande), error
							if (m_CurrentPopulation[i].getLowerLimit(j) > m_CurrentPopulation[i].getUpperLimit(j)) {
								System.out.printf("ERROR: %d %d", i, j);

								throw new Exception("Error individual " + String.valueOf(i) + ", attribute " + String.valueOf(j));
							}
						}
					}
				}

				refineRule(m_NextPopulation[0]);
				reduceData(m_NextPopulation[0]);

				if (m_NextPopulation[0] != null) {
					m_Rules.add(m_NextPopulation[0]);
				}
			}
		}
	}

	/**
	 * Returns a description of the classifier.
	 *
	 * @return a description of the classifier
	 */
	public String toString() {
		String result = "Random seed: " + String.valueOf(m_RandomSeed) + "\nThe created rules are:\n\n";

		for (int i = 0; i < m_Rules.size(); i++) {
			result += "Rule " + (i + 1) + ":\n" + m_Rules.get(i).toString(m_UseRefined) + "\n\n";
		}

		return result;
	}

	/**
	 * Generates the classifier.
	 *
	 * @param instances the data to train the classifier with
	 * @throws Exception if classifier can't be built successfully
	 */
	public void buildClassifier(Instances instances)
			throws Exception {

		getCapabilities().testWithFail(instances);

		randomGenerator = new Random(m_RandomSeed);

		m_DataSetInstances = instances;

		calculateClassOrder();

		m_Rules = new ArrayList<GASUD_Rule>();

		buildRules();
	}

	/**
	 * Classifies an instance.
	 *
	 * @param instance the instance to classify
	 * @return the classification for the instance
	 * @throws Exception if instance can't be classified successfully
	 */
	@Override
	public double classifyInstance(Instance instance) throws Exception {
		Instance instance_copy = (Instance) instance.copy();
		if (m_bScaleEnabled) {
			scaleInstance(instance_copy);
		}

		for (int i = 0; i < m_Rules.size(); i++) {
			GASUD_Rule rule = m_Rules.get(i);
			boolean is_contained = m_UseRefined ? rule.checkRefined(instance_copy) : rule.check(instance_copy);

			if (is_contained) {
				return rule.getRuleClass();
			}
		}

		throw new Exception("The instance couldn't be classified");
	}

	/**
	 * Returns class probabilities for an instance.
	 *
	 * @param instance the instance to calculate the class probabilities for
	 * @return the class probabilities
	 * @throws Exception if distribution can't be computed successfully
	 */
	@Override
	public final double[] distributionForInstance(Instance instance)
			throws Exception {

		if (m_Rules.isEmpty()) {
			throw new Exception("There are no rules.");
		}

		double num_classes = 0.0;
		double[] dist = new double[instance.classAttribute().numValues()];
		double factor = 1.0;

		Instance instance_copy = (Instance) instance.copy();
		if (m_bScaleEnabled) {
			scaleInstance(instance_copy);
		}

		for (int i = 0; i < m_Rules.size(); i++) {
			GASUD_Rule rule = m_Rules.get(i);
			boolean is_contained = m_UseRefined ? rule.checkRefined(instance_copy) : rule.check(instance_copy);

			if (is_contained) {
				dist[(int) rule.getRuleClass()] += factor;//1.0;
				num_classes += factor;

				factor *= 0.5;
			}
		}

		if (num_classes > 0.0) {
			for (int i = 0; i < instance.classAttribute().numValues(); i++) {
				dist[i] /= num_classes;
			}
		}

		return dist;
	}

	/**
	 * Parses a given list of options.
	 *
	 * Valid options are: <p/>
	 *
	 * <pre> -N
	 *  Use not refined rules.</pre>
	 *
	 * <pre> -I &lt;number of individuals&gt;
	 *  Set the number of individuals for the evolutionary algorithm population.
	 *  (default 400)</pre>
	 *
	 * <pre> -C &lt;number of individuals&gt;
	 *  Set the number of individuals that will be copied in the next population.
	 *  (default 40)</pre>
	 *
	 * <pre> -G &lt;number of generations&gt;
	 *  Set the number of generations for the evolutionary algorithm.
	 *  (default 500)</pre>
	 *
	 * <pre> -S
	 *  Enables scalation.
	 *  (default false)</pre>
	 *
	 * <pre> -M &lt;scale minimum&gt;
	 *  Sets the minimum for scaling.
	 *  (default 1)</pre>
	 *
	 * <pre> -X &lt;scale maximum&gt;
	 *  Sets the maximum for scaling.
	 *  (default 20)</pre>
	 *
	 * <pre> -R &lt;random seed&gt;
	 *  Sets the random seed.</pre>
	 *
	 * <pre> -E &lt;error percentage&gt;
	 *  Sets the error percentage.
	 *  (default 0.2)</pre>
	 *
	 * <pre> -D
	 *  If set, classifier is run in debug mode and
	 *  may output additional info to the console</pre>
	 *
	 * @param options the list of options as an array of strings
	 * @throws Exception if an option is not supported
	 */
	@Override
	public void setOptions(String[] options) throws Exception {

		// Other options
		setUseRefined(Utils.getFlag('N', options));

		setScaleEnabled(Utils.getFlag('S', options));

		setDebug(Utils.getFlag('D', options));

		String minScale = Utils.getOption('M', options);
		if (minScale.length() != 0)
			setScaleMin(Integer.parseInt(minScale));

		String maxScale = Utils.getOption('X', options);
		if (maxScale.length() != 0)
			setScaleMax(Integer.parseInt(maxScale));

		String randomSeed = Utils.getOption("R", options);
		if (randomSeed.length() != 0)
			setRandomSeed(Long.parseLong(randomSeed));

		String errorPercentage = Utils.getOption("E", options);
		if (errorPercentage.length() != 0)
			setErrorPercentage(Double.parseDouble(errorPercentage));

		String numIndividuals = Utils.getOption("I", options);
		if (numIndividuals.length() != 0)
			setNumIndividuals(Integer.parseInt(numIndividuals));

		numIndividuals = Utils.getOption("C", options);
		if (numIndividuals.length() != 0)
			setNumCopiedIndividuals(Integer.parseInt(numIndividuals));

		String numGenerations = Utils.getOption("G", options);
		if (numGenerations.length() != 0)
			setNumGenerations(Integer.parseInt(numGenerations));
	}

	/**
	 * Returns an enumeration describing the available options.
	 *
	 * Valid options are: <p/>
	 *
	 * <pre> -N
	 *  Use not refined rules.</pre>
	 *
	 * <pre> -I &lt;number of individuals&gt;
	 *  Set the number of individuals for the evolutionary algorithm population.
	 *  (default 400)</pre>
	 *
	 * <pre> -C &lt;number of individuals&gt;
	 *  Set the number of individuals that will be copied in the next population.
	 *  (default 40)</pre>
	 *
	 * <pre> -G &lt;number of generations&gt;
	 *  Set the number of generations for the evolutionary algorithm.
	 *  (default 500)</pre>
	 *
	 * <pre> -S
	 *  Enables scalation.
	 *  (default false)</pre>
	 *
	 * <pre> -M &lt;scale minimum&gt;
	 *  Sets the minimum for scaling.
	 *  (default 1)</pre>
	 *
	 * <pre> -X &lt;scale maximum&gt;
	 *  Sets the maximum for scaling.
	 *  (default 20)</pre>
	 *
	 * <pre> -R &lt;random seed&gt;
	 *  Sets the random seed.</pre>
	 *
	 * <pre> -E &lt;error percentage&gt;
	 *  Sets the error percentage.
	 *  (default 0.2)</pre>
	 *
	 * <pre> -D
	 *  If set, classifier is run in debug mode and
	 *  may output additional info to the console</pre>
	 *
	 * @return an enumeration of all the available options.
	 */
	@Override
	public Enumeration listOptions() {

		Vector newVector = new Vector(9);

		newVector.addElement(new Option("\tUse not refined rules.",
				"N", 0, "-N"));
		newVector.addElement(new Option("\tSet the number of individuals for the evolutionary algorithm population.\n" +
				"\t(default 400)",
				"I", 1, "-I <number of individuals>"));
		newVector.addElement(new Option("\tSet the number of individuals that will be copied in the next population.\n" +
				"\t(default 40)",
				"C", 1, "-C <number of individuals>"));
		newVector.addElement(new Option("\tSet the number of generations for the evolutionary algorithm.\n" +
				"\t(default 500)",
				"G", 1, "-G <number of generations>"));
		newVector.addElement(new Option("\tEnables scalation.\n" + "\t(default false)",
				"S", 0, "-S"));
		newVector.addElement(new Option("\tSet the minimum for scaling.\n" +
				"\t(default 1)",
				"M", 1, "-M <scale minimum>"));
		newVector.addElement(new Option("\tSet the maximum for scaling.\n" +
				"\t(default 20)",
				"X", 1, "-X <scale maximum>"));
		newVector.addElement(new Option("\tSet the random seed.\n",
				"R", 1, "-R <random seed>"));
		newVector.addElement(new Option("\tSet the error percentage.\n" +
				"\t(default 0.2)",
				"E", 1, "-E <error percentage>"));
		newVector.addElement(new Option("\tEnables debug mode.\n" + "\t(default false)",
				"D", 0, "-D"));

		return newVector.elements();
	}

	/**
	 * Returns a string describing classifier
	 * @return a description suitable for
	 * displaying in the explorer/experimenter gui
	 */
	public String globalInfo() {

		return "Global information\n\n" + getTechnicalInformation().toString();
	}

	/**
	 * Returns an instance of a TechnicalInformation object, containing
	 * detailed information about the technical background of this class,
	 * e.g., paper reference or book this class is based on.
	 *
	 * @return the technical information about this class
	 */
	public TechnicalInformation getTechnicalInformation() {
		TechnicalInformation result;

		result = new TechnicalInformation(Type.BOOK);
		result.setValue(Field.AUTHOR, "Sergio Padrino Recio");
		result.setValue(Field.YEAR, "2009");
		result.setValue(Field.TITLE, "GASUD");
		//result.setValue(Field.PUBLISHER, "Morgan Kaufmann Publishers");
		//result.setValue(Field.ADDRESS, "San Mateo, CA");

		return result;
	}

	/**
	 * Returns the revision string.
	 * 
	 * @return        the revision
	 */
	public String getRevision() {
		return RevisionUtils.extract("$Revision: 1.0 $");
	}

	/**
	 * Returns the capabilities of the classifier.
	 * @return the capabilities
	 */
	@Override
	public Capabilities getCapabilities() {
		Capabilities result = super.getCapabilities();   // returns the object from weka.classifiers.Classifier

		// attributes
		result.enable(Capability.NUMERIC_ATTRIBUTES);
		result.enable(Capability.MISSING_VALUES);

		// class
		result.enable(Capability.NOMINAL_CLASS);
		result.enable(Capability.MISSING_CLASS_VALUES);

		return result;
	}

	/**
	* Main method for testing this class
	*
	* @param args the commandline parameters
	*/
	public static void main(String[] args) {
		runClassifier(new GASUD(), args);
	}

	/**
	 * Class that represents a rule in this classifier.
	 */
	private class GASUD_Rule implements Serializable {

		private double mClass;
		private int mClassIndex;
		private int mNumAttributes;
		private double[][] mLimits;
		private double[][] mRefinedLimits;
		private double[] mAttrMax,  mAttrMin;
		private boolean mScaleEnabled;
		private double mScaleMin,  mScaleMax;
		private int[] mComparisonTypes;
		private int mCorrect,  mIncorrect;
		public final int NO_COMPARISON = 0;
		public final int LESS_THAN = 1;
		public final int GREATER_THAN = 2;
		public final int BETWEEN = 3;

		/**
		 * Constructor
		 * @param rule_class Class that the rule belongs to
		 * @param num_attributes Number of attributes involved.
		 * @param class_index Class attribute index.
		 * @param attr_max Maximums of each attribute.
		 * @param attr_min Minimums of each attribute.
		 * @param scale_enabled Is scaling enabled?
		 * @param scale_max Maximum for scaling.
		 * @param scale_min Minimum for scaling.
		 */
		public GASUD_Rule(double rule_class, int num_attributes, int class_index, double[] attr_max, double[] attr_min,
				boolean scale_enabled, double scale_max, double scale_min) {
			mClass = rule_class;
			mNumAttributes = num_attributes;

			mLimits = new double[mNumAttributes][2];
			mRefinedLimits = new double[mNumAttributes][2];
			mComparisonTypes = new int[mNumAttributes];

			mClassIndex = class_index;

			//Scaling data
			mAttrMax = attr_max;
			mAttrMin = attr_min;
			mScaleEnabled = scale_enabled;
			mScaleMin = scale_min;
			mScaleMax = scale_max;

			for (int i = 0; i < mNumAttributes; i++) {
				mComparisonTypes[i] = NO_COMPARISON;
			}
		}

		/**
		 * Returns the number of correctly classified instances.
		 * @return Returns the number of correctly classified instances.
		 */
		public int getCorrect() {
			return mCorrect;
		}

		/**
		 * Sets the number of correctly classified instances.
		 * @param mCorrect
		 */
		public void setCorrect(int mCorrect) {
			this.mCorrect = mCorrect;
		}

		/**
		 * Returns the number of incorrectly classified instances.
		 * @return Returns the number of incorrectly classified instances.
		 */
		public int getIncorrect() {
			return mIncorrect;
		}

		/**
		 * Sets the number of incorrectly classified instances.
		 * @param mCorrect
		 */
		public void setIncorrect(int mIncorrect) {
			this.mIncorrect = mIncorrect;
		}

		/**
		 * Sets the comparison mode for a specified attribute.
		 * @param attribute_index
		 * @param comparison
		 */
		public void setAttributeComparison(int attribute_index, int comparison) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes && comparison >= NO_COMPARISON && comparison <= BETWEEN);

			mComparisonTypes[attribute_index] = comparison;
		}

		/**
		 * Returns the class which the rule belongs to.
		 * @return Returns the class which the rule belongs to.
		 */
		public double getRuleClass() {
			return mClass;
		}

		/**
		 * Checks if the given instance is contained by the non-refined version of the rule.
		 * @param instance
		 * @return true if the instance is contained, false if not
		 */
		public boolean contains(Instance instance) {
			assert (instance != null);

			for (int i = 0; i < mNumAttributes; i++) {
				if (i == mClassIndex) {
					continue;
				}

				if (instance.value(i) < getLowerLimit(i) || instance.value(i) > getUpperLimit(i)) {
					return false;
				}
			}

			return true;
		}

		/**
		 * Checks if the given instance is contained by the refined version of the rule.
		 * @param instance
		 * @return true if the instance is contained, false if not
		 */
		public boolean containsRefined(Instance instance) {
			assert (instance != null);

			for (int i = 0; i < mNumAttributes; i++) {
				if (i == mClassIndex) {
					continue;
				}

				if (instance.value(i) < getLowerRefinedLimit(i) || instance.value(i) > getUpperRefinedLimit(i)) {
					return false;
				}
			}

			return true;
		}

		/**
		 * Checks if the given instance is contained by the non-refined version of the rule according to the comparison modes.
		 * @param instance
		 * @return true if the instance is contained, false if not
		 */
		public boolean check(Instance instance) {
			assert (instance != null);

			int counter = 0;

			for (int i = 0; i < mNumAttributes; i++) {
				if (i == mClassIndex) {
					continue;
				}

				switch (mComparisonTypes[i]) {
					case LESS_THAN:
						if (instance.value(i) >= getUpperLimit(i)) {
							return false;
						}
						break;
					case GREATER_THAN:
						if (instance.value(i) <= getLowerLimit(i)) {
							return false;
						}
						break;
					case BETWEEN:
						if (instance.value(i) <= getLowerLimit(i) || instance.value(i) >= getUpperLimit(i)) {
							return false;
						}
						break;
					default:
						counter++;
						break;
				}
			}

			return counter != mNumAttributes;
		}

		/**
		 * Checks if the given instance is contained by the refined version of the rule according to the comparison modes.
		 * @param instance
		 * @return true if the instance is contained, false if not
		 */
		public boolean checkRefined(Instance instance) {
			assert (instance != null);

			int counter = 0;

			for (int i = 0; i < mNumAttributes; i++) {
				if (i == mClassIndex) {
					continue;
				}

				switch (mComparisonTypes[i]) {
					case LESS_THAN:
						if (instance.value(i) > getUpperRefinedLimit(i)) {
							return false;
						}
						break;
					case GREATER_THAN:
						if (instance.value(i) < getLowerRefinedLimit(i)) {
							return false;
						}
						break;
					case BETWEEN:
						if (instance.value(i) < getLowerRefinedLimit(i) || instance.value(i) > getUpperRefinedLimit(i)) {
							return false;
						}
						break;
					default:
						counter++;
						break;
				}
			}

			return counter != mNumAttributes;
		}

		/**
		 * Returns the lower limit for an attribute from the non-refined version of the rule.
		 * @param attribute_index
		 * @return Returns the lower limit for an attribute from the non-refined version of the rule.
		 */
		public double getLowerLimit(int attribute_index) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			return mLimits[attribute_index][0];
		}

		/**
		 * Returns the upper limit for an attribute from the non-refined version of the rule.
		 * @param attribute_index
		 * @return Returns the upper limit for an attribute from the non-refined version of the rule.
		 */
		public double getUpperLimit(int attribute_index) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			return mLimits[attribute_index][1];
		}

		/**
		 * Sets the lower limit for an attribute from the non-refined version of the rule.
		 * @param attribute_index
		 * @param value
		 */
		public void setLowerLimit(int attribute_index, double value) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			mLimits[attribute_index][0] = value;
		}

		/**
		 * Sets the upper limit for an attribute from the non-refined version of the rule.
		 * @param attribute_index
		 * @param value
		 */
		public void setUpperLimit(int attribute_index, double value) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			mLimits[attribute_index][1] = value;
		}

		/**
		 * Returns the lower limit for an attribute from the refined version of the rule.
		 * @param attribute_index
		 * @return Returns the lower limit for an attribute from the refined version of the rule.
		 */
		public double getLowerRefinedLimit(int attribute_index) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			return mRefinedLimits[attribute_index][0];
		}

		/**
		 * Returns the upper limit for an attribute from the refined version of the rule.
		 * @param attribute_index
		 * @return Returns the upperlimit for an attribute from the refined version of the rule.
		 */
		public double getUpperRefinedLimit(int attribute_index) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			return mRefinedLimits[attribute_index][1];
		}

		/**
		 * Sets the lower limit for an attribute from the refined version of the rule.
		 * @param attribute_index
		 * @param value
		 */
		public void setLowerRefinedLimit(int attribute_index, double value) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			mRefinedLimits[attribute_index][0] = value;
		}

		/**
		 * Sets the upper limit for an attribute from the refined version of the rule.
		 * @param attribute_index
		 * @param value
		 */
		public void setUpperRefinedLimit(int attribute_index, double value) {
			assert (attribute_index >= 0 && attribute_index < mNumAttributes);

			mRefinedLimits[attribute_index][1] = value;
		}

		/**
		 * Clones a rule.
		 * @return the new clone.
		 */
		@Override
		public GASUD_Rule clone() {
			GASUD_Rule rule = new GASUD_Rule(mClass, mNumAttributes, mClassIndex, mAttrMax, mAttrMin, mScaleEnabled, mScaleMax, mScaleMin);

			for (int i = 0; i < mNumAttributes; i++) {
				if (i == mClassIndex) {
					continue;
				}

				rule.setLowerLimit(i, getLowerLimit(i));
				rule.setUpperLimit(i, getUpperLimit(i));

				rule.setLowerRefinedLimit(i, getLowerRefinedLimit(i));
				rule.setUpperRefinedLimit(i, getUpperRefinedLimit(i));
			}

			return rule;
		}

		/**
		 * Returns a description of the rule.
		 *
		 * @return a description of the rule
		 */
		public String toString(boolean bRefined) {
			String result = "if ";

			int counter = 0;

			double[][] limits = (bRefined) ? ((double[][]) mRefinedLimits.clone()) : ((double[][]) mLimits.clone());

			if (mScaleEnabled) {
				for (int i = 0; i < mNumAttributes; i++) {
					if (i == mClassIndex) {
						continue;
					}

					for (int j = 0; j < 2; j++) {
						limits[i][j] = (limits[i][j] - mScaleMin) * (mAttrMax[i] - mAttrMin[i]) / (mScaleMax - mScaleMin) + mAttrMin[i];
					}
				}
			}

			for (int i = 0; i < mNumAttributes; i++) {
				if (i == mClassIndex) {
					continue;
				}

				String att_name = "att" + String.valueOf(i + 1);

				switch (mComparisonTypes[i]) {
					case LESS_THAN:
						result += att_name + " <= " + String.valueOf(limits[i][1]) + "\n   ";
						break;
					case GREATER_THAN:
						result += att_name + " >= " + String.valueOf(limits[i][0]) + "\n   ";
						break;
					case BETWEEN:
						result += att_name + " >= " + String.valueOf(limits[i][0]) + " and " + att_name + " <= " + String.valueOf(limits[i][1]) + "\n   ";
						break;
					default:
						counter++;
						break;
				}
			}

			result += "then class = " + String.valueOf(mClass) + "\nCorrect: " + mCorrect + ", Incorrect: " + mIncorrect;

			return (counter == mNumAttributes) ? "" : result;
		}
	}
}

