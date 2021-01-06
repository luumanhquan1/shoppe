/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.conterler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author ASUS TUF
 */
public class dangki  {
    private String taikhoan;
     private String matkhau;
      private String hovaten;
      
      int kiemtra=0;
      
        
    ArrayList<Object> account=new ArrayList<>();
    public dangki(String taikhoan, String matkhau, String hovaten) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.hovaten = hovaten;
       
    }    
public void luufile(){ 
     docfile();
     dangki();
    try (PrintWriter pw=new PrintWriter("account.dat")){
    for(Object tmp:account){
        System.out.println(""+tmp.toString());
        pw.println(tmp.toString());
    }
    } catch (Exception e) {
    }
}
public void dangki(){
    dangki tmp=new dangki(taikhoan, matkhau, hovaten);
       account.add(tmp);
}

public int Kiemtra(){
    try {
            File file=new File("account.dat");
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br =new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null) {
              String[] t=line.split("\\$");
              if(taikhoan.equals(t[0])){
              kiemtra=1;
                 
              break;
              }
              else{
                  kiemtra=0;
              }
              }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    return kiemtra;
}
public void docfile(){
    try {
            File file=new File("account.dat");
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br =new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null) {
              String[] t=line.split("\\$");
              dangki tmp=new dangki(t[0],t[1], t[2]);
              account.add(tmp.toString());
              }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
}

    @Override
    public String toString() {
        return taikhoan + "$" + matkhau + "$" + hovaten;
    }
    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }
      
}
