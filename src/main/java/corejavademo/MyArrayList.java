package corejavademo;

public class MyArrayList {

	int initialSize = 0;
	int arr[];
	int pointer = 0;

	public MyArrayList() {
		initialSize = 10;
		arr = new int[initialSize];
	}

	public MyArrayList(int initialSize) {
		if (initialSize <= 0) {
			throw new IllegalArgumentException();
		}
		this.initialSize = initialSize;
		arr = new int[initialSize];
	}

	public synchronized void put(int data) {

		if (pointer >= initialSize) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (pointer < initialSize) {
			arr[pointer] = data;
			pointer++;
		}

	}

	public void traverse() {
		for (int i = 0; i < pointer; i++) {
			System.out.println("ele : " + arr[i]);
		}
	}

	public void normalSearch(int ele) {
		int idx = 0;
		while (idx < pointer) {
			if (ele == arr[idx]) {
				System.out.println("Ele Found at = " + (idx + 1));
			}
			idx++;
		}
	}

	public void selectionSort() {
		int idx = 0;
		while (idx < pointer) {
			for (int j = idx + 1; j < (pointer - 1); j++) {
				if (arr[idx] > arr[j]) {
					int temp = arr[idx];
					arr[idx] = arr[j];
					arr[j] = temp;
				}
			}

			idx++;
		}
	}

	public void binarySearch(int ele) {
		binarySearch(ele, 0, pointer);
	}

	private void binarySearch(int ele, int leftIdx, int rightIdx) {
		System.out.println("=================");
		int mid = (leftIdx + rightIdx) / 2;
		if (ele == arr[mid]) {
			System.out.println("Ele Found at = " + (mid + 1));
			return;
		}

		if (ele < arr[mid]) {
			binarySearch(ele, 0, mid - 1);
		} else {
			binarySearch(ele, mid + 1, pointer);
		}
	}

	public static void main(String args[]) {
		MyArrayList myArrayList = new MyArrayList();
		myArrayList.put(2);
		myArrayList.put(4);
		myArrayList.put(5);
		myArrayList.put(6);
		myArrayList.put(7);
		myArrayList.put(1);
		myArrayList.put(55);
		myArrayList.put(54);
		myArrayList.put(66);
		myArrayList.put(78);

		myArrayList.traverse();
		System.out.println("----------------------");
		myArrayList.selectionSort();
		myArrayList.traverse();
		myArrayList.normalSearch(55);
		myArrayList.binarySearch(55);

	}
}
