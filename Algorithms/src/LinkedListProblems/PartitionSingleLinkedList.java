package LinkedListProblems;

public class PartitionSingleLinkedList {
	public static void main(String args[]) {
		int arr[] = {3,5,8,5,10,2,1};
		
		ListNode linkedList = arrayToLinkedList(arr);
		printLinkedList(linkedList);
		ListNode partitionedList = partitionList(linkedList, 5);
		printLinkedList(partitionedList);
	}
	
	private static ListNode arrayToLinkedList(int arr[]) {
		ListNode root = new ListNode(0);
		ListNode ptr = root;
		for(int x: arr)
		{
			ListNode node = new ListNode(x);
			ptr.next = node;
			ptr = ptr.next;
			
			//print LinkedList in reverse order
			/*node.next = root;
			root = node;*/
		}
		return root.next;
	}
	private static void printLinkedList(ListNode list) {
		while(list != null) {
			System.out.print(list.val + "->");
			list = list.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	private static ListNode partitionList(ListNode node, int x) {
		ListNode head = node;
		ListNode tail = node;
		while (node != null) {
			ListNode next = node.next;
			System.out.println(node.val);
			if(node.val < x) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		
		tail.next = null;
		return head;
		
		//Solution II: make two list (i.e. left and right) for elements less than and greater than or equal 
		//to pivot element respectively.
		/*ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode leftSentinel = left;
		ListNode rightSentinel = right;
		ListNode current = node;
		while(current != null) {
			if(current.val < x) {
				left.next = current;
				left = left.next;
			}else {
				right.next = current;
				right = right.next;
			}
			current = current.next;
		}
		left.next = rightSentinel.next;
		right.next = null;
		return leftSentinel.next;*/
	}
}
