package org.example.practice.interview.preparation.kit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DictionariesAndHashmaps {

	void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> wordMap = new ConcurrentHashMap<>();
		for (int i = 0; i < magazine.length; i++) {
			String currentWord = magazine[i];

			if (wordMap.containsKey(currentWord)) {
				wordMap.put(currentWord, wordMap.get(currentWord) + 1);
			} else {
				wordMap.put(currentWord, 1);
			}
		}

		for (int i = 0; i < note.length; i++) {
			if (!wordMap.containsKey(note[i])) {
				System.out.println("No");
				return;
			}
			if (wordMap.get(note[i]) == 1) {
				wordMap.remove(note[i]);
				continue;
			} else {
				wordMap.put(note[i], wordMap.get(note[i]) - 1);
			}
		}

		System.out.println("Yes");
	}

	String twoStrings(String s1, String s2) {
		Set<Character> characterSet = s1.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());

		for (int i = 0; i < s2.length(); i++) {
			if (characterSet.contains(s2.charAt(i))) {
				return "YES";
			}
		}
		return "NO";
	}

	int sherlockAndAnagrams(String s) {

		Function<String, String> alphabetizeCharacters = (String unsortedCharacters) -> {
			char[] sortedCharacters = unsortedCharacters.toCharArray();
			Arrays.sort(sortedCharacters);
			return String.valueOf(sortedCharacters);
		};

		Map<String, Integer> anagrams = new ConcurrentHashMap<>();
		for (int startIndex = 0; startIndex < s.length(); startIndex++) {
			for (int length = 1; length < s.length() - startIndex + 1; length++) {
				String alphabetizedString = alphabetizeCharacters.apply(s.substring(startIndex, startIndex + length));
				if (!anagrams.containsKey(alphabetizedString)) {
					anagrams.put(alphabetizedString, 1);
				} else {
					anagrams.put(alphabetizedString, anagrams.get(alphabetizedString) + 1);
				}
			}
		}

		return anagrams.values().stream().mapToInt(Integer::intValue).map(count -> count * (count - 1)).sum() / 2;
	}

	long countTriplets(List<Long> arr, long r) {
		int tripletCount = 0;
		Map<Long, Long> valuesMap = arr.stream().collect(Collectors.groupingBy(Long::longValue, Collectors.counting()));

		// cannot go back in order to get triplet!
		for (long number : arr) {
			long secondTriplet = number * r;
			if (valuesMap.containsKey(secondTriplet)) {
				long secondTripletCount = valuesMap.get(secondTriplet);
				long thirdTriplet = secondTriplet * r;
				if (valuesMap.containsKey(thirdTriplet)) {
					tripletCount += secondTripletCount * valuesMap.get(thirdTriplet);
				}
			}
		}

		return tripletCount;
	}

	List<Integer> freqQuery(int[][] queries) {
		List<Integer> toReturn = new CopyOnWriteArrayList<>();

		int numberOfQueries = queries.length;

		Map<Integer, Integer> valueToFrequency = new ConcurrentHashMap<>(numberOfQueries / 2);
		Map<Integer, Integer> frequencyToOccurrences = new ConcurrentHashMap<>(numberOfQueries / 2);

		final int add = 1;
		final int remove = 2;
		final int print = 3;

		for(int i = 0; i < queries.length; i++) {
			int operation = queries[i][0];
			int value = queries[i][1];

			if (operation == print) {
				toReturn.add(frequencyToOccurrences.getOrDefault(value, 0) > 0 ? 1 : 0);
				continue;
			}

			Integer parse = valueToFrequency.get(value);
			int currentFrequency = parse == null ? 0 : parse;
			parse = frequencyToOccurrences.get(currentFrequency);
			int currentOccurrences = parse == null ? 0 : parse;

			int updatedFrequency;
			int updatedOccurrences;

			if (operation == add) {
				updatedFrequency = currentFrequency + 1;
			} else {
				updatedFrequency = currentFrequency - 1;
			}

			parse = frequencyToOccurrences.get(updatedFrequency);
			updatedOccurrences = parse == null ? 0 : parse;

			if (updatedFrequency < 1) {
				valueToFrequency.remove(value);
			} else {
				valueToFrequency.put(value, updatedFrequency);
			}

			if (currentFrequency < 0) {
				frequencyToOccurrences.remove(value);
			} else {
				frequencyToOccurrences.put(currentFrequency, currentOccurrences - 1);
			}

			frequencyToOccurrences.put(updatedFrequency, updatedOccurrences + 1);
		}

		return toReturn;
	}
}
