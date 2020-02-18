package com.sentimentanalyser;
import java.util.Arrays;


 
public class SentimentAnalyzer {

	/**
	 * @param review
	 * @param featureSet
	 * @param posOpinionWords
	 * @param negOpinionWords
	 * @return
	 */
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
			String[] negOpinionWords) {

		int[] featureOpinions = new int[featureSet.length]; // output

		for(int i = 0 ; i<featureSet.length ;i++) {
			for(String s :featureSet[i]) {
				if(review.contains(s)) {
					featureOpinions[i] = getOpinionOnFeature(review, s, posOpinionWords, negOpinionWords);
				}
			}
		}

		return featureOpinions;
	}

	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {

		int opinion = 0;
		opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
		if(opinion==0) {
		 opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
		}
		return opinion;
	}	

	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {

		int opinion = 0;
		String pattern = feature + " was ";

		for(String opString :  posOpinionWords) {

			if(review.contains(opString)&&(review.indexOf(opString)==(review.indexOf(pattern)+pattern.length())))  {
				opinion = 1;
			}
				

		}

		for (String negString : negOpinionWords) {

			if (review.contains(negString)&&
					(review.indexOf(negString)==(review.indexOf(pattern)+pattern.length()))) 
				opinion = -1;
		}
		return opinion; 	
	}

	private static int checkForOpinionFirstPattern(String review, String feature,
			String[] posOpinionWords,String[] negOpinionWords) {

		int opinion = 0;
		for(String opString :  posOpinionWords) {
			if(review.contains(opString)&&
					(review.indexOf(feature)==(review.indexOf(opString)+opString.length()+1)))  
				opinion = 1;

		}
		for(String negString : negOpinionWords) {
			if (review.contains(negString)&&
					(review.indexOf(feature)==(review.indexOf(negString)+negString.length()+1))) 
				opinion = -1;
		}
		return opinion;
	}

	public static void main(String[] args) throws ClassNotFoundException, Exception {

		String review = "Haven't been here in years! Fantastic service and the food was bad! Definetly will be a frequent flyer! Francisco was very attentive".toLowerCase();

//		String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude.The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.".toLowerCase();

		String[][] featureSet = { 
				{ "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
		"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));

		
	}	
}