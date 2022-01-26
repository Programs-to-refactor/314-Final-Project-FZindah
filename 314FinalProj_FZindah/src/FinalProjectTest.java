/* Farha Zindah
 * COSC 314 Final Project
 * 12/11/2021
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import java.math.BigInteger;

// Class to test Final Project
public class FinalProjectTest {
	
	// Test r-permutation values
	@Test
	public void testRPermutationsRandom() throws Exception {
		// check random numbers
		assertEquals(new BigInteger("20"), FinalProject.rPermutationsAndCombinations(5, 2)[0]);
	}
		// Test r-permutation edge values
	@Test
	public void testRPermutationsEdge() throws Exception {
		// check when r = 0
		assertEquals(new BigInteger("1"), FinalProject.rPermutationsAndCombinations(5, 0)[0]);
	}
		// Test r-permutation large values
	@Test
	public void testRPermutationsRandom() throws Exception {
		// check with big numbers
		assertEquals(new BigInteger("331284225412682501619179520000"), 
				FinalProject.rPermutationsAndCombinations(100, 15)[0]);
	}
	
	// Test r-combination values
	@Test
	public void testRCombinations() throws Exception {
		// check random numbers
		assertEquals(new BigInteger("10"), FinalProject.rPermutationsAndCombinations(5, 2)[1]);
	}
	
	// Test r-combination edge values
	@Test
	public void testRCombinations() throws Exception {
		// check when r = 0
		assertEquals(new BigInteger("1"), FinalProject.rPermutationsAndCombinations(5, 0)[1]);
	}
	
	// Test r-combination large values
	@Test
	public void testRCombinations() throws Exception {
		// check with big numbers
		assertEquals(new BigInteger("253338471349988640"), 
				FinalProject.rPermutationsAndCombinations(100, 15)[1]);
	}
	
	@Test
	@DisplayName("doesn't accept invalid values")
	public void Exceptions() {
		assertThrows(Exception.class, () -> FinalProject.rPermutationsAndCombinations(0,5));
	}
}
