/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.ArrayList;
import java.util.Date;

/*
*class that contains information specific to the CEO who has no manager
*unlike salaried subordinates and contracted subordinates
*/
public class CEO extends Person implements IManager, ISalariedPerson  {

    
    public CEO (ArrayList<ISubordinate> person){
        listOfSubordinates = person;
    }
    /**
     * @return the listOfSubordinates
     */
    public ArrayList<ISubordinate> getListOfSubordinates() {
        return listOfSubordinates;
    }

    /**
     * @param listOfSubordinates the listOfSubordinates to set
     */
    public void setListOfSubordinates(ArrayList<ISubordinate> listOfSubordinates) {
        this.listOfSubordinates = listOfSubordinates;
    }
    
    private TimePeriods salaryFreq;
    private double currentBonus;
    private final double baseSalary = 110000;
    private double managerBonusFund = 5000;
    private Date startWorkDate;                                                                                                                                                     
    private ArrayList<ISubordinate> listOfSubordinates = new ArrayList();
    private TimePeriods timePeriod;
    
    //calculatePay method
    public double calculatePay() {
        return SalaryPaymentCalculator.calculatePay(this);
    }
    
    
    //Assign bonus
    public String assignBonus(ISubordinate subordinate, double bonus){ 
        return BonusUpdater.assignBonus(this, subordinate, bonus);
    }
    
    
    
    //method
    public void applyBonus(){
        
    }
    
    
    
    /******Override Methods From IManage
     * @return r****/
    @Override
    public ArrayList<ISubordinate> getSubordinateList() {
        return listOfSubordinates;
    }

    @Override
    public double CalculatePay(Date startDateOfPayPeriod, double numberOfHours) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*****************************/
    
    
    /******Override Methods From ISalariedPerso
     * @return n****/
    @Override
    public TimePeriods getTimePeriod() {
        return timePeriod;
    }

    @Override
    public void setTimePeriod(TimePeriods timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public double getCurrentBonus() {
        return currentBonus;
    }

    @Override
    public void setCurrentBonus(double currentBonus) {
        this.currentBonus = currentBonus;
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

    /**
     * @return the startWorkDate
     */
    @Override
    public Date getStartOfWorkDate() {
        return startWorkDate;
    }

    
    @Override
    public void setStartOfWorkDate(Date startWorOfkDate) {
        this.startWorkDate = startWorOfkDate;
    }

    /**
     * @return the baseSalary
     */
    @Override
    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public void setBaseSalary(double Salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    
}
