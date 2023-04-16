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
public class GVCoHuu extends GiangVien{
    private double LCB;
    private int heSoLuong, namCT;

    @Override
    public double tinhLuong() {
        if(namCT<5) return LCB*heSoLuong;
        else return LCB*heSoLuong + LCB*((double)namCT/100);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public GVCoHuu(String hoTen, String diaChi, String loaiGV,double LCB, int heSoLuong, int namCT) {
        super(hoTen, diaChi, loaiGV);
        this.LCB = LCB;
        this.heSoLuong = heSoLuong;
        this.namCT = namCT;
    }

    public GVCoHuu() {
        super();
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.print("Nhap luong co ban: ");
        Scanner sn= new Scanner(System.in);
        LCB= sn.nextDouble();
        System.out.print("Nhap he so luong: ");
        heSoLuong= sn.nextInt();
        System.out.print("Nhap nam cong tac: ");
        namCT=sn.nextInt();
    }
    static void inTieuDe(){
        GiangVien.inTieuDe();
        System.out.printf("%15s %15s %15s %15s %n","Luong co ban","He so luong","Nam CT","Luong");
    }
    @Override
    public void inThongTin(){
        super.inThongTin();
        System.out.printf("%15s %15s %15s %15s %n",LCB,heSoLuong,namCT, tinhLuong());        
    }
}
