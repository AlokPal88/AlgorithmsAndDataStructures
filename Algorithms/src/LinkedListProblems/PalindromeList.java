package LinkedListProblems;

import java.util.Stack;

class Result{
	public Result(ListNode node, boolean result) {
		this.node = node;
		this.result = result;
	}
	boolean result;
	ListNode node;
}

public class PalindromeList {

	public static void main(String[] args) {
		int arr[] = {1,2,3,5,3,2,1};
		ListUtilities listUtils = new ListUtilities();
		ListNode head = listUtils.arrayToLinkedList(arr);
		listUtils.printLinkedList(head);
		
		//Solution 1: reverse and compare lists
		ListNode reverse = reverseList(head);
		listUtils.printLinkedList(reverse);
		System.out.println(isEqual(head, reverse) ? "List is Palindrome" : "List is not Palindrome");
		
		//Solution 2: runner approach
		System.out.println(isPalindrome(head) ? "List is Palindrome" : "List is not Palindrome");
		
		//Solution 3: recursive method to compare the elements at head and tail respectively
		System.out.println(isPalindromeRecursive(head) ? "List is Palindrome" : "List is not Palindrome");
	}
	
	private static boolean isPalindromeRecursive(ListNode node) {
		int length = lengthOfList(node);
		Result result = isPalindromeRecurse(node, length);
		return result.result;
	}
	
	private static Result isPalindromeRecurse(ListNode head, int length) {
		if(head == null || length <= 0)  //Even number of nodes
			return new Result(head, true);
		else if (length == 1) //Odd number of nodes
			return new Result(head.next, true);
		Result r = isPalindromeRecurse(head.next, length - 2);
		if(!r.result || r.node == null)
			return r;
		r.result = r.node.val == head.val;
		r.node = r.node.next;
		return r;
	}
	
	private static int lengthOfList(ListNode head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}
	private static ListNode reverseList(ListNode node) {
		ListNode head = null;
		while(node != null) {
			ListNode n = new ListNode(node.val);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	private static boolean isEqual(ListNode l1, ListNode l2) {
		while(l1 != null && l2 != null) {
			if(l1.val != l2.val)
				return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		return l1 == null && l2 == null;
	}
	private static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(stack.size());
		//Odd number of elements in list - the middle element can be skipped
		if(fast != null) {
			slow = slow.next;
		}
		while(slow != null) {
			int top = stack.pop();
			if(top != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
}
