package org.mge.ds.tree.basic;

public class DeleteNodeFromBST {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(12);
		bst.insertRecursion(bst.root, 10);
		bst.insertRecursion(bst.root, 20);
		bst.insertRecursion(bst.root, 9);
		bst.insertRecursion(bst.root, 11);
		bst.insertRecursion(bst.root, 10);
		bst.insertRecursion(bst.root, 12);
		bst.insertRecursion(bst.root, 12);

		bst.inorder(bst.root);

		deleteNode(bst.root, 12);
		System.out.println();
		bst.inorder(bst.root);
		
		deleteNode(bst.root, 12);
		System.out.println();
		bst.inorder(bst.root);
		
		deleteNode(bst.root, 12);
		System.out.println();
		bst.inorder(bst.root);
	}
	
	public static Node deleteNode(Node root, int data) {
		if(root == null)
			return root;
		
		if(data < root.data)
			root.left = deleteNode(root.left, data);
		else if(data > root.data) 
			root.right = deleteNode(root.right, data);
		else {
			if(root.getCount() > 1) {
				root.setCount(root.getCount()- 1);
				return root;
			}
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				Node succ = findInOrderSuccessor(root.right);
				root.data = succ.data;
				root.right = deleteNode(root.right, succ.data);
			}
		}
			
		return root;
	}
	
	public static Node findInOrderSuccessor(Node root){
		Node succ = root;
		while(succ.left != null)
			succ = succ.left;
		return succ;
	}

//	public static void deleteNode(BinarySearchTree bst, int data) {
//		Node delNode = null;
//		Node temp = bst.root;
//		Node parent = bst.root;
//		boolean isLeft = false;
//		while (temp != null) {
//			if (data < temp.getData()) {
//				parent = temp;
//				isLeft = true;
//				temp = temp.left;
//			} else if (data > temp.getData()) {
//				parent = temp;
//				isLeft = false;
//				temp = temp.right;
//			} else {
//				delNode = temp;
//				break;
//			}
//		}
//
//		if (delNode.left == null && delNode.right == null) {
//			if (isLeft)
//				parent.left = null;
//			else
//				parent.right = null;
//		} else if (delNode.left != null && delNode.right != null) {
//			Node t = delNode.right;
//			Node tp = delNode;
//			while (t.left != null) {
//				tp = t;
//				t = t.left;
//			}
//			
//			if(tp.data != delNode.data)
//				tp.left = t.right;
//			if (isLeft)
//				parent.left = t;
//			else
//				parent.right = t;
//			t.left = delNode.left;
//			if(tp.data != delNode.data)
//				t.right = delNode.right;
//		} else if (delNode.left != null) {
//			if (isLeft)
//				parent.left = delNode.left;
//			else
//				parent.right = delNode.right;
//		}
//	}
}
