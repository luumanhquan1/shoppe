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
import javax.swing.JOptionPane;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
import shoppe.model.giohangmodel;
import shoppe.view.giohangview;
import shoppe.view.indexview;

/**
 *
 * @author ASUS TUF
 */
public class giohangconterler {

    private giohangview view;
    giohangmodel giohang;
    private String taikhoan;
    private String matkhau;
    ArrayList<Object> listgiohang = new ArrayList<>();
    int i1 = 1, i2 = 1, i3 = 1;
    int kiemtra1 = 0;
    int tongtienhang = 0;
    int tien1 = 0;

    public giohangconterler(giohangview view, String taikhoan, String matkhau) throws IOException {
        this.view = view;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        giohang = new giohangmodel();
        giohang.docfile();
        for (Object tmq : giohang.getListgiohang()) {
            listgiohang.add(tmq.toString());
        }
        for (int i = 0; i < listgiohang.size(); i++) {
            String[] t = listgiohang.get(i).toString().split("\\$");
            if (taikhoan.equals(t[0])) {
                kiemtra1 = 1;
            }
        }
        if (kiemtra1 == 0) {
            view.getThongbao().setVisible(true);
            view.getListgiohang().setVisible(false);
            view.getFormthanhtoan().setVisible(false);
        } else {
            view.getThongbao().setVisible(false);
            view.getListgiohang().setVisible(true);
            view.getFormthanhtoan().setVisible(true);
        }
        giohangsp();

        view.getTrangchu().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                indexconterler control = new indexconterler(taikhoan, matkhau);
                control.reloat();
                view.setVisible(false);
            }
        });
        view.getBtnmuangay().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                indexconterler control = new indexconterler(taikhoan, matkhau);
                control.reloat();
                view.setVisible(false);
            }

        });
        view.getBtncong4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i1++;
                view.getTxtsoluong4().setText(String.valueOf(i1));
                String sotien = view.getTxtgia4().getText().replace(".", "");
                int tien = Integer.valueOf(sotien);
                int tinhtien = i1 * tien;
                view.getTxttratien4().setText(String.valueOf(tinhtien));

            }
        });

        view.getBtntru4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                i1--;
                int kiemtra = 0;
                view.getTxtsoluong4().setText(String.valueOf(i1));
                String sotien = view.getTxtgia4().getText().replace(".", "");
                int tien = Integer.valueOf(sotien);
                int tinhtien = i1 * tien;
                view.getTxttratien4().setText(String.valueOf(tinhtien));
                if (i1 == 0) {

                    view.getTxtsoluong4().setText(String.valueOf(i1 + 1));
                    view.getTxttratien4().setText(view.getTxtgia4().getText());
                    int cautraloi = JOptionPane.showConfirmDialog(view, "Bạn chắc chắn muốn!!!", "QUÂN TRÂN TRỌNG THÔNG BÁO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (cautraloi == JOptionPane.YES_OPTION) {
                        view.getFormhang4().setVisible(false);
                        for (int i = 0; i < listgiohang.size(); i++) {
                            String[] t = listgiohang.get(i).toString().split("\\$");
                            if (taikhoan.equals(t[0])) {
                                listgiohang.remove(i);
                                break;
                            }
                        }
                        luufile();
                        for (int i = 0; i < listgiohang.size(); i++) {
                            String[] t = listgiohang.get(i).toString().split("\\$");
                            if (taikhoan.equals(t[0])) {
                                kiemtra = 1;
                                break;
                            }
                        }

                        if (kiemtra == 0) {
                            view.getListgiohang().setVisible(false);
                            view.getThongbao().setVisible(true);
                        } else {
                            view.getListgiohang().setVisible(true);
                            view.getThongbao().setVisible(false);
                        }
                        view.getFormhang4().setVisible(false);

                    }

                }

            }
        });
        view.getBtncong1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                i2++;
                view.getTxtsoluong1().setText(String.valueOf(i2));
                String sotien = view.getTxtgia1().getText().replace(".", "");
                int tien = Integer.valueOf(sotien);
                int tinhtien = i2 * tien;
                view.getTxttratien1().setText(String.valueOf(tinhtien));
            }

        });

        view.getBtntru1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                i2--;
                int kiemtra = 0;
                view.getTxtsoluong1().setText(String.valueOf(i2));
                String gia = view.getTxtgia1().getText().replace(".", "");
                int gia1 = Integer.valueOf(gia);
                view.getTxttratien1().setText(String.valueOf(i2 * gia1));
                if (i2 == 0) {

                    view.getTxtsoluong1().setText(String.valueOf(i2 + 1));
                    view.getTxttratien1().setText(view.getTxtgia1().getText());
                    int cautraloi = JOptionPane.showConfirmDialog(view, "Bạn chắc chắn muốn!!!", "QUÂN TRÂN TRỌNG THÔNG BÁO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (cautraloi == JOptionPane.YES_OPTION) {
                        view.getFormhang1().setVisible(false);
                        for (int i = 0; i < listgiohang.size(); i++) {
                            String[] t = listgiohang.get(i).toString().split("\\$");
                            if (taikhoan.equals(t[0])) {
                                kiemtra++;
                                if (kiemtra == 2) {
                                    listgiohang.remove(i);
                                    break;
                                }
                            }
                        }
                        luufile();

                    }

                }
            }
        });
        view.getBtncong2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                i3++;
                view.getTxtsoluong2().setText(String.valueOf(i3));
                String sotien = view.getTxtgia2().getText().replace(".", "");
                int tien = Integer.valueOf(sotien);
                int tinhtien = i3 * tien;
                view.getTxttratien2().setText(String.valueOf(tinhtien));
            }

        });
        view.getBtntru2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                i3--;
                int kiemtra = 0;
                view.getTxtsoluong2().setText(String.valueOf(i3));
                String gia = view.getTxtgia2().getText().replace(".", "");
                int gia1 = Integer.valueOf(gia);
                view.getTxttratien2().setText(String.valueOf(i3 * gia1));
                if (i3 == 0) {

                    view.getTxtsoluong2().setText(String.valueOf(i3 + 1));
                    view.getTxttratien2().setText(view.getTxtgia2().getText());
                    int cautraloi = JOptionPane.showConfirmDialog(view, "Bạn chắc chắn muốn!!!", "QUÂN TRÂN TRỌNG THÔNG BÁO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (cautraloi == JOptionPane.YES_OPTION) {
                        view.getFormhang2().setVisible(false);
                        for (int i = 0; i < listgiohang.size(); i++) {
                            String[] t = listgiohang.get(i).toString().split("\\$");
                            if (taikhoan.equals(t[0])) {
                                kiemtra++;
                                if (kiemtra == 3) {
                                    listgiohang.remove(i);
                                    break;
                                }
                            }
                        }
                        luufile();

                    }

                }
            }

        });
        view.getCb4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tien1 = Integer.valueOf(view.getTxttratien4().getText().replace(".", ""));
                if (view.getCb4().isSelected()) { 
                    tongtienhang = tongtienhang + tien1;
                    view.getTxttongtienhang().setText(String.valueOf(tongtienhang));
                }
                if (view.getCb4().isSelected() == false) {

                    tongtienhang = tongtienhang - tien1;

                    view.getTxttongtienhang().setText(String.valueOf(tongtienhang));

                }
            }

        });
        view.getCb1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tien1 = Integer.valueOf(view.getTxttratien1().getText().replace(".", ""));
                if (view.getCb1().isSelected()) {
                    tongtienhang = tongtienhang + tien1;
                    view.getTxttongtienhang().setText(String.valueOf(tongtienhang));
                } else {
                    tongtienhang = tongtienhang - tien1;
                    view.getTxttongtienhang().setText(String.valueOf(tongtienhang));

                }
            }
        });
        view.getCb2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tien1 = Integer.valueOf(view.getTxttratien2().getText().replace(".", ""));
                if (view.getCb2().isSelected()) {

                    tongtienhang = tongtienhang + tien1;
                    view.getTxttongtienhang().setText(String.valueOf(tongtienhang));
                } else {
                    tongtienhang = tongtienhang - tien1;
                    view.getTxttongtienhang().setText(String.valueOf(tongtienhang));

                }
            }
        });
    }

    public void giohangsp() throws IOException {
        int i = 0;
        for (Object tmq : listgiohang) {
            String[] t = tmq.toString().split("\\$");
            if (taikhoan.equals(t[0])) {
                i++;
                File file = new File(t[4]);
                BufferedImage image = ImageIO.read(file);
                ImageIcon icon = new ImageIcon(image.getScaledInstance(140, 143, image.SCALE_SMOOTH));
                if (i == 1) {
                    view.getAnhgiohang4().setIcon(icon);
                    view.getTxttengiohang4().setText(t[2]);
                    view.getTxtgia4().setText(t[3]);
                    view.getTxttratien4().setText(t[3]);
                }
                if (i == 2) {
                    view.getAnhgiohang1().setIcon(icon);
                    view.getTxttengiohang1().setText(t[2]);
                    view.getTxtgia1().setText(t[3]);
                    view.getTxttratien1().setText(t[3]);
                }
                if (i == 3) {
                    view.getAnhgiohang2().setIcon(icon);
                    view.getTxttengiohang2().setText(t[2]);
                    view.getTxtgia2().setText(t[3]);
                    view.getTxttratien2().setText(t[3]);
                }
            }
        }
        if (i < 2) {
            view.getFormhang1().setVisible(false);
        } else if (i >= 2) {
            view.getFormhang1().setVisible(true);
        }
        if (i < 3) {
            view.getFormhang2().setVisible(false);
        } else if (i >= 3) {
            view.getFormhang2().setVisible(true);
        }
    }

    public void luufile() {
        try (PrintWriter pw = new PrintWriter("giohang.dat")) {
            for (Object tmp : listgiohang) {
                pw.println(tmp.toString());
            }
        } catch (Exception e) {
        }
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
