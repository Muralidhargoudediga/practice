package org.mge.ds.tree.basic;

public class BinarySearchTree {
	Node root;

	public BinarySearchTree(int data) {
		root = new Node(data);
	}

	public void insertNode(int data) {
		Node parent = root;
		Node temp = root;
		boolean isLeft = false;
		while (temp != null) {
			parent = temp;
			if (data < temp.getData()) {
				isLeft = true;
				temp = temp.left;
			} else if (data > temp.getData()) {
				isLeft = false;
				temp = temp.right;
			}
		}
		if (isLeft)
			parent.left = new Node(data);
		else
			parent.right = new Node(data);
	}

	public Node insertRecursion(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			return node;
		}

		if (data < node.data) {
			node.left = insertRecursion(node.left, data);
		} else if (data > node.data) {
			node.right = insertRecursion(node.right, data);
		} else {
			node.count++;
		}
		return node;
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.getLeft());
		System.out.print(node.getData()+"("+ node.getCount() + ")" + " ");
		inorder(node.getRight());
	}

	public Node find(int data) {
		Node temp = root;
		
		while (temp != null) {
			if (data < temp.getData()) {
				temp = temp.left;
			} else if (data > temp.getData()) {
				temp = temp.right;
			} else {
				return temp;
			}
		}
		return null;
	}
}
