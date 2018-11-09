package corejavademo;

public class MyArrayRotaion {

	public static void rotationArray(int arr[], int d, int n) {

		for (int idx = 0; idx < d; idx++) {
			int temp = arr[0];
			System.out.println("temp:" + temp);

			// switft element...
			int i = 0;

			while (i < n - 1) {
				arr[i] = arr[++i];
			}

			i = 0;
			while (i < n - 1) {
				System.out.println("==" + arr[i]);
				i++;
			}
			System.out.println("n====" + (n - 1));
			arr[n - 1] = temp;
		}
	}

	public static void findElementAtleastGreater(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];

			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > temp) {
					count++;
				}

				if (count == 2) {
					System.out.println(arr[i]);
					break;
				}
			}

		}

	}

	public static void main(String args[]) {
		int arr[] = { 7, -2, 3, 4, 9, -1 };
		//
		// for (int idx = 0; idx < arr.length; idx++) {
		// System.out.println(arr[idx]);
		// }
		// System.out.println("-----------------------------");
		// rotationArray(arr, 2, arr.length);
		// for (int idx = 0; idx < arr.length; idx++) {
		// System.out.println(arr[idx]);
		// }

		findElementAtleastGreater(arr);
	}
}
