package zappfood;


import java.awt.*;
//import java.awt.event.WindowEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class LoginForm extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;
    
    public LoginForm() {
        initComponents();
        conn=JavaConnect.connector1();
    }
public void close(){
    WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}

    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jb1 = new javax.swing.JButton();
        jt1 = new javax.swing.JTextField();
        jt2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(122, 141, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(151, 19, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("      Username");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("      Password");

        jb1.setBackground(new java.awt.Color(240, 243, 73));
        jb1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jb1.setText("Kitchen Login");
        jb1.setToolTipText("Click to submit");
        jb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb1MouseClicked(evt);
            }
        });
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        jb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb1KeyPressed(evt);
            }
        });

        jt1.setToolTipText("Enter User Name");

        jt2.setToolTipText("Enter Password");
        jt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt2KeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(240, 243, 73));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Cashier Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 243, 73));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Backup Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb1, jt1, jt2});

        jLabel3.setBackground(new java.awt.Color(95, 90, 202));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(142, 0, 0));
        jLabel3.setText("                          Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        String sql="select * from kitchen_login where User_Name=? and Password=? ";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1,jt1.getText());
            pst.setString(2,jt2.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and Password is correct");
                 rs.close();
                 pst.close();
             Kitchen e=new Kitchen();
               e.setVisible(true);
                close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Username and Password is not correct");
            }
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jb1ActionPerformed

    private void jb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb1MouseClicked
//       String sql="select *from Billing where username=? and password=?";
    }//GEN-LAST:event_jb1MouseClicked

    private void jb1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb1KeyPressed
      
        
    }//GEN-LAST:event_jb1KeyPressed

    private void jt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt2KeyPressed
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//             String sql="select * from kitchen_login where User_Name=? and Password=?";
//        try{
//            pst =conn.prepareStatement(sql);
//            pst.setString(1,jt1.getText());
//            pst.setString(2,jt2.getText());
//            rs=pst.executeQuery();
//            if(rs.next()){
//                JOptionPane.showMessageDialog(null, "Username and Password is correct");
//                 rs.close();
//                 pst.close();
//// AttendanceSystem e=new AttendanceSystem();
////                e.setVisible(true);
//                close();
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "Username and Password is not correct");
//            }
//        }
//        catch(SQLException | HeadlessException e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//            
//        }
    }//GEN-LAST:event_jt2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql="select * from account_login where User_Name=? and Password=?";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1,jt1.getText());
            pst.setString(2,jt2.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and Password is correct");
                 rs.close();
                 pst.close();
              Cashier e=new Cashier();
                e.setVisible(true);
                close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Username and Password is not correct");
            }
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          String sql="select * from backup where User_Name=? and Password=?";
        try{
            pst =conn.prepareStatement(sql);
            pst.setString(1,jt1.getText());
            pst.setString(2,jt2.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username and Password is correct");
                 rs.close();
                 pst.close();
              Backup_table e=new Backup_table();
                e.setVisible(true);
                close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Username and Password is not correct");
            }
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb1;
    private javax.swing.JTextField jt1;
    private javax.swing.JPasswordField jt2;
    // End of variables declaration//GEN-END:variables
}
