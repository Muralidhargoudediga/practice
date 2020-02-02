package org.mge.general;

public class InstanceBlock {
	{
		n = 2;
		System.out.println("Instance Block executed.");
	}

	private int n = 1;

	public InstanceBlock() {
		n = 3;
		System.out.println("Constructor executed.");
	}

	public static void main(String[] args) {
		System.out.println(new InstanceBlock().n);
	}
}
