package OOP_Collection.model;

import java.util.Scanner;

public class NhanVienSX extends NhanVien {
	private int soSanPham;
	
	public int getSoSanPham() {
		return soSanPham;
	}
	public void setSoSanPham(int soSanPham) {
		this.soSanPham = soSanPham;
	}
	public NhanVienSX(String maNV, String hoTen, int namVaoLam, int soSanPham) {
		super(maNV, hoTen, namVaoLam);
		this.soSanPham = soSanPham;
	}
	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return this.soSanPham*10000;
	}

	public void Nhap() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap so san pham:");
		this.soSanPham = sc.nextInt();
	}
	public static void inTieuDe()
	{
		NhanVien.inTieuDe();
		System.out.printf("%10s %15s %15s %n", "So sp","Phu cap", "Luong");
	}
	public void xuatDuLieu() {
		super.xuatDuLieu();
		System.out.printf("%10d %15.2f %15.2f %n",this.soSanPham,this.tinhPhuCap(),this.tinhLuong());
	}
}
