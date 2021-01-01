/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakingsystem;

import bank.management.javaconnect;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author DUY
 */
public class Transfer extends javax.swing.JInternalFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    /**
     * Creates new form Deposite
     */
    public Transfer() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        conn=javaconnect.ConnecrDb();
       
        showInformation();
        Account();
    }
    
    public String inputFile(){
        String userName="";
        try {
            File file=new File("text.txt");
            Scanner sc = new Scanner(file);
            userName=sc.next();
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userName;
    }
    
    public void showInformation(){
        String userName=inputFile();
        String sql="select * from Balances where username=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, userName);
            rs=pst.executeQuery();
            if(rs.next()){
                User.setText(userName);
                String add1=rs.getString("fullname");
                Name.setText(add1);
                String add2=rs.getString("Acc_Num");
                AccountNumber.setText(add2);
                String add3=rs.getString("balance");
                AccountBal.setText(add3);
                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter correct Name,please");
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
            rs.close();
            pst.close();
            }catch(Exception e){
            
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Show = new javax.swing.JButton();
        Transfer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Credit1 = new javax.swing.JTextField();
        Total = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Credit2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CreditAccount = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        TransferAmount2 = new javax.swing.JTextField();
        AccountNumber = new javax.swing.JTextField();
        User = new javax.swing.JTextField();
        TransferAmount1 = new javax.swing.JTextField();
        AccountBal = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(764, 529));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 102), 3), "Transfer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Account Number");

        Show.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        Show.setText("SHOW");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        Transfer.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        Transfer.setText("TRANSFER");
        Transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Credit Account");

        Total.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        Total.setText("TOTAL");
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Available Balance");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Transfer Amount");

        CreditAccount.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        CreditAccount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        CreditAccount.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                CreditAccountPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        CreditAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditAccountActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Name");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("User");

        Name.setEditable(false);

        TransferAmount2.setEditable(false);

        AccountNumber.setEditable(false);

        User.setEditable(false);

        AccountBal.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AccountBal)
                            .addComponent(AccountNumber)
                            .addComponent(Name)
                            .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TransferAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(CreditAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Credit1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Credit2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(TransferAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Transfer)
                                .addGap(79, 79, 79)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Total)
                            .addComponent(Show))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AccountBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addComponent(Total))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TransferAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TransferAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CreditAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Credit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Credit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Show))
                .addGap(30, 30, 30)
                .addComponent(Transfer)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    public void Account(){
        try{
            String sql="select * from Balances";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                String account=rs.getString("Acc_Num");
                CreditAccount.addItem(account);
            }
            rs.close();
            pst.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
            
            }
        }
    }
     public void TransferC(){
        try{
            String value1=(String) CreditAccount.getSelectedItem();
            String value2=Credit2.getText();
            String sql="update Balances set balance='"+value2+"' where Acc_Num='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Succesfully Transfered");
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
            }catch(Exception e){
            
            }
        }
    }
    
    public void TransferD(){
        try{
            String value1=User.getText();
            String value2=TransferAmount2.getText();
            String sql="update Balances set balance='"+value2+"' where username='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } finally{
            try{
                pst.close();
            }catch(Exception e){
            
            }
        }
    }
    
    private void TransferActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        TransferD();
        TransferC();
        Transaction();
        TransferAmount1.setText("");
        TransferAmount2.setText("");
        Credit1.setText("");
        Credit2.setText("");
    }                                        
    
    public String Calender(){
        Calendar cal = new GregorianCalendar();
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        return day+"/"+(month+1)+"/"+year;
    }
    
    public String Time(){
        Calendar cal = Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        return hour+"h:"+minute+"m:"+second+"s";
    }
    
    public void Transaction(){
        String sql="insert into TranHis(Username,Date,Time,Type,Amount)values (?,?,?,?,?)";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,User.getText());
            pst.setString(2,Calender());
            pst.setString(3,Time()); 
            pst.setString(4,"Transfer");
            pst.setString(5,TransferAmount1.getText());
            pst.execute();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
            }catch(Exception e){
            
            }
        }
    }
    
    private void CreditAccountActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        try{
            String a1=AccountBal.getText();
            String a2=TransferAmount1.getText();
             Double sum=Double.parseDouble(a1)-Double.parseDouble(a2);
            String sum1=String.valueOf(sum);
            TransferAmount2.setText(sum1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }                                     

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        try{
            String a1=TransferAmount1.getText();
            String a2=Credit1.getText();
            Double sum=Double.parseDouble(a1)+Double.parseDouble(a2);
            String sum1=String.valueOf(sum);
            Credit2.setText(sum1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }                                    

    private void CreditAccountPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {                                                           
        // TODO add your handling code here:
        try{
            String a1=(String) CreditAccount.getSelectedItem();
            String sql="select * from Balances where Acc_Num=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, a1);
            rs=pst.executeQuery();
            if(rs.next()){
                String add=rs.getString("balance");
                Credit1.setText(add);
            }
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
            
            }
        }
    }                                                          


    // Variables declaration - do not modify                     
    private javax.swing.JTextField AccountBal;
    private javax.swing.JTextField AccountNumber;
    private javax.swing.JTextField Credit1;
    private javax.swing.JTextField Credit2;
    private javax.swing.JComboBox<String> CreditAccount;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Show;
    private javax.swing.JButton Total;
    private javax.swing.JButton Transfer;
    private javax.swing.JTextField TransferAmount1;
    private javax.swing.JTextField TransferAmount2;
    private javax.swing.JTextField User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration                   
}
