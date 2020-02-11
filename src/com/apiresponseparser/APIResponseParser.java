package com.apiresponseparser;


public class APIResponseParser {
    
     public static Book parse(String response) {
        
    	Book book = new Book();
 		char endRule = '<';
 		
 		String startRule = "<title>";
 		String title = parse(response, startRule, endRule); 
 	    book.setTitle(title);
 		
 	    String startRule1 = "<author>";		
		String author = parse(response, startRule1, endRule); 
	    book.setAuthor(author);
	    
	    String startRule2 = "<original_publication_year type=\"integer\">";		
 		String publicationYear = parse(response, startRule2, endRule); 
 	    int year = Integer.parseInt(publicationYear);
 		book.setPublicationYear(year);
 	    
 		String startRule3 = "<average_rating>";		
		String avgRating = parse(response, startRule3, endRule); 
		double averageRating = Double.parseDouble(avgRating);
		book.setAverageRating(averageRating);
		
		String startRule4 = "<ratings_count type=\"integer\">";		
		String rateCount = parse(response, startRule4, endRule).replaceAll(",", ""); 
		int ratingsCount = Integer.parseInt(rateCount);
		book.setRatingsCount(ratingsCount);
		
		String startRule5 = "<image_url>";		
		String imgUrl = parse(response, startRule5, endRule); 
		book.setImageUrl(imgUrl);
		
 		return book;
		
     }
     
     private static String parse(String response, String startRule, char endRule) {
    	 	
    	 String value = "";
    	 	if(!(startRule.equals("<author>"))) 
     			value =  findSubString(response,startRule,endRule);
    	 	else
    	 		value =  findSubString(response,"<name>",endRule);
    	 	return value;
	}
     
	private static String findSubString(String response, String startRule, char endRule) {
		
		int startIndex = response.indexOf(startRule)+startRule.length();
		int endIndex = startIndex;
		while(response.charAt(endIndex)!='<') {
			endIndex++;
		}
		return response.substring(startIndex, endIndex);
		
	}


}