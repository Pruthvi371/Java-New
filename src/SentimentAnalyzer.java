

/**
 * @author Pruthvi
 *
 */
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
				if(review.contains(s)) 
			featureOpinions[i] = getOpinionOnFeature(review, s, posOpinionWords, negOpinionWords);
			}
		}
 
		return featureOpinions;
	}

	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		
		int opinion = 0;
		opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
		opinion= checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
		return opinion;
	}	

	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		
		int opinion = 0;
		String pattern = feature + " was ";

		for(int j =0 ; j<posOpinionWords.length;j++) {
		
			String opString =  posOpinionWords[j];
			if(review.contains(opString)&&
			  (review.indexOf(opString)==review.indexOf(pattern)+pattern.length()+1))  
			 opinion = 1;
			
		}
		
		for(int i = 0 ; i<negOpinionWords.length;i++) {
			
			String negString = negOpinionWords[i];
			if (review.contains(negString)&&
			   (review.indexOf(negString)==review.indexOf(pattern)+pattern.length()+1)) 
				opinion = -1;
		}
		return opinion; 	
	}
	
	private static int checkForOpinionFirstPattern(String review, String feature,
			String[] posOpinionWords,String[] negOpinionWords) {
		
		int opinion = 0;
		for(int j =0 ; j<posOpinionWords.length;j++) {
			String opString =  posOpinionWords[j];
			if(review.contains(opString)&&
			  (review.indexOf(feature)==review.indexOf(opString)+opString.length()+1))  
			  opinion = 1;
		
		}
		
		
		for(int i = 0 ; i<negOpinionWords.length;i++) {
			String negString = negOpinionWords[i];
			if (review.contains(negString)&&
			   (review.indexOf(feature)==review.indexOf(negString)+negString.length()+1)) 
				opinion = -1;
		}
		
		return opinion;
	}
	
	
}