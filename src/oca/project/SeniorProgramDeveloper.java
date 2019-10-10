/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class SeniorProgramDeveloper extends Manager implements ISubordinate, IManager{
    

    public SeniorProgramDeveloper(double baseSalary, IManager manager, ArrayList<ISubordinate> subordinate) {
        super(baseSalary, manager, subordinate);
    }
    
   


}
