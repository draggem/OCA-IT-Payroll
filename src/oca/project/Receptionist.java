/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;

/**
 *
 * @author 92017492
 */
public class Receptionist extends SalariedSubordinate implements ISubordinate{

    public Receptionist(double hourlyRate, IManager manager) {
        super(hourlyRate, manager);
    }


    
}
