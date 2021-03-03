package org.example.practice.interview.preparation.kit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DictionariesAndHashmapsTest {

	private DictionariesAndHashmaps sut;

	@BeforeEach
	void setup() {
		sut = new DictionariesAndHashmaps();
	}

	@Test
	void testCheckMagazine() {
		String expectedOutput = "No\n";
		ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stdOut));
		String[] magazine = { "two", "times", "three", "is", "not", "four" };
		String[] note = { "five", "times", "two", "is", "four" };
		sut.checkMagazine(magazine, note);

		assertEquals(expectedOutput, stdOut.toString());
	}

	@Test
	void testTwoStrings() {
		String expectedOutput = "NO";
		String s1 = "hi";
		String s2 = "world";
		String actualOutput = sut.twoStrings(s1, s2);

		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testSherlockAndAnagrams() {
		int expectedOutput = 3;
		String input = "ifailuhkqq";
		int actualOutput = sut.sherlockAndAnagrams(input);

		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testCountTriplets() {
		long expectedOutput = 3;
		List<Long> arr = Arrays.asList(new Long[] { 1L, 2L, 1L, 2L, 4L });
		long r = 2;

		long actualOutput = sut.countTriplets(arr, r);

		assertEquals(expectedOutput, actualOutput);
		;

	}

	@Test
    void testFreqQuery() {
		List<Integer> expectedOutput = Arrays.asList(new Integer[] {0, 1});
    	int [][] queries = { {3, 4}, {2, 1003}, {1, 16}, {3, 1} };
    	List<Integer> actualOutput = sut.freqQuery(queries);

    	assertEquals(expectedOutput, actualOutput);
    }

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}
}
