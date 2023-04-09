import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println(" Nhập số nguyên n: ");
		n = sc.nextInt();
		if (n <= 0) {
			int soTruoc = n + 1;
			int soSau = n - 1;
			System.out.println(" Số đứng trước: " + n + " là: " + soTruoc);
			System.out.println(" Số đứng sau: " + n + " là: " + soSau);
		} else {
			int soTruoc = n - 1;
			int soSau = n + 1;
			System.out.println(" Số đứng trước: " + n + " là: " + soTruoc);
			System.out.println(" Số đứng sau: " + n + " là: " + soSau);
		}
	}
}
