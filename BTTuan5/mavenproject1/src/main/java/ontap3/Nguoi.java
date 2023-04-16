/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ontap3;

import java.util.Scanner;

public abstract class Nguoi implements Comparable<Nguoi>{

    protected String maSV;

    protected  String hoTen, ngaySinh, loaiSV;

    public Nguoi() {
    }

    public Nguoi(String maSV, String hoTen, String ngaySinh, String loaiSV) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.loaiSV = loaiSV;
    }
    
    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLoaiSV() {
        return loaiSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLoaiSV(String loaiSV) {
        this.loaiSV = loaiSV;
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap ma sinh vien: ");
        maSV = sc.nextLine();
        System.out.println(" Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.println(" Nhap ngay sinh: ");
        ngaySinh = sc.nextLine();
        System.out.println(" Nhap loai sinh vien: ");
        loaiSV = sc.nextLine();
    }
    public abstract double  tinhDiem();
    static void inTieuDe(){
        System.out.printf("%-10s %-15s %-15s %-15s", "masv", "hoten", "ngaysinh","loaisv");
    }
    public void xuatDL() {
        System.out.printf("%-10s %-15s %-15s %-15s",maSV, hoTen, ngaySinh, loaiSV);
    }
}
