package com.treesetandcomparator;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {

		int title = ((Book) o1).getTitle().compareTo(((Book) o2).getTitle()); 
        int year = ((Book) o2).getYear()-((Book) o1).getYear();

        if (year == 0) { 
            return ((title == 0) ? year : title); 
        } else { 
            return year; 
        } 
	}

}
