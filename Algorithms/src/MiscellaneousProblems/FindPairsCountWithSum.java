import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairsCountWithSum {

	public static void main(String[] args) {
		int[] nums = {1, 5, 7, -1, 5};
		int sum = 6;
		
		System.out.println(getPairsCount(nums, sum));

	}

	private static int getPairsCount(int[] nums, int sum) {
		Map<Integer, Integer> count = new HashMap<>();
		/*
		 * Arrays.stream(nums).forEach(num -> { count.put(num,
		 * count.getOrDefault(num,0)+1); });
		 */
		
		//count.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
		int twicePairCount = 0;
		for(int i=0; i<nums.length; i++) {
			if(count.get(sum-nums[i]) != null)
				twicePairCount ++;
			count.put(nums[i],count.getOrDefault(nums[i],0)+1);
		}
		return twicePairCount;
	}

}
