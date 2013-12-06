package codingAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
* Single Round Match 211 Round 1 - Division I, Level Two
* http://www.topcoder.com/stat?c=problem_statement&pm=2998&rd=5857
* 
* @author Anthony Chin
*/
public class GrafixMask {
	
	public static final int fillX = 600;
	public static final int fillY = 400;

	public static boolean[][] grid;

	public int[] sortedArea (String[] rectangles){
		grid = new boolean[600][400];
		cleanRectangle();
		maskRectangle(rectangles);

		//Find the area for each hole: in pixel
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				if(grid[x][y]) {
					result.add(doFill(x,y));
					int pixel = doFill(x,y);
					if (pixel != 0) {
						result.add(doFill(x,y));
					}
				}
			}
		}

		int[] arrayResult = convertIntegersListToArray(result);
		Arrays.sort(arrayResult);
		return arrayResult;
		
	}

	public int doFill(int x, int y) {
		int result = 0;
		Stack<Node> stack = new Stack<Node>();
		stack.push(new Node(x,y));

		while (!stack.isEmpty()) {
			Node top = stack.peek();
			stack.pop();

			if (top.x < 0 || top.x >= fillX) { continue; }
			if (top.y < 0 || top.y >= fillY) { continue; }
			if (!grid[top.x][top.y]) { continue; }

			grid[top.x][top.y] = false;
			result++;
			stack.push(new Node(top.x + 1, top.y));
			stack.push(new Node(top.x - 1, top.y));
			stack.push(new Node(top.x, top.y + 1));
			stack.push(new Node(top.x, top.y - 1));
		}
		return result;
	}

	private void cleanRectangle() {
		// fill the masking layer to true
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				grid[x][y] = true;
			}
		}
	}

	private void maskRectangle (String[] rectangles) {
		for(String rectangle : rectangles) {
			//split the string to remove all white space
			// '\s' removes a whitespace character [ \t\n\x0B\f\r]
			// beginning with '\' is an escape construct. (need to use twice for it to compile)
			
			// Take the string { 0, 292, 399, 307 } and break it into individual integer.
			String[] rectangleSplit = rectangle.split("\\s");
			int[] rectangleValue = new int[rectangleSplit.length];
			for (int val = 0; val < rectangleSplit.length; val++) {
				rectangleValue[val] = Integer.parseInt(rectangleSplit[val]);
			}
			
			// Fill rectangle masked rectangle
			for (int pixelX = rectangleValue[1]; pixelX <= rectangleValue[3]; pixelX++) {
				for (int pixelY = rectangleValue[0]; pixelY <= rectangleValue[2]; pixelY++) {
					grid[pixelX][pixelY] = false;
				}
			}
		}
	}

	private static int[] convertIntegersListToArray(ArrayList<Integer> result) {
		int[] newResult = new int[result.size()];
		Iterator<Integer> iterator = result.iterator();

		for (int i = 0; i < newResult.length; i++) {
			newResult[i] = iterator.next().intValue();
		}

		return newResult;
	}

	class Node {
		private int x;
		private int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
