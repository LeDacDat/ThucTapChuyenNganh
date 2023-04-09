import java.util.Scanner;

public class Cau4 {

	public static void main(String[] args) {
		Scanner scan= new Scanner (System.in);
		System.out.println("Enter a String: ");
		String s1= scan.next();
		
		System.out.println("Enter another String: ");
		String s2=scan.next();
		System.out.println(s1.toLowerCase()+" "+s2.toUpperCase());;
	}

}
