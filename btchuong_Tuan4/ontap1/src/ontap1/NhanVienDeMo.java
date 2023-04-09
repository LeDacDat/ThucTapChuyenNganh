package ontap1;


import java.util.Scanner;

public class NhanVienDeMo {
	static int soNV, loaiNV;
	static double tongLuong = 0f;
	static NhanVien myNV[] = new NhanVien[soNV];

	static void nhapDSNV() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong nhan vien=");
		soNV = sc.nextInt();
		
		myNV = new NhanVien[soNV];
		for (int i = 0; i < soNV; i++) {
			System.out.println("1.Nhap NVSX, 2.NVVP");
			loaiNV = sc.nextInt();
			if (loaiNV == 1) {
				myNV[i] = new NhanVienSX();
			} else {
				myNV[i] = new NhanVienVP();
			}
			myNV[i].nhap();
			tongLuong = tongLuong + myNV[i].tinhLuong() + myNV[i].tinhPhuCap();
		}
	}

	static void inDSNV() {
		System.out.println("\nDanh sach nhan vien sx cong ty la");
		NhanVienSX.inTieuDe();
		
		for (int i = 0; i < soNV; i++)
			if (myNV[i] instanceof NhanVienSX)
				myNV[i].xuatDL();
		System.out.println("Tong luong nhan vien: " + tongLuong);
		
		System.out.println("\nDanh sach nhan vien VP cong ty la");
		NhanVienVP.inTieuDe();
		for (int i = 0; i < soNV; i++)
			if (myNV[i] instanceof NhanVienVP)
				myNV[i].xuatDL();
		System.out.println(" ");
		System.out.println("Tong luong nhan vien: " + tongLuong);
	}

	public static void main(String[] args) {
		nhapDSNV();
		inDSNV();
	}
}
