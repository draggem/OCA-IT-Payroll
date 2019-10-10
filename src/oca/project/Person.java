/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.*;
import java.text.*;
/**
 *
 * @author Owner
 */
public class Person {    
    //This class has all the details of each Employees
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String fName;
    private String lName;
    private String position;
    private Date DOB;
    private String employeeManager;
    private boolean isContractor;
    
    
    //sdf.format(new Date()) use this
    
    @Override
    public String toString() {
        return getfName() + " " + getlName();
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the DOB
     */
    public Date getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the employeeManager
     */
    public String getEmployeeManager() {
        return employeeManager;
    }

    /**
     * @param employeeManager the employeeManager to set
     */
    public void setEmployeeManager(String employeeManager) {
        this.employeeManager = employeeManager;
    }

    /**
     * @return the isContractor
     */
    public boolean isIsContractor() {
        return isContractor;
    }

    /**
     * @param isContractor the isContractor to set
     */
    public void setIsContractor(boolean isContractor) {
        this.isContractor = isContractor;
    }
    
}
