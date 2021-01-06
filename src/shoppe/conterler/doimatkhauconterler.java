/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import shoppe.model.dangkimodel;
import shoppe.view.fromdangnhapview;
import shoppe.view.fromdoimatkhauview;

/**
 *
 * @author ASUS TUF
 */
public class doimatkhauconterler {
    private fromdoimatkhauview view;
    private String luugmail;
   private String passmoi;
    int OTP;
int luu=0;
   ArrayList<Object> account=new ArrayList<>();  
    public doimatkhauconterler(fromdoimatkhauview view) {
        this.view = view;
        view.getBtntieptheo().addActionListener(l -> {
            try {    
                tieptheo();
            } catch (IOException ex) {
                Logger.getLogger(doimatkhauconterler.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        view.getBtnquaylai().addActionListener(a2 -> quaylai());
    }
    private void tieptheo() throws FileNotFoundException, IOException {
       String mess="";
        dangkimodel model = view.getModel();
        if (view.getjLabel1().getText().equals("OTP:")) {
            view.getBtnquaylai().setVisible(false);
            if (view.getTxtdoimatkhau().getText().equals(String.valueOf(OTP))) {
                view.getjLabel1().setText("Mật Khẩu Mới:");
                view.getTxtdoimatkhau().setText("");
                 view.getBtntieptheo().setText("Lưu Thay Đổi");
            }
        }
           else if (view.getjLabel1().getText().equals("Mật Khẩu Mới:")) {        
                    passmoi=view.getTxtdoimatkhau().getText();
                    String kiemtrakitu="\\w+";
                    boolean kiemtra=passmoi.matches(kiemtrakitu);
                    if(kiemtra==true){
                        int i;
                        for(i=0;i<passmoi.length();i++){}
                        if(i<=6){
                        mess+="Mật Khẩu Quá Ngắn ";
                        JOptionPane.showMessageDialog(view, mess);
                        mess="";
                        }
                        else{
                            luu++;
                            mess+="Thay Đổi Mật Khẩu Thành Công";
                            if(luu==1){
                              doimk(passmoi);
                    try(PrintWriter pw=new PrintWriter("account.dat")) {
                for(Object tmp:account){
                    pw.println(tmp);
                }
                
                JOptionPane.showMessageDialog(view, mess);
                mess="";
                    fromdangnhapview t=new fromdangnhapview();
                    dangnhapconterler control=new dangnhapconterler(t);
                    t.setVisible(true);
                    view.setVisible(false);
            } catch (Exception e) {
            }
                            }       
              
                        }
                }
                    else{
                    mess+="Mật Khẩu không có kí tự đặc biệt";
                    JOptionPane.showMessageDialog(view, mess);
                    mess="";
                    }
           } 
         else if(view.getjLabel1().getText().equals("Gmail:")){
            guima();
        }
        
    }
    
    
    public void guima() {
        dangkimodel model = view.getModel();
        String mess = "";
        if (model.getTaikhoan().isEmpty()) {
            mess += "Vui Lòng Nhập Gamil để tiếp tục";
            JOptionPane.showMessageDialog(view, mess);
            mess = "";
        } else {
            dangki ktra = new dangki(model.getTaikhoan(), model.getMatkhau(), model.getHovaten());
            if (ktra.Kiemtra() == 1) {
                luugmail = model.getTaikhoan();
              
                Random random = new Random();
                OTP = random.nextInt(9999 - 1000) + 1000;
                final String user = "luumanhquan442001@gmail.com";
                final String pass = "quanit442001";
                String kiemtra = "@gmail.com";
                String gamil = model.getTaikhoan();
                if (gamil.contains(kiemtra) == false) {
                    JOptionPane.showMessageDialog(view, "Gmail không đúng định dạng");
                } else {
                    JOptionPane.showMessageDialog(view, "Đợi Một Chút!!\nchúng Tôi sẽ gửi cho bạn một mã xác minh^-^");
                    Properties prop = new Properties();
                    prop.put("mail.smtp.host", "smtp.gmail.com");
                    prop.put("mail.smtp.port", "587");
                    prop.put("mail.smtp.auth", "true");
                    prop.put("mail.smtp.starttls.enable", "true");
                    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, pass);
                        }
                    });
                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(user));
                        message.setRecipient(Message.RecipientType.TO,
                                new InternetAddress(model.getTaikhoan())
                        );
                        message.setSubject("Shoppe");
                        message.setText("Mã OTP cua ban la " + OTP);
                        Transport.send(message);
                        
                    } catch (MessagingException e) {
                        if (gamil.contains(kiemtra)) {
                            JOptionPane.showMessageDialog(view, "vui lòng xem lại đường truyền mạng");
                        }
                    }
                    view.getjLabel1().setText("OTP:");
                    view.getTxtdoimatkhau().setText("");
                    System.out.println("" + OTP);
                    
                }
                
            } else {
                mess += "Tài Khoản Không Tồn Tại";
                JOptionPane.showMessageDialog(view, mess);
                mess = "";
            }
        }
    }
    
    private void quaylai() {
        fromdangnhapview t = new fromdangnhapview();
        dangnhapconterler control = new dangnhapconterler(t);
        t.setVisible(true);
        view.setVisible(false);
    }
    public void doimk(String passmoi){
        try {
            File file=new File("account.dat");
            FileInputStream fis =new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String Line="";
            while((Line=br.readLine())!=null){
                String[] t=Line.split("\\$");
                if(luugmail.equals(t[0])){
                    t[1]=passmoi;
                }
                dangki tmp=new dangki(t[0], t[1], t[2]);
                account.add(tmp.toString());
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }
    
}
