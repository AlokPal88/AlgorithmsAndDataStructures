import java.util.Stack;

/*Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 */

public class BlancedBraces {

	public static void main(String[] args) {
		String brackets = "([)]";
		if(areBracesBalances(brackets))
			System.out.println("Given set of brackets are balanced!");
		else
			System.out.println("Not balanced!!");
	}

	private static boolean areBracesBalances(String brackets) {
		Stack<Character> stack = new Stack<>();
		for(char c : brackets.toCharArray()) {
			if(c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}else {
				if(stack.isEmpty())
					return false;
				if(!isMatchingPair(c,stack.pop()))
					return false;
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatchingPair(char c, char pop) {
		return (c == '(' && pop == ')') || (c == '{' && pop == '}') ||  (c == '[' && pop == ']');
	}

}
