/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontap3;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class SVCDN extends Nguoi {
    private double tongDiemKT, soMon;

    public SVCDN() {
    }

    public SVCDN(double tongDiemKT, double soMon) {
        this.tongDiemKT = tongDiemKT;
        this.soMon = soMon;
    }

    public SVCDN(double tongDiemKT, double soMon, String maSV, String hoTen, String ngaySinh, String loaiSV) {
        super(maSV, hoTen, ngaySinh, loaiSV);
        this.tongDiemKT = tongDiemKT;
        this.soMon = soMon;
    }
    
    
    public double getTongDiemKT() {
        return tongDiemKT;
    }

    public double getSoMon() {
        return soMon;
    }

    public void setTongDiemKT(double tongDiemKT) {
        this.tongDiemKT = tongDiemKT;
    }

    public void setSoMon(double soMon) {
        this.soMon = soMon;
    }
    
    @Override
    public double tinhDiem() {
        return tongDiemKT / soMon;
    }
    public void Nhap(){
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap tong diem kiem tra: ");
        tongDiemKT = sc.nextDouble();
        System.out.println(" Nhap so mon: ");
        soMon = sc.nextDouble();
    }
    static void inTieuDe(){
        Nguoi.inTieuDe();
        System.out.printf("%-15s %-15s %-15s%n", "tongdiemkt", "soMon", "diemTB");
    }
    public void xuatDL() {
        super.xuatDL();
        System.out.printf("%-15s %-15s %-15s%n",tongDiemKT,soMon,tinhDiem());
    }

    @Override
    public int compareTo(Nguoi o) {
        return hoTen.compareToIgnoreCase(o.getHoTen());
    }
    
}
