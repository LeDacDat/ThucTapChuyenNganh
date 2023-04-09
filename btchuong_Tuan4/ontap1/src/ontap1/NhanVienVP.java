package ontap1;

import java.util.Scanner;


public class NhanVienVP extends NhanVien{
    private  int soNgayNghi;
    private float mucLuong;

    public NhanVienVP(int soNgayNghi, float mucLuong, String maNV, String hoTen, int namVaoLam) {
        super(maNV, hoTen, namVaoLam);
        this.soNgayNghi = soNgayNghi;
        this.mucLuong = mucLuong;
    }

    public NhanVienVP() {
        super();
    } 
    @Override
    public double tinhLuong() {
        return mucLuong -soNgayNghi* 10000;
    }

    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so ngay nghi: ");
        soNgayNghi = sc.nextInt();
        System.out.println("Nhap muc luong: ");
        mucLuong = sc.nextFloat();
    }
    
    public static void inTieuDe(){
        NhanVien.inTieuDe();
        System.out.printf(" %-15s %-15s %-15s %-15s%n", "So ngay nghi", "Muc luong", "Phu cap", "Tong luong");
    }
   public void xuatDL(){
       super.xuatDL();
       System.out.printf(" %-15s %-15s %-15s %-15s%n", soNgayNghi, mucLuong,tinhPhuCap(), tinhLuong());
   }

    @Override
    public String toString() {
        return super.toString() +"\t so ngay nghi" + soNgayNghi +"\t Muc luong" +mucLuong;
    }
   
}
