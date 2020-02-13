package com.jvm.unittester;

import java.lang.reflect.Method;

public class SimpleUnitTester {
	


	@SuppressWarnings({ "rawtypes", "unused", "deprecation" })
	public int execute(Class clazz) throws Exception {
		int failedCount = 0;

		Object object = null;
		try {
			object = clazz.newInstance();
		} 	catch (InstantiationException e) {
			System.out.println("Cannot Instantiate  ");
		}  
			catch (IllegalAccessException e) {
			System.out.println("Cannot access..  ");
		}
		
		for(Method m: clazz.getDeclaredMethods()) {
			String methodName = m.getName();
			if(methodName.startsWith("test")) {
				@SuppressWarnings("unchecked")
				Method m1 = clazz.getDeclaredMethod("methodName");
				Object ob = m1.invoke(clazz);
				Boolean b = ((Boolean) ob).booleanValue();
				if(b==false)
					failedCount++;
			}
		}

		return failedCount;
	}

}