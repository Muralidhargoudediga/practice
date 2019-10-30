package org.mge.ds.tree.basic;

public class DriverProgram {
	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		tree.insert(7);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		
		System.out.print("Inorder :: ");
		tree.inorder(tree.root);
		System.out.println();
		System.out.print("PreOrder :: ");
		tree.preorder(tree.root);
		System.out.println();
		System.out.print("LevelOrder :: ");
		tree.levelOrder(tree.root);
	}
}
