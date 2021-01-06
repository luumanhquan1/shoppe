/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS TUF
 */
public class giohangmodel {
    ArrayList<Object> listgiohang=new ArrayList<>();
    public giohangmodel() {
    }
    
    public void docfile() throws IOException{

        try {
             File file=new File("giohang.dat");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String Line="";
            while((Line=br.readLine())!=null){
                listgiohang.add(Line);
               
            }
            fis.close();
            isr.close();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(giohangmodel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Object> getListgiohang() {
        return listgiohang;
    }

  public void them(String them){
      listgiohang.add(them);
  }
    
}
