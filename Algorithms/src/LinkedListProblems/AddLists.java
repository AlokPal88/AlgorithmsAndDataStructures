package LinkedListProblems;

public class AddLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {3,5,8};
		int arr2[] = {1,7,1};
		int carry = 0;
		ListUtilities listUtils = new ListUtilities();
		ListNode listA = listUtils.arrayToLinkedList(arr1);
		listUtils.printLinkedList(listA);
		ListNode listB = listUtils.arrayToLinkedList(arr2);
		listUtils.printLinkedList(listB);
		ListNode result = addLists(listA, listB, carry);
		listUtils.printLinkedList(result);
	}

	private static ListNode addLists(ListNode l1, ListNode l2, int carry) {
		if(l1 == null && l2 == null && carry == 0)
			return null;
		
		ListNode sum = new ListNode(0);
		int value = carry;
		if(l1 != null)
			value += l1.val;
		if(l2 != null)
			value += l2.val;
		sum.val = value%10;
		if(l1 != null || l2 != null) {
			ListNode more = addLists(l1 == null ? null : l1.next,
										l2 == null ? null : l2.next,
												value/10);
			sum.next = more;
		}
		
		return sum;
	}

}
