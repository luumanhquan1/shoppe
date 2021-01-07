/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
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
    public giohangconterler(giohangview view,String taikhoan) throws IOException {
        this.view = view;
        this.taikhoan=taikhoan;
       giohang=new giohangmodel();
       giohang.docfile();
       for(Object tmq:giohang.getListgiohang()){
           listgiohang.add(tmq.toString());
       }
        giohangsp();
   view.getBtncong4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i++;
               view.getTxtsoluong4().setText(String.valueOf(i));
                 String sotien=view.getTxtgia4().getText().replace(".","");
                 int tien=Integer.valueOf(sotien);
                 int tinhtien=i*tien;
                 view.getTxttratien4().setText(String.valueOf(tinhtien));
                
            }
});
   view.getBtntru4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i--;
                int kiemtra=0;
                 view.getTxtsoluong4().setText(String.valueOf(i));
                  String sotien=view.getTxtgia4().getText().replace(".","");
                 int tien=Integer.valueOf(sotien);
                 int tinhtien=i*tien;
                 view.getTxttratien4().setText(String.valueOf(tinhtien));
                 if(i==0){
                    for(int i=0;i<listgiohang.size();i++){
                      String[] t=listgiohang.get(i).toString().split("\\$");
                      if(taikhoan.equals(t[0])){
                       listgiohang.remove(i);
                       break;
                      }
                    }
                    luufile();
             for(int i=0;i<listgiohang.size();i++){
                 String[] t=listgiohang.get(i).toString().split("\\$");
                      if(taikhoan.equals(t[0])){
                       kiemtra=1;
                       break;
                      }
             }
             
             if(kiemtra==0){
                view.getListgiohang().setVisible(false);  
             }
             else{
                 view.getThongbao().setVisible(false);
             }
                    try {
                        giohangsp();
                    } catch (IOException ex) {
                        Logger.getLogger(giohangconterler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            }
});
   view.getCb4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(view.getCb4().isSelected()){
                    System.out.println("1");
                }
            }

   });
    }
   public void giohangsp() throws IOException{
       int i=0;
      for(Object tmq:listgiohang){
         String[] t=tmq.toString().split("\\$");
         if(taikhoan.equals(t[0])){
           i++;
          if(i==1){
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
 public void luufile(){
     try (PrintWriter pw=new PrintWriter("giohang.dat")){
         for(Object tmp:listgiohang){
             pw.println(tmp.toString());
         }
     } catch (Exception e) {
     }
 }

    
}
