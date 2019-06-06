package MiscellaneousProblems;

import java.util.Stack;

public class PalindromeString {
static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) {
		String str = "abcccba";
		boolean isPalindrome = palindromeTest(str);
		if(isPalindrome)
			System.out.println("Palindrome!");
		else
			System.out.println("Not Palindrome!");
	}
	
	private static boolean palindromeTest(String s) {
		int begin =0, end = s.length()-1, mid = s.length()/2, i=0;
		for( i=0; i<=mid; i++) {
			if(s.charAt(begin) == s.charAt(end)) {
				begin++;
				end--;
			}else break;
		}
		return i == mid+1;
	}

}
