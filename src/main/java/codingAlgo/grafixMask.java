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
		String[] test =  {"4 3 2 5", "2 2 2 2"};
		sortedArea(test);
	}

/*	if (!grid[x][y]){
		//System.out.println(++check);
		System.out.println(grid[x][y] + "x is: " + x + "y is: " + y);
		result[0] += doFill(fillX, fillY);
		result[1] += doFill(fillX, fillY);
	}*/
	
	public static int[] sortedArea (String[] rectangles){
		
		grid = new boolean[600][400];

		// fill the masking layer
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				grid[x][y] = true;
			}
		}
		for(String rectangle : rectangles) {
			//split the string to remove all white space
			// '\s' removes a whitespace character [ \t\n\x0B\f\r]
			// beginning with '\' is an escape construct. (need to use twice for it to compile)
			String[] rectangleSplit = rectangle.split("\\s");
			int[] rectangleValue = new int[rectangleSplit.length];
			for (int val = 0; val < rectangleSplit.length; val++) {
				rectangleValue[val] = Integer.parseInt(rectangleSplit[val]);
				System.out.println(rectangleValue[val]);
			}
			//TODO bad method need to fix
			for (int pixel = 0; pixel < rectangleValue.length/2; pixel += 2){
				grid[pixel][pixel+1] = true;
				System.out.println(pixel);
				System.out.println(pixel+1);
				System.out.println(grid[pixel][pixel+1]);
			}
		}
		
		int[] result = new int [2];
		
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid[x].length; y++){
				result[0] += doFill(fillX, fillY);
				result[1] += doFill(fillX, fillY);
			}
		}		
		
		return null;
		
	}
	
	public static int doFill(int x, int y){
		
		if(x < 0 || x >=fillX) { return 0; }
		if (y < 0 || y >= fillY) { return 0; }
		
		if(grid[x][y]) { return 0; }
		
		grid[x][y] = true;
		
		
		return (1 + doFill(x-1,y) + doFill(x+1,y) + doFill(x,y-1) + doFill(x,y+1));
	}
}
