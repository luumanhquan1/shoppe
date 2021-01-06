/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import shoppe.model.themsanphammodel;
import shoppe.view.indexview;
import shoppe.view.themsanpham;

/**
 *
 * @author ASUS TUF
 */
public class themsanphamcontroler {
    private themsanpham view;
String duongdan;
private String taikhoan;
private int kiemtra=0;
    ArrayList<Object> listsanpham=new ArrayList<>();
    
    public themsanphamcontroler(themsanpham view) {
        this.view = view;
        view.getJlbanhbia().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser t=new JFileChooser();
                FileNameExtensionFilter img=new FileNameExtensionFilter("hinh anh","jpg","png","jfif");
                t.setFileFilter(img);
                t.setMultiSelectionEnabled(false);
                t.showOpenDialog(null);
      File f=t.getSelectedFile();
               duongdan=""+f;
        try {
            BufferedImage image=ImageIO.read(f);
            ImageIcon icon=new ImageIcon(image.getScaledInstance(view.getJlbanhbia().getSize().width, view.getJlbanhbia().getSize().height, image.SCALE_SMOOTH));
     view.getJlbanhbia().setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(themsanpham.class.getName()).log(Level.SEVERE, null, ex);
        }
            }

        });
        view.getBtnthemsanpham().addActionListener(a1->{
            try {
                themsp();
            } catch (IOException ex) {
                
            }
        });
    }
    private void themsp() throws IOException {
        String mess="";
themsanphammodel model=view.getModel();
File file=new File(duongdan);
BufferedImage img=ImageIO.read(file);
        String luuanh="imgsanpham/"+taikhoan+"."+model.getTensp()+".png";
ImageIO.write(img, "png",new File(luuanh));
  String tmp=taikhoan+"$"+model.getTensp()+"$"+model.getGiasp()+"$"+luuanh;
  kiemtra();
  if(kiemtra==1){
      mess+="Sản Phẩm Này Của Bạn Đã Có";
     JOptionPane.showMessageDialog(view, mess);
     mess="";
  }else{
      listsanpham.add(tmp);
      docfile();
        try (PrintWriter pw=new PrintWriter("sanpham.dat")) {
        for(Object tmq:listsanpham)
        {
        pw.println(tmq.toString());
        }
        } catch (Exception e) {
        }
        mess+="Thêm Sản Phẩm Thành Công";
       JOptionPane.showMessageDialog(view, mess);
       mess="";
       indexview t=new indexview();
       indexconterler control=new indexconterler(t);
  }
    }
    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }
    public void docfile(){
        try {
            File file=new File("sanpham.dat");
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                listsanpham.add(line);
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }
    public void kiemtra(){
        themsanphammodel model=view.getModel();
          try {
            File file=new File("sanpham.dat");
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                String[] t=line.split("\\$");
                if(taikhoan.equalsIgnoreCase(t[0])){
                    if(model.getTensp().equalsIgnoreCase(t[1])){
                        kiemtra=1;
                        break;
                    }
                }
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }
}
