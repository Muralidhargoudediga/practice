import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.mge.algos.KMPSearchAlgo;

import sun.java2d.pipe.SpanShapeRenderer.Simple;


public class Test {
	public static void main(String[] args) throws ParseException {
		int[][] a = {{0,0,0,1}, {0,1,1,1},{1,1,1,1},{0,0,0,1}};
		System.out.println(rowWithMax1s(a, a.length, a[0].length));
	}
	
	public static int m1(int i) {
		Integer r = null;
		try {
			r = 10/i;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	static int first(int arr[], int low, int high) 
    { 
        if (high >= low) { 
            // Get the middle index 
            int mid = low + (high - low) / 2; 
  
            // Check if the element at middle index is first 1 
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) 
                return mid; 
  
            // If the element is 0, recur for right side 
            else if (arr[mid] == 0) 
                return first(arr, (mid + 1), high); 
                  
            // If element is not first 1, recur for left side 
            else 
                return first(arr, low, (mid - 1)); 
        } 
        return -1; 
    }
	
	static int rowWithMax1s(int mat[][], int R, int C) 
	{ 
	    int i, index; 
	   
	    // Initialize max using values from first row.   
	    int max_row_index = 0; 
	    int max = first(mat[0], 0, C-1); 
	   
	    // Traverse for each row and count number of 1s by finding the index 
	    // of first 1 
	    for (i = 1; i < R; i++) 
	    { 
	        // Count 1s in this row only if this row has more 1s than 
	        // max so far 
	  
	        
	        if (max != -1 && max != 0 && mat[i][max-1] == 1) 
	        { 
	            // Note the optimization here also 
	            index = first (mat[i], 0, C-max); 
	   
	            if (index != -1 && index < max) 
	            { 
	                max = index; 
	                max_row_index = i; 
	            }    
	        } 
	        else if(max == -1){ 
	            max = first(mat[i], 0, C - 1);  
	        }    
	    }    
	    return max_row_index; 
	} 
}

enum TestEnum {
	test(10);
	
	int a;
	TestEnum(int a){
		this.a = a;
	}
}

class A {

	
	void m1() throws FileNotFoundException, SQLException{
		System.out.println("Super class method");
	}
	
}

class B extends A{
	int i;
	String b;
	@Override
	public String toString() {
		return "B [i=" + i + ", b=" + b + "]";
	}
	
	   void m1() throws FileNotFoundException{
		System.out.println("Sub class method");
	}
}