package org.example.practice.interview.preparation.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysChallenges {

    int hourglassSum(int[][] arr) {
        List<Integer> hourglassSums = new ArrayList<>();

        for (int row = 0; row < arr.length - 2; row++) {
            for (int column = 0; column < arr[row].length - 2; column++) {
                int hourglassSum = arr[row][column] + arr[row][column + 1] + arr[row][column + 2]
                        + arr[row + 1][column + 1] + arr[row + 2][column] + arr[row + 2][column + 1]
                        + arr[row + 2][column + 2];
                hourglassSums.add(hourglassSum);

            }
        }

        return hourglassSums.stream().sorted().max(Comparator.naturalOrder()).get();
    }

    int[] rotLeft(int[] a, int d) {
        List<Integer> toRotate = Arrays.stream(a).boxed().collect(Collectors.toList());

        List<Integer> lastPart = toRotate.subList(0, d);
        toRotate.addAll(lastPart);
        toRotate.subList(0, d).clear();

        return toRotate.stream().mapToInt(value -> value).toArray();
    }

    // unable to solve
    void minimumBribes(int[] q) {
        long totalBribes = 0;

        int maxBribe = 2;

        for (int i = 0; i < q.length; i++) {
            if (q[i] > i + maxBribe + 1) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - maxBribe); j < i; j++) {
                if (q[j] > q[i]) {
                    totalBribes++;
                }
            }

        }
        System.out.println(totalBribes);
    }

    int minimumSwaps(int[] arr) {
        int numberOfSwaps = 0;

        BiFunction<int[], Integer, Integer> indexOf = (array, value) -> {
            for (int i = 0; i < array.length; i++) {
                if (arr[i] == value) {
                    return i;
                }
            }
            return -1;
        };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int indexToSwap = indexOf.apply(arr, i + 1);
                arr[indexToSwap] = arr[i];
                arr[i] = i + 1;
                numberOfSwaps++;
            }
        }

        return numberOfSwaps;
    }

    long arrayManipulation(int n, int[][] queries) {
        BiFunction<Integer, int[][], long[]> findSlopes = (Integer queryEntries, int[][] queryArray) -> {
            long[] slopeArray = new long[queryEntries];
            for (int i = 0; i < queryArray.length; i++) {
                int startIndex = queryArray[i][0] - 1;
                int endIndex = queryArray[i][1] - 1;
                int valueToAdd = queryArray[i][2];

                slopeArray[startIndex] += valueToAdd;
                if (endIndex != queryEntries - 1) {
                    slopeArray[endIndex + 1] -= valueToAdd;
                }
            }
            return slopeArray;
        };

        Function<long[], Long> findMax = (long[] slopeArray) -> {
            long maxValue = 0;
            for (int i = 1; i < n; i++) {
                slopeArray[i] += slopeArray[i - 1];

                if (slopeArray[i] > maxValue) {
                    maxValue = slopeArray[i];
                }
            }

            return maxValue;
        };
        
        long[] slopeArray = findSlopes.apply(n, queries);
        
        return findMax.apply(slopeArray);

    }

}
