package org.mge.serialize;

import java.io.Serializable;

public class B extends A implements Serializable{
	B(){
		System.out.println("Class B Constructor");
	}
	
	public void show(){
//		/super.a = 20;
		//System.out.println(a);
		System.out.println(s);
		
		//System.out.println(super.a);
		System.out.println(super.s);
	}
	
	public static void main(String[] args) {
		
		short s = 8;
		s += 8;
		int[] i = null;
		System.out.println(i);
		
		start: while(true) {
			break start;
		}
		B.test();
	}
}
