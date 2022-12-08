package Decode;

import java.util.Arrays;
import java.util.List;

public class BWT {
	
	public String decode (String encString, int encNum) {
		
		String[] array = new String[encString.length()];
		for(int i = 0; i < encString.length(); i++){
			moveFront(encString, array);
			Arrays.sort(array);
		}
		String result = array[encNum];
		return result.substring(0, encString.length());
	}
	
	public static void moveFront(String s, String[] a){
		for (int i = 0; i < s.length(); i++){
			a[i] = s.charAt(i) + a[i];
		}
	}
}
