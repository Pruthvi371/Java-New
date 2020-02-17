package com.treesetandcomparator;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if(o1.getYear() != o2.getYear() ) {
			return o2.getYear()-o1.getYear();
		}
		else{
			return o1.getTitle().compareTo(o2.getTitle());
		}

	}

}
