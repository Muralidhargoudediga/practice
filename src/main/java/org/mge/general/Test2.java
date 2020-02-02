package org.mge.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
	
	public static void main(String[] args) {
		System.out.println(sherlockAndAnagrams("abba"));
	}
	static int sherlockAndAnagrams(String s) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				String str = s.substring(j, j + i);
				char[] chars = str.toCharArray();
				Arrays.sort(chars);
				str = new String(chars);
				Integer c = map.get(str);
				if (c != null) {
					map.put(str, c + 1);
				} else {
					map.put(str, 1);
				}
			}
		}
		int noOfAnagrams = 0;
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			int c = e.getValue();
			int n = c - 1;
			noOfAnagrams += (n * (n + 1)) / 2;
		}

		return noOfAnagrams;
	}
}
