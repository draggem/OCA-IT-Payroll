/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;

/*
*This class will contain information common to all contractors working in the company
*/
public class ContractSubordinate extends Person implements IContractor, ISubordinate{
    
    private IManager manager;
    private double hourlyRate;
    
    //COnstructor
    public ContractSubordinate(double hourlyRate, IManager manager) {
        this.manager = manager;
        this.hourlyRate = hourlyRate;
    }
    
  
    
    //CalculatePay method
    @Override
    public double calculatePay(Date periodStartDate, double numberOfHours) {
        double payment;
        double overtimeHourlyRate = hourlyRate + (hourlyRate * 0.1);
        if (numberOfHours > 160){
            payment = numberOfHours * overtimeHourlyRate;
        }else{
            payment = numberOfHours * hourlyRate;
        }
        return payment;

    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public IManager getManager() {
        return manager;
    }

    @Override
    public double CalculatePay(Date startDateOfPayPeriod, double numberOfHours) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
