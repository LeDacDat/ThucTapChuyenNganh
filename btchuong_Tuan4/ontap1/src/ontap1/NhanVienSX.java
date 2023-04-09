package ontap1;

import java.util.Scanner;


public class NhanVienSX extends NhanVien {
    private int sanPham;

   
    public NhanVienSX( int sanPham) {
		this.sanPham = sanPham;
	}


	public NhanVienSX() {
        
    }

    
    @Override
    public double tinhLuong() {
        return this.sanPham *10000;
    }

    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so san pham: ");
        sanPham = sc.nextInt();   
    }
    public static void inTieuDe(){
        NhanVien.inTieuDe();
        System.out.printf(" %-10s %-15s %-15s%n", "So sp", "Phuc cap","Luong");
    }
    public  final void xuatDL(){
        super.xuatDL();
        System.out.printf("%-15s %-15s %-15s%n", sanPham, tinhPhuCap(), tinhLuong());
        System.out.println("");
    }

    public int getSanPham() {
        return sanPham;
    }

    public void setSanPham(int sanPham) {
        this.sanPham = sanPham;
    }
    
}
