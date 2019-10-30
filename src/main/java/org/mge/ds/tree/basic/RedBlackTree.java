package org.mge.ds.tree.basic;

import java.util.LinkedList;

public class RedBlackTree {
	Node root;
	private final static boolean BLACK = true;
	private final static boolean RED = false;

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Node t = root;
		Node p = null;
		int cmp = 0;
		while (t != null) {
			p = t;
			if (data < t.data) {
				cmp = -1;
				t = t.left;
			} else if (data > t.data) {
				cmp = 1;
				t = t.right;
			}
		}

		Node n = new Node(data);
		n.parent = p;
		if (cmp < 0)
			p.left = n;
		else
			p.right = n;
		fixAfterInsert(n);
	}

	private void fixAfterInsert(Node x) {
		x.color = RED;
		while (x != null && x != root && colorOf(parentOf(x)) == RED) {
			if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
				Node u = rightOf(parentOf(parentOf(x)));
				if (colorOf(u) == RED) {
					setColor(u, BLACK);
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));
				} else {
					if (x == rightOf(parentOf(x))) {
						x = parentOf(x);
						rotateLeft(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateRight(parentOf(parentOf(x)));
				}
			} else {
				Node u = leftOf(parentOf(parentOf(x)));
				if (colorOf(u) == RED) {
					setColor(u, BLACK);
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					x = parentOf(parentOf(x));
				} else {
					if (x == leftOf(parentOf(x))) {
						x = parentOf(x);
						rotateRight(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rotateLeft(parentOf(parentOf(x)));
				}
			}
		}
		root.color = BLACK;
	}

	public void delete(int data) {
		Node t = root;
		while (t != null) {
			if (data < t.data) {
				t = t.left;
			} else if (data > t.data) {
				t = t.right;
			} else {
				break;
			}
		}

		if (t != null) {
			if (t.left != null && t.right != null) {
				Node s = findSucc(t.right);
				t.data = s.data;
				t = s;
			}
			
			Node replacement = t.left != null? t.left : t.right; 
			
			if(replacement != null) {
				replacement.parent = t.parent;
				if(t.parent == null)
					root = replacement;
				if(t == leftOf(parentOf(t)))
					t.parent.left = replacement;
				else 
					t.parent.right = replacement;
				
				t.left = t.right = t.parent = null;
				
				if(t.color == BLACK){
					
				}
			}
		}
	}
	
	private void fixAfterDelete(Node n){
		while(n != root && colorOf(n) == BLACK) {
			if(n == leftOf(parentOf(n))) {
				Node s = rightOf(parentOf(n));
				if(colorOf(s) == RED) {
					setColor(s, BLACK);
					setColor(parentOf(n), RED);
					rotateLeft(parentOf(n));
					s = rightOf(parentOf(n));
				}
				
			}
		}
		
		setColor(n, BLACK);
	}

	private Node findSucc(Node n) {
		Node t = n;
		while (t.left != null) {
			t = t.left;
		}
		return t;
	}

	private Node parentOf(Node n) {
		return (n == null ? null : n.parent);
	}

	private Node leftOf(Node n) {
		return (n == null ? null : n.left);
	}

	private Node rightOf(Node n) {
		return (n == null ? null : n.right);
	}

	private boolean colorOf(Node n) {
		return (n == null ? BLACK : n.color);
	}

	private void setColor(Node n, boolean color) {
		if (n != null)
			n.color = color;
	}

	private void rotateLeft(Node n) {
		if (n != null) {
			Node t = n.right;
			n.right = t.left;
			if (t.left != null)
				t.left.parent = n;
			t.parent = n.parent;
			if (n.parent == null)
				root = t;
			else if (n == leftOf(parentOf(n)))
				n.parent.left = t;
			else
				n.parent.right = t;
			t.left = n;
			n.parent = t;
		}
	}

	private void rotateRight(Node n) {
		if (n != null) {
			Node t = n.left;
			n.left = t.right;
			if (t.right != null)
				t.right.parent = n;
			t.parent = n.parent;
			if (n.parent == null)
				root = t;
			else if (n == leftOf(parentOf(n)))
				n.parent.left = t;
			else
				n.parent.right = t;
			t.right = n;
			n.parent = t;
		}
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

	public void levelOrder(Node node) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node t = q.remove();
			if (t.left != null)
				q.add(t.left);
			if (t.right != null)
				q.add(t.right);
			System.out.print(t.data + " ");
		}
		System.out.println();
	}
}
