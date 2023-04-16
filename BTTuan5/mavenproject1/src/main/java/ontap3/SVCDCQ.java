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
public class SVCDCQ extends Nguoi {
    private double TDKT, SMKT, DKTHP;

    public SVCDCQ() {
    }

    public SVCDCQ(double TDKT, double SMKT, double DKTHP) {
        this.TDKT = TDKT;
        this.SMKT = SMKT;
        this.DKTHP = DKTHP;
    }

    public SVCDCQ(double TDKT, double SMKT, double DKTHP, String maSV, String hoTen, String ngaySinh, String loaiSV) {
        super(maSV, hoTen, ngaySinh, loaiSV);
        this.TDKT = TDKT;
        this.SMKT = SMKT;
        this.DKTHP = DKTHP;
    }
    
    public double getTDKT() {
        return TDKT;
    }

    public double getSMKT() {
        return SMKT;
    }

    public double getDKTHP() {
        return DKTHP;
    }

    public void setTDKT(double TDKT) {
        this.TDKT = TDKT;
    }

    public void setSMKT(double SMKT) {
        this.SMKT = SMKT;
    }

    public void setDKTHP(double DKTHP) {
        this.DKTHP = DKTHP;
    }
     public void Nhap() {
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap tong diem kiem tra: ");
        TDKT = sc.nextDouble();
        System.out.println(" Nhap so mon: ");
        SMKT = sc.nextDouble();
        System.out.println(" Nhap diem thi kt hoc phan: ");
        DKTHP = sc.nextDouble();
    }
     static void inTieuDe(){
        Nguoi.inTieuDe();
        System.out.printf("%-15s %-15s %-15s -%15s%n ", "tongdiemkt", "soMon", "diemthi kthp","diemTB");
    }
    public void xuatDL() {
        super.xuatDL();
        System.out.printf("%-15s %-15s-%15s -%15s%n",TDKT,SMKT,DKTHP,tinhDiem());
    }
    @Override
    public double tinhDiem() {
        return (TDKT / SMKT + DKTHP)/3;
    }

    @Override
    public int compareTo(Nguoi o) {
        return hoTen.compareToIgnoreCase(o.getHoTen());
    } 
}
