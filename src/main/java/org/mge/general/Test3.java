package org.mge.general;

public class Test3 {
	public static void main(String[] args) {
		
		//System.out.println(((char)-1));
		
		char[] digitChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		int[] sizes = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
		
		int data = Integer.MIN_VALUE+1;
		
		if(data == 0) {
			System.out.println('0');
			return;
		}
		
		if(data == Integer.MIN_VALUE) {
			System.out.println("-2147483648");
			return;
		}
		int n = data;
		char sign = 0;
		if(n < 0) {
			sign = '-';
			n = -n;
		}
		int stringSize = 0;
		for(int i = 0; i < sizes.length; i++) {
			if(n <= sizes[i]) {
				stringSize = i + 1;
				break;
			}
		}
		
		if(sign != 0) {
			stringSize++;
		}
		char[] buf = new char[stringSize];
		int j = stringSize-1;
		
		while(n > 0) {
			int r = n % 10;
			buf[j--] = digitChars[r];
			n = n / 10;
		}
		
		if(sign != 0) {
			buf[0] = sign;
		}
		
		String str = new String(buf);
		
		System.out.println(str);
	}
}
