package org.example.practice.interview.preparation.kit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WarmpUpChallenges {

    int sockMerchant(int n, int[] ar) {
        int numberOfPairs = 0;
        List<Integer> sortedSocks = Arrays.stream(ar).boxed().sorted().collect(Collectors.toList());

        for (int i = 0; i < sortedSocks.size() - 1; i++) {
            if (sortedSocks.get(i).equals(sortedSocks.get(i + 1))) {
                numberOfPairs++;
                i++;
            }
        }
        return numberOfPairs;
    }

    int countingValleys(int steps, String path) {
        long totalHeight = 0;
        int valleys = 0;
        @SuppressWarnings("unused")
        int mountains = 0;

        char uphill = 'U';

        char[] stepPath = path.toCharArray();
        for (int i = 0; i < stepPath.length; i++) {
            if (stepPath[i] == uphill) {
                if (totalHeight == 0) {
                    mountains++;
                }
                totalHeight++;
            } else {
                if (totalHeight == 0) {
                    valleys++;
                }
                totalHeight--;
            }
        }

        return valleys;
    }

    int jumpingOnClouds(int[] c) {
        int minimumNumberOfJumps = 0;

        int cumulus = 0;

        for (int i = 0; i < c.length - 1; i++) {
            if (i + 2 < c.length) {
                if (c[i + 2] == cumulus) {
                    minimumNumberOfJumps++;
                    i++;
                    continue;
                }
            }
            minimumNumberOfJumps++;
        }
        return minimumNumberOfJumps;
    }

    long repeatedString(String s, long n) {
        char characterToFind = 'a';
        
        //occurrences per instances
        long occurencesPerInstance = s.chars().filter(c -> c == characterToFind).count();
        long quotient = n / s.length();
        long occurrences = quotient * occurencesPerInstance;

        //get last occurrence count
        long remainder = n % s.length();
        String lastOccurence = s.substring(0, (int) remainder);
        occurrences += lastOccurence.chars().filter(c -> c == characterToFind).count();
        

        return occurrences;
    }
   
}
