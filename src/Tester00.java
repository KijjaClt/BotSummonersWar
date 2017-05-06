import java.util.Scanner;

public class Tester00 {
	public static void main(String[] args) {
		Scanner ad = new Scanner(System.in);

		int a1 = ad.nextInt();
		int a2 = ad.nextInt();

		char type = ad.next().charAt(0);

		int[] num1 = new int[a1];
		int[] num2 = new int[a2];

		int[] num3 = new int[a1 + a2];

		for (int d1 = 0; d1 < a1; d1++) {
			num1[d1] = ad.nextInt();
		}

		for (int d2 = 0; d2 < a2; d2++) {
			num2[d2] = ad.nextInt();
		}

		for (int d3 = 0; d3 < num3.length; d3++) {
			num3[d3] = -9999999;
		}

		if (type == 'u') {

			for (int x = 0; x < a1; x++) {
				num3[x] = num1[x];
			}

			for (int i = 0; i < a2; i++) {
				boolean isDup = false;

				for (int j = 0; j < a1; j++) {
					if (num2[i] == num1[j]) {
						isDup = true;
					}
				}

				if (isDup == false) {
					num3[a1 + i] = num2[i];
				}
			}

			for (int i = 0; i < num3.length; i++) {
				if (num3[i] != -9999999) {
					System.out.print(num3[i] + " ");
				}
			}
		}
	}
}