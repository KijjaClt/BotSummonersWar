import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int arr[] = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}

		incArray(arr);
		
		int n = kb.nextInt();

		printArray(arr, n);
	}

	public static void incArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] += 1;
		}
	}

	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > n) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
