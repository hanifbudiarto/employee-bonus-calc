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
public class Worker extends Employee {

    private double pctBonus ;
    
    public Worker(String name, double salary, double pctBonus) {
        super(name, salary);
        this.pctBonus = pctBonus;
    }

    public double getPctBonus() {
        return pctBonus;
    }
    
    @Override
    public double computeBonus() {
        return getSalary() * getPctBonus();
    }
    
}
