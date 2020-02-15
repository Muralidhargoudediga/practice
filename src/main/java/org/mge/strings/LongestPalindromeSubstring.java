package org.mge.strings;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		String str = "aaaabbaaaa";
		System.out.println(longestPalindrome(str));
	}

	static String longestPalindrome(String str) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		int start = 0;
		int maxLength = 1;
		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = true;
					if (maxLength < k) {
						start = i;
						maxLength = k;
					}
				}
			}
		}

		return str.substring(start, start + maxLength);
	}
}
