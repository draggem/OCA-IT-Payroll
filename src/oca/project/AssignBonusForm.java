/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class AssignBonusForm extends javax.swing.JFrame {
    //Declared ArrayList Person
    private ArrayList<Person> person = new ArrayList();
    
    
    
    /**
     * Creates new form AssignBonusForm
     * @param person
     */
    public AssignBonusForm(ArrayList<Person> person) {          
        initComponents();
        this.person = person;
        populateManagersBox();
        populateSubordinateBox();
        
    }
    
    DefaultComboBoxModel managerModel = new DefaultComboBoxModel();
    DefaultComboBoxModel subordinateModel = new DefaultComboBoxModel();
    
    /**Method cycles through the person object and checks 
         * if the objects class extends Manager
         * which means it has subordinates
     */
    public final void populateManagersBox(){
        for (Person p : person) {
            if(Manager.class.isAssignableFrom(p.getClass()) || CEO.class.isAssignableFrom(p.getClass())){
                managerModel.addElement(p.toString());
            }
        }
        cboManagers.setModel(managerModel); //set model 
    }
    
    
    /**
     * Subordinate List Loop
     */
    public final void populateSubordinateBox(){
        subordinateModel.removeAllElements();
        for (Person p: person){
            if(Manager.class.isAssignableFrom(p.getClass())){
                Manager m = (Manager)p;
                
                if (m.toString().equals(cboManagers.getSelectedItem())){
                    System.out.println(m.getSubordinateList());
                    for (ISubordinate sub: m.getSubordinateList()){
                        Person per = (Person)sub;
                        if (per.isIsContractor()){
                            //System.out.println("Contractor");
                            //do nothing because you dont want to add it to the list
                        }else{
                            subordinateModel.addElement(sub);
                        }
                    }
                    break;
                }
            }if (CEO.class.isAssignableFrom(p.getClass())){
                CEO c = (CEO)p;
                if (c.toString().equals(cboManagers.getSelectedItem())){
                    //System.out.println(c.getListOfSubordinates());
                    for (ISubordinate sub: c.getListOfSubordinates()){
                        subordinateModel.addElement(sub);
                    }
                    break; 
                } 
            }
        }
        cboSubordinateList.setModel(subordinateModel); 
        
        
   }
    
    /**
     * Method that checks if subordinate box is empty
     * which means there is no salaried subordinates
     */
    public void checkSubordinateBox(){
        if (cboSubordinateList.getItemCount() == 0){
                subordinateModel.addElement("No Salaried Subordinate.");
                cboSubordinateList.setModel(subordinateModel);
            }
    }
    
    
    
    /**
     * Method that checks when check bonus 
     * button is pressed
     */
    public void checkBonus(){
        ISalariedPerson p = (ISalariedPerson)cboSubordinateList.getSelectedItem();
        if (p.getCurrentBonus() == 0){
            JOptionPane.showMessageDialog(rootPane, p.toString() + " does not have any bonus.", "No Bonus Yet!",JOptionPane.OK_OPTION);
        }else{
            JOptionPane.showMessageDialog(this, "The bonus of " + cboSubordinateList.getSelectedItem() + " is $" + p.getCurrentBonus());
            //System.out.println(p.getCurrentBonus());
        }
    }
    
    
    
    /**
     * Assign Bonus Method
     */
    public void assignBonus(){
        
        if (cboSubordinateList.getSelectedItem().equals("No Salaried Subordinate.")){
            JOptionPane.showMessageDialog(rootPane, "No Subordinate Is Selected!");
            
            
        }else if (txtBonus.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You haven't specified the bonus", "Announcement", JOptionPane.OK_OPTION);
            
        }else {
            try{
                ISalariedPerson selectedSubordinate = (SalariedSubordinate)cboSubordinateList.getSelectedItem();
                
                for (Person p: person){
                    if (Manager.class.isAssignableFrom(p.getClass()) && p.toString().equals(cboManagers.getSelectedItem())){
                        Manager selectedManager = (Manager)p;
                        if (selectedSubordinate.getCurrentBonus() == 0){
                            if (Double.parseDouble(txtBonus.getText()) <= selectedManager.getManagerBonusFund()){
                                selectedManager.setManagerBonusFund(selectedManager.getManagerBonusFund() - Double.parseDouble(txtBonus.getText()));
                                selectedSubordinate.setCurrentBonus(selectedSubordinate.getCurrentBonus() + Double.parseDouble(txtBonus.getText()));
                                JOptionPane.showMessageDialog(this, "The bonus of $" + selectedSubordinate.getCurrentBonus() + " has been assigned to " + selectedSubordinate.toString(), "Announcement", JOptionPane.OK_OPTION);
                            }else{
                                JOptionPane.showMessageDialog(this, "Manager cannot allocate more than $" + selectedManager.getManagerBonusFund(), "Announcement", JOptionPane.OK_OPTION);
                            }

                        }else{
                            JOptionPane.showMessageDialog(this, selectedSubordinate.toString() + " has already got a bonus assigned", "Announcement", JOptionPane.OK_OPTION);
                        }
                        break;
                    }else if (CEO.class.isAssignableFrom(p.getClass()) && p.toString().equals(cboManagers.getSelectedItem())){
                        CEO CEOSelected = (CEO)p;
                        if (selectedSubordinate.getCurrentBonus() == 0){
                            if (Double.parseDouble(txtBonus.getText()) <= CEOSelected.getManagerBonusFund()){
                                CEOSelected.setManagerBonusFund(CEOSelected.getManagerBonusFund() - Double.parseDouble(txtBonus.getText()));
                                selectedSubordinate.setCurrentBonus(selectedSubordinate.getCurrentBonus() + Double.parseDouble(txtBonus.getText()));
                                JOptionPane.showMessageDialog(this, "The bonus of $" + txtBonus.getText() + " has been assigned to " + selectedSubordinate.toString(), "Announcement", JOptionPane.OK_OPTION);
                            }else{
                                JOptionPane.showMessageDialog(this, "Manager cannot allocate more than $" + CEOSelected.getManagerBonusFund(), "Announcement", JOptionPane.OK_OPTION);
                            }

                        }else{
                            JOptionPane.showMessageDialog(this, selectedSubordinate.toString() + " has already got a bonus assigned", "Announcement", JOptionPane.OK_OPTION);
                        }
                        break;
                    }
                    
                }
                
            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(rootPane, "Invalid Input in Bonus TextBox!", "Invalid!",JOptionPane.OK_OPTION);
            }catch (Exception e ){
                JOptionPane.showMessageDialog(rootPane, e);
            }

        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAssign = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboManagers = new javax.swing.JComboBox<>();
        cboSubordinateList = new javax.swing.JComboBox<>();
        txtBonus = new javax.swing.JTextField();
        btnAssign = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblAssign.setBackground(new java.awt.Color(102, 102, 255));
        lblAssign.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        lblAssign.setForeground(new java.awt.Color(102, 102, 102));
        lblAssign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAssign.setText("Best IT Payroll");
        lblAssign.setAutoscrolls(true);
        lblAssign.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Manager:");

        jLabel2.setText("Subordinates List:");

        jLabel3.setText("Bonus:");
        jLabel3.setToolTipText("");

        cboManagers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboManagersItemStateChanged(evt);
            }
        });
        cboManagers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboManagersActionPerformed(evt);
            }
        });
        cboManagers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboManagersKeyPressed(evt);
            }
        });

        btnAssign.setBackground(new java.awt.Color(102, 255, 102));
        btnAssign.setText("Assign Bonus");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnCheck.setBackground(new java.awt.Color(102, 255, 102));
        btnCheck.setText("Check current bonus");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Assign Bonus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAssign, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboManagers, 0, 210, Short.MAX_VALUE)
                            .addComponent(cboSubordinateList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(btnAssign, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboManagers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSubordinateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        MainForm form = new MainForm(getPerson());
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cboManagersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboManagersActionPerformed
        populateSubordinateBox();
        checkSubordinateBox();
        
        
        
    }//GEN-LAST:event_cboManagersActionPerformed

    private void cboManagersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboManagersItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboManagersItemStateChanged

    private void cboManagersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboManagersKeyPressed
        
    }//GEN-LAST:event_cboManagersKeyPressed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        //Checks if there is a subordinate selected.
        if (cboSubordinateList.getSelectedItem().equals("No Salaried Subordinate.")){
            JOptionPane.showMessageDialog(rootPane,"Please Select a subordinate from subordinate's List Box. \r\n You cannot check Bonus if they dont exist!","Select Subordinate",JOptionPane.OK_OPTION);
        }else{
            checkBonus();
         }
        
        
        
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        assignBonus();
        
        
    }//GEN-LAST:event_btnAssignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JComboBox<String> cboManagers;
    private javax.swing.JComboBox<String> cboSubordinateList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAssign;
    private javax.swing.JTextField txtBonus;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the person
     */
    public ArrayList<Person> getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(ArrayList<Person> person) {
        this.person = person;
    }
}
