package oca.project;

import java.util.Date;

/**
 *
 * Interface to be implemented by all people working at the company
 * who are getting salaries 
 */
public interface ISalariedPerson extends IPaidPerson {
    
    //Date startWorkDate();
    void setStartOfWorkDate(Date startWorOfkDate);
    Date getStartOfWorkDate();
    
    //getter and setter methods for pay period   
    TimePeriods getTimePeriod();
    
    //getters and setter for base salary
    double getBaseSalary();
    void setBaseSalary(double salary);
    
    void setTimePeriod(TimePeriods timePeriod);
    
    //getter and setter methods for Bonuses that might be assigned 
    //to subordinate by manager
    double getCurrentBonus();
    
    void setCurrentBonus(double currentBonus);
}
