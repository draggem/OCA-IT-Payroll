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
public class BonusUpdater {
    public static String assignBonus(IManager manager, ISubordinate subordinate, double bonus) {
        SalariedSubordinate currentBonus = new SalariedSubordinate(bonus, manager);
        String output="";
        for (ISubordinate sub: manager.getSubordinateList()){
            
            if (sub != subordinate){
                System.out.println("Throw Exception HEre");
            } 
            else {
                //check current bonus notexceeding manager bonus
                
                if (currentBonus.getCurrentBonus() <= bonus ){
                    
                    
                    
                }
                else{
                    output = "The Bonus Assigned is greater than the current Bonus";
                }
            }
        
        
        }
        return output;
      
    }
}
