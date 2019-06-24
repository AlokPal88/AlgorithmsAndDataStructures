import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. 
 * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox']
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond'] or ['bedbath', 'and', 'beyond']
*/
public class DictionaryWordReconstruction {

	static class TrieNode{
		Map<Character, TrieNode> children = new HashMap<>();
		boolean endOfWord;
		String leafNodeStr;
	}
	static TrieNode root = new TrieNode();
	public static void main(String[] args) {
		String[] dictionary = {"quick", "brown", "the", "fox"};
		String str = "thequickbrownfox";
		String[] dictionary2 = {"bed", "bath", "bedbath", "and", "beyond"};
		String str2 = "bedbathbeyondand";
		constructTrieFromDictionary(dictionary2);
		System.out.println(reconstructWordsFromString(str2));
	}
	
	private static void constructTrieFromDictionary(String[] words) {
		for(String word: words) {
			TrieNode pCrawl = root;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				pCrawl.children.putIfAbsent(c, new TrieNode());
				pCrawl = pCrawl.children.get(c);
			}
			pCrawl.endOfWord = true;
			pCrawl.leafNodeStr = word;
		}
	}
	
	private static List<String> reconstructWordsFromString(String str){
		List<String> result = new ArrayList<>();
		TrieNode pCrawl = root;
		for(char c : str.toCharArray()) {
			pCrawl = pCrawl.children.get(c);
			if(pCrawl != null) {
				if(pCrawl.endOfWord) {
					result.add(pCrawl.leafNodeStr);
					pCrawl = root;
				}
			}else break;
		}
		return result;
	}
}
