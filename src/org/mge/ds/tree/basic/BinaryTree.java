package org.mge.ds.tree.basic;

public class BinaryTree {
	Node root;

	public BinaryTree(int data) {
		root = new Node(data);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.getLeft());
		System.out.print(node.getData() + " ");
		inorder(node.getRight());
	}
}

class Node {
	int data;
	int count;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
		count = 1;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}