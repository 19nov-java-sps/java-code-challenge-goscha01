package com.revature.eval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.eval.EvaluationService.BinarySearch;

public class Driver {

	public static void main(String[] args) {
		EvaluationService testMethod = new EvaluationService();
		
		
		String testString = "olly olly in come free";
		//String printing = testMethod.reverse("plomnit");
		
		//System.out.println(printing);
		
	//	testMethod.acronym("Complementary metal-oxide semiconductor");
		
	//	testMethod.getScrabbleScore("dpoiufd");
		
		//testMethod.wordCount(testString);
		
		List<Integer> sortedListOfOddLength = Collections
				.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634));
		
		BinarySearch testMethod2 = new BinarySearch(sortedListOfOddLength);
		testMethod2.indexOf(55);
	
	}

}
