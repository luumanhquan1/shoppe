
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import shoppe.model.indexmodel;
import shoppe.view.formxemhang;
import shoppe.view.fromdangkiview;
import shoppe.view.fromdangnhapview;
import shoppe.view.giohangview;
import shoppe.view.indexview;
import shoppe.view.themsanpham;

/**
 *
 * @author ASUS TUF
 */
public class indexconterler {

    int i = 0;
    private indexview view;
    private String taikhoan;
    private String matkhau;
    private String Ten;
    int xemthem = 0;
    ArrayList<Object> timsp = new ArrayList<>();
    indexmodel listsp = new indexmodel();
    formxemhang formxemhang;
    xemhangconterler t1;

    public indexconterler() {
    }

    public indexconterler(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public indexconterler(indexview view) {
        this.view = view;
        listsp.docfile();
        try {
            setsp();
        } catch (IOException ex) {
            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
        }
         view.getBtngiohang().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               giohang();
            }
        });
        view.getBtnxemthem().addActionListener(a1 -> xemthem());
         view.getBtntrangchu().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                trangchu();
            }
        });
        view.getBtndangxuat().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                 dangxuat();
            }
        });
      view.getDangnhap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
              dangnhap();
            }
        });
      view.getDangki().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dangki();//To change body of generated methods, choose Tools | Templates.
            }  
        });
        view.getBtntimkiem().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
             timkiem();
            }
        });
       view.getBtnthemsanpham().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                 themsp();
            }
        });
       
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setsp() throws IOException {
        if (listsp.getListsp().size() > 12) {
            view.getBtnxemthem().setVisible(true);
        } else {
            view.getBtnxemthem().setVisible(false);
        }
        int x = view.getLbimgsanpham1().getSize().width;
        int y = view.getLbimgsanpham1().getSize().height;
        for (i = 0 + xemthem; i < listsp.getListsp().size(); i++) {
            String[] t = listsp.getListsp().get(i).toString().split("\\$");
            if (i == 0 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham1().setIcon(icon);
                    view.getLbgiasanpham1().setText(t[2]);
                    view.getLbtensanpham1().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp1().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(0 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp1().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp1().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp1().setBorder(null);
                    }

                });
            }
            if (i == 1 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham2().setIcon(icon);
                    view.getLbgiasanpham2().setText(t[2]);
                    view.getLbtensanpham2().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp2().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(1 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp2().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp2().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp2().setBorder(null);
                    }

                });
            }
            if (i == 2 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham3().setIcon(icon);
                    view.getLbgiasanpham3().setText(t[2]);
                    view.getLbtensanpham3().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp3().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(2 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp3().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp3().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp3().setBorder(null);
                    }

                });
            }
            if (i == 3 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham4().setIcon(icon);
                    view.getLbgiasanpham4().setText(t[2]);
                    view.getLbtensanpham4().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp4().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(3 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp4().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp4().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp4().setBorder(null);
                    }

                });

            }
            if (i == 4 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham5().setIcon(icon);
                    view.getLbgiasanpham5().setText(t[2]);
                    view.getLbtensanpham5().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp5().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(4 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }
                });
                view.getJpsp5().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp5().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp5().setBorder(null);
                    }

                });
            }
            if (i == 5 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham6().setIcon(icon);
                    view.getLbgiasanpham6().setText(t[2]);
                    view.getLbtensanpham6().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp6().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(5 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp6().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp6().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp6().setBorder(null);
                    }

                });
            }
            if (i == 6 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham7().setIcon(icon);
                    view.getLbgiasanpham7().setText(t[2]);
                    view.getLbtensanpham7().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp7().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(6 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp7().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp7().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp7().setBorder(null);
                    }

                });
            }
            if (i == 7 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham8().setIcon(icon);
                    view.getLbgiasanpham8().setText(t[2]);
                    view.getLbtensanpham8().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp8().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(7 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp8().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp8().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp8().setBorder(null);
                    }

                });
            }
            if (i == 8 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham9().setIcon(icon);
                    view.getLbgiasanpham9().setText(t[2]);
                    view.getLbtensanpham9().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp9().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(8 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp9().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp9().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp9().setBorder(null);
                    }

                });
            }
            if (i == 9 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham10().setIcon(icon);
                    view.getLbgiasanpham10().setText(t[2]);
                    view.getLbtensanpham10().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp10().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(9 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp10().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp10().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp10().setBorder(null);
                    }

                });
            }
            if (i == 10 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham11().setIcon(icon);
                    view.getLbgiasanpham11().setText(t[2]);
                    view.getLbtensanpham11().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp11().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(10 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp11().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp11().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp11().setBorder(null);
                    }

                });
            }
            if (i == 11 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham12().setIcon(icon);
                    view.getLbgiasanpham12().setText(t[2]);
                    view.getLbtensanpham12().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp12().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang formxemhang = new formxemhang();
                        xemhangconterler t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) listsp.getListsp().get(11 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp12().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp12().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp12().setBorder(null);
                    }

                });
            }
        }
        if (i + xemthem > listsp.getListsp().size()) {
            view.getBtnxemthem().setVisible(false);
        }
    }

    private void xemthem() {
        xemthem = xemthem + 12;

        try {
            setsp();
        } catch (IOException ex) {
            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void timkiem() {
        String tensptimkiem = view.getTxttimkiem().getText().toLowerCase();
        for (int i = 0; i < listsp.getListsp().size(); i++) {
            String tensp = listsp.getListsp().get(i).toString().toLowerCase();
            if (tensp.matches("(.*)" + tensptimkiem + "(.*)")) {
                timsp.add(listsp.getListsp().get(i));
            }
        }

        if (timsp.size() > 12) {
            view.getBtnxemthem().setVisible(true);
        } else {
            view.getBtnxemthem().setVisible(false);
        }
        int x = view.getLbimgsanpham1().getSize().width;
        int y = view.getLbimgsanpham1().getSize().height;
        for (i = 0 + xemthem; i < timsp.size(); i++) {
            String[] t = timsp.get(i).toString().split("\\$");
            if (i == 0 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham1().setIcon(icon);
                    view.getLbgiasanpham1().setText(t[2]);
                    view.getLbtensanpham1().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp1().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(0 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp1().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp1().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp1().setBorder(null);
                    }

                });
            }
            if (i == 1 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham2().setIcon(icon);
                    view.getLbgiasanpham2().setText(t[2]);
                    view.getLbtensanpham2().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp2().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(1 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp2().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp2().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp2().setBorder(null);
                    }

                });
            }
            if (i == 2 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham3().setIcon(icon);
                    view.getLbgiasanpham3().setText(t[2]);
                    view.getLbtensanpham3().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp3().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(2 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp3().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp3().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp3().setBorder(null);
                    }

                });
            }
            if (i == 3 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham4().setIcon(icon);
                    view.getLbgiasanpham4().setText(t[2]);
                    view.getLbtensanpham4().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp4().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(3 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp4().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp4().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp4().setBorder(null);
                    }

                });

            }
            if (i == 4 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham5().setIcon(icon);
                    view.getLbgiasanpham5().setText(t[2]);
                    view.getLbtensanpham5().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp5().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(4 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }
                });
                view.getJpsp5().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp5().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp5().setBorder(null);
                    }

                });
            }
            if (i == 5 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham6().setIcon(icon);
                    view.getLbgiasanpham6().setText(t[2]);
                    view.getLbtensanpham6().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp6().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(5 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp6().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp6().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp6().setBorder(null);
                    }

                });
            }
            if (i == 6 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham7().setIcon(icon);
                    view.getLbgiasanpham7().setText(t[2]);
                    view.getLbtensanpham7().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp7().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(6 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp7().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp7().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp7().setBorder(null);
                    }

                });
            }
            if (i == 7 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham8().setIcon(icon);
                    view.getLbgiasanpham8().setText(t[2]);
                    view.getLbtensanpham8().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp8().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(7 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp8().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp8().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp8().setBorder(null);
                    }

                });
            }
            if (i == 8 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham9().setIcon(icon);
                    view.getLbgiasanpham9().setText(t[2]);
                    view.getLbtensanpham9().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp9().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(8 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp9().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp9().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp9().setBorder(null);
                    }

                });
            }
            if (i == 9 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham10().setIcon(icon);
                    view.getLbgiasanpham10().setText(t[2]);
                    view.getLbtensanpham10().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp10().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(9 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp10().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp10().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp10().setBorder(null);
                    }

                });
            }
            if (i == 10 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham11().setIcon(icon);
                    view.getLbgiasanpham11().setText(t[2]);
                    view.getLbtensanpham11().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp11().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(10 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp11().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp11().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp11().setBorder(null);
                    }

                });
            }
            if (i == 11 + xemthem) {
                try {
                    File file = new File(t[3]);
                    BufferedImage image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y, image.SCALE_SMOOTH));
                    view.getLbimgsanpham12().setIcon(icon);
                    view.getLbgiasanpham12().setText(t[2]);
                    view.getLbtensanpham12().setText(t[1]);
                } catch (Exception e) {
                }
                view.getJpsp12().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        formxemhang = new formxemhang();
                        t1 = new xemhangconterler(formxemhang);
                        try {
                            t1.setThongtinsp((String) timsp.get(11 + xemthem));
                        } catch (IOException ex) {
                            Logger.getLogger(indexconterler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        t1.setTen(Ten);
                        t1.setTaikhoan(taikhoan);
                        t1.setMatkhau(matkhau);
                        formxemhang.setVisible(true);
                        view.setVisible(false);
                    }

                });
                view.getJpsp12().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        view.getJpsp12().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        view.getJpsp12().setBorder(null);
                    }

                });
            }
        }
        if (i + xemthem > listsp.getListsp().size()) {
            view.getBtnxemthem().setVisible(false);
        }

    }

    public void reloat() {
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
                if (taikhoan.equals(t[0]) && matkhau.equals(t[1])) {
                    n = 1;
                    break;
                } else {
                    n = 0;
                }
            }
            if (n == 1) {
                indexview trangchu = new indexview();
                indexconterler control = new indexconterler(trangchu);
                trangchu.setTen(t[2]);
                control.setTaikhoan(taikhoan);
                control.setMatkhau(matkhau);
                control.setTen(t[2]);
                view.setVisible(false);
                trangchu.setVisible(true);
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }

    public void giohang() {
                if (taikhoan != null) {
                    try {
                        giohangview giohang = new giohangview();
                        giohangconterler control = new giohangconterler(giohang, taikhoan,matkhau);
                        giohang.setVisible(true);
                        view.setVisible(false);
                    } catch (IOException ex) {
                    }
                } else {
                    fromdangnhapview dangnhap = new fromdangnhapview();
                    dangnhapconterler control = new dangnhapconterler(dangnhap);
                    dangnhap.setVisible(true);
                    view.setVisible(false);
                }
    }
    public void trangchu() {
                if (taikhoan==null) {
                    view.setVisible(false);
                    indexview t = new indexview();
                    indexconterler control = new indexconterler(t);
                    t.setVisible(true);
                } else {
                    reloat();
                }
    }

    public void dangxuat() {
                view.setVisible(false);
                indexview t = new indexview();
                indexconterler control = new indexconterler(t);
                t.setVisible(true);//To change body of generated methods, choose Tools | Templates.
    }

    public void dangnhap() {
                fromdangnhapview t = new fromdangnhapview();
                dangnhapconterler control = new dangnhapconterler(t);
                t.setVisible(true);
                view.setVisible(false);    
    }

    public void dangki() {
                fromdangkiview t1 = new fromdangkiview();
                dangkiconterler control1 = new dangkiconterler(t1);
                t1.setVisible(true);
                view.setVisible(false); 
    }

    

    public void themsp() {
                if (view.getDangnhap().isVisible()) {
                    fromdangnhapview t = new fromdangnhapview();
                    dangnhapconterler control = new dangnhapconterler(t);
                    view.setVisible(false);
                } else {
                    themsanpham t = new themsanpham();
                    themsanphamcontroler control = new themsanphamcontroler(t);
                    t.setVisible(true);
                    view.setVisible(false);
                    control.setTaikhoan(taikhoan);
                }
    }
}
