package org.mge.ds.tree.basic;

public class LCABST {

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree(9);
		b.insertNode(7);
		b.insertNode(5);
		b.insertNode(6);
		b.insertNode(1);
		b.insertNode(10);
		b.insertNode(12);

		System.out.println(findLCA(b.root, 5, 10).data);
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

		if (root.data > k1 && root.data < k2) {
			return root;
		}

		if (root.data < k1 && root.data < k2) {
			return findLCA(root.right, k1, k2);
		}

		if (root.data > k1 && root.data > k2) {
			return findLCA(root.left, k1, k2);
		}

		return null;
	}
}
