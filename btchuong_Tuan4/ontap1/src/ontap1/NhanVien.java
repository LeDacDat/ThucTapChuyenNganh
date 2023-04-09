package ontap1;


import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public abstract class NhanVien {

	protected String maNV;
	protected String hoTen;
	protected int namVaoLam;
	final double phuCap_BD = 10000;
	static double tongLuong;

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

	public String getHoTen() {
		return hoTen;
	}

	public int getNamVaoLam() {
		return namVaoLam;
	}

	public abstract double tinhLuong();

	protected double tinhPhuCap() {
		Date now = new Date();
		int d = LocalDate.now().getYear();
		return phuCap_BD + (d - namVaoLam) * 20000;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Nhap ma nhan vien: ");
		maNV = sc.nextLine();
		System.out.println("Nhap ho ten: ");
		hoTen = sc.nextLine();
		System.out.println("Nhap nam vao lam: ");
		namVaoLam = sc.nextInt();
	}

	public static void inTieuDe() {
		System.out.printf(" %-10s %-15s %6s ", "Ma NV", "Ho Ten", "Nam VL");
	}

	public void xuatDL() {
		System.out.printf(" %-10s %-15s %-15s", maNV, hoTen, namVaoLam);
	}
}
