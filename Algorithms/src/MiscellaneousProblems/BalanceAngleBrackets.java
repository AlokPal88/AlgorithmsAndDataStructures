import java.util.Stack;

public class BalanceAngleBrackets {

	public static void main(String[] args) {
		String angles = "><<><"; //Output: "<><<><>>"
		Stack<Character> stack = new Stack<>();
		String result = "";
		char[] chars = angles.toCharArray();
		for(int i=0; i<angles.length(); i++) {
			if(chars[i] == '<') {
				stack.push('<');
				result += "<";
			}
			else {
				if(stack.isEmpty()) {
					result += "<";
					result += ">";
				}
				else {
					result += ">";
					stack.pop();
				}
			}
		}
		
		if(!stack.isEmpty()) {
			for(Character c: stack){
				result += '>';
            }
		}
		
		System.out.println(result);
		
	}

}
