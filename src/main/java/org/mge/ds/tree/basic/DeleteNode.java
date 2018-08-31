package org.mge.ds.tree.basic;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class DeleteNode {
	public static void main(String[] args) {
		BinaryTree b = new BinaryTree(13);
		b.root.left = new Node(12);
		b.root.right = new Node(10);
		b.root.left.left = new Node(4);
		b.root.left.right = new Node(19);
		b.root.right.left = new Node(16);
		b.root.right.right = new Node(9);
		
		b.inorder(b.root);
		Map<Integer, Node> map = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		findNodes(map, b.root, 12, 1, null);
		int level = 0;
		while (map.keySet().iterator().hasNext()) {
			level = map.keySet().iterator().next();
			break;
		}

		Node dep = map.get(level);
		Node par = map.get(-level);
		Node del = map.get(0);
		del.data = dep.data;
		if (par.left != null && dep.data == par.left.data)
			par.left = null;
		else
			par.right = null;
		System.out.println();
		b.inorder(b.root);
	}

	public static void findNodes(Map<Integer, Node> map, Node node, int el,
			int level, Node parent) {
		if (node == null)
			return;
		findNodes(map, node.left, el, level + 1, node);
		findNodes(map, node.right, el, level + 1, node);
		if (node.left == null && node.right == null) {
			map.put(level, node);
			map.put(-level, parent);
		}
		if (node.data == el)
			map.put(0, node);
	}
}
