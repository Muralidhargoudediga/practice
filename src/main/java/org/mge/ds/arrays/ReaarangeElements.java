package org.mge.ds.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class ReaarangeElements {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 3, 3, 3, 3};

		reaarangeArrayElements(arr);
	}
	
	@Test
	public void test(){
		int[] arr = { 1, 1, 1, 2, 2, 2};
		reaarangeArrayElements(arr);
		int[] res = {1, 2, 1, 2, 1, 2};
		Assert.assertArrayEquals(arr, res);
	}

	public static void reaarangeArrayElements(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			Integer count = map.get(arr[i]);
			if (count == null) {
				count = 0;
			}
			map.put(arr[i], count + 1);
		}

		PriorityQueue<Element> pq = new PriorityQueue<>(arr.length,
				new Comparator<Element>() {
					public int compare(Element e1, Element e2) {
						if (e1.freq < e2.freq)
							return 1;
						else if (e1.freq > e2.freq)
							return -1;
						return 0;
					}
				});

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			Element element = new Element(e.getKey(), e.getValue());
			pq.add(element);
		}

		Element prev = new Element(-1, -1);
		int i = 0;

		while (!pq.isEmpty()) {
			Element e = pq.poll();
			arr[i++] = e.key;

			if (prev.freq > 0) {
				pq.add(prev);
			}

			e.freq--;

			prev = e;
		}

		if (i != arr.length) {
			System.out.println("Not Possible");
		} else {
			for (int k : arr) {
				System.out.print(k + " ");
		}
		}
	}

	public static class Element {
		int key;
		int freq;

		public Element(int key, int freq) {
			this.key = key;
			this.freq = freq;
		}
	}
}
