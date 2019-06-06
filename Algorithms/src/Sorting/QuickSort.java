package Sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	
	private static void quickSort(int[] A, int left, int right){
		if(left >= right)
			return;
		int pivot = A[getPivot(left, right)];
		int index = partition(A, left, right, pivot);
		quickSort(A, left, index - 1);
		quickSort(A, index, right);
	}
	
	private static int partition(int[] a, int left, int right, int pivot) {
		while(left <= right) {
			while(a[left] < pivot) {
				left++;
			}
			while(a[right] > pivot) {
				right--;
			}
			if(left <= right) {
				swapElements(a, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static int getPivot(int left, int right) {
		Random rand = new Random();
		return rand.nextInt((right-left)+1) + left;
	}
	public static void displayArray(int[] A) {
		Arrays.stream(A).forEach(e -> System.out.print(e + " "));
	}

	private static void swapElements(int[] A, int index1, int index2) {
		int temp;
		temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}
}
