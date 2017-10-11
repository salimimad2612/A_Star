/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_star;

/**
 *
 * @author W8 = nama komputer saya ya pak
 */
public class Jalur {
    
    private Kota kota_tujuan;

    private double jarak;

    public Jalur(Kota kota_tujuan, double jarak) {
        this.kota_tujuan = kota_tujuan;
        this.jarak = jarak;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

    public Kota getKota_tujuan() {
        return kota_tujuan;
    }

    public void setKota_tujuan(Kota kota_tujuan) {
        this.kota_tujuan = kota_tujuan;
    }

}
