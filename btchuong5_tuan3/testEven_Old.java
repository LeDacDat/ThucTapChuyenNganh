package ttcn_httt.model;

import java.util.Scanner;

public class testEven_Old {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap vao so bat ki:");
		int n = sc.nextInt();
		
		if(n %2 == 0)
			System.out.println(n + " la so chan ");
		else
			System.out.println(n + " la so le");
		

	}

}
