/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.view;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import shoppe.model.dangkimodel;

/**
 *
 * @author ASUS TUF
 */
public class fromdangkiview extends javax.swing.JFrame {

    /**
     * Creates new form fromdangki
     */
    
    public fromdangkiview() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        lbloitaikhoan.setText(" ");
        lbloimatkhau.setText(" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdangkitk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdkimatkhau = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txthovaten = new javax.swing.JTextField();
        btndangki = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btndangnhap = new javax.swing.JButton();
        lbloitaikhoan = new javax.swing.JLabel();
        lbloimatkhau = new javax.swing.JLabel();
        jlbotp = new javax.swing.JLabel();
        txtotp = new javax.swing.JTextField();
        btnguima = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Đăng Kí");

        jLabel2.setText("Gmail:");

        txtdangkitk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdangkitkFocusLost(evt);
            }
        });

        jLabel3.setText("Mật Khẩu:");

        txtdkimatkhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdkimatkhauFocusLost(evt);
            }
        });

        jLabel4.setText("Họ Và Tên");

        btndangki.setText("Đăng Kí");
        btndangki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangkiActionPerformed(evt);
            }
        });

        jLabel5.setText("Bạn Đã Có Tài Khoản");

        btndangnhap.setText("Đăng Nhập");
        btndangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangnhapActionPerformed(evt);
            }
        });

        lbloitaikhoan.setBackground(new java.awt.Color(255, 51, 51));
        lbloitaikhoan.setForeground(new java.awt.Color(255, 51, 51));

        lbloimatkhau.setForeground(new java.awt.Color(255, 51, 51));
        lbloimatkhau.setText("jLabel7");

        jlbotp.setText("OTP:");

        btnguima.setForeground(new java.awt.Color(255, 51, 51));
        btnguima.setText("Gửi Mã");
        btnguima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguimaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btndangki, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndangnhap))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jlbotp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbloitaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdangkitk)
                            .addComponent(txtdkimatkhau)
                            .addComponent(txthovaten)
                            .addComponent(lbloimatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtotp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnguima)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdangkitk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lbloitaikhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdkimatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lbloimatkhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txthovaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbotp)
                    .addComponent(txtotp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguima)
                .addGap(2, 2, 2)
                .addComponent(btndangki)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btndangnhap))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btndangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangnhapActionPerformed
       
    }//GEN-LAST:event_btndangnhapActionPerformed

    private void btndangkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangkiActionPerformed

        
    }//GEN-LAST:event_btndangkiActionPerformed

    private void txtdangkitkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdangkitkFocusLost

      
    }//GEN-LAST:event_txtdangkitkFocusLost

    private void txtdkimatkhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdkimatkhauFocusLost
       
    }//GEN-LAST:event_txtdkimatkhauFocusLost

    private void btnguimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguimaMouseClicked
      
    }//GEN-LAST:event_btnguimaMouseClicked

    /**
     * @param args the command line arguments
     */

   


    public JButton getBtndangnhap() {
        return btndangnhap;
    }

    public JButton getBtndangki() {
        return btndangki;
    }

    public JLabel getBtnguima() {
        return btnguima;
    }

    public JButton getjButton1() {
        return btndangnhap;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JLabel getJlbotp() {
        return jlbotp;
    }

    public JLabel getLbloimatkhau() {
        return lbloimatkhau;
    }

    public JLabel getLbloitaikhoan() {
        return lbloitaikhoan;
    }

    public JTextField getTxtdangkitk() {
        return txtdangkitk;
    }

    public JTextField getTxtdkimatkhau() {
        return txtdkimatkhau;
    }

    public JTextField getTxthovaten() {
        return txthovaten;
    }

    /**
     * @param args the command line arguments
     */
    public JTextField getTxtotp() {
        return txtotp;
    }
public dangkimodel getModel(){
     String taikhoan=txtdangkitk.getText();
      String matkhau=txtdkimatkhau.getText();
       String hovaten=txthovaten.getText();
       String OTP=txtotp.getText();
  return new dangkimodel(taikhoan, matkhau, hovaten, OTP);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndangki;
    private javax.swing.JButton btndangnhap;
    private javax.swing.JLabel btnguima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jlbotp;
    private javax.swing.JLabel lbloimatkhau;
    private javax.swing.JLabel lbloitaikhoan;
    private javax.swing.JTextField txtdangkitk;
    private javax.swing.JTextField txtdkimatkhau;
    private javax.swing.JTextField txthovaten;
    private javax.swing.JTextField txtotp;
    // End of variables declaration//GEN-END:variables
}
