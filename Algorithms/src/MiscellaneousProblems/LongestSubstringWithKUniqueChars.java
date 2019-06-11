package MiscellaneousProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {

	public static void main(String[] args) {
		String str = "abcadcacacaca";
		int k = 3;
		System.out.println(findLengthOfLongestSubString(str, k));
	}

	private static int findLengthOfLongestSubString(String str, int k) {
		int result = 0;
		int i = 0;
		Map<Character, Integer> count = new HashMap<>();
		
		for(int j=0; j<str.length(); j++) {
			char c = str.charAt(j);
			count.put(c, count.getOrDefault(c, 0)+1);
			
			if(count.size() <= k) {
				result = Math.max(result, j-i+1);
			}else {
				while(count.size()>k) {
					char ch = str.charAt(i);
					if(count.get(ch) == 1)
						count.remove(ch);
					else
						count.put(ch, count.get(ch)-1);
					i++;
				}
			}
		}
		return result;
	}

}
