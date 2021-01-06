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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import shoppe.model.giohangmodel;
import shoppe.view.formxemhang;
import shoppe.view.fromdangnhapview;
import shoppe.view.indexview;

/**
 *
 * @author ASUS TUF
 */
public class xemhangconterler {

    private formxemhang view;
    private String thongtinsp;
    int x, y;
    private String taikhoan;
    private String matkhau;
    private String Ten;
    private int sohang = 0;

    public xemhangconterler(formxemhang view) {
        this.view = view;
        x = view.getImgsanpham().size().width;
        y = view.getImgsanpham().size().height;
        view.getBtnthemgiohang().addActionListener(a1 -> {
            try {
                themgiohang();
            } catch (IOException ex) {
                Logger.getLogger(xemhangconterler.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        view.getBtndangxuat().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                view.setVisible(false);
                indexview t = new indexview();
                indexconterler control = new indexconterler(t);
                t.setVisible(true);//To change body of generated methods, choose Tools | Templates.
            }
        });
        view.getBtntimkiem().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }

        });
        view.getBtntrangchu().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (view.getDangnhap().isVisible()) {
                    view.setVisible(false);
                    indexview t = new indexview();
                    indexconterler control = new indexconterler(t);
                    t.setVisible(true);
                } else {
                    indexconterler control = new indexconterler(taikhoan, matkhau);
                    control.reloat();
                    view.setVisible(false);
                }
            }
        });
    }

    public String getThongtinsp() {
        return thongtinsp;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
        if (this.Ten != null) {
            view.getDangnhap().setVisible(false);
            view.getDangki().setVisible(false);
            view.getTxtten().setText(Ten);
            view.getTxtten().setVisible(true);
            view.getBtndangxuat().setVisible(true);
        }
    }

    public void setThongtinsp(String thongtinsp) throws IOException {
        this.thongtinsp = thongtinsp;
        String[] t = this.thongtinsp.split("\\$");
        File file = new File(t[3]);
        BufferedImage image = ImageIO.read(file);
        ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
        view.getLbimgsp().setIcon(icon);
        view.getTxttensp().setText(t[1]);
        view.getTxtgia().setText(t[2]);
        try {
            File file1 = new File("account.dat");
            FileInputStream fis = new FileInputStream(file1);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String Line = "";
            while ((Line = br.readLine()) != null) {
                String[] t1 = Line.split("\\$");
                if (t[0].equals(t1[0])) {
                    view.getTxttennguoiban().setText(t1[2]);
                    break;
                }
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }

    public void themgiohang() throws IOException {
        String mess = "";
        if (taikhoan != null) {
            String giohang = taikhoan + "$" + thongtinsp;
            System.out.println("" + giohang);
            giohangmodel gh = new giohangmodel();
            gh.docfile();
            gh.them(giohang);
            System.out.println("" + gh.getListgiohang());
                for (Object tmq : gh.getListgiohang()) {
                    String[] t = tmq.toString().split("\\$");
                    if (taikhoan.equals(t[0])) {
                        sohang += 1;
                    }
                }
                if(sohang<4){
                  try (PrintWriter pw = new PrintWriter("giohang.dat")) {
                    for (Object tmq : gh.getListgiohang()) {
                        pw.println(tmq.toString());
                    }
                    System.out.println("" + sohang);
                    mess += "Thêm Vào Giỏ Hàng Thành Công";
                    JOptionPane.showMessageDialog(view, mess);
                    mess = "";
            } catch (Exception e) {
            }
                }
                else{
                     mess += "Giỏ Hàng Của Bạn Đã Đầy";
                    JOptionPane.showMessageDialog(view, mess);
                    mess = "";
                }
        } else {
            fromdangnhapview dangnhap = new fromdangnhapview();
            dangnhapconterler control = new dangnhapconterler(dangnhap);
            dangnhap.setVisible(true);
            view.setVisible(false);
        }
    }
}
