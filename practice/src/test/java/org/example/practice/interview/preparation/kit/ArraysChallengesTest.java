package org.example.practice.interview.preparation.kit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArraysChallengesTest {

    private ArraysChallenges sut;

    @BeforeEach
    void setup() {
        sut = new ArraysChallenges();
    }

    @Test
    void testHourglassSum() {
        int[][] arr = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
                { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
        int expectedOutput = 19;
        int actualOutput = sut.hourglassSum(arr);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testRotLeft() {
        int[] a = { 1, 2, 3, 4, 5 };
        int d = 4;
        int[] expectedOutput = { 5, 1, 2, 3, 4 };
        int[] actualOutput = sut.rotLeft(a, d);

        assertTrue(Arrays.equals(expectedOutput, actualOutput));

    }

    @Test
    void testMinimumBribes() {
        String expectedOutput = "7\n";
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
        sut.minimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 });

        assertEquals(expectedOutput, stdOut.toString());
    }

    @Test
    void testMinimumSwaps() {
        int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
        int expectedOutput = 5;
        int actualOutput = sut.minimumSwaps(arr);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testArrayManipulation() {
        int n = 10;
        int[][] queries = { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
        long expectedOutput = 10;
        long actualOutput = sut.arrayManipulation(n, queries);

        assertEquals(expectedOutput, actualOutput);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}
