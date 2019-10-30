package org.mge.serialize;

import java.io.Serializable;

public class A implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//transient int a;
	int b;
	String s;
	A(){
		System.out.println("Class A Constuctor");
	}
	static void test(){
		System.out.println("Class A test()");
	}
	public void show(){
//		/super.a = 20;
		//System.out.println(a);
		System.out.println(s);
		System.out.println(b);
		
	}
}
