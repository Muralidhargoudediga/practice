package org.mge.ds.tree.basic;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;

public class InsertInBTLevelOrder {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(10);

		tree.getRoot().setLeft(new Node(11));
		tree.getRoot().setRight(new Node(9));
		tree.getRoot().getLeft().setLeft(new Node(7));
		tree.getRoot().getRight().setLeft(new Node(15));
		tree.getRoot().getRight().setRight(new Node(8));
		inorder(tree.getRoot());
		insert(tree.getRoot(), 12);
		System.out.println();
		inorder(tree.getRoot());
	}

	public static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.getLeft());
		System.out.print(node.getData() + " ");
		inorder(node.getRight());
	}

	public static void insert(Node parent, int data) {
		Node node = parent;
		Node newNode = new Node(data);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(parent);
		while (!queue.isEmpty()) {
			Node temp = queue.getFirst();
			queue.remove();
			if (temp.getLeft() == null) {
				temp.setLeft(newNode);
				return;
			} else {
				queue.add(temp.getLeft());
			}

			if (temp.getRight() == null) {
				temp.setRight(newNode);
				return;
			} else {
				queue.add(temp.getRight());
			}

		}
	}
}
