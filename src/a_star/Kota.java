/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_star;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author W8 = nama komputer saya ya pak
 */
public class Kota {
    
    private String nama;
    
    private ArrayList<Jalur> list = new ArrayList<>();

    private double h_ke_revenna;

    private double F;

    private double G;
    
    private Kota kota_asal;

      
    public void generateF (){
        this.F = this.G + this.h_ke_revenna;
    }
    
    public Kota getKota_asal() {
        return kota_asal;
    }

    public void setKota_asal(Kota kota_asal) {
        this.kota_asal = kota_asal;
    }


    public void addJalur (Kota k, double j){
        Jalur a = new Jalur(k,j);
        list.add(a);
    }
    
    public double getG() {
        return G;
    }

    public void setG(double G) {
        this.G = G;
    }

    public double getF() {
        return F;
    }

    public void setF(double F) {
        this.F = F;
    }

    public double getH_ke_revenna() {
        return h_ke_revenna;
    }

    public void setH_ke_revenna(double h_ke_revenna) {
        this.h_ke_revenna = h_ke_revenna;
    }

    public Kota(String nama,double h) {
        this.nama = nama;
        this.h_ke_revenna = h;
    }
    
    public Kota() {
        
    }
    
    public ArrayList<Jalur> getList(){
        return this.list;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
