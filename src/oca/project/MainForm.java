/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Owner
 */
public class MainForm extends javax.swing.JFrame {
    
    //Declared ArrayList
    private ArrayList<Person> person = new ArrayList();
    private static ArrayList<PayrollReportItem> payrollReportList = new ArrayList();
    
    
    
    /**
     * Instance of Calendar + Date Format
     */
    static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
    static Calendar calendar = Calendar.getInstance();
    static Date fortnightlyPayDate;
    static Date monthlyPayDate;
    
    /**
     * Forms    
     */
    AssignBonusForm bonusForm; 
    CreatePaymentsForm paymentsForm;
    PersonalDataForm personalForm;
    ReportForm reportForm;

    
    
    /**
     * Creates new form MainForm
     * @param person
     */
    public MainForm(ArrayList<Person> person){
        initComponents();
        this.person = person;
            bonusForm = new AssignBonusForm(person);
            paymentsForm = new CreatePaymentsForm(person);
            personalForm = new PersonalDataForm(person);
            reportForm = new ReportForm(person, payrollReportList);
            
        try {
            MainForm.setFortnightlyPayDate(df.parse("01/01/2015"));
            MainForm.setMonthlyPayDate(df.parse("01/01/2015"));
        } catch (ParseException ex) {
            System.out.println("Something wrong with the date\r\n" + ex);
        }
        
        
    }
    
    
    
    /**
     * Method that adds new objects in the payroll array list
     * @param payrollItem
     */
    public static void addToPayroll(PayrollReportItem payrollItem){
        payrollReportList.add(payrollItem);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAssign = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Best IT Payroll - Main Form");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        btnAssign.setBackground(new java.awt.Color(102, 255, 102));
        btnAssign.setText("Assign Bonus");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnDetails.setBackground(new java.awt.Color(102, 255, 102));
        btnDetails.setText("Personal Details and Contractor Data Entry");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(102, 255, 102));
        btnPay.setText("Create Payments");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(102, 255, 102));
        btnReport.setText("Run Reports");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IT Payroll");
        jLabel1.setAutoscrolls(true);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed

        this.dispose();
        bonusForm.setPerson(person);
        bonusForm.setVisible(true);
 
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // Opens Perosonal and Data Form
        this.dispose();
        personalForm.setVisible(true);
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // Opens Payments Form
        this.hide();
        paymentsForm.show();
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        this.dispose();
        reportForm.setVisible(true);
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReport;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the payrollReportList
     */
    public ArrayList<PayrollReportItem> getPayrollReportList() {
        return payrollReportList;
    }

    /**
     * @param payrollReportList the payrollReportList to set
     */
    public void setPayrollReportList(ArrayList<PayrollReportItem> payrollReportList) {
        MainForm.payrollReportList = payrollReportList;
    }

    /**
     * @return the fortnightlyPayDate
     */
    public static Date getFortnightlyPayDate() {
        return fortnightlyPayDate;
    }

    /**
     * @param aFortnightlyPayDate the fortnightlyPayDate to set
     */
    public static void setFortnightlyPayDate(Date aFortnightlyPayDate) {
        fortnightlyPayDate = aFortnightlyPayDate;
    }

    /**
     * @return the monthlyPayDate
     */
    public static Date getMonthlyPayDate() {
        return monthlyPayDate;
    }

    /**
     * @param aMonthlyPayDate the monthlyPayDate to set
     */
    public static void setMonthlyPayDate(Date aMonthlyPayDate) {
        monthlyPayDate = aMonthlyPayDate;
    }

}