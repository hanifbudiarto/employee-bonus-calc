/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonuscalculator;

import static java.lang.System.out;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Hanif
 */
public class TestEmployee {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("enter the number of workers : ");
        int nw = in.nextInt();
        in.nextLine();
        
        System.out.println("enter the number of managers : ");
        int nm = in.nextInt();
        in.nextLine();
        
        System.out.println("enter the number of executives : ");
        int ne = in.nextInt();
        in.nextLine();
        
        int n = nw + nm + ne;
        
        Employee[] employees = new Employee[n];
        
        int empCounter = 0;
        
        // create nw Worker
        for (int i=0; i<nw; i++) {
            System.out.println("enter a worker data : ");
            String workerData = in.nextLine();
            
            String[] data = workerData.split(", ");
            
            Worker worker = new Worker(data[0], Double.parseDouble(data[1]), 
                    Double.parseDouble(data[2]));
            employees[empCounter++] = worker;
        }
        
        // create nm Manager
        for (int i=0; i<nm; i++) {
            System.out.println("enter a manager data : ");
            String managerData = in.nextLine();
            
            String[] data = managerData.split(", ");
            
            Manager manager = new Manager(data[0], 
                    Double.parseDouble(data[1]), 
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
            employees[empCounter++] = manager;
        }
        
        // create ne Executive
        for (int i=0; i<ne; i++) {
            System.out.println("enter an executive data : ");
            String executiveData = in.nextLine();
            
            String[] data = executiveData.split(", ");
            
            Executive executive = new Executive(
                    data[0], 
                    Double.parseDouble(data[1]), 
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]),
                    Integer.parseInt(data[4]));
            employees[empCounter++] = executive;            
        }
        
        String name;
        double salary, pctBonus, bonus, travelExpense;
        int optionsCount;
        
        //use name, salary, bonus, pctBonus returned above towards building the summary report.
        String out, outW="", outM="", outE="";
        
        DecimalFormat df = new DecimalFormat ( );
        df.applyPattern ( ".00" );
        
        System.out.println();
        for (int i=0; i < employees.length; i++) {
            //get name and salary
            //To access target object methods that are defined in class Employee, we don’t need type casting.
            name = employees[i].getName();
            salary = employees[i].getSalary ( );

            //call computeBonus using polymorphic call
            //Since computeBonus is declared in Employee class, we don’t need type casting.
            bonus = employees [i].computeBonus ( );

            //To access target object methods that are not defined in class Employee, we use down casting.
            //Downcasting (Widening) should be done within an if statement using instanceof
            //Since getPctBonus method is not present in class Employee, it is accessed via down casting.
            //Similarly getTravelExpense, and getOptionsCount are accessed via downcasting.
            //The instanceof clause is used below to ensure a safe down casting (widening).

            if (employees[i] instanceof Worker){
                pctBonus = ( (Worker) employees[i] ).getPctBonus ( );
                
                //accumulate Worker output in outW
                outW = outW + "Name: " + name + "\n";
                outW = outW + "Salary: $ " + df.format(salary) + "\n";
                outW = outW + "PercentBonus: " + df.format(pctBonus) + "\n";
                outW = outW + "Total Bonus: $ " + df.format(bonus) + "\n\n";
                //add other values in outW
            }
            else if (employees[i] instanceof Manager) {
                pctBonus = ( (Manager) employees[i] ).getPctBonus ( );
                travelExpense = ( (Manager) employees[i] ).getTravelExpense ( );

                //accumulate Manager output in outM
                outM = outM + "Name: " + name + "\n";
                outM = outM + "Yearly Salary: $ " + df.format(salary) + "\n";
                outM = outM + "PercentBonus: " + df.format(pctBonus) + "\n";
                outM = outM + "Total Bonus: $ " + df.format(bonus) + "\n";
                outM = outM + "Travel Expense: $ " + df.format(travelExpense) + "\n\n";
                //add other values in outM
            }
            else if (employees[i] instanceof Executive) {

                pctBonus = ( (Executive) employees[i] ).getPctBonus ( );
                travelExpense = ( (Executive) employees[i] ).getTravelExpense ( );
                optionsCount = ( (Executive) employees[i] ).getOptionsCount ( );

                //accumulate Executive output in outE
                outE = outE + "Name: " + name + "\n";
                outE = outE + "Yearly Salary: $ " + df.format(salary) + "\n";
                outE = outE + "PercentBonus: " + df.format(pctBonus) + "\n";
                outE = outE + "Total Bonus: $ " + df.format(bonus) + "\n";
                outE = outE + "Travel Expense: $ " + df.format(travelExpense) + "\n";
                outE = outE + "Options Count: " + optionsCount + "\n\n";
                //add other values in outE    
            }

        }

        //After getting out of the loop
        out = outW + outM + outE;
        //display out
        
        System.out.println(out);
        JOptionPane.showMessageDialog(null, out);

        
    }
    
    
}
