package OOP_Collection.model;

import java.util.Scanner;

public class Xe {
	
	private String tenChuXe;
	private String loaiXe;
	private int dungTich;
	private double triGia;
	
	public Xe(String tenChuXe, String loaiXe, int dungTich, double triGia) {
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	public Xe() {
	}

	public int getDungTich() {
		return dungTich;
	}

	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}
	
	public void Nhap() {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Nhap vao ten chu xe:");
			this.tenChuXe = sc.nextLine();
			System.out.println("Nhap vao loai xe:");
			this.loaiXe = sc.nextLine();
			System.out.println("Nhap vao dung tich xe:");
			this.dungTich = sc.nextInt();
			System.out.println("Nhap tri gia:");
			this.triGia = sc.nextDouble();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public double tinhThue() {
		double thue = 0;
		
		if(this.dungTich<100)
		{
			thue+= this.triGia*0.1;
		}
		else if(this.dungTich>=100 && this.dungTich<=200)
		{
			thue +=this.triGia*0.3;
		}
		else {
			thue += this.triGia*0.5;
		}
		
		return thue;
	
	}
	
	public static void xuatTieuDe() {
		
		System.out.printf("%-15s %-15s %-15s %-15s %-15s %n","Ten Chu Xe","Loai Xe","Dung Tich", "Tri Gia","Thue phai nop");
		
	}
	public void xuatDL() {
		System.out.printf("%-15s %-15s %-15d %-15.1f %-15.1f %n",this.tenChuXe,this.loaiXe,this.dungTich,this.triGia,this.tinhThue());
	}

}
