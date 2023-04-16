package OOP_Collection.model.test;

import java.util.Scanner;

import OOP_Collection.model.DanhSachSinhVien;
import OOP_Collection.model.SinhVien;

public class testSinhVien {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DanhSachSinhVien dssv = new DanhSachSinhVien();;
		int chon = 0;
		do {
			System.out.println("--------------Menu----------------");
			System.out.println("-------------Nhap lua chon----------");
			System.out.println("1. Them Sinh Vien");
			System.out.println("2. In Danh Sach Sinh Vien");
			System.out.println("3. Kiem tra danh sach rong");
			System.out.println("4. Lay ra so luong sinh vien trong danh sach");
			System.out.println("5. Lam rong danh sach sinh vien");
			System.out.println("6. Kiem tra ton tai sinh vien");
			System.out.println("7. Xoa sinh vien khoi danh sach");
			System.out.println("8. Tim kiem sinh vien theo ten");
			System.out.println("9. Xuat danh sach sinh vien co diem tu cao den thap");
			System.out.println("0. Thoat chuong trinh");	
			
			chon = sc.nextInt();
			if(chon == 1) {
				SinhVien sv = new SinhVien();
				sv.NhapThongTinSV();
				dssv.themSinhVien(sv);
				
			}else if(chon == 2) {
				System.out.println("------------------Danh sach sinh vien------------------");
				dssv.inDanhSachSV();
			
			}else if(chon == 3) {
				System.out.println("Kiem tra danh sach rong:" + dssv.kiemTraDSRong());
				
			}else if(chon==4) {
				System.out.println("So luong sinh vien trong danh sach la:" + dssv.laySoLuongSinhVien());
				
			}else if(chon == 5)
			{
				dssv.lamRongDanhSach();
				
			}else if(chon== 6)
			{
				System.out.println("Nhap ma sinh vien:");
				String masv = sc.nextLine();
				SinhVien sv = new SinhVien(masv);
				System.out.println("Kiem tra ton tai sinh vien:"+dssv.kiemTraTonTaiSV(sv));
				
			}else if(chon == 7) {
				
				System.out.println("Nhap ma sinh vien:");
				String masv = sc.nextLine();
				SinhVien sv = new SinhVien(masv);
				System.out.println("Xoa sinh vien:"+dssv.xoaSinhVien(sv));
				
			}else if(chon == 8)
			{
				System.out.println("Nhap vao ten sinh vien:");
				String ten = sc.nextLine();
				System.out.println("ket qua tim kiem la:");
				dssv.timSinhVien(ten);
			}else if(chon==9) {
				dssv.sapXepSVTheoDiem();
				System.out.println("Danh sach sinh vien sau khi sap xep:");
				dssv.inDanhSachSV();
			}
			
		}while(chon !=0);
		
	}
}
