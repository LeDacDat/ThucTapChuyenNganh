/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b1_class_person;

/**
 *
 * @author Huyền Trang
 */
 import java.util.Scanner;
public class B1_class_person {

      private static String name;
    private static int age;
    public static void oneMoreYear(){
        age=age+1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten: ");
        name=sc.nextLine();
        System.out.println("Nhap tuoi:");
        age=sc.nextInt();
        System.out.println("------birthday----");
        System.out.println(name+"you are"+age );
        oneMoreYear();
        System.out.println("Sau khi tang them 1 tuoi: " + age);
    }
    
}
