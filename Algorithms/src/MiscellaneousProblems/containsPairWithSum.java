import java.util.*;

public class containsPairWithSum {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10, 5, 10, 3, 7);
		
		nums.stream().forEach(System.out::println);
		
		System.out.println(pairWithSum(nums, 20));

	}

	private static boolean pairWithSum(List<Integer> nums, int sum) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<nums.size(); i++) {
			if(set.contains(sum - nums.get(i)))
				return true;
			set.add(nums.get(i));
		}
		return false;
	}

}
