/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Owner
 */
public class SalaryPaymentCalculator {
    
    private static final int MONTH_IN_A_YEAR = 12;
    private static final int FORTNIGHTS_A_YEAR = 26;
    
    
    //Inititae date
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final String FIXED_DATE = "01/01/2015";
    static Date staticDate;
    
    static DecimalFormat df = new DecimalFormat("#0.00");
    
    /**
     * Method for difference between dates
     * @param year1
     * @param year2
     * @return 
     */
    public static int yearsBetween(Date year1, Date year2){
        Calendar secondYear= getCalendar(year1);
        Calendar firstYear= getCalendar(year2);
        int diff = secondYear.get(Calendar.YEAR) - firstYear.get(Calendar.YEAR);
        if (firstYear.get(Calendar.MONTH) > secondYear.get(Calendar.MONTH) || 
            (firstYear.get(Calendar.MONTH) == secondYear.get(Calendar.MONTH) && firstYear.get(Calendar.DATE) > secondYear.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
        
    }
    
    
    public static double calculateCurrentSalaryWithIncrease(double baseSalary, Date dateStarted){
        try{
            staticDate = sdf.parse(FIXED_DATE);
        }catch (ParseException e){
            System.out.println("Unparseable using " + sdf + e);
        }
        double salary=baseSalary;
        for (int i=0; i < yearsBetween(staticDate, dateStarted); i++){
            
            salary = baseSalary + (baseSalary *0.02);
        }
        return salary;
        
    }
    
     
    public static String calculateFinalYearlyPay(ISalariedPerson person){
        double finalYearlyPay = calculateCurrentSalaryWithIncrease(person.getBaseSalary(), person.getStartOfWorkDate());
        return df.format(finalYearlyPay);
    }
    
    
    public static double calculatePay(ISalariedPerson payment){
        double total;
        if (payment.getTimePeriod() == TimePeriods.MONTHLY){
            total = Double.parseDouble(calculateFinalYearlyPay(payment)) / (double)MONTH_IN_A_YEAR;
            return total;
        }else{
            total = Double.parseDouble(calculateFinalYearlyPay(payment)) / (double)FORTNIGHTS_A_YEAR;
            return total;
        }
    }
    
    /**
     * calendar method
     * @param date
     * @return 
     */
    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
    return cal;
}
}
