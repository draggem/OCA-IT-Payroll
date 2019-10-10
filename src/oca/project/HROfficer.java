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
public class HROfficer extends Manager implements ISubordinate{
    
    public HROfficer(double baseSalary, IManager manager, ArrayList<ISubordinate> subordinateList) {
        super(baseSalary, manager, subordinateList);
    }
    
    
    
}
