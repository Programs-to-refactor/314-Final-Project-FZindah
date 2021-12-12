/*	Farha Zindah
 *  12/11/2021
 *  COSC 314 Final Project
 *  
 *  Given a positive integer n and a nonnegative integer not
 *  exceeding n, find the number of r-permutations and rcombinations of a set with n elements.
 */

import java.math.BigInteger;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FinalProject {
	public static void main(String[] args) {
		
		// test rPermutationsAndCombinations method using JUnit
		Result result = JUnitCore.runClasses(FinalProjectTest.class);
		
		// print out failures if occur
		for(Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		System.out.println("Program successful: " + result.wasSuccessful());
		
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------------\n r-permutations "
				+ "and r-combinations calculator\n--------------------" + "-------------------------");
		
		// run program until user quits
		while (true) {
			try {
				System.out.print("Enter a positive integer (n) for num elements in set: ");
				int n = input.nextInt();
				System.out.print("\nEnter an integer for r: ");
				int r = input.nextInt();
				
				// call function
				BigInteger[] arr = rPermutationsAndCombinations(n, r);
				// print out values returned
				System.out.println("r-permutations: " + arr[0] + "\n" + "r-combinations: " + arr[1]);

			} catch (Exception e) {
				System.out.println("Please enter valid integers");
			}

			System.out.println("Try again? (yes/no)");
			input.nextLine();
			if (input.nextLine().equals("no")) {
				input.close();
				break;
			}
		}
	}

	/* method to find and return num r-Permutations and 
	 * rCombinations in a set
	 */
	public static BigInteger[] rPermutationsAndCombinations(int n, int r) throws Exception {
		
		// if values not applicable, throw exception
		if (n <= 0 || r > n || r < 0)
			throw new Exception();
		
		// declare BigInteger variables for factorials
		BigInteger nFact = BigInteger.valueOf(n);
		// 0! = 1, so if values == 0, change to 1;
		BigInteger rFact = (r == 0) ? new BigInteger("1") : BigInteger.valueOf(r);
		BigInteger nrFact = (n - r == 0) ? new BigInteger("1") : BigInteger.valueOf(n - r);

		// loop to calculate factorials for n, r, and n-r
		for (int i = n - 1; i > 0; i--) {
			nFact = BigInteger.valueOf(i).multiply(nFact);
			if (i < n - r)
				nrFact = BigInteger.valueOf(i).multiply(nrFact);
			if (i < r)
				rFact = BigInteger.valueOf(i).multiply(rFact);
		}

		// implement equations for permutations and combinations
		BigInteger rPerm = nFact.divide(nrFact);
		BigInteger rComb = nFact.divide(rFact.multiply(nrFact));

		return new BigInteger[] {rPerm, rComb};
	}
}
