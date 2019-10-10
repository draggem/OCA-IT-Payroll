 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;

/**
 *Class contain information common to all employees working in the company
 * who receives salary
 * 
 */
public class SalariedSubordinate extends Person implements ISubordinate, ISalariedPerson{
    
    private Date startWorkOfDate;
    private IManager manager;
    private TimePeriods timePeriod;
    private double baseSalary;
    private double currentBonus;
    
    //Class Constructor 2 parameters
    public SalariedSubordinate (double baseSalary, IManager manager){
        this.baseSalary = baseSalary;
        this.manager = manager;
    }
    
    
    @Override
    public IManager getManager() {
        return manager;
    }

    @Override
    public double CalculatePay(Date startDateOfPayPeriod, double numberOfHours) throws Exception {
        return SalaryPaymentCalculator.calculatePay((ISalariedPerson)this);
    }


    /**
     * @param manager the manager to set
     */
    public void setManager(IManager manager) {
        this.manager = manager;
    }


    /**
     * @return the baseSalary
     */
    
    @Override
    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * @param baseSalary the baseSalary to set
     */
    @Override
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * @return the currentBonus
     */
    @Override
    public double getCurrentBonus() {
        return currentBonus;
    }

    /**
     * @param currentBonus the currentBonus to set
     */
    @Override
    public void setCurrentBonus(double currentBonus) {
        this.currentBonus = currentBonus;
    }

    /**
     * @return the startDate
     */
    @Override
    public Date getStartOfWorkDate() {
        return startWorkOfDate;
    }

    /**
     * @param startWorkOfDate
     */
    @Override
    public void setStartOfWorkDate(Date startWorkOfDate) {
        this.startWorkOfDate = startWorkOfDate;
    }

    @Override
    public TimePeriods getTimePeriod() {
        return timePeriod;
    }

    @Override
    public void setTimePeriod(TimePeriods timePeriod) {
        this.timePeriod = timePeriod;
    }
    
}
