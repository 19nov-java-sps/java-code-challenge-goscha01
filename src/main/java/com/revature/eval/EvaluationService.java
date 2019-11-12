package com.revature.eval;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */

	public String reverse(String string) {
		String reverseString = new String();
		if (string==null) {
			reverseString = null;
		} else {
			char [] array = new char [string.length()];
			for (int i=0; i< string.length(); i++) {
					array[i]=string.charAt((string.length()-1)-i);
					String charachter=Character.toString(array[i]);
					reverseString = reverseString.concat(charachter);
				}
		}
		return reverseString;
	}
	
	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		String acronym = new String();
		
		if (phrase==null) {
			acronym = null;
		} else {
			
			String [] stringArray = phrase.split("\\s|\\-");
			char[] charArray = new char [stringArray.length];
			
		for (int i=0; i<stringArray.length;i++) {
			charArray[i]=stringArray[i].charAt(0);
			String charachter=Character.toString(charArray[i]);
			acronym=acronym.concat(charachter.toUpperCase());
		}
		}

		return acronym;

	}
	
	
	/**
	 * 3. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		List<Character> string1 = Arrays.asList('A','E','I','O','U','L','N','R','S','T');
		List<Character> string2 = Arrays.asList('D','G');
		List<Character> string3 = Arrays.asList('B','C','M','P');
		List<Character> string4 = Arrays.asList('F','H','V','W','Y');
		List<Character> string5 = Arrays.asList('K');
		List<Character> string8 = Arrays.asList('J','X');
		List<Character> string10 = Arrays.asList('Q','Z');
		
				
		HashMap<Character,Integer> myHashMap1 = new HashMap<>();
			for (Character number: string1) {
				myHashMap1.put(number,1);
			}
		HashMap<Character,Integer> myHashMap2 = new HashMap<>();	
			for (Character number: string2) {
				myHashMap2.put(number,2);
			}
		HashMap<Character,Integer> myHashMap3 = new HashMap<>();
			for (Character number: string3) {
				myHashMap3.put(number,3);
			}
		HashMap<Character,Integer> myHashMap4 = new HashMap<>();	
			for (Character number: string4) {
				myHashMap4.put(number,4);
			}
		HashMap<Character,Integer> myHashMap5 = new HashMap<>();
			for (Character number: string5) {
				myHashMap5.put(number,5);
			}
		HashMap<Character,Integer> myHashMap8 = new HashMap<>();	
			for (Character number: string8) {
				myHashMap8.put(number,8);
			}
		HashMap<Character,Integer> myHashMap10 = new HashMap<>();	
			for (Character number: string10) {
				myHashMap10.put(number,10);
			}		
				
			HashMap<Character,Integer> myHashMap = new HashMap<>();
			myHashMap.putAll(myHashMap1);
			myHashMap.putAll(myHashMap2);
			myHashMap.putAll(myHashMap3);
			myHashMap.putAll(myHashMap4);
			myHashMap.putAll(myHashMap5);
			myHashMap.putAll(myHashMap8);
			myHashMap.putAll(myHashMap10);

	
			int [] numberArray = new int [string.length()];
			
			for (int i=0; i<string.length();i++) {
				char c = string.toUpperCase().charAt(i);
				numberArray[i]=myHashMap.get(c);
			}

			int result=Arrays.stream(numberArray).sum();
		
		return result;
	}
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	public Map<String, Integer> wordCount(String string) {
		
		String[] stringArray = string.split("\\s|\\,");
		
System.out.println(Arrays.toString(stringArray));
		
		HashMap<String,Integer> myHashMap = new HashMap<>();

		for (int i=0; i<stringArray.length; i++) {
			Integer count = myHashMap.get(stringArray[i]);
			if (count==null) {
				myHashMap.put(stringArray[i],1);
			}else {
				myHashMap.put(stringArray[i],++count);
			}

		}

		return myHashMap;
	}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int arrayLength=sortedList.size();
			int indexLow=0;
			int index;
			int indexHigh=arrayLength;
			int result = 0;
			
		do {
			index = (indexLow+indexHigh)/2;
			int i = (int) sortedList.get(index);
			Integer k = new Integer(i);
			
		  if  (t.hashCode()== k.hashCode()) {
				result = (int) sortedList.get(index);
			  } else if (t.hashCode() < k.hashCode()) {
			    indexHigh = index-1;
				System.out.println(t.hashCode());
		  } else {
			  indexLow= index+1;
				System.out.println(t.hashCode());
		  }
			} while(t.hashCode()!= result);
			
			System.out.println(index);
			System.out.println(result);
			
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}
