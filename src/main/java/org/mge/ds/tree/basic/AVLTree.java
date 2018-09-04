package org.mge.ds.tree.basic;

public class AVLTree {
	Node root;

	public AVLTree(int data) {
		root = new Node(data);
	}

	public AVLTree() {

	}

	public Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.getData()) {
			root.right = insert(root.right, data);
		}

		root.height = 1 + maxHeight(root);
		int heightDiff = heightDiff(root);
		if (heightDiff < -1) {
			if (data < root.right.data) {
				root.right = rightRotation(root.right);
			}
			root = leftRotation(root);
		} else if (heightDiff > 1) {
			if (data > root.left.data) {
				root.left = leftRotation(root.left);
			}
			root = rightRotation(root);
		}
		return root;
	}

	public Node delete(Node node, int data) {
		if (node == null)
			return node;
		if (data < node.data)
			node.left = delete(node.left, data);
		else if (data > node.data)
			node.right = delete(node.right, data);
		else {
			if (node.left == null)
				node = node.right;
			else if (node.right == null)
				node = node.left;
			else {
				Node succ = findSucc(node.right);
				node.data = succ.data;
				node.right = delete(node.right, succ.data);
			}
		}

		if (node == null)
			return node;
		node.height = 1 + maxHeight(node);
		int heightDiff = heightDiff(node);

		if (heightDiff < -1 && heightDiff(node.right) <= 0) {
			node = leftRotation(node);
		}
		if (heightDiff < -1 && heightDiff(node.right) > 0) {
			node.right = rightRotation(node.right);
			node = leftRotation(node);
		}
		if (heightDiff > 1 && heightDiff(node.left) >= 0) {
			node = rightRotation(node);
		}
		if (heightDiff > 1 && heightDiff(node.left) < 0) {
			node.left = leftRotation(node.left);
			node = rightRotation(node);
		}

		return node;
	}

	public Node findSucc(Node node) {
		Node succ = node;
		while (succ.left != null) {
			succ = succ.left;
		}
		return succ;
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private int maxHeight(Node node) {
		return Math.max(height(node.left), height(node.right));
	}

	private int heightDiff(Node node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	private Node rightRotation(Node root) {
		Node temp = root;
		root = root.left;
		temp.left = root.right;
		root.right = temp;
		temp.height = maxHeight(temp) + 1;
		root.height = maxHeight(root) + 1;
		return root;
	}

	private Node leftRotation(Node root) {
		Node temp = root;
		root = root.right;
		temp.right = root.left;
		root.left = temp;
		temp.height = maxHeight(temp) + 1;
		root.height = maxHeight(root) + 1;
		return root;
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.getLeft());
		System.out.print(node.getData() + " ");
		inorder(node.getRight());
	}

	public void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.getData() + " ");
		preorder(node.getLeft());
		preorder(node.getRight());
	}
}
