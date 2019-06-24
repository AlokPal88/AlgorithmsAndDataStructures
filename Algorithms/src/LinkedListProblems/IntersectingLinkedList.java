import java.util.HashMap;
import java.util.Map;

public class IntersectingLinkedList {

	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
		Node(){}
	}
	
	static Node head1;
	static Node head2;
	static Map<Integer,Node> nodeMap = new HashMap<>();
	public static void main(String[] args) {
		int[] arr1 = {3,7,8,10};
		int[] arr2 = {2,99,1,8,10};
		head1 = new Node(3);
		head1.next = new Node(7);
		head2 = new Node(2);
		head2.next = new Node(99);
		head2.next.next = new Node(1);
		head1.next.next = head2.next.next.next = new Node(8);
		head1.next.next.next = new Node(10);
		printLinkedList(head1);
		printLinkedList(head2);
		Node intersectionPoint = findIntersectionPoint(head1,head2);
		System.out.println("Intersectiing point is at Node : "+intersectionPoint.data);
	}
	private static Node findIntersectionPoint(Node head12, Node head22) {
		Node n1 = head12;
		Node n2 = head22;
		while(n1 != null) {
			nodeMap.put(n1.data, n1);
			n1 = n1.next;
		}
		while(n2 != null) {
			if(nodeMap.get(n2.data) != null)
				return n2;
			n2 = n2.next;
		}
		return null;
	}
	private static void printLinkedList(Node head) {
		Node pCrawl = head;
		while(pCrawl != null) {
			System.out.print(pCrawl.data+"->");
			pCrawl = pCrawl.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
