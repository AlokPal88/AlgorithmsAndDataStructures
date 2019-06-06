package Sorting;

public class TestSorting {

	public static void main(String[] args) {
		int arr[] = {4,1,8,9,2,6,10,11,9};
		QuickSort.displayArray(arr);
		QuickSort.quickSort(arr);
		System.out.println();
		QuickSort.displayArray(arr);

	}

}
