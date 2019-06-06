package Google;
/*RhymingScheme problem can be solved by constructing a tree like this one here
for n = 3
		A
	   / \
	  A   B
	 / \ /|\
	A  B ABC
after tree construction, traverse the tree and keep adding the values to the List
[AAA]
[AAB]
[ABA]
[ABB]
[ABC]
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RhymeScheme {
	static class Node{
		Character data;
		List<Node> children = new ArrayList<>();
		Node(Character data){
			this.data = data;
		}
	}
	static Node root = new Node('A');
	public static void main(String[] args) {
		int n = 2;
		List<String> rhymeScheme = new ArrayList<>();
		rhymeScheme = getRhymeScheme(n);
		System.out.println(rhymeScheme);
	}
	
	private static List<String> getRhymeScheme(int n) {
		List<String> results = new ArrayList<>();
		int level = 0;
		String str = "";
		String charSet = getAllRhymings(n);
		constructTree(n, level, root, charSet);
		getRhymeScheme(root, str, results);
		return results;
	}

	private static String getRhymeScheme(Node node,String rhyme, List<String> results) {
		String str = rhyme + Character.toString(node.data);
		for(Node child: node.children) {
			String rhymeScheme = getRhymeScheme(child, str, results);
			if(child.children.isEmpty())
				results.add(rhymeScheme);
		}
		return str;
	}
	
	private static void constructTree(int n, int level, Node pCrawl, String charSet) {
		if(level == n - 1)
			return;
		int index = charSet.indexOf(pCrawl.data);
		for(int i=0; i<= index +1; i++) {
			pCrawl.children.add(new Node(charSet.charAt(i)));
		}
		pCrawl.children.stream().forEach(child -> {
			int lvl = level+1;
			constructTree(n, lvl, child, charSet);
		});				
	}

	private static String getAllRhymings(int n) {
		StringBuilder rhymes = new StringBuilder();
		for(int i=0; i<n; i++) {
			rhymes.append(Character.toString((char)((int)'A' + i)));
		}
		return rhymes.toString();
	}

}
