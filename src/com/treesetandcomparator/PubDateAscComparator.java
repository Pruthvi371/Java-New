package com.treesetandcomparator;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Object> {

//	@Override
//	public int compare(Book o1, Book o2) {
////		if(o1.getYear()!=o2.getYear()) {
////			return (o1.getYear()-o2.getYear());
////		}
////		else {
////			return (o1.getTitle().compareTo(o2.getTitle()));
////		}
//		
////		int title = o1.getTitle().compareTo(o2.getTitle()); 
////        int year = o1.getYear()-o2.getYear();
////        System.out.println(year+"  helllllllloooooo");
////
////        // 2-level comparison using if-else block 
////        if (year == 0) { 
////            return ((title == 0) ? year : title); 
////        } else { 
////            return year; 
////        } 
//
//		return (o1.getAuthor().compareTo(o2.getAuthor()));
//	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		 return (((Book) o2).getAuthor().compareTo(((Book) o1).getAuthor()));
	}
}
