/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qunLyGV;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Thuy
 */
public class GiangvienDemo {
    static int soGV;
    static GiangVien myGV[];
    static void nhap(){
        Scanner sn= new Scanner(System.in);
        do{
            System.out.print("Nhap so luong giang vien: ");
            soGV=sn.nextInt();            
        }while(soGV<1);
        soGV+=3;
        myGV= new GiangVien[soGV];
        for(int i=3; i<soGV; i++){
            System.out.println("Nhap giang vien thu "+ (i+1) +": ");
            myGV[i]=new GVCoHuu();
            myGV[i].nhap();
        }
    }
    static void inDSGV(){
        
        System.out.println("=======DANH SACH GIANG VIEN CO HUU========");
        GVCoHuu.inTieuDe();
        for(int i=0; i<soGV;i++){
            myGV[i].inThongTin();
        }
    }
    
    
    public static void main(String[] args) {
        nhap();
        inDSGV();
        
    }

   
}
