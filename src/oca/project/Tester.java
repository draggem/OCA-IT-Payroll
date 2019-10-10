/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

/**
 *
 * @author Owner
 */
public class Tester extends ContractSubordinate implements IContractor, ISubordinate{

    public Tester(double hourlyRate, IManager manager) {
        super(hourlyRate, manager);
    }

}
