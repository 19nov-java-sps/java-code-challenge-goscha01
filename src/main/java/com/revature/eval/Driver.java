package com.revature.eval;

public class Driver {

	public static void main(String[] args) {
		EvaluationService testMethod = new EvaluationService();
		String testString = "plomnit";
		String printing = testMethod.reverse("plomnit");
		
		System.out.println(printing);
		
		testMethod.acronym("Complementary metal-oxide semiconductor");

	}

}
