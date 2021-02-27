package org.example.practice;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("static-access")
public class MainTest {
	
	private Main sut;

	@BeforeEach
	void setup() {
		sut = new Main();
	}

	@Test
	void testComapreTriplets() {
		List<Integer> expected = Arrays.asList(new Integer[] {1,1});
		List<Integer> actual = sut.compareTriplets(Arrays.asList(new Integer[] {1,3,2}), Arrays.asList(new Integer[] {2,3,1}));
		
		assertEquals(expected, actual);
	}

	@Test
	void testDiagonalDifference() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(new Integer[] {1, 2, 3}));
		input.add(Arrays.asList(new Integer[] {4, 5, 6}));
		input.add(Arrays.asList(new Integer[] {9, 8, 9}));
		int expectedDifference  = 2;
		
		int actualDifference = sut.diagonalDifference(input);
		
		assertEquals(expectedDifference, actualDifference);
	}

	@Test
	void testPlusMinus() {
		String expectedOutput = "0.400000\n0.400000\n0.200000\n";
		ByteArrayOutputStream stdOut = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(stdOut));
		int[] input = {1, 1, 0, -1, -1};
		sut.plusMinus(input);

		assertEquals(expectedOutput, stdOut.toString());
	}

	@Test
	void testStaircase() {
		String expectedOutput = "   #\n  ##\n ###\n####\n";
		ByteArrayOutputStream stdOut = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(stdOut));
		sut.staircase(4);

		assertEquals(expectedOutput, stdOut.toString());
	}

	@Test
	void testMiniMaxSum() {
		String expectedOutput = "16 24";
		ByteArrayOutputStream stdOut = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(stdOut));
		System.setOut(new PrintStream(stdOut));
		int[] input = new int[] {1, 3, 5, 7, 9};
		sut.miniMaxSum(input);

		assertEquals(expectedOutput, stdOut.toString());
	}

	@Test
	void testBirthdayCakeCandles() {
		int expectedOutput = 2;
		List<Integer> input = Arrays.asList(new Integer[] {4, 4, 1, 3});
		int actualOutput = sut.birthdayCakeCandles(input);

		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testSuperDigit() {
		int expectedOutput = 3;
		String n = "148";
		int k = 3;
		int actualOutput = sut.superDigit(n, k);

		assertEquals(expectedOutput, actualOutput);
	}

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}
}
