package bai8;
import java.util.Scanner;
public class bai8 {
	
	
	    public static void main(String[] args) {
	        System.out.println("nhap so phan tu trong mang: ");
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        double[] arr = new double[n];
	        double total = 0;
	        for(int i=0; i<arr.length; i++){
	            System.out.print("nhap gia tri phan tu thu  "+(i+1)+": ");
	            arr[i] = scanner.nextDouble();
	        }
	        scanner.close();
	        for(int i=0; i<arr.length; i++){
	            total = total + arr[i];
	        }
	        double average = total / arr.length;
	        System.out.format("ket qua: %.3f", average);
	    }
	}


