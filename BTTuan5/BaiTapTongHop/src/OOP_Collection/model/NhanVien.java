package OOP_Collection.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public abstract class NhanVien {
	
	protected String maNV;
	protected String hoTen;
	protected int namVaoLam;
	static double tongLuong;
	final double Phucap_BanDau = 100000;
	abstract public double tinhLuong();
	
	public NhanVien(String maNV, String hoTen, int namVaoLam) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.namVaoLam = namVaoLam;
	}

	public NhanVien() {
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	protected double tinhPhuCap() {
		Date now = new Date();
		int d = LocalDate.now().getYear();
		return Phucap_BanDau +(d-this.namVaoLam)*20000;
	}
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma Nhan Vien:");
		this.maNV = sc.nextLine();
		System.out.println("Nhap ho ten nhan vien:");
		this.hoTen = sc.nextLine();
		System.out.println("Nhap nam vao lam:");
		this.namVaoLam = sc.nextInt();
	}
	
	public static void inTieuDe() {
		System.out.printf("%-10s %-15s %6s","Ma nv","Ho Va Ten","Nam vao lam");
	}
	public  void xuatDuLieu() {
		System.out.printf("%-10s %-15s %6d",this.maNV, this.hoTen, this.namVaoLam);
		
	}

}
