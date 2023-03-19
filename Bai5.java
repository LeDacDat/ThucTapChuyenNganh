import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bạn bao nhiêu tuổi rồi ?");	
		int age = scan.nextInt();
		if(age >0) {
			LocalDate localDate = LocalDate.now();
			int year = localDate.getYear();
			int namSinh = year - age;
			System.out.println(" Năm bạn sinh ra: " + namSinh);
		}
		else {
			System.out.println("Độ tuổi không hợp lệ ");
		}
	}
}
