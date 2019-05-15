package com.ria.java;

import java.util.Arrays;

public class ToLowerCase {

	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello"));
		
		String [] s = {"hello", "ria", "gupta"};
		Arrays.sort(s);
		for (String string : s) {
			System.out.println(string);
		}
	}
	
	public static String toLowerCase(String str) {
        char [] array = str.toCharArray();
        for(int i=0; i<array.length; i++) {
            int ch = array[i];
            if(ch<=90 && ch>=65) {
                array[i] = (char) (array[i]+32);
            }
        }
        return String.valueOf(array);
    }

}
