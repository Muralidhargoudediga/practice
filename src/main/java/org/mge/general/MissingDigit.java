package org.mge.general;

public class MissingDigit {
	public static void main(String[] args) {
		System.out.println(findDigit("3x + 12 = 46"));
		System.out.println(findDigit("1X0 * 12 =12000"));
		System.out.println(findDigit("3+4=X"));
		System.out.println(findDigit("100* 25 = 2X00"));
		System.out.println(findDigit("100 / 1X =10"));
		System.out.println(findDigit("15 - X = 3"));
	}

	public static int findDigit(String str){
		
		str = str.replace(" ", "").toLowerCase();
		String[] arr = str.split("-|\\+|\\*|/|=");
		int index = -1;
			if(str.contains("+")){
				index = arr[0].indexOf("x"); 
				if(index != -1) {
					String r = Integer.parseInt(arr[2]) - Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[1].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[2]) - Integer.parseInt(arr[0])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[2].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
			}
				
			if(str.contains("-")){
				index = arr[0].indexOf("x"); 
				if(index != -1) {
					String r = Integer.parseInt(arr[2]) + Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[1].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[2].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
			}
				
			if(str.contains("*")){
				index = arr[0].indexOf("x"); 
				if(index != -1) {
					String r = Integer.parseInt(arr[2]) / Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[1].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[2]) / Integer.parseInt(arr[0])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[2].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
			}
			
			if(str.contains("/")){
				index = arr[0].indexOf("x"); 
				if(index != -1) {
					String r = Integer.parseInt(arr[2]) * Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[1].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[0]) / Integer.parseInt(arr[2])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
				
				index = arr[2].indexOf("x");
				
				if(index != -1) {
					String r = Integer.parseInt(arr[0]) / Integer.parseInt(arr[1])+"";
					return Integer.parseInt(r.substring(index, index+1));
				}
			}
				
		
		return -1;
	}
}
