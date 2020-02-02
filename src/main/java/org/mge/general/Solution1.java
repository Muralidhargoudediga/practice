package org.mge.general;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

	static String isValid(String s) {
        int[] freq = new int[26];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            freq[j]++;
        }

        for(int i : freq) {
             if(i > 0 && i < min) {
                min = i;
            }

            if(i > max) {
                max = i;
            }
        }

        if((max-min) > 1) {
            return "NO";
        }

        if(min == max) {
            return "YES";
        }

        int minCount = 0;
        int maxCount = 0;
        for(int i : freq) {
            if(max == i) {
                maxCount++;
            }

            if(min == i) {
                minCount++;
            }
        }

        if(min == 1 && minCount == 1) {
            return "YES";
        }

        if(maxCount == 1) {
            return "YES";
        }

        return "NO";
    }
    
    private static File file = new File("D:/input.txt");
    private static Scanner scanner;
    
    static {
    	try {
    		scanner = new Scanner(file);
    	} catch(Exception e) {
    		
    	}
    }

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
