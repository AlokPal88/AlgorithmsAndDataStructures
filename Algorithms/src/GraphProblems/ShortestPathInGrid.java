package GraphProblems;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;

/*Problem statement: Find the shortest path in a given maze represented by a grid
where cell value of 1 indicates the valid position that can be visited and cells
having value 0 represents the obstacles on the way.

Solution approach: by performing the BFS search on the grid we will find the
shortest path to the given destination.
*/
public class ShortestPathInGrid {

	static int[] rows = {0,0,-1,1};
	static int[] cols = {-1,1,0,0};
	
	static int grid[][] = { 
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
			{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
			{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
			{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
			{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
		}; 
	
	public static void main(String args[])
	{
		//System.out.println(Arrays.deepToString(grid));
		Point source = new Point(0,0);
		Point destination = new Point(3,4);
		int shortestDist = BFS(source, destination);
		System.out.println("The length of shortest path is: " + shortestDist);
	}
	
	private static int BFS(Point src, Point dest)
	{
		boolean visited[][] = new boolean[grid.length][grid.length];
		if((grid[src.getX()][src.getY()] == 0) || (grid[dest.getX()][dest.getY()] == 0))
			return -1;
		visited[src.getX()][src.getY()] = true;
		
		/*for(boolean[] boolRow: visited)
			System.out.println(Arrays.toString(boolRow));
		System.out.println("");*/
		Queue<QueueNode> queue = new LinkedList<QueueNode>();
		QueueNode s = new QueueNode(src,0);
		queue.add(s);
		while(!queue.isEmpty())
		{
			QueueNode curr = queue.poll();
			Point currPos = curr.getPoint();
			System.out.println(currPos);
			if(currPos.getX() == dest.getX() && currPos.getY() == dest.getY())
				return curr.getDistance();
			for(int i=0; i<4; i++) {
				int r = currPos.getX() + rows[i];
				int c = currPos.getY() + cols[i];
				if(isValid(r,c) && grid[r][c] == 1 && !visited[r][c])
				{
					visited[r][c] = true;
					/*for(boolean[] boolRow: visited)
						System.out.println(Arrays.toString(boolRow));
					System.out.println("");*/
					queue.add(new QueueNode(new Point(r,c),curr.getDistance()+1));
				}
			}
		}
		//Return -1 is destination cannot be reached
		return -1;
	}
	
	private static boolean isValid(int r, int c) {
		return (r >= 0) && (r< grid.length) && (c >= 0) && (c < grid[0].length);
	}

}


