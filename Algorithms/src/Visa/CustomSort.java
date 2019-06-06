package Visa;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSort {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(7,1,3,5,6,8,3,7,7,3);
		System.out.println(customSort(nums));
	}

	private static List<Integer> customSort(List<Integer> nums) {
		Map<Integer,Integer> count = new HashMap<>();
		nums.stream().forEach(num -> count.put(num, count.getOrDefault(num, 0)+1));
		//count.entrySet().stream().forEach(e -> System.out.println(e.getKey()+ ":" + e.getValue()));
		Collections.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				Integer v1 = count.get(o1);
				Integer v2 = count.get(o2);
				if(v1 == v2)
					return o1.compareTo(o2);
				else
					return v1.compareTo(v2);
				
			}
			
		});
		return nums;
	}

}
