package MiscellaneousProblems;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		String str = "aabbcddeffe";
		LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
		
		for(char c: str.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0)+1);
		}
		
		Iterator entrySetItr = countMap.entrySet().iterator();
		while(entrySetItr.hasNext()) {
			Entry entry = (Entry) entrySetItr.next();
			if((int)entry.getValue() == 1) {
				System.out.println("First Non-Repeating Character is: " + entry.getKey());
				break;
			}
		}

	}

}
