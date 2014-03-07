package codingAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinding {
	private boolean[][][][] visited = new boolean[20][20][20][20];

	public int minTurns(String board[]) {
		int width = board[0].length();
		int height = board.length;
		
		Node start = new Node();
		
		//Find the first position of A and B.
		//Save them in start
		
		Queue<Node> q = new LinkedList();
		pushToQueue(q, start);
		while (!q.isEmpty()) {
			Node top = q.peek();
			q.remove();
		
			// Check if p1 or p2 is out of bounds, or on an X scare. (continue)
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
	}
	
	private void pushToQueue(Queue<Node> q, Node v) {
		if(!visited[v.playerOneX][v.playerOneY][v.playerTwoX][v.playerTwoY]) {
			q.add(v);
			visited[v.playerOneX][v.playerOneY][v.playerTwoX][v.playerTwoY] = true;
		}
	}
}
