/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

/**
 *
 * @author Owner
 */
public class SystemAnalyst extends SalariedSubordinate implements ISubordinate{
    
    public SystemAnalyst(double baseSalary, IManager manager) {
        super(baseSalary, manager);
    }
    
}
