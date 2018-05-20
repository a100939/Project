/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;


public class CreateFolder extends javax.swing.JFrame {
    public static int user_id;
    public static    int folder_count;
    public static int id;
    public static  ArrayList<String> folder_name=new ArrayList<String>();
 
    /**
     * Creates new form RegisterForm
     */
    Connection conn=null;
   
    PreparedStatement pst=null;
    ResultSet rs=null;
    public CreateFolder() {
        initComponents();
        LoginForm use = new LoginForm();
        use.conn= MySqlConnect.ConnectDB();
        String Sql="SELECT * FROM users";
        try {
            use.pst=use.conn.prepareStatement(Sql);
            use.rs=use.pst.executeQuery();
            if(use.rs.next())
            {
               id=use.rs.getInt("id");
             
            }
            
           
            use.conn= MySqlConnect.ConnectDB();
            
            String Sql2="SELECT * FROM folders";
           
            use.pst=use.conn.prepareStatement(Sql2);
             
            use.rs=use.pst.executeQuery();
          
           while(use.rs.next())
           {
               
               folder_name.add(use.rs.getString("name"));
               user_id = use.id;
               
           }
        } catch (SQLException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        register_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        loging_link = new javax.swing.JLabel();
        folder_name_lbl = new javax.swing.JLabel();
        folder_name_tf = new javax.swing.JTextField();
        folder_name_lbl1 = new javax.swing.JLabel();
        yes_rb = new javax.swing.JRadioButton();
        no_rb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Secure Files -Create Folder");

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(585, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel2)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabelClose))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        register_btn.setBackground(new java.awt.Color(153, 255, 153));
        register_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        register_btn.setForeground(new java.awt.Color(255, 255, 255));
        register_btn.setText("Create");
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        cancel_btn.setBackground(new java.awt.Color(242, 38, 19));
        cancel_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel_btn.setForeground(new java.awt.Color(255, 255, 255));
        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        loging_link.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loging_link.setForeground(new java.awt.Color(255, 255, 255));
        loging_link.setText("click here to login");
        loging_link.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loging_link.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loging_linkMouseClicked(evt);
            }
        });

        folder_name_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        folder_name_lbl.setForeground(new java.awt.Color(236, 240, 241));
        folder_name_lbl.setText("Folder Name:");

        folder_name_tf.setBackground(new java.awt.Color(108, 122, 137));
        folder_name_tf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        folder_name_tf.setForeground(new java.awt.Color(228, 241, 254));
        folder_name_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folder_name_tfActionPerformed(evt);
            }
        });

        folder_name_lbl1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        folder_name_lbl1.setForeground(new java.awt.Color(236, 240, 241));
        folder_name_lbl1.setText("Do you want the Folder as public?");

        yes_rb.setBackground(new java.awt.Color(255, 255, 255));
        yes_rb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yes_rb.setText("Yes ");
        yes_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yes_rbActionPerformed(evt);
            }
        });

        no_rb.setBackground(new java.awt.Color(255, 255, 255));
        no_rb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        no_rb.setText("No");
        no_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_rbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loging_link)
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yes_rb)
                    .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(folder_name_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(no_rb)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(folder_name_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(folder_name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loging_link)
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folder_name_lbl)
                    .addComponent(folder_name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folder_name_lbl1)
                    .addComponent(no_rb)
                    .addComponent(yes_rb))
                .addGap(126, 126, 126)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked

        System.exit(0);

    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked

        this.setState(JFrame.ICONIFIED);

    }//GEN-LAST:event_jLabelMinMouseClicked

    private void folder_name_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folder_name_tfActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_folder_name_tfActionPerformed

    private void loging_linkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loging_linkMouseClicked
        LoginForm lgf = new LoginForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_loging_linkMouseClicked
  
    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
        
        conn= MySqlConnect.ConnectDB();
        String Sql ="INSERT INTO folders(name,is_public,user_id) VALUES(?,?,?)";
    
         try
        {
            

                pst=conn.prepareStatement(Sql);
                
                if (folder_count >=10) {
                 JOptionPane.showMessageDialog(null,"Maximum Folders achieved!!");
                 JOptionPane.showMessageDialog(null,"Delete folders in order to add!!");
                }
                else{
                if (folder_name.contains(folder_name_tf.getText())) {
                JOptionPane.showMessageDialog(null,"folder already exits");
                }
                else{
                pst.setString(1,folder_name_tf.getText()); 
                
                }
                if (yes_rb.isSelected()) 
                {
                    pst.setBoolean(2, true);
                }
                else if(no_rb.isSelected())
                {
                    pst.setBoolean(2, false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Select one radio button");
                }
                pst.setInt(3,id);
         
                pst.executeUpdate();
                folder_count++;
               JOptionPane.showMessageDialog(null,"New folder added successfull");
                Welcome wlc = new Welcome();
                wlc.setVisible(true);
                wlc.pack();
                wlc.setLocationRelativeTo(null);
                wlc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
               if (rs.next()) {

                 
               }
                }
        }catch(Exception e)
        {
           
        }  
 
     

    }//GEN-LAST:event_register_btnActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
       Welcome wlc = new Welcome();
        wlc.setVisible(true);
        wlc.pack();
        wlc.setLocationRelativeTo(null);
        wlc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void yes_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yes_rbActionPerformed
        // TODO add your handling code here:
        no_rb.setSelected(false);
    }//GEN-LAST:event_yes_rbActionPerformed

    private void no_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_rbActionPerformed
        // TODO add your handling code here:
        yes_rb.setSelected(false);
    }//GEN-LAST:event_no_rbActionPerformed

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_btn;
    private javax.swing.JLabel folder_name_lbl;
    private javax.swing.JLabel folder_name_lbl1;
    private javax.swing.JTextField folder_name_tf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loging_link;
    private javax.swing.JRadioButton no_rb;
    private javax.swing.JButton register_btn;
    private javax.swing.JRadioButton yes_rb;
    // End of variables declaration//GEN-END:variables
}
