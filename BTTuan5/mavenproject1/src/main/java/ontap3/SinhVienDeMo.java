/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontap3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SinhVienDeMo {
    static int soSV, loaiSV;
    static double diemTB = 0f;
    static Nguoi sv[] = new Nguoi[soSV];
    
    
    public static void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nhap so sinh vien: ");
        soSV = sc.nextInt();
        sv = new Nguoi[soSV];
        fakeData();
        for (int i = 2; i < soSV; i++){
            System.out.println(" Nhap loai sinh vien: 1.svcdn 2.svcdcq");
            loaiSV = sc.nextInt();
            if( loaiSV == 1 )
                sv[i] = new SVCDN();
            else
               sv[i] = new SVCDCQ();
            sv[i].Nhap();
            diemTB = diemTB + sv[i].tinhDiem();         
        }
    }
    public static void inDSSV() {
        System.out.println("Danh sach sinh vien cao dang nghe cua truong: ");
        SVCDN.inTieuDe();
        for (int i = 0; i < soSV; i++) {
            if (sv[i] instanceof SVCDN) {
                sv[i].xuatDL();
            }
        }
        System.out.println("");
        System.out.println("Danh sach sinh vien cao dang chinh quy cua truong: ");
        SVCDCQ.inTieuDe();
        for (int i = 0; i < soSV; i++) {
            if (sv[i] instanceof SVCDCQ) {
                sv[i].xuatDL();
            }
        }
    }
    public static void fakeData(){
        SVCDN sv1 = new SVCDN(10,4,"sv01","hoang","01/02/2003","svcdn");
        sv[0] = sv1;
        SVCDCQ sv2 = new SVCDCQ(10,4,9,"sv02","huy","01/12/2000","svcdcq");
        sv[1] = sv2;
    }
    public static void sapXep(){
        Collections.sort(Arrays.asList(sv));
        System.out.println("Sau khi sap xep: ");
        inDSSV();
    }
    public static void timSV(){
        Scanner sc = new Scanner(System.in);
        String ht;
        System.out.println(" Nhap ho ten: ");
        ht = sc.nextLine();
        for (int i = 0; i < soSV; i++) {
            if(sv[i].getHoTen().equals(ht))
                sv[i].xuatDL();
        }
    }
    public static void main(String[] args) {
        Nhap();
        inDSSV();
        sapXep();
        timSV();
    }
}
