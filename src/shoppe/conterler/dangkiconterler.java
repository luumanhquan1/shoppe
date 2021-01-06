
package shoppe.conterler;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import shoppe.model.dangkimodel;
import shoppe.view.fromdangkiview;
import shoppe.view.fromdangnhapview;

/**
 *
 * @author ASUS TUF
 */
public class dangkiconterler {
    private fromdangkiview view;
    int OTP;

    public dangkiconterler() {
    }

    
    public int getOTP() {
        return OTP;
    }

    public void setOTP(int OTP) {
        this.OTP = OTP;
    }
    
  String mess="";
    public dangkiconterler(fromdangkiview view) {  
        this.view = view;
        view.getBtndangnhap().addActionListener(l->chuyenfrom());
        view.getBtndangki().addActionListener(a1->DangKi());
       view.getTxtdangkitk().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) { 
                super.focusLost(e);
               kiemtrataikhoan();
            }          
});
       view.getTxtdkimatkhau().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                kiemtramatkhau();//To change body of generated methods, choose Tools | Templates.
            }
       });
       view.getBtnguima().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                guima();
            }
           
           
});
    }
     public void guima() {
                dangkimodel model=view.getModel();
             if (view.getLbloitaikhoan().getText().equals(" ")) {
            Random random = new Random();
            OTP = random.nextInt(9999 - 1000) + 1000;
            final String user = "luumanhquan442001@gmail.com";
            final String pass = "quanit442001";
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
                String kiemtra = "@gmail.com";
                String gamil = model.getTaikhoan();
                System.out.println("1"+model.getTaikhoan());
                if (gamil.contains(kiemtra) == false) {
                    JOptionPane.showMessageDialog(view, "Gmail không đúng định dạng");
                } else {
                    JOptionPane.showMessageDialog(view, "Đợi Một Chút!!\nchúng Tôi sẽ gửi cho bạn một mã xác minh^-^");
                }
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(user));
                message.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(model.getTaikhoan())
                );
                message.setSubject("Shoppe");
                message.setText("Mã OTP cua ban la " + OTP);
                Transport.send(message);

            } catch (MessagingException e) {
                String kiemtra = "@gmail.com";
                String gamil = model.getTaikhoan();
                if (gamil.contains(kiemtra)) {
                    JOptionPane.showMessageDialog(view, "vui lòng xem lại đường truyền mạng");
                } else {

                }
            }
        }
            }
boolean kiemtraloi() {
    dangkimodel model=view.getModel();
        if (view.getLbloitaikhoan().getText().equals(" ") == false||model.getTaikhoan().isEmpty()) {
            mess += "lỗi định dạng";
            return false;
        }
        if (view.getLbloimatkhau().getText().equals(" ") == false||model.getMatkhau().isEmpty()) {
            mess += "lỗi định dạng";
            return false;
        }
        if(model.getHovaten().isEmpty()){
            mess+="lỗi định dạng";
            return false;
        }
        return true;
    }
    private void DangKi() {
    
        dangkimodel model=view.getModel();
     boolean hople = true;
       
        hople = kiemtraloi();
        dangki dki = new dangki(model.getTaikhoan(), model.getMatkhau(), model.getHovaten());
        if (hople) {
            if (dki.Kiemtra() == 1) {
                mess += "Tên Đăng Nhập Đã Tồn Tại";
                JOptionPane.showMessageDialog(view, mess);
                mess = "";
            } else {
                String otp = model.getOTP();
                if (otp.equals(String.valueOf(OTP))) {
                    dki.luufile();
                    mess += "Đăng Kí Thành Công";
                    JOptionPane.showMessageDialog(view, mess);
                    mess = "";
                } else {
                    mess += "Mã OTP không đúng!!!";
                    JOptionPane.showMessageDialog(view, mess);
                    mess = "";
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, mess);
            mess = "";
        }
        String otp=model.getOTP();
        if(otp.equals(String.valueOf(OTP)))
        {
        Random random = new Random();
        OTP = random.nextInt(9999 - 1000) + 1000;
        }
         
    }
    private void kiemtrataikhoan(){
        dangkimodel model=view.getModel();
        int i;
        if (model.getTaikhoan().isEmpty()) {
          view.getLbloitaikhoan().setText("tài khoản không được để trống");
        } else if (model.getTaikhoan().isEmpty() == false) {

            for (i = 0; i < model.getTaikhoan().length(); i++) {
            }
            if (i <= 5) {
                view.getLbloitaikhoan().setText("không kí tự,ít nhất 6 từ");
            } else {
                view.getLbloitaikhoan().setText(" ");
            }
        }
    }
     private void kiemtramatkhau(){
        dangkimodel model=view.getModel();
        boolean kiemtrakitu;
        int i;
        if (model.getMatkhau().isEmpty()) {
            view.getLbloimatkhau().setText("mật khẩu không được để trống");
        } else if (model.getMatkhau().isEmpty() == false) {
            String kiemtra = "\\w+";
            String matkhau = model.getMatkhau();
            kiemtrakitu = matkhau.matches(kiemtra);
            if (kiemtrakitu == false) {
              view.getLbloimatkhau().setText("không kí tự,ít nhất 6 từ");

            } else {
                for (i = 0; i < model.getMatkhau().length(); i++) {
                }
                if (i <= 5) {
                    view.getLbloimatkhau().setText("không kí tự,ít nhất 6 từ");
                } else if (kiemtrakitu == true) {
                    view.getLbloimatkhau().setText(" ");
                }

            }
        }
    }
    private void chuyenfrom() {
     fromdangnhapview t=new fromdangnhapview();
     dangnhapconterler control=new dangnhapconterler(t);
     t.setVisible(true);
     view.setVisible(false);
    }
}
