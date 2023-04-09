/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ws6;
public class employee{
    String name;
    String dateOfBirth;
    String wasHiredOn;
    String job;
    Double salary;
    void promote(double amount){
        salary +=amount;
    }
    double calculateAnnualSalary(){
        return this.salary*12;
    }
    void show(){
        System.out.println("name: "+name);
        System.out.println("dateOfBirth: "+dateOfBirth);
        System.out.println("wasHiredOn: "+wasHiredOn);
        System.out.println("job: "+job);
        System.out.println("salary: "+salary);
        System.out.println("annualSalary: "+calculateAnnualSalary());
    }
    public static void main(String[] args) {
        employee em = new employee();
        em.name =" Lucas";
        em.dateOfBirth ="25/10/2001";
        em.wasHiredOn = "01/09/2017";
        em.job = "CEO";
        em.salary = 5000.0;
        em.promote(500.0);
        em.show();

    }
}
