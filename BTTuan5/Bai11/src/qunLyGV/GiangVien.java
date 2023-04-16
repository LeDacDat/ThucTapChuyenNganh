/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qunLyGV;

import java.util.Scanner;

/**
 *
 * @author Thuy
 */
public abstract class GiangVien implements Comparable<GiangVien>{
    private String hoTen, diaChi, loaiGV;
    public abstract double tinhLuong();

    

    public String getHoTen() {
        return hoTen;
    }
    
    public void nhap(){
        Scanner sn= new Scanner(System.in);
        do{
            System.out.print("Nhap ho ten: ");
            hoTen= sn.nextLine();
        }while("".equals(hoTen));
        
        System.out.print("Nhap dia chi: ");
        diaChi= sn.nextLine();
        System.out.print("Nhap loai giang vien (giang vien co huu/giang vien thinh giang): ");
        loaiGV= sn.nextLine();
    }

    public GiangVien(String hoTen, String diaChi, String loaiGV) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loaiGV = loaiGV;
    }

    public GiangVien() {
    }
    @Override
     public int compareTo(GiangVien o){
        return hoTen.compareToIgnoreCase(o.getHoTen());
    }
    static void inTieuDe(){
        System.out.printf("%15s %15s %20s","Ho ten","Dia chi","Loai giang vien");
    }
    public void inThongTin(){
        System.out.printf("%15s %15s %20s",hoTen, diaChi, loaiGV);        
    }
}
