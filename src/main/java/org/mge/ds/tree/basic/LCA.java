package org.mge.ds.tree.basic;

public class LCA {

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree(9);
		b.root.left = new Node(7);
		b.root.right = new Node(5);
		b.root.left.left = new Node(6);
		b.root.left.right = new Node(1);
		b.root.right.left = new Node(10);
		b.root.right.right = new Node(12);

		System.out.println(findLCA(b.root, 5, 7).data);
	}

	public static Node findLCA(Node root, int k1, int k2) {

		if (root == null)
			return root;

		if (root.data == k1) {
			return root;
		}

		if (root.data == k2) {
			return root;
		}

		Node leftLCA = findLCA(root.left, k1, k2);
		Node rightLCA = findLCA(root.right, k1, k2);

		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		if (leftLCA != null)
			return leftLCA;
		return rightLCA;
	}
}
