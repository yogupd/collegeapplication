/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
/**
 * 18285
 * @author raju
 */
public class Loginform extends javax.swing.JFrame {

    /**
     * Creates new form Loginform
     */
    Student s;
    Lecturers l;
    Admin a;
    Statement stmt;
    DatabaseConnect db = new DatabaseConnect();
    Connection conn = db.connect();
    public Loginform() {
        initComponents();
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
        loginform = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jusername = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        submit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginform.setFont(new java.awt.Font("Times", 1, 48)); // NOI18N
        loginform.setText("Welcome To VGC ");
        jPanel1.add(loginform, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times", 1, 24)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times", 1, 24)); // NOI18N
        jLabel3.setText("Password");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jusername.setPreferredSize(new java.awt.Dimension(175, 36));
        jPanel1.add(jusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        jpassword.setPreferredSize(new java.awt.Dimension(175, 36));
        jPanel1.add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        submit.setFont(new java.awt.Font("Times", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 12, true));
        submit.setPreferredSize(new java.awt.Dimension(79, 51));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 90, -1));

        reset.setFont(new java.awt.Font("Times", 1, 18)); // NOI18N
        reset.setText("reset");
        reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 12));
        reset.setPreferredSize(new java.awt.Dimension(79, 51));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 90, -1));

        exit.setFont(new java.awt.Font("Times", 1, 18)); // NOI18N
        exit.setText("exit");
        exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 12));
        exit.setPreferredSize(new java.awt.Dimension(79, 51));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
            // TODO add your handling code here:
            System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        jusername.setText(null);
        jpassword.setText(null);
        
        
        
    }//GEN-LAST:event_resetActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        String username = jusername.getText();
        String password = jpassword.getText();
        try {
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT id, privilegeId, name FROM user WHERE id =" + username +  " AND password='" + password + "'" ;
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()){
            //Retrieve by column name
                String name = rs.getString("name");
                int privid = rs.getInt("privilegeID");
                JOptionPane.showMessageDialog(null, "Hello " + name + "... Login Successfull");
                this.dispose();
                
                //Display valuesa
                //System.out.println("Hello "+ name);
                //System.out.println("Your ID = " + username);
                if (privid == 1) {
                    //System.out.println("Status: Super Administrator");
                    a = new Admin();
                    a.setUserId(rs.getInt("id"),name);
                    a.setVisible(true);
                    
                }
                else if(privid ==2) {
                    //System.out.println("Status: Faculty Member");
                    l = new Lecturers();
                    l.setUserId(rs.getInt("id"),name);
                    l.setVisible(true);
                }
                else if (privid == 3) {
                    //System.out.println("Status: Student");
                    s = new Student();
                    s.setUserId(rs.getInt("id"),name);
                    s.setVisible(true);
                } 

            }
            else {
                JOptionPane.showMessageDialog(null, "invalid username or password");
                //System.out.println("User credential invalid. Please try again.");
                //viewLoginMenu(c);
            }
        }
        catch(SQLException se){
      //Handle errors for JDBC
        se.printStackTrace();
        JOptionPane.showMessageDialog(null, "Invald username format. Please ensure your id is numeric only.");
        
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        
        /*if (username.equals("raju") && password.equals("1234"))
        {
            JOptionPane.showMessageDialog(null, "Login Successfull");
            jusername.setText(null);
            jpassword.setText(null);
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "invalid username or password");
            jusername.setText(null);
            jpassword.setText(null);
            
        } */
        
    }//GEN-LAST:event_submitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>a
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTextField jusername;
    private javax.swing.JLabel loginform;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
