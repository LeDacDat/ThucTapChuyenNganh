package ITforBeginner_java;

import java.util.Scanner;

public class discountPrice_Bai9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the price of products :");
		double price = sc.nextDouble();
		double discount = price - price*0.1;
		System.out.println("After a 10% discount, this product will be sold for $  " + discount);
		System.out.println();
		
	}

}
