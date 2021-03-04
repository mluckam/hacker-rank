package org.example.practice.interview.preparation.kit;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

	void countSwaps(int[] a) {
		int swaps = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					swaps++;
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}

		System.out.printf("Array is sorted in %d swaps.\n", swaps);
		System.out.printf("First Element: %d\n", a[0]);
		System.out.printf("Last Element: %d\n", a[a.length - 1]);
	}

	int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		int toyCount = 0;
		for (int i = 0; i < prices.length; i++) {
			k -= prices[i];
			if (k > 0) {
				toyCount++;
			} else {
				break;
			}
		}

		return toyCount;
	}

	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	class Checker implements Comparator<Player> {
		public int compare(Player a, Player b) {
			if(a.score == b.score) {
				b.name.compareTo(a.name);
			}

			return b.score - a.score;
	    
	    }
	}
}
