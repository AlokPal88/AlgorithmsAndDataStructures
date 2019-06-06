package MiscellaneousProblems;

import java.util.ArrayList;
import java.util.List;

/*For example, inputs [1, 0, 3, 9, 2] should return 10 (1 + 9)*/

public class MaxSumSubarrayNonAdj {
	private static int[] arr = {1, 0, 3};
	private static int[] mem = new int[arr.length];
	private static List<Integer> res = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println("Max sum recursive : " + max_sum_recursive(arr, arr.length-1));
		System.out.println("Max Sum elements are: " + res.toString());
		System.out.println("Max sum iterative : " + max_sum_iterative(arr, arr.length-1));
	}

	private static int max_sum_recursive(int[] arr, int i) {
		if(i == 0) {
			return arr[0];
		}
		if(i == 1) {
			return max(arr[0], arr[1]);
		}
		if(mem[i] != 0) {
			return mem[i];
		}
		mem[i] = max(max_sum_recursive(arr, i-1), arr[i]+ max_sum_recursive(arr,i-2));
		//res.add(mem[i]);
		return mem[i];
	}
	
	private static int max_sum_iterative(int[] arr, int i) {
		int[] sum = new int[i+1];
		for(int j = 0; j <= i; j++) {
			if (j == 0)
				sum[0] = arr[0];
			else if (j == 1)
				sum[1] = max(arr[0], arr[1]);
			else
				sum[j] = max(sum[i-2] + arr[i], sum[i-1]);
		}
		return sum[i];
	}

	private static int max(int i, int j) {
		return i >= j ? i : j;
	}

}
