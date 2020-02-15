package org.mge.general;

public class OuterClass {
	private int a = 10;

	class InnerClass extends OuterClass{
		private int b = 20;

		void showInner() {
			System.out.println("Outer.a=" + OuterClass.this.a);
		}
	}

	void shouOuter() {
		InnerClass in = new InnerClass();
		System.out.println(in.b);
	}
}

class OuterInner {
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		o.shouOuter();
		OuterClass.InnerClass in = o.new InnerClass();
		in.showInner();
	}
}