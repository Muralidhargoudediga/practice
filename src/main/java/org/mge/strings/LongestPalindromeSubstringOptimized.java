package org.mge.strings;

public class LongestPalindromeSubstringOptimized {
	public static void main(String[] args) {
		String str = "aaaabba";
		System.out.println(longestPalindrome(str));
	}

	static String longestPalindrome(String str) {
		int n = str.length();
		int start = 0;
		int maxLength = 1;
		for (int i = 1; i < n; i++) {
			// Even length substring
			int l = i - 1;
			int h = i;
			while (l >= 0 && h < n) {
				if (str.charAt(l) == str.charAt(h)) {
					if (maxLength < (h - l + 1)) {
						maxLength = h - l + 1;
						start = l;
					}
					l--;
					h++;
				} else {
					break;
				}
			}

			// Odd length substring
			l = i - 1;
			h = i + 1;

			while (l >= 0 && h < n) {
				if (str.charAt(l) == str.charAt(h)) {
					if (maxLength < (h - l + 1)) {
						maxLength = h - l + 1;
						start = l;
					}
					l--;
					h++;
				} else {
					break;
				}
			}
		}

		return str.substring(start, start + maxLength);
	}
}
