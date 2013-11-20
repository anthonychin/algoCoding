package codingAlgo;

public class grafixMask {
	
	public static final int fillX = 600;
	public static final int fillY = 400;

	public static boolean[][] grid;

	public static void main(String[] args){
//		String s = "5 4 3 2";
//		System.out.println(s);
//		String[] splittedString = s.split("\\s");
//		for (String string : splittedString) {
//			System.out.println(string);
//		}
		//String[] test =  {"4 3 2 5", "2 2 2 2", "300 399 500 199"};
		String[] test = {"0 292 399 307"};
		sortedArea(test);
	}

/*	if (!grid[x][y]){
		//System.out.println(++check);
		System.out.println(grid[x][y] + "x is: " + x + "y is: " + y);
		result[0] += doFill(fillX, fillY);
		result[1] += doFill(fillX, fillY);+
	}*/
	
	public static int[] sortedArea (String[] rectangles){
		
		grid = new boolean[600][400];

		// fill the masking layer to true
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				grid[x][y] = true;
			}
		}

		for(String rectangle : rectangles) {
			//split the string to remove all white space
			// '\s' removes a whitespace character [ \t\n\x0B\f\r]
			// beginning with '\' is an escape construct. (need to use twice for it to compile)
			
			// Takke the string { 0, 292, 399, 307 } and break it into individual integer.
			String[] rectangleSplit = rectangle.split("\\s");
			int[] rectangleValue = new int[rectangleSplit.length];
			for (int val = 0; val < rectangleSplit.length; val++) {
				rectangleValue[val] = Integer.parseInt(rectangleSplit[val]);
				//System.out.println(rectangleValue[val]);
			}
			
			// 0 and 292 as left top pixel and make it false
			// 399 and 307 as right bottom pixel and make it false
			for (int pixel = 0; pixel < rectangleValue.length/2; pixel += 2){
				grid[rectangleValue[pixel]][rectangleValue[pixel+1]] = false;
			}
			//System.out.println(grid[2][2]);
		}
		
		
		
		int[] result = new int [2];
		
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				if(grid[x][y]) {
					// something
				}
			}
		}

		//System.out.println(grid[200][300]);
		//System.out.println(result.toString());
		return result;
		
	}
	
	public static int doFill(int x, int y){
		
		if(x < 0 || x >=fillX) { return 0; }
		if (y < 0 || y >= fillY) { return 0; }
		
		if(!grid[x][y]) { return 0; }
		
		// record that you visit this node.
		grid[x][y] = false;
		
		//return 1;
		return 1 + doFill(x-1,y) + doFill(x+1,y) + doFill(x,y-1) + doFill(x,y+1);
	}
}
