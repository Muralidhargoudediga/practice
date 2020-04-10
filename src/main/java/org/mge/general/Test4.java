package org.mge.general;

import java.util.ArrayList;
import java.util.List;

class A {
	int temp = 10;

	public void print() {
		System.out.println("In Class A");
	}
}

class B extends A {
	int temp = 20;

	public void print() {
		System.out.println("In Class B");
	}
}

public class Test4 {
	public static void main(String args[]) {
		// A a = new B();
		// System.out.println(a.temp);
		// a.print();

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 != 0)
				list.remove(i);
		}
		System.out.println(list);
	}
}
