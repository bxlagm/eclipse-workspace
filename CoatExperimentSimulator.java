import java.util.Scanner;

/**
 * Enter number of people (people) and assess the following:
 *   a.  probability of 0 people getting their coats
 *   b.  average number of people who get their coats back
 * based on X number of simulations run 
 * @author Alberto
 */
public class CoatExperimentSimulator {

	
	/**  structure:  variables, constructor, methods, main, getters */

	/**  variables */ 
	int numberPeople=0;
	static int iterationsA=1000000;
	static int sampleA=0;
	static int matchA=0;
	static int[] matchC=new int[iterationsA];
	static int indexA=0;
	static double probabilityZero=0.00;
	static double avgMatches=0.00;

	/** constructor:  set the number of people at party 
	 * @param numPpl 	*/
	public CoatExperimentSimulator(int numPpl) {
		this.numberPeople=numPpl;
	}

	/** methods: */
	
	/**  method array with results of all simulations, returning 
	 * number of people who get their coats back in each simulation  	*/
	public int[] simulateCoatExperiment(int matchB, int indexB) {	
		matchC[indexB]=matchB;
		return matchC;
	}

	/**  method find coat:  run simulation once to determine number of people who found their coat */

	public void numPplWhoGotTheirCoat(int sampleB) {
		// run the simulation once
		matchA=0;
		int[] randomArrangementFrom1To10 = RandomOrderGenerator.getRandomOrder(sampleB);
		for (int i=0; i<sampleB; i++) {
			if(randomArrangementFrom1To10[i]==(i+1)) {
				matchA=matchA+1;
			}
		}
	}

	/**  method answer A:  after X runs, compute probability of 0 people getting their coats */   	
	public double answerToQuestionA(int[] matchD) {
		int sumOfZero=0;
		for (int i=0; i<iterationsA; i++) {
			if(matchD[i]==0) {
				sumOfZero=sumOfZero+1;
			}
		}
		double sumOfZeroAsDouble=sumOfZero*1.00;
		probabilityZero=sumOfZeroAsDouble/iterationsA;
		return probabilityZero;
	}

	/**  method answer B:  after X runs, compute average number of people who get their coats */   	
	public double answerToQuestionB(int[] matchE) {
		double sumMatches=0;
		for (int i=0; i<iterationsA; i++ ) {
			sumMatches=sumMatches+matchE[i];
		}
		double sumMatchesAsDouble=sumMatches*1.00;
		avgMatches=sumMatches/iterationsA;
		return avgMatches;
	}
	
	
	/**  main:     
	 * @param args */
	public static void main(String[] args) {

		// Construct CoatExperimentSimulator with N people.  Get sample size from user
		Scanner scan=new Scanner(System.in);
		System.out.println("How many people get their coat: ");
		int sampleA=scan.nextInt();	
		CoatExperimentSimulator experiment = new CoatExperimentSimulator(sampleA);

		// run the simulation X times
		for (int i=0; i<iterationsA; i++) {
			experiment.numPplWhoGotTheirCoat(sampleA);
			indexA=i;
			experiment.simulateCoatExperiment(matchA, indexA);
		}
		
		// print the probability of 0 people getting their coats back
		experiment.answerToQuestionA(matchC);
		System.out.println();
		System.out.println("The probability of zero people getting their coats back is "+probabilityZero);
		
		// print the average number of people who get their hats back
		experiment.answerToQuestionB(matchC);
		System.out.println();
		System.out.println("The average number of people who get their coats back is "+avgMatches);

		// print estimate of e-value (probability of 0 people = 1/e as sample grows to 100K
		System.out.println();
		System.out.println("The estimate of the value e is: "+(1/probabilityZero));

	}
}
