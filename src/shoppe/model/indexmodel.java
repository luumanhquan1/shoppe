/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author ASUS TUF
 */
public class indexmodel {

    ArrayList<Object> listsp = new ArrayList<>();

    public indexmodel() {
    }

    public ArrayList<Object> getListsp() {
        return listsp;
    }

    public void docfile() {
        try {
            File file = new File("sanpham.dat");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String Line = "";
            while ((Line = br.readLine()) != null) {
                listsp.add(Line);
            }
            fis.close();
            isr.close();
            br.close();
        } catch (Exception e) {
        }
    }
}
