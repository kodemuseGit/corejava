package corejavademo;

import java.util.HashMap;
import java.util.Map;

public class SortedRotateArray {

	public int findPivot(int arr[], int ele) {
		return findPivot(arr, 0, arr.length, ele);
	}

	private int findPivot(int arr[], int low, int high, int ele) {
		if (high < low) {
			return -1;
		}

		if (high == low) {
			return arr[high];
		}

		int mid = (low + high) / 2;
		if (ele == arr[mid]) {
			return ele;
		}

		if (ele < arr[mid]) {
			findPivot(arr, low, mid - 1, ele);
		} else {
			findPivot(arr, mid + 1, high, ele);
		}
		return 0;
	}

	public void reverseArray(int arr[]) {
		int mid = (arr.length) / 2;
		int last = arr.length - 1;
		for (int i = 0; i < mid; i++) {
			int temp = arr[i];
			arr[i] = arr[last];
			arr[last] = temp;
			last--;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("========== :" + arr[i]);
		}
	}

	public void splitAndMerger(int arr[], int pos) {
		int temp[] = new int[pos];
		int posI = pos;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < pos) {
				temp[i] = arr[i];
			}

			if (posI < arr.length) {
				arr[i] = arr[posI];
			}
			if (posI >= arr.length) {
				arr[i] = temp[j];
				j++;
			}

			posI++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("******* :" + arr[i]);
		}

	}

	public void splitAndMergerByMove(int arr[], int pos) {

		for (int i = 0; i < pos; i++) {
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}

			arr[arr.length - 1] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("******* :" + arr[i]);
		}

	}

	public void findKthSmallestEle(int arr[], int k) {
		// Arrays.sort(arr);
		// System.out.println("*smallest****** :" + arr[k - 1]);

		selectionSort(arr);
		System.out.println();
		for (int i = 0; i < k; i++) {
			System.out.println("*smallest****** :" + arr[i]);
		}
	}

	public void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

	}

	public void findSmallestEle(int arr[]) {
		int smallest = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			if (smallest > arr[i + 1]) {
				smallest = arr[i + 1];
			}
		}

		System.out.println("smallest : " + smallest);
	}

	public void findLargestEle(int arr[]) {
		int smallest = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			if (smallest < arr[i + 1]) {
				smallest = arr[i + 1];
			}
		}

		System.out.println("Largest : " + smallest);
	}

	public void findSmallesNumberFromSortedArray(int arr[]) {
		int diff = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = arr[i + i] - arr[i];
			if (temp < diff) {
				diff = temp;
			}
		}
	}

	public void findSecondHighestValue(int arr[]) {
		int first, second;

		first = second = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < first) {
				second = first;
				first = arr[i];
			} else if (arr[i] < second && arr[i] != first) {
				second = arr[i];
			}
		}

		System.out.println("First = " + first + ", second =" + second);
	}

	public void findKOccurens(int arr[], int k) {
		// {3, 1, 4, 4, 5, 2, 6, 1};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < k; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], (Integer) map.get(arr[i]) + 1);
			}
		}

		int first, second;
		first = second = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] > second && arr[i] != first) {
				second = arr[i];
			}
		}
	}

	public void moveAllZerosToEnd(int arr[]) {
		// {3, 1, 4, 4, 5, 2, 6, 1};
		// {1, 2, 0, 4, 3, 0, 5, 0};
		// {1, 2, 4, 3, 5, 0, 0};
		// {1, 2, 0, 0, 0, 3, 6}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count] = arr[i];
				count++;
			} else {
				arr[i] = 0;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("S : " + arr[i]);
		}

	}

	// {3, 1, 4, 4, 5, 2, 6, 1},
	// k = 2
	public static void main(String args[]) {
		SortedRotateArray sortedRotateArray = new SortedRotateArray();
		int arr[] = { 4, 0, 5, 2, 0, 9, 3 };
		// System.out.println(sortedRotateArray.findPivot(arr, arr.length-1));
		// sortedRotateArray.reverseArray(arr);
		// sortedRotateArray.splitAndMerger(arr, 2);
		// sortedRotateArray.splitAndMergerByMove(arr, 2);
		// sortedRotateArray.findKthSmallestEle(arr, 6);
		// sortedRotateArray.findSmallestEle(arr);
		// sortedRotateArray.findLargestEle(arr);
		// sortedRotateArray.findKthSmallestEle(arr, 2);
		// sortedRotateArray.findSecondHighestValue(arr);
		sortedRotateArray.moveAllZerosToEnd(arr);

		// : {0, 1, 2, 6, 9}, n = 5, m = 10

	}
}
