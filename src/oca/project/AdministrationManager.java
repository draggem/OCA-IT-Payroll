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
public class AdministrationManager extends Manager implements IManager, ISubordinate {
    
    
    public AdministrationManager(double baseSalary, IManager manager, ArrayList<ISubordinate> subordinates) {
        super(baseSalary, manager, subordinates);
        
    }

    

  
    
}
