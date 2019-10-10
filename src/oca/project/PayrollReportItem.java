/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Owner
 */
public class PayrollReportItem {
    DecimalFormat df = new DecimalFormat("#0.00");
    
    //Fields
    Person person;
    double personSalary;
    Date startOfPayPeriod;
    TimePeriods payFreq;
    
    //Contructor
    public PayrollReportItem(Person person, double personSalary, Date startOfPayPeriod, TimePeriods payFreq){
        this.person = person;
        this.personSalary = personSalary;
        this.startOfPayPeriod = startOfPayPeriod;
        this.payFreq = payFreq;
    }
    
    
    //Method to output
    @Override
    public String toString(){
        
        return person + " was paid $" + df.format(personSalary) + " on the " + startOfPayPeriod + " Payment Period: " + payFreq;
    }
}
