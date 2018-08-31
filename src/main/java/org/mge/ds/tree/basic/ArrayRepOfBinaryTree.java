package org.mge.ds.tree.basic;

public class ArrayRepOfBinaryTree {
	private String[] tree = new String[10];
	
	public void root(String value){
		tree[0] = value;
	}
	
	public void setLeft(String value, int parent){
		int i = parent * 2 + 1;
		if(tree[parent] == null)
			System.out.println("Cannot set left child. Parent is null");
		else
			tree[i] = value;
	}
	
	public void setRight(String value, int parent){
		int i = parent * 2 + 2;
		if(tree[parent] == null)
			System.out.println("Cannot set right child. Parent is null");
		else
			tree[i] = value;
	}
	
	public void printTree(){
		for(String s : tree) {
			if(s != null)
			System.out.print(s + " ");
			else
				System.out.print("- ");
		}
	}
	
	public static void main(String[] args) {
		ArrayRepOfBinaryTree tree = new ArrayRepOfBinaryTree();
		tree.root("A");
		//tree.setLeft("B", 0);
		tree.setRight("C", 0);
		tree.setLeft("D", 1);
		tree.setRight("E", 1);
		tree.setLeft("F", 2);
		tree.setRight("G", 2);
		
		tree.printTree();
		
	}
}
