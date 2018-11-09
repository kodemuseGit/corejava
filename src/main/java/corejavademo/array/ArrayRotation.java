package corejavademo.array;

import java.util.Arrays;

public class ArrayRotation {

	public static void rotateArray(int arr[], int size, int d) {
		for (int i = 0; i < d; i++) {
			int temp = arr[0];
			for (int j = 0; j < size - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[size - 1] = temp;
		}

		for (int i = 0; i < size; i++) {
			System.out.println("i = " + arr[i]);
		}
	}

	public static boolean areArrayEqual(int arr1[], int arr2[]) {

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int idx = 0;
		while (idx < arr1.length) {
			if (arr1[idx] != arr2[idx]) {
				return false;
			}
			idx++;
		}
		return true;
	}

	public static boolean searchEleInSortedRotatedArry(int arr1[], int ele) {
		return searchEleInSortedRotatedArry(arr1, 0, arr1.length, ele);
	}

	public static int kthSmalledElment(int arr[], int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

	public static int kthLongestElment(int arr[], int k) {
		Arrays.sort(arr);
		return arr[arr.length - k];
	}

	private static boolean searchEleInSortedRotatedArry(int arr1[], int low,
			int high, int ele) {

		int mid = arr1.length / 2;

		if (arr1[mid] == ele) {
			return true;
		}

		if (arr1[mid] < ele) {
			return searchEleInSortedRotatedArry(arr1, low, mid - 1, ele);
		} else {
			return searchEleInSortedRotatedArry(arr1, mid + 1, high, ele);
		}

	}

	public static int findSmallestEle(int arr1[]) {
		int temp = Integer.MAX_VALUE;
		int idx = 0;
		while (idx < arr1.length) {
			if (temp > arr1[idx]) {
				temp = arr1[idx];
			}
			idx++;
		}

		return temp;

	}

	public static int findGreatestEle(int arr1[]) {
		int temp = Integer.MIN_VALUE;
		int idx = 0;
		while (idx < arr1.length) {
			if (temp < arr1[idx]) {
				temp = arr1[idx];
			}
			idx++;
		}

		return temp;

	}

	public static int findTwoSmallestEle(int arr1[]) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		int idx = 0;
		while (idx < arr1.length) {
			if (first > arr1[idx]) {
				second = first;
				first = arr1[idx];
			} else if (second > arr1[idx] && arr1[idx] != first) {
				second = arr1[idx];
			}
			idx++;
		}

		System.out.println("First : " + first);
		System.out.println("Second : " + second);

		return first;

	}

	public static void main(String args[]) {

		int arr[] = { 11, 2, 3, 4, 1, 6 };
		ArrayRotation.rotateArray(arr, arr.length, 2);

		int arr2[] = { 1, 2, 30, 4, 5, 6 };
		System.out.println("isEqual=" + ArrayRotation.areArrayEqual(arr, arr2));

		System.out.println("smallest :" + kthSmalledElment(arr2, 3));
		System.out.println("Longest :" + kthLongestElment(arr2, 1));
		System.out.println("smallest :" + findSmallestEle(arr2));
		System.out.println("Greatest :" + findGreatestEle(arr2));
		findTwoSmallestEle(arr);

	}
}
