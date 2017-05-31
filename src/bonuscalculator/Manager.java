/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonuscalculator;

/**
 *
 * @author Hanif
 */
public class Manager extends Employee {

    private double pctBonus, travelExpense;
    
    public Manager(String name, double salary, double pctBonus, double travelExpense) {
        super(name, salary);
        this.pctBonus = pctBonus;
        this.travelExpense = travelExpense;
    }

    public double getPctBonus() {
        return pctBonus;
    }

    public double getTravelExpense() {
        return travelExpense;
    }

    @Override
    public double computeBonus() {
        return  (getSalary() * getPctBonus()) + 500.00;
    }
    
}
