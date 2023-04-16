package OOP_Collection.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class SinhVien implements Comparable<SinhVien> {
	
	private String maSinhVien;
	private String tenSinhVien;
	private int namSinh;
	private double diemTrungBinh;
	
	
	public SinhVien() {
		
	}

	public SinhVien(String maSV) {
		this.maSinhVien = maSV;
	}

	public SinhVien(String maSinhVien, String tenSinhVien, int namSinh, double diemTrungBinh) {
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemTrungBinh = diemTrungBinh;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", namSinh=" + namSinh
				+ ", diemTrungBinh=" + diemTrungBinh + "]";
	}
	 
	public void NhapThongTinSV() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma sinh vien:");
		this.maSinhVien = sc.nextLine();
		System.out.println("Nhap ho va ten sinh vien:");
		this.tenSinhVien = sc.nextLine();
		System.out.println("Nhap nam sinh:");
		this.namSinh = sc.nextInt();
		System.out.println("Nhap diem trung binh:");
		this.diemTrungBinh = sc.nextDouble();
	}

	public int compareTo(SinhVien sv1) {
		return this.maSinhVien.compareTo(sv1.maSinhVien);
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemTrungBinh, maSinhVien, namSinh, tenSinhVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(maSinhVien, other.maSinhVien);
	}


	
	

}
