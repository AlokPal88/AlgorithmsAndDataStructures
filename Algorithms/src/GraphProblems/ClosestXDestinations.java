package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ClosestXDestinations {

	static class Point implements Comparable {
		List<Integer> xy = new ArrayList<>();
		Double distance;
		Point(List<Integer> xy, double distance){
			this.xy.addAll(xy);
			this.distance = distance;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == this)
				return true;
			if(!(o instanceof Point))
				return false;
			return ((Point)o).distance == this.distance;
		}

		@Override
		public int compareTo(Object arg0) {
			return this.distance.compareTo(((Point)arg0).distance);
		}
	}
	
	private static List<List<Integer>> closestXDestinations(List<List<Integer>> allLocations, int x){
		ArrayList<Point> allPoints = getListOfAllPoints(allLocations);
		//Instead of Sorting the entire list better approach is to create the max heap of size x.
		
		/*Collections.sort(allPoints, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.distance.compareTo(o2.distance);
			}
		});*/
		PriorityQueue<Point> minHeap = new PriorityQueue<Point>(allPoints.subList(0, x));
		
		for(int i = x; i < allPoints.size(); i++) {
			if(allPoints.get(i).distance < minHeap.peek().distance) {
				minHeap.remove();
				minHeap.offer(allPoints.get(i));
			}	
		}
		allPoints.stream().map(p -> p.distance).forEach(System.out::println);
		return minHeap.stream().map(point -> point.xy).collect(Collectors.toList());
	}
	
	private static ArrayList<Point> getListOfAllPoints(List<List<Integer>> allLocations) {
		ArrayList<Point> points = new ArrayList<>();
		for(List<Integer> xy: allLocations) {
			double distance = Math.sqrt(Math.pow(xy.get(0), 2) + Math.pow(xy.get(1), 2));
			Point point = new Point(xy, distance);
			points.add(point);
		}
		return points;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> locations = new ArrayList<>();
		int x = 3;
		locations.add(Arrays.asList(1,3));
		locations.add(Arrays.asList(-1,5));
		locations.add(Arrays.asList(1,-5));
		locations.add(Arrays.asList(4,7));
		System.out.println(closestXDestinations(locations, x));
	}

}
