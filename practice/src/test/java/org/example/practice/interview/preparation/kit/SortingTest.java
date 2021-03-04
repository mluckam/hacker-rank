package org.example.practice.interview.preparation.kit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingTest {

	private Sorting sut;

	@BeforeEach
	void setup() {
		sut = new Sorting();
	}

	@Test
	void testCountSwaps() {
		String expectedOutput = "Array is sorted in 3 swaps.\n"
				+ "First Element: 1\n"
				+ "Last Element: 6\n";
		ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stdOut));

		int[] input = {6,4,1};
		sut.countSwaps(input);

		assertEquals(expectedOutput, stdOut.toString());
	}

	@Test
	void testMaximumToys() {
		int[] prices = {1, 12, 5, 111, 200, 1000, 10};
		int k = 50;
		int expectedOutput = 4;
		int actualOutput = sut.maximumToys(prices, k);

		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testCompare() {
		Arrays.sort(player, new Sorting.Checker());
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }()
	}

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}
}
