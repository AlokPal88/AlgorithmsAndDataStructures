import java.util.LinkedList;
import java.util.Queue;

/* in the given matrix land chain is represented by 1. Implement a method that will return number of island chains in the given matrix.
 * For the example below the method should return number 4, as there are four such island chains available.
|1|1|0|1|0|0|
|1|0|0|1|0|0|
|0|0|1|1|0|0|
|0|1|0|0|1|0|
|1|1|0|1|1|1|
*/
public class IslandChainsProblem {
	
	static class Node{
		int value;
		int row, col;
		Node(int value, int row, int col){
			this.value = value;
			this.row = row;
			this.col = col;
		}
	}
	static int[][] landMass =  {{1,1,0,1,0,0},
								{1,0,0,1,0,0},
								{0,0,1,1,0,0},
								{0,1,0,0,1,0},
								{1,0,0,1,1,1}};
	static boolean[][] visited = new boolean[landMass.length][landMass[0].length];
	public static void main(String[] args) {

		int islands = findNumberOfIslands(landMass, visited);	
		System.out.println("Number of Islands is: " + islands);
	}

	private static int findNumberOfIslands(int[][] landMass, boolean[][] visited) {
		int countIsland = 0;
		int[] rows = {-1,0,0,1};
		int[] cols = {0,-1,1,0};
		Queue<Node> queue = new LinkedList<>();
		for(int i = 0; i < landMass.length; i++) {
			for(int j = 0; j < landMass[0].length; j++) {
				if(landMass[i][j] == 1 && !visited[i][j]) {
					queue.add(new Node(landMass[i][j],i,j));
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						visited[n.row][n.col] = true;
						addNeighbors(queue, rows, cols, n);
					}
					countIsland++;
				}
			}
		}
		return countIsland;
	}

	private static void addNeighbors(Queue<Node> queue, int[] rows, int[] cols, Node n) {
		for(int i = 0; i < 4; i++) {
			int r = n.row + rows[i];
			int c = n.col + cols[i];
			if(isValid(r,c) && landMass[r][c] == 1 && !visited[r][c])
				queue.add(new Node(landMass[r][c], r, c));
		}
		
	}

	private static boolean isValid(int r, int c) {
		return r >= 0 && r < landMass.length && c >= 0 && c < landMass[0].length;
	}

}
