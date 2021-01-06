/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import shoppe.model.giohangmodel;
import shoppe.view.giohangview;

/**
 *
 * @author ASUS TUF
 */
public class giohangconterler {
    private giohangview view;
 giohangmodel giohang;
 private String taikhoan;
    ArrayList<Object> listgiohang=new ArrayList<>();
    int i=1;
    public giohangconterler(giohangview view) throws IOException {
        this.view = view;
       giohang=new giohangmodel();
       giohang.docfile();
       for(Object tmq:giohang.getListgiohang()){
           listgiohang.add(tmq.toString());
       }
   view.getBtncong4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i++;
               view.getTxtsoluong4().setText(String.valueOf(i));
        
            }
});
   view.getBtntru4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i--;
                 view.getTxtsoluong4().setText(String.valueOf(i));
            }
});
    }
   public void giohangsp() throws IOException{
       int i=0;
      for(Object tmq:listgiohang){
        
         String[] t=tmq.toString().split("\\$");
          System.out.println(""+t[0]);
         if(taikhoan.equals(t[0])){
           i++;
          if(i==1){
          System.out.println(""+t[4]);
            File file=new File(t[4]);
             BufferedImage image=ImageIO.read(file);
             ImageIcon icon=new ImageIcon(image.getScaledInstance(140, 143, image.SCALE_SMOOTH));
            view.getAnhgiohang4().setIcon(icon);
            view.getTxttengiohang4().setText(t[2]);
            view.getTxtgia4().setText(t[3]);
          }
         }
      }
   }
    public void setTaikhoan(String taikhoan) throws IOException {
        this.taikhoan = taikhoan;
   giohangsp();
    }
}
