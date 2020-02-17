package com.jvm.unittester;

import java.lang.reflect.Method;

public class SimpleUnitTester {
	
	public static int execute(Class<?> clazz) throws Exception {
		int failedCount = 0;
		Reflection reflection = new Reflection();	
		for(Method m: clazz.getDeclaredMethods()) {
			String methodName = m.getName();
			if(methodName.startsWith("test")) {
				if(m.invoke(reflection).equals(false))
					failedCount++;
			}
		}
		return failedCount;
	}
	
	
	public static void main (String args []) throws Exception {
		
		Class<?> clazz = null;
		try {
			clazz = Class.forName("com.jvm.unittester.Reflection");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		System.out.println("Failed Counts are  "+execute(clazz));
		
	}

}