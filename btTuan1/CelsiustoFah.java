package ITforBeginner_java;

import java.util.Scanner;

public class CelsiustoFah {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the temperature in Celsius:");
		double c = sc.nextDouble();
		 double f = (9*c)/5 +32;
		 System.out.println(c + " oC is equivalent to " + f +" oF");
		 System.out.println();
	}

}
