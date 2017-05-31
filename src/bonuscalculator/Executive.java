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
public class Executive extends Employee {

    private double pctBonus, travelExpense;
    private int optionsCount;
    
    public Executive(String name, double salary, double pctBonus, double travelExpense, int optionsCount) {
        super(name, salary);
        this.pctBonus = pctBonus;
        this.travelExpense = travelExpense;
        this.optionsCount = optionsCount;
    }

    public double getPctBonus() {
        return pctBonus;
    }

    public double getTravelExpense() {
        return travelExpense;
    }

    public int getOptionsCount() {
        return optionsCount;
    }

    @Override
    public double computeBonus() {
        return (getSalary() * getPctBonus()) + 1000.00;
    }
    
}
