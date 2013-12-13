package codingAlgo;

import java.util.Stack;

public class Marketing {

	public long howMany(String[] products) {
		int size = products.length;
		boolean[][] graph = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			String[] connectedProducts = products[i].split(" ");
			for (String product:connectedProducts) {
				if (product.equals("")) {
					int j = Integer.parseInt(product);
					graph[i][j] = true;
					graph[j][i] = true;
				}
			}
		}

		int howMany = 0;

		Stack<Integer> s = new Stack<Integer>();
		
		return -1;
	}

	private boolean checkIfProductIsContainsInProducts(String[] products) {
		for(int i = 0; i < products.length; i++) {
			String product = products[i];
			if (product.contains(i + "")){
				return true;
			}
		}
		return false;
	}
}
