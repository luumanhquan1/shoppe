/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.model;

/**
 *
 * @author ASUS TUF
 */
public class themsanphammodel {

    private String Tensp;
    private String giasp;

    public themsanphammodel(String Tensp, String giasp) {
        this.Tensp = Tensp;
        this.giasp = giasp;

    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

}
