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