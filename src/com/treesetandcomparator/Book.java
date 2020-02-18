package com.treesetandcomparator;

import java.util.Comparator;

public class Book implements Comparable<Object> {

	private String title;
	private String author;
	private int year;

	public static final Comparator<Object> TITLE_COMPARATOR = new TitleComparator();


	public static class PubDateComparators {

		public static class PubDateAscComparator implements  Comparator<Object> {

			@Override
			public int compare(Object o1, Object o2) {

				int title = TITLE_COMPARATOR.compare(o1, o2);
				int year = ((Book) o1).getYear()-((Book) o2).getYear();

				if (year == 0) { 
					return ((title == 0) ? year : title); 
				} else { 
					return year; 
				} 
			}

		}

		public static class PubDateDescComparator implements Comparator<Object> {

			@Override
			public int compare(Object o1, Object o2) {

				int title = TITLE_COMPARATOR.compare(o1, o2);
				int year = ((Book) o2).getYear()-((Book) o1).getYear();

				if (year == 0) { 
					return ((title == 0) ? year : title); 
				} else { 
					return year; 
				} 
			}

		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/*public int hashCode() {
		return title.hashCode();
	}

	public boolean equals(Object o) {
		return (year == (((Book)o).getYear())) && (author.equals((((Book)o).getAuthor())));
	}*/	

	public int compareTo(Object book) {
		return getTitle().compareTo(((Book)book).getTitle()); // utilizing String’s compareTo
	}

}

class TitleComparator implements Comparator<Object> {    

	public int compare(Object o1, Object o2) {
		return ((Book) o1).getTitle().compareTo(((Book) o2).getTitle());
	}   

}
