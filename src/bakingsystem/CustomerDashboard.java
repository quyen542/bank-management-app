/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakingsystem;

import bank.management.LogIn;
import bank.management.javaconnect;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.pow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUY
 */
public class CustomerDashboard extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    /**
     * Creates new form CustomerDashboard
     */
    Color DefaultColor,ClickedColor;
    public CustomerDashboard() {
        super("Home");
        initComponents();
        DefaultColor = new Color(212,242,234);
        ClickedColor = new Color(233,249,242);
        
        Profile.setBackground(DefaultColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(DefaultColor);
        LogOut.setBackground(DefaultColor);
        ChagePass.setBackground(DefaultColor);
        conn=javaconnect.ConnecrDb();
        Calender();
        User();
        typeAcc();
        CheckAcount();
    }
    
    public void typeAcc(){
        String userName="";
        try {
            File file=new File("text.txt");
            Scanner sc = new Scanner(file);
            userName=sc.next();
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql="select * from Account where username=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, userName);
            rs=pst.executeQuery();
            if(rs.next()){
                String add1=rs.getString("acc_type");
                TypeAcc.setText(add1);
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
    
    public void User(){
        try {
            File file=new File("text.txt");
            Scanner sc = new Scanner(file);
            User.setText(sc.next());
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Calender(){
        Calendar cal = new GregorianCalendar();
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        Date.setText(+day+"-"+(month+1)+"-"+year);
    }
    
    public void CheckAcount()
    {
         String userName= User.getText();
         String UpdateD="";
          String bal="";
        String sql="select * from Balances where username=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, userName);
            rs=pst.executeQuery();
            if(rs.next()){
                UpdateD=rs.getString("UpdateD");
                bal=rs.getString("balance");
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
        int i=0;
        boolean check = false;
        LocalDate update = LocalDate.parse(UpdateD,
                DateTimeFormatter.ofPattern("dd-LL-yyyy"));
        while(LocalDate.now().isAfter(update.plusMonths(1)))
        {
            i=i+1;
            update = update.plusMonths(1);
            check = true;
        }
        if(check == true)
        {
            if(TypeAcc.getText().equals("Saving"))
            {
                Double r = 1+0.04;
                Double balance = Double.parseDouble(bal);
        Double sum;
                sum = balance*pow(r,i) ;
        System.out.println(i);
        System.out.println(sum);
        DateTimeFormatter dateFormatter4 = DateTimeFormatter
                .ofPattern("dd-LL-yyyy");
        String NewUpdate = dateFormatter4.format(update);
        String sum1=String.valueOf(sum);   
        setbal(sum1);
        setday(NewUpdate);
            }
        }
    }
    public void setbal(String sum)
    {
        try{
            String value1=User.getText();
            String sql1="update Balances set balance='"+sum+"' where username='"+value1+"'";
            pst=conn.prepareStatement(sql1);
            pst.execute();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void setday(String NewUpdate)
    {
        try{
            String value1=User.getText();
            String sql1="update Balances set UpdateD='"+NewUpdate+"' where username='"+value1+"'";
            pst=conn.prepareStatement(sql1);
            pst.execute();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        TypeAcc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Profile = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Deposite = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Withdraw = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TransactionHistory = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LogOut = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Transfer = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ChagePass = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(233, 249, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 3));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Welcome back,");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Type acc:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setText("IU BANK APP");

        User.setEditable(false);

        Date.setEditable(false);

        TypeAcc.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TypeAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TypeAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(212, 242, 234));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3));

        Profile.setBackground(new java.awt.Color(212, 242, 234));
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProfileMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setText("PROFILE");

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Deposite.setBackground(new java.awt.Color(212, 242, 234));
        Deposite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DepositeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DepositeMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setText("DEPOSITE");

        javax.swing.GroupLayout DepositeLayout = new javax.swing.GroupLayout(Deposite);
        Deposite.setLayout(DepositeLayout);
        DepositeLayout.setHorizontalGroup(
            DepositeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepositeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DepositeLayout.setVerticalGroup(
            DepositeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepositeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Withdraw.setBackground(new java.awt.Color(212, 242, 234));
        Withdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WithdrawMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                WithdrawMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setText("WITHDRAW");

        javax.swing.GroupLayout WithdrawLayout = new javax.swing.GroupLayout(Withdraw);
        Withdraw.setLayout(WithdrawLayout);
        WithdrawLayout.setHorizontalGroup(
            WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WithdrawLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WithdrawLayout.setVerticalGroup(
            WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WithdrawLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        TransactionHistory.setBackground(new java.awt.Color(212, 242, 234));
        TransactionHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionHistoryMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TransactionHistoryMousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel9.setText("TRANS HISTORY");

        javax.swing.GroupLayout TransactionHistoryLayout = new javax.swing.GroupLayout(TransactionHistory);
        TransactionHistory.setLayout(TransactionHistoryLayout);
        TransactionHistoryLayout.setHorizontalGroup(
            TransactionHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionHistoryLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        TransactionHistoryLayout.setVerticalGroup(
            TransactionHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        LogOut.setBackground(new java.awt.Color(212, 242, 234));
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogOutMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setText("LOG OUT");

        javax.swing.GroupLayout LogOutLayout = new javax.swing.GroupLayout(LogOut);
        LogOut.setLayout(LogOutLayout);
        LogOutLayout.setHorizontalGroup(
            LogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogOutLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        LogOutLayout.setVerticalGroup(
            LogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        Transfer.setBackground(new java.awt.Color(212, 242, 234));
        Transfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TransferMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setText("TRANSFER");

        javax.swing.GroupLayout TransferLayout = new javax.swing.GroupLayout(Transfer);
        Transfer.setLayout(TransferLayout);
        TransferLayout.setHorizontalGroup(
            TransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TransferLayout.setVerticalGroup(
            TransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        ChagePass.setBackground(new java.awt.Color(212, 242, 234));
        ChagePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChagePassMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChagePassMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel11.setText("CHANGE PASS");

        javax.swing.GroupLayout ChagePassLayout = new javax.swing.GroupLayout(ChagePass);
        ChagePass.setLayout(ChagePassLayout);
        ChagePassLayout.setHorizontalGroup(
            ChagePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChagePassLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChagePassLayout.setVerticalGroup(
            ChagePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChagePassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TransactionHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Transfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Withdraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Deposite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChagePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Deposite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Transfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(TransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(ChagePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        Desktop.setPreferredSize(new java.awt.Dimension(764, 529));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-removebg-preview.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bank-removebg-preview.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel14.setText("WELCOME TO OUR BANKING MANAGEMENT SYSTEM");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("CHOOSE THE TRANSACTION TO CONTINUE");

        Desktop.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DesktopLayout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addGroup(DesktopLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(132, 132, 132))
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(154, 154, 154))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMousePressed
        // TODO add your handling code here:
        Profile.setBackground(ClickedColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(DefaultColor);
        LogOut.setBackground(DefaultColor);
        
    }//GEN-LAST:event_ProfileMousePressed

    private void DepositeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepositeMousePressed
        // TODO add your handling code here:
        Profile.setBackground(DefaultColor);
        Deposite.setBackground(ClickedColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(DefaultColor);
        ChagePass.setBackground(DefaultColor);
        LogOut.setBackground(DefaultColor);
    }//GEN-LAST:event_DepositeMousePressed

    private void WithdrawMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WithdrawMousePressed
        // TODO add your handling code here:
        Profile.setBackground(DefaultColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(ClickedColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(DefaultColor);
         ChagePass.setBackground(DefaultColor);
        LogOut.setBackground(DefaultColor);
    }//GEN-LAST:event_WithdrawMousePressed

    private void TransferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferMousePressed
        // TODO add your handling code here:
        Profile.setBackground(DefaultColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(ClickedColor);
        TransactionHistory.setBackground(DefaultColor);
         ChagePass.setBackground(DefaultColor);
        LogOut.setBackground(DefaultColor);
    }//GEN-LAST:event_TransferMousePressed

    private void TransactionHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionHistoryMousePressed
        Profile.setBackground(DefaultColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(ClickedColor);
         ChagePass.setBackground(DefaultColor);
        LogOut.setBackground(DefaultColor);
    }//GEN-LAST:event_TransactionHistoryMousePressed

    private void LogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMousePressed
        Profile.setBackground(DefaultColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(DefaultColor);
         ChagePass.setBackground(DefaultColor);
        LogOut.setBackground(ClickedColor);
    }//GEN-LAST:event_LogOutMousePressed

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        // TODO add your handling code here:
        Profile profile = new Profile();
        Desktop.removeAll();
        Desktop.add(profile).setVisible(true);
    }//GEN-LAST:event_ProfileMouseClicked

    private void DepositeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepositeMouseClicked
        // TODO add your handling code here:
        Deposite deposite = new Deposite();
        Desktop.removeAll();
        Desktop.add(deposite).setVisible(true);
    }//GEN-LAST:event_DepositeMouseClicked

    private void WithdrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WithdrawMouseClicked
        // TODO add your handling code here:
        Withdraw withdraw = new Withdraw();
        Desktop.removeAll();
        Desktop.add(withdraw).setVisible(true);
    }//GEN-LAST:event_WithdrawMouseClicked

    private void TransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferMouseClicked
        // TODO add your handling code here:
        Transfer transfer = new Transfer();
        Desktop.removeAll();
        Desktop.add(transfer).setVisible(true);
    }//GEN-LAST:event_TransferMouseClicked

    private void TransactionHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionHistoryMouseClicked
        // TODO add your handling code here:
        TransactionHistory transactionHistory = new TransactionHistory();
        Desktop.removeAll();
        Desktop.add(transactionHistory).setVisible(true);
    }//GEN-LAST:event_TransactionHistoryMouseClicked

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        // TODO add your handling code here:
          setVisible(false);
        LogIn up = new LogIn();
        up.setVisible(true);
    }//GEN-LAST:event_LogOutMouseClicked

    private void ChagePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChagePassMouseClicked
        // TODO add your handling code here:
        ChangePass change = new ChangePass();
         Desktop.removeAll();
        Desktop.add(change).setVisible(true);
        
    }//GEN-LAST:event_ChagePassMouseClicked

    private void ChagePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChagePassMousePressed
        // TODO add your handling code here:
          Profile.setBackground(DefaultColor);
        Deposite.setBackground(DefaultColor);
        Withdraw.setBackground(DefaultColor);
        Transfer.setBackground(DefaultColor);
        TransactionHistory.setBackground(DefaultColor);
         ChagePass.setBackground(ClickedColor);
        LogOut.setBackground(DefaultColor);
    }//GEN-LAST:event_ChagePassMousePressed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChagePass;
    private javax.swing.JTextField Date;
    private javax.swing.JPanel Deposite;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JPanel LogOut;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel TransactionHistory;
    private javax.swing.JPanel Transfer;
    private javax.swing.JTextField TypeAcc;
    private javax.swing.JTextField User;
    private javax.swing.JPanel Withdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
