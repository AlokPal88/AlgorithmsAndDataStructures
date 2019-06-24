import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWholeMinutesPairs {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10,50,90,30);
		System.out.println(getPairsCount(nums));
	}

	private static int getPairsCount(List<Integer> nums) {
		//Collections.sort(nums);
		Map<Integer, Integer> countMap = new HashMap<>();
		int x = 0;
		for(int i=0; i<nums.size(); i++) {
			if(x < nums.get(i)/60)
				x = nums.get(i)/60;
		}
		System.out.println("x="+x);
		int pairCount = 0;
		for(int i=0; i < nums.size(); i++) {
			for(int j=0; j<x; j++) {
				int sum = 60*j;
				if(countMap.getOrDefault(sum - nums.get(i), 0) == 0)
					pairCount++;
			}
			countMap.put(nums.get(i), countMap.getOrDefault(nums.get(i), 0)+1);
		}
		return pairCount/2;
	}

}
