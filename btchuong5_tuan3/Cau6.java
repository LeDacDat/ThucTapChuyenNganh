/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt_TTCN;

/**
 *
 * @author Huyền Trang
 */
import java.util.Scanner;
public class Cau6 {
    public static void main(String[] args) {
       int age, year;
       String name,ageGroup;
       Scanner scan=new Scanner(System.in);
       System.out.println("What is your name? ");
       name=scan.nextLine();
       System.out.println("In what year were you born? ");
       year=scan.nextInt();
       age= 2023 - year;
       if(age>16) {
           ageGroup =" you can drive in the US ";
       }else {
           ageGroup= "you cann't drive in the US";
       }
       System.out.println(name + ", you are "+age+" and "+ ageGroup);
       }
}
