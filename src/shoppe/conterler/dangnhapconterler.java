/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import shoppe.model.dangnhapModel;
import shoppe.view.fromdangkiview;
import shoppe.view.fromdangnhapview;
import shoppe.view.indexview;
import shoppe.view.fromdoimatkhauview;
/**
 *
 * @author ASUS TUF
 */
public class dangnhapconterler {
    private fromdangnhapview view;
    private String taikhoan;
    private String matkhau;
    public dangnhapconterler(fromdangnhapview view) {
        this.view = view;
        view.getBtntrangchudangnhap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                indexview index=new indexview();
                indexconterler control=new indexconterler(index);
                index.setVisible(true);
                view.setVisible(false);
            }

        });
        view.getBtdangki().addActionListener(a2->chuyenfrom());
        view.getBtndangnhap().addActionListener(a1->login());
        view.getBtndoimatkhau().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
  fromdoimatkhauview t=new fromdoimatkhauview();
  doimatkhauconterler control=new doimatkhauconterler(t);
  t.setVisible(true);
  view.setVisible(false);
            }          
});
        
    }

    dangnhapconterler(indexview view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public void login() { 
        dangnhapModel model=view.getModel();
        if(model.getTaikhoan().isEmpty()||model.getMatkhau().isEmpty()){
        JOptionPane.showMessageDialog(view,"Tài Khoản Hoặc Mật Khẩu Không được Để Trống");
        }else{
        int n = 0;
        String[] t = null;
        try {
            File file = new File("account.dat");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                t = line.split("\\$");
                if (model.getTaikhoan().equals(t[0]) && model.getMatkhau().equals(t[1])) {
                    n = 1;
                    break;
                } else {
                    n = 0;
                }
            }
            if (n == 1) { 
                taikhoan=model.getTaikhoan();
                matkhau=model.getMatkhau();
                indexview trangchu = new indexview();
                indexconterler control=new indexconterler(trangchu);
                control.setTaikhoan(taikhoan);
                control.setMatkhau(matkhau);
                trangchu.setTen(t[2]);
                control.setTen(t[2]);
                trangchu.setVisible(true);
                view.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(view,"Tài Khoản Hoặc Mật Khẩu Không Tồn Tại");
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }
  }
    private void chuyenfrom() {
        fromdangkiview t=new fromdangkiview();
        dangkiconterler control=new dangkiconterler(t);
        t.setVisible(true);
        view.setVisible(false);
    }
   
    
    }
    

