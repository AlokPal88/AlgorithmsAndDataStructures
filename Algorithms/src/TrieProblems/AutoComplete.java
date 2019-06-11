package TrieProblems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * This is a demonstration of implementation AutoComplete feature using Trie data structure 
*/
public class AutoComplete {

	static class TrieNode{
		Map<Character, TrieNode> children = new LinkedHashMap<>();
		int size;
		boolean isEndOfWord;
		String leafNodeStr;
	}
	
	static TrieNode root = new TrieNode();
	public static void main(String[] args) {
		String[] words = {"what is autocomplete", "what is sharding", "what is natural language processing",
				"what is tire data structure?"};
		String prefix = "what if";
		buildTrieNode(words);
		System.out.println(getAutoCompleteList(prefix));
	}

	public static void buildTrieNode(String[] words)
	{
		for(String word : words) {
			TrieNode pCrawl = root;
			for(Character c : word.toCharArray())
			{
				pCrawl.children.putIfAbsent(c, new TrieNode());
				pCrawl = pCrawl.children.get(c);
				pCrawl.size++;
			}
			pCrawl.isEndOfWord = true;
			pCrawl.leafNodeStr = word;
		}
	}
	
	public static List<String> getAutoCompleteList(String prefix)
	{
		List<String> words = new ArrayList<>();
		TrieNode pCrawl = root;
		String word = "";
		for(Character c : prefix.toCharArray()) {
			pCrawl = pCrawl.children.get(c);
			if(pCrawl == null)
				return null;
		}
		//Traverse down the tree to get all the words from the current Tire node
		getWordFromTrie(pCrawl, words);
		return words;
	}
	
	public static void getWordFromTrie(TrieNode node, List<String> words) {
		if(node.isEndOfWord) {
			words.add(node.leafNodeStr);
		}
		for(Character c : node.children.keySet()) {
			getWordFromTrie(node.children.get(c), words);
		}
		//return node.leafNodeStr;
	}
}
