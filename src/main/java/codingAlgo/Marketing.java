package codingAlgo;

import java.util.Arrays;
import java.util.Stack;

public class Marketing {
	boolean[][] graph;
	boolean oppositeCycle = false;
	int size;
	int[] colors;
	String[] connectedProducts;

	public final int GREEN = 0;
	public final int RED = 1;
	public final int BLUE = 2;
	public final int YELLOW = 3;
	public long howMany(String[] products) {
		// Draw a connectivity graph. with your product facing up against the competitors
		size = products.length;
		graph = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			connectedProducts = products[i].split(" ");
			for (String product:connectedProducts) {
				if (!product.equals("")) {
					int j = Integer.parseInt(product);
					graph[i][j] = true;
					graph[j][i] = true;
				}
			}
		}

		// 4 elements = 4 colors
		colors = new int[size];
		//initialize color
		Arrays.fill(colors, 0);
		//check color

		int howMany = 0;
		for(int i = 0; i < size; ++i) {
			if (colors[i] == 0) {
				dfs(1, i);
				++howMany;
			}
		}

		if(oppositeCycle) {
			return -1;
		}

		return (long)Math.pow(2, howMany);
	}

	private void dfs (int color, int myProduct) {
		// 0 is green
		if(colors[myProduct] != 0) {
			if (colors[myProduct] != color) {
				oppositeCycle = true;
			}
			return;
		}

		colors[myProduct] = color;
		for(int i = 0; i < size; ++i) {
			if(graph[myProduct][i]) {
				dfs(3 - color, i);
			}
		}
	}
}
