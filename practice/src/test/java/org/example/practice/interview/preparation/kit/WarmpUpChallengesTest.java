package org.example.practice.interview.preparation.kit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarmpUpChallengesTest {

	private WarmpUpChallenges sut;

	@BeforeEach
	void setup() {
		sut = new WarmpUpChallenges();
	}

	@Test
	void testSockMerchant() {
		int n = 7;
		int[] arr = new int[] { 1, 2, 1, 2, 1, 3, 2 };
		int expectedOuput = 2;
		int acutalOutput = sut.sockMerchant(n, arr);

		assertEquals(expectedOuput, acutalOutput);
	}

	@Test
	void testCountingValleys() {
	    int steps = 8;
	    String path = "UDDDUDUU";
	    int expectedOutput = 1;
	    int acutalOutput = sut.countingValleys(steps, path);

	    assertEquals(expectedOutput, acutalOutput);
	}

	@Test
	void testJumpingOnClouds() {
	    int[] clouds = new int[] {0, 0, 1, 0, 0, 1, 0};
	    int expectedOutput = 4;
	    int actualOutput = sut.jumpingOnClouds(clouds);

	    assertEquals(expectedOutput, actualOutput);
	    
	}

	@Test
	void testRepeatedString() {
	    String s = "abcac";
	    long n = 10;
	    int expectedOutput = 4;
	    long actualOutput = sut.repeatedString(s, n);

	    assertEquals(expectedOutput, actualOutput);
	}
}
