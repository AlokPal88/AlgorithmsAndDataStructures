package GraphProblems;

public class QueueNode {
	Point point;
	int distance;
	
	
	public QueueNode(Point point, int distance) {
		this.point = point;
		this.distance = distance;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
