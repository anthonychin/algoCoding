package codingAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinding {
	private boolean[][][][] visited = new boolean[20][20][20][20];

	public int minTurns(String board[]) {
		int width = board[0].length();
		int height = board.length;
		
		Node start = new Node(0,0,0,0,0);
		
		//Find the first position of A and B.
		//Save them in start
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i].charAt(j) == 'A') {
					start.playerOneX = j;
					start.playerOneY = i;
				} else if (board[i].charAt(j) == 'B') {
					start.playerTwoX = j;
					start.playerTwoY = i;
				}
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		pushToQueue(q, start);
		while (!q.isEmpty()) {
			Node top = q.peek();
			q.remove();
		
			// Check if p1 or p2 is out of bounds, or on an X square. (continue)
			if (top.playerOneX > width || top.playerOneX < 0 || top.playerOneY > height || top.playerOneY < 0 ||
					top.playerTwoX > width || top.playerTwoX < 0 || top.playerTwoY > width || top.playerTwoY < 0) {
				return -1;
			}

			// Check if p1 or p2 is on top of each other. continue
		
			// Check if current positions of A and B are oposite of each toerh. If yes. finished
			if (top.playerOneX == start.playerTwoX && top.playerOneY == start.playerTwoY &&
				top.playerTwoX == start.playerOneX && top.playerTwoY == start.playerOneY) {
				return top.steps;
			}
			
			// Now we need to make all the transitions between nodes.
			// To do this, use nested loop (one direction for easy possible way to go)
			// possible scenarios: (-1,-1), (-1,0), (-1,1), (0,-1), (0,0), (0,1), (1,-1), (1,0), (1,1)
			// so, a player can go from -1 to 1. Hence four for loops for each coordinate and player
			for (int playerOneDeltaX = -1; playerOneDeltaX < 2; playerOneDeltaX++) {
				for (int playerOneDeltaY = -1; playerOneDeltaY < 2; playerOneDeltaY++) {
					for (int playerTwoDeltaX = -1; playerTwoDeltaX < 2; playerTwoDeltaX++) {
						for (int playerTwoDeltaY = -1; playerTwoDeltaY < 2; playerTwoDeltaY++) {
							// NOTE: MAKE SURE PLAYER ONE AND PLAYER TWO DID NOT SWAP POSITION
							if (top.playerOneX == top.playerTwoX && top.playerOneY == top.playerTwoY) {
								return -1;
							}
							
							pushToQueue(q, new Node(top.playerOneX + playerOneDeltaX, top.playerOneY + playerOneDeltaY, top.playerTwoX + playerTwoDeltaX, top.playerTwoY + playerTwoDeltaY, top.steps+1));
						}
					}
				}
			}
		}
		return -1;
	}
	

	class Node {
		int playerOneX;
		int playerOneY;
		int playerTwoX;
		int playerTwoY;

		int steps;

		public Node(int p1X, int p1Y, int p2X, int p2Y, int steps) {
			playerOneX = p1X;
			playerOneY = p1Y;
			playerTwoX = p2X;
			playerTwoY = p2Y;
			this.steps = steps;
		}
	}
	
	private void pushToQueue(Queue<Node> q, Node v) {
		if(!visited[v.playerOneX][v.playerOneY][v.playerTwoX][v.playerTwoY]) {
			q.add(v);
			visited[v.playerOneX][v.playerOneY][v.playerTwoX][v.playerTwoY] = true;
		}
	}
}
