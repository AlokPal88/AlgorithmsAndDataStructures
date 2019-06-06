package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathListList {

	static class Node{
		int x,y,distance;
		Node(int x, int y, int distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	public static void main(String[] args) {
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1,0,0,1));
		area.add(Arrays.asList(1,1,1,1));
		area.add(Arrays.asList(1,1,9,0));
		area.add(Arrays.asList(0,1,1,0));
		System.out.println(findMinimumDistance(area));
	}

	private static int findMinimumDistance(List<List<Integer>> area) {
		 return BFS(area);
	}

	private static int BFS(List<List<Integer>> area) {
		int[] row = {-1,1,0,0};
		int[] col = {0,0,1,-1};
		boolean [][] visited = new boolean[area.size()][area.get(0).size()];
		Node src = new Node(0,0,0);
		Queue<Node> queue = new LinkedList<>();
		queue.add(src);
		visited[src.x][src.y] = true;
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(area.get(curr.x).get(curr.y) == 9)
				return curr.distance;
			for(int i=0; i<4; i++) {
				int x = curr.x + row[i];
				int y = curr.y + col[i];
				if(isValid(x,y,area) && area.get(x).get(y) != 0 && !visited[x][y]) {
					queue.add(new Node(x,y,curr.distance+1));
					visited[x][y] = true;
				}
			}
		}
		return -1;
	}

	private static boolean isValid(int x, int y, List<List<Integer>> area) {
		return (x >= 0) && (x < area.size() && (y >=0) && (y<area.get(0).size()));
	}

}
