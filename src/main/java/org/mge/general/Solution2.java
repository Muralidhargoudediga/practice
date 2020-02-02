package org.mge.general;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution2 {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int i = 0;
        while(i < arr.length-1) {
            if(arr[i] > arr[i+1]) {
                break;
            }
            i++;
        }

        if(i == arr.length - 1) {
            return 0;
        }
        long c = mergeSort(arr, i, arr.length-1);

        if(i != 0 && arr[i-1] > arr[i])
            c += merge(arr, 0, i-1, arr.length-1);

        return c;
    }

    static long mergeSort(int[] arr, int l, int h){
        if(l >= h)
            return 0;
        int m = (l+h)/2;
        
        long c = mergeSort(arr, l, m);
        c += mergeSort(arr, m+1, h);

        c += merge(arr, l, m, h);
        return c;
    }

    static long merge(int[] arr, int l, int m, int h){
        int[] aux = new int[arr.length];
        for(int i = l; i<=h; i++) {
            aux[i] = arr[i];
        }

        int i = l, j = m+1, k = l;

        long c = 0;

        while(i <= m && j <= h) {
            if(aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                c += j-k;
                arr[k++] = aux[j++];
            }
        }

        while(i<=m) {
            arr[k++] = aux[i++];
        }

        while(j<=h) {
            arr[k++] = aux[j++];
        }

        return c;
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
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            System.out.println(String.valueOf(result));
        }


        scanner.close();
    }
}

