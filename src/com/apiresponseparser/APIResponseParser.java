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

	public static void main(String[] args) throws ClassNotFoundException, Exception {

		String response = "<work>" + 
				"<id type=\"integer\">2361393</id>" +
				"<books_count type=\"integer\">813</books_count>" +
				"<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
				"<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
				"<original_publication_year type=\"integer\">1854</original_publication_year>" +
				"<original_publication_month type=\"integer\" nil=\"true\"/>" +
				"<original_publication_day type=\"integer\" nil=\"true\"/>" +
				"<average_rating>3.79</average_rating>" +
				"<best_book type=\"Book\">" +
				"<id type=\"integer\">16902</id>" +
				"<title>Walden</title>" + 
				"<author>" +
				"<id type=\"integer\">10264</id>" + 
				"<name>Henry David Thoreau</name>" + 
				"</author>" +
				"<image_url>" + 
				"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
				"</image_url>" +
				"<small_image_url>" + 
				"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
				"</small_image_url>" +
				"</best_book>" +
				"</work>";

		Book b = APIResponseParser.parse(response);
		System.out.println(b.getRatingsCount());

	}
}