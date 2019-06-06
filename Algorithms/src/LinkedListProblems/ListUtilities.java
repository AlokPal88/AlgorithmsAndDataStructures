package LinkedListProblems;

public class ListUtilities {
	public static ListNode arrayToLinkedList(int arr[]) {
		ListNode root = new ListNode(0);
		ListNode ptr = root;
		for(int x: arr)
		{
			ListNode node = new ListNode(x);
			ptr.next = node;
			ptr = ptr.next;
		}
		return root.next;
	}
	public static void printLinkedList(ListNode list) {
		while(list != null) {
			System.out.print(list.val + "->");
			list = list.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
