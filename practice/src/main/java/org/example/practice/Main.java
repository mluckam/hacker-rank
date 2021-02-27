package org.example.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> toReturn = Arrays.asList(new Integer[] { 0, 0 });

		for (int i = 0; i < 3; i++) {
			if (a.get(i) > b.get(i)) {
				toReturn.set(0, toReturn.get(0) + 1);
			} else if (a.get(i) < b.get(i)) {
				toReturn.set(1, toReturn.get(1) + 1);
			}
		}

		return toReturn;
	}

	public static int diagonalDifference(List<List<Integer>> arr) {
		int primaryDiagonal = 0;
		int secondaryDiagonal = 0;

		for (int i = 0; i < arr.size(); i++) {
			primaryDiagonal += arr.get(i).get(i);
			secondaryDiagonal += arr.get(i).get(arr.size() - (i + 1));
		}

		return Math.abs(primaryDiagonal - secondaryDiagonal);

	}

	static void plusMinus(int[] arr) {
		int positives = 0;
		int zeros = 0;
		int negatives = 0;
		float totalNumbers = arr.length;

		for (int i = 0; i < totalNumbers; i++) {
			int value = arr[i];
			if (value > 0) {
				positives++;
			} else if (value == 0) {
				zeros++;
			} else {
				negatives++;
			}
		}

		System.out.printf("%.6f%n", positives / totalNumbers);
		System.out.printf("%.6f%n", negatives / totalNumbers);
		System.out.printf("%.6f%n", zeros / totalNumbers);
	}

	static void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			int numberOfSpaces = n - i;
			int numberOfBangs = i;

			String spaces = String.join("", Collections.nCopies(numberOfSpaces, " "));
			String bangs = String.join("", Collections.nCopies(numberOfBangs, "#"));

			System.out.println(spaces + bangs);
		}
	}

	static void miniMaxSum(int[] arr) {
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		System.out.printf("%d %d", list.stream().sorted().limit(4).mapToLong(Integer::longValue).sum(),
				list.stream().sorted(Comparator.reverseOrder()).limit(4).mapToLong(Integer::longValue).sum());
	}

	public static int birthdayCakeCandles(List<Integer> candles) {
		int largest = Collections.max(candles);
		return Collections.frequency(candles, largest);
	}

	static int superDigit(String n, int k) {
		if (n.length() == 1) {
			return Integer.parseInt(n);
		}

		long sum = addCharacters(n);

		if (k > 1) {
			sum *= k;
		}

		return superDigit(String.valueOf(sum), 1);
	}

	private static long addCharacters(String n) {
		long sum = 0;
		for (Character c : n.toCharArray()) {
			int character = Character.getNumericValue(c);
			if (character > -1) {
				sum += character;
			}
		}
		return sum;
	}

	public static void main(String[] args) {

	}

}
