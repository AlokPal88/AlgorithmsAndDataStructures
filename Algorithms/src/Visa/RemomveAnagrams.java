package Visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Remove anagrams from the given list of string
public class RemomveAnagrams {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("code","anagram","eodc","aaarmng");
		System.out.println(removeAnagrams(words));
	}

	private static List<String> removeAnagrams(List<String> words) {
		List<String> result = new ArrayList<>();
		Map<String,Integer> count = new HashMap<>();
		//O(n)
		words.stream().forEach(word -> {
			char[] chars = word.toCharArray();
			//O(a log a)
			Arrays.sort(chars);
			if(count.getOrDefault(new String(chars),0) == 0)
				result.add(word);
			count.put(new String(chars), count.getOrDefault(new String(chars),0)+1);
		});
		return result;
	}

}
