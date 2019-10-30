package org.mge.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnasackFraction {
	public static void main(String[] args) {
		int w[] = { 10, 40, 20, 30 };
		int v[] = { 60, 40, 100, 120 };
		int W = 50;
		System.out.println(maxValue(w, v, W));
	}

	static double maxValue(int w[], int v[], int W) {
		double maxValue = 0;
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < w.length; i++) {
			items.add(new Item(w[i], v[i], v[i] / w[i]));
		}
		Collections.sort(items, new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return i2.uc.compareTo(i1.uc);
			}
		});
		for (Item item : items) {
			if (W >= item.w) {
				maxValue += item.v;
				W -= item.w;
			} else {
				maxValue += W * item.uc;
				break;
			}
		}
		return maxValue;
	}

	static class Item {
		int w;
		int v;
		Double uc;

		public Item(int w, int v, double uc) {
			this.w = w;
			this.v = v;
			this.uc = uc;
		}
	}

}
