package org.mge.ds.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ArrayDeletion {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] arr_ = br.readLine().split(" ");
			int Array[] = new int[2];
			for (int i = 0; i < 2; i++) {
				Array[i] = Integer.parseInt(arr_[i]);
			}
			int N = Array[0];
			int q = Array[1];
			String[] arr_A = br.readLine().split(" ");
			int[] A = new int[N];

			for (int i_A = 0; i_A < arr_A.length; i_A++) {
				A[i_A] = Integer.parseInt(arr_A[i_A]);
			}

			String[] arr_query = br.readLine().split(" ");
			int[] query = new int[q];
			for (int i_query = 0; i_query < arr_query.length; i_query++) {
				query[i_query] = Integer.parseInt(arr_query[i_query]);
			}

			int[] out_ = final_arr1(A, query, q, N);
			System.out.print(out_[0]);
			for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
				System.out.print(" " + out_[i_out_]);
			}
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	static int[] final_arr(final int[] A, int[] query, int q, int N) {
		// final int[] C = A.clone();
		TreeSet<Integer> s = new TreeSet<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if (A[i1] > A[i2]) {

					return -1;
				} else if (A[i1] < A[i2]) {
					if (i1 > i2) {
						return 0;
					} else {
						return 1;
					}
				} else {
					if (i1 < i2) {
						return -1;
					}
					return 0;
				}
			}

		});
		for (int i : query) {
			s.add(i);
		}
		int k = 0;
		int prev = N;

		for (int i : s) {
			for (int j = i + 1; j < prev; j++) {
				if (A[j] < A[i]) {
					A[j] = 0;
				}
			}
			prev = i;
		}
		return A;
	}
	
	static int[] final_arr1(int[] A, int[] query, int q, int N){
        // Write your code here
        if(A==null )
        return null;
        if(query==null)
        return null;
        Arrays.sort(query);
       
        int queryId=0;
        int currentPosition=query[queryId];
        if(currentPosition>=N)
        return A;
        queryId++;
        int nextPosition=-1;
        if(queryId<q)
        nextPosition=query[queryId];
        int currentValue=A[currentPosition];
        for(int j=currentPosition+1;j<N;j++)
        {
            if(A[j]<currentValue)
            A[j]=0;
            if(j==nextPosition)
            {   
                 if(nextPosition<N && A[nextPosition]>currentValue)
                currentValue=A[nextPosition];
                queryId++;
                if(queryId<q)
                {
                nextPosition=query[queryId];
                
              
                }
            }
        }
        return A;
        
    }
}
