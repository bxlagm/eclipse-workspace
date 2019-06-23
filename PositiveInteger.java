import java.util.*;
import java.util.Scanner;
/**
 * a number entered by the user is tested to check 
 * whether it is perfect, abundant and narcissistic in the mathematical sense
 * @author Alberto
 *
 */
public class PositiveInteger {

	// structure: variables, constructor, verbs, main, getters
	
	// variables
	int number=0;
	int numberB=0;
	static boolean perfect=false;
	static boolean abundant=false;
	static boolean narcissistic=false;
	
	// constructor
	public PositiveInteger(int numberB) {
		this.number=numberB;
	}

	// verbs
	
	public boolean isPerfect(int numberB, int sumFactorsB) {
		if (sumFactorsB==numberB) {
			perfect=true;
		}
		return perfect;
	}
	public boolean isAbundant(int numberB, int sumFactorsB) {
		if (sumFactorsB>numberB) {
			abundant=true;
		}
		return abundant;
	}
	public boolean isNarcissistic(int numberB, int sumNarcissisticB) {
		if (sumNarcissisticB==numberB) {
			narcissistic=true;
		}
		return narcissistic;
	}
	
	public static void main(String[] args) {

		// Construct number, using user's entry
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int numberA=scan.nextInt();	
		PositiveInteger number= new PositiveInteger(numberA);

		// derive all the factors of a number
		ArrayList<Integer> factorList=new ArrayList<Integer>();
		for (int i=numberA-1; i>0; i=i-1) {
			if (numberA%i==0) {
				factorList.add(i);
			}	
		}	
		System.out.println("Here are all factors:");				
		int size=factorList.size();
		for (int i=size; i>0; i=i-1) {
			System.out.print(i+" ");
		}
		System.out.println();

		// find the sum of all factors
		int sumFactors=0;
		for (int i=0; i<size; i++) {
			sumFactors=sumFactors+factorList.get(i);
		}
		System.out.println("The sum of the factors is "+sumFactors+".");
		System.out.println();
				
		// check whether the number is perfect
		number.isPerfect(numberA, sumFactors);
	
		if (perfect==true) {
			System.out.println("The number "+numberA+" is perfect");
		} else	{
			System.out.println("The number "+numberA+" is NOT perfect");
		}
		System.out.println();
	
		// check whether the number is abundant 	
		number.isAbundant(numberA, sumFactors);
		if (abundant==true) {
			System.out.println("The number "+numberA+" is abundant");
		} else	{
			System.out.println("The number "+numberA+" is NOT abundant");
		}
		System.out.println();
		
		// count the number of digits
		int numberToCountDigits=numberA;
		int count=0;
		while (numberToCountDigits>=1) {
			numberToCountDigits = numberToCountDigits/10;
			count=count+1;
		}
		System.out.println("The number has "+count+" digits");

		// arraylist of digits
		ArrayList<Integer> digitList=new ArrayList<Integer>();
		int locationInArray=0;
		int numberDeconstructed=numberA;
		for (int i=count; i>0; i=i-1) {
			double denominatorAsDouble=Math.pow(10, i-1);
			int denominatorAsInteger= (int) denominatorAsDouble;
			digitList.add(locationInArray,numberDeconstructed/denominatorAsInteger);
			numberDeconstructed=numberDeconstructed-((numberDeconstructed/denominatorAsInteger)*denominatorAsInteger);
			locationInArray=locationInArray+1;
		}
		System.out.println("The individual digits are:");
		for (int i=0; i<digitList.size(); i++) {
			System.out.print(digitList.get(i)+"    ");
		}
		System.out.println();

		// sum of digits, each raised to the power of the digit-count
		int sumNarcissisticA=0;
		int additionalExponential=0;
		for (int i=0; i<digitList.size(); i++) {
			additionalExponential= (int) Math.pow(digitList.get(i),count);
			sumNarcissisticA=sumNarcissisticA+additionalExponential;
		}		
		System.out.println("The sum of digits raised to the power of the number of digits is: "+sumNarcissisticA);
		
		// check whether the number is narcissistic
		number.isNarcissistic(numberA, sumNarcissisticA);
		if (narcissistic==true) {
			System.out.println("The number "+numberA+" is narcissistic");
		} else	{
			System.out.println("The number "+numberA+" is NOT narcissistic");
		}	
	}
}
