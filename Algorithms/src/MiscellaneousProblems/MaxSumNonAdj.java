import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumNonAdj {

	private static int[] arr = {1,0,3,4,9};
	private static Node[] res = new Node[arr.length];
	
	static class Node{
		int sum;
		List<Integer> elements;
		Node(int sum) {
			this.sum = sum;
			elements = new ArrayList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(max_sum_iterative(arr, arr.length));
		System.out.println(res[res.length-1].elements.toString());
	}

	private static int max_sum_iterative(int[] arr, int length) {
		for(int i = 0; i < length; i++) {
			if(i == 0) {
				Node n0 = new Node(arr[0]);
				n0.elements.add(arr[0]);
				res[0] = n0;
			}
			else if (i == 1) {
				Node n1 = new Node(Math.max(arr[0], arr[1]));
				n1.elements.add(n1.sum);
				res[1] = n1;
			}
			else {
				res[i] = max(res[i-2],arr[i], res[i-1], i);
			}
		}
		return res[length-1].sum;
	}

	private static Node max(Node i_2, int i, Node i_1, int index) {
		Node ni;
		if (i_2.sum + i > i_1.sum) {
			ni = new Node(i_2.sum + i);
			ni.elements.addAll(i_2.elements);
			ni.elements.add(i);
		}
		else {
			ni = new Node(i_1.sum);
			ni.elements.addAll(i_1.elements);
		}
		return ni;
	}

}
