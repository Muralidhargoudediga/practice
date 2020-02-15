package org.mge.general;

import java.util.ArrayList;
import java.util.List;

public class MissingDigit {
	public static void main(String[] args) {
		System.out.println(findDigit("3x + 12 = 46"));
		System.out.println(findDigit("1X0 * 12 =12000"));
		System.out.println(findDigit("3+4=X"));
		System.out.println(findDigit("100* 25 = 2X00"));
		System.out.println(findDigit("100 / 1X =10"));
		System.out.println(findDigit("15 - X = 3"));
	}

	public static int findDigit(String str) {
		char sign = 0;
		int j = 0;
		List<String> list = new ArrayList<>(3);
		StringBuilder sb = new StringBuilder();
		int index = -1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '+' || c == '-' || c == '/' || c == '*' || c == '=') {
				if (c != '=')
					sign = c;
				list.add(sb.toString());
				sb = new StringBuilder();
			} else if (c != ' ') {
				if (c == 'x' || c == 'X') {
					j = list.size() + 1;
					index = sb.length();
				}
				sb.append(c);
			}
		}

		list.add(sb.toString());

		String res = "";

		switch (sign) {
		case '+':
			if (j == 1) {
				res = performOperation(list.get(2), list.get(1), '-');
			} else if (j == 2) {
				res = performOperation(list.get(2), list.get(0), '-');
			} else {
				res = performOperation(list.get(0), list.get(1), sign);
			}
			break;

		case '-':
			if (j == 1) {
				res = performOperation(list.get(2), list.get(1), '+');
			} else if (j == 2) {
				res = performOperation(list.get(0), list.get(2), '-');
			} else {
				res = performOperation(list.get(0), list.get(1), sign);
			}
			break;

		case '*':
			if (j == 1) {
				res = performOperation(list.get(2), list.get(1), '/');
			} else if (j == 2) {
				res = performOperation(list.get(2), list.get(0), '/');
			} else {
				res = performOperation(list.get(0), list.get(1), sign);
			}
			break;

		case '/':
			if (j == 1) {
				res = performOperation(list.get(2), list.get(1), '*');
			} else if (j == 2) {
				res = performOperation(list.get(0), list.get(2), '/');
			} else {
				res = performOperation(list.get(0), list.get(1), sign);
			}
			break;
		}

		return res.charAt(index) - '0';
	}

	static String performOperation(String s1, String s2, char sign) {
		int op1 = Integer.parseInt(s1);
		int op2 = Integer.parseInt(s2);
		int res = -1;
		switch (sign) {
		case '+':
			res = op1 + op2;
			break;

		case '-':
			res = op1 - op2;
			break;

		case '*':
			res = op1 * op2;
			break;

		case '/':
			res = op1 / op2;
		}

		return String.valueOf(res);
	}

	public static int findDigit1(String str) {

		str = str.replace(" ", "").toLowerCase();
		String[] arr = str.split("-|\\+|\\*|/|=");
		int index = -1;
		if (str.contains("+")) {
			index = arr[0].indexOf("x");
			if (index != -1) {
				String r = Integer.parseInt(arr[2]) - Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[1].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[2]) - Integer.parseInt(arr[0])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[2].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}
		}

		if (str.contains("-")) {
			index = arr[0].indexOf("x");
			if (index != -1) {
				String r = Integer.parseInt(arr[2]) + Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[1].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[2].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}
		}

		if (str.contains("*")) {
			index = arr[0].indexOf("x");
			if (index != -1) {
				String r = Integer.parseInt(arr[2]) / Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[1].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[2]) / Integer.parseInt(arr[0])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[2].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}
		}

		if (str.contains("/")) {
			index = arr[0].indexOf("x");
			if (index != -1) {
				String r = Integer.parseInt(arr[2]) * Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[1].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[0]) / Integer.parseInt(arr[2])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}

			index = arr[2].indexOf("x");

			if (index != -1) {
				String r = Integer.parseInt(arr[0]) / Integer.parseInt(arr[1])
						+ "";
				return Integer.parseInt(r.substring(index, index + 1));
			}
		}

		return -1;
	}
}
