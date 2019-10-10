/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.ArrayList;
import java.util.Date;

/**
 *Class contain information about salaried subordinates 
 * who themselves have subordinates.
 * 
 */
public class Manager extends SalariedSubordinate implements IManager, ISubordinate {
    private ArrayList<ISubordinate> listOfSubordinates = new ArrayList();
    private double managerBonusFund = 5000;
    
    //constructor 3 param
    public Manager(double baseSalary, IManager manager, ArrayList<ISubordinate> subordinateList) {
        super(baseSalary, manager);
        this.listOfSubordinates = subordinateList;
        
    }
    
    //Constructor 2 param
    public Manager(double baseSalary, IManager manager){
        super(baseSalary, manager);
    }

    
    
    
    //applyBonus method
    public void applyBonus(double bonus){
        managerBonusFund = managerBonusFund - bonus;
        
    }
    
    
    //assignBonus method
    public String assignBonus(ISubordinate subordinate, double bonus){
        BonusUpdater.assignBonus(this, subordinate, bonus);
        return ""; 
   }
    
    
    
    //CalculatePay method
    public double calculatePay(Date startDateOfPayPeriod, double numberOfHours) throws Exception {
        return SalaryPaymentCalculator.calculatePay((ISalariedPerson)this);
    }


    /**
     * @param listOfSubordinates the listOfSubordinates to set
     */
    public void setListOfSubordinates(ArrayList<ISubordinate> listOfSubordinates) {
        this.listOfSubordinates = listOfSubordinates;
    }

    /**
     * @return the managerBonusFund
     */
    public double getManagerBonusFund() {
        return managerBonusFund;
    }

    /**
     * @param managerBonusFund the managerBonusFund to set
     */
    public void setManagerBonusFund(double managerBonusFund) {
        this.managerBonusFund = managerBonusFund;
    }

    @Override
    public ArrayList<ISubordinate> getSubordinateList() {
       return listOfSubordinates;
    }
    
}
