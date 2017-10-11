/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_star;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author W8 = nama komputer saya ya pak
 */
public class A_STAR {

    /**
     * @param args the command line arguments
     */
    public static void propagasi (Kota k, ArrayList<Kota> O){
         for (int i=0; i<k.getList().size(); i++){
            double temp = (k.getG()+k.getList().get(i).getJarak());
            if(O.contains(k.getList().get(i))){
                k.getList().get(i).getKota_tujuan().setG(temp);
                k.getList().get(i).getKota_tujuan().generateF();
                propagasi (k.getList().get(i).getKota_tujuan(),O);
            } else if (temp < k.getList().get(i).getKota_tujuan().getG()){
                k.getList().get(i).getKota_tujuan().setG(temp);
                k.getList().get(i).getKota_tujuan().generateF();
                propagasi (k.getList().get(i).getKota_tujuan(),O);
            }
        }   
    }
    
    public static void cek (Kota a, ArrayList<Kota> L, Kota b){
        L.add(a.getKota_asal());
        if(a.getKota_asal()!=b){
            cek(a.getKota_asal(), L, b);
        }
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        
        Kota k1 = new Kota("Bobbia",15);
        Kota k2 = new Kota("Piacenza",14.5);
        Kota k3 = new Kota("Carpi",13);
        Kota k4 = new Kota("Terme",12);
        Kota k5 = new Kota("Emilia",10);
        Kota k6 = new Kota("Imola",7.5);
        Kota k7 = new Kota("Faenza",8);
        Kota k8 = new Kota("Cesena",4.5);
        Kota k9 = new Kota("Forli",4);
        Kota k10 = new Kota("Ferrara",5);
        Kota k11 = new Kota("Rimini",2.5);
        Kota k12 = new Kota("Revenna",0);
        
        k1.addJalur(k2,5);
        k1.addJalur(k4,3);
        k1.addJalur(k8,15);
        
        k2.addJalur(k3,3);
        k2.addJalur(k4,3);
        
        k3.addJalur(k10,8);
        k3.addJalur(k5,2);
        
        k4.addJalur(k5,2);
        k4.addJalur(k7,3);
        
        k5.addJalur(k6,2);
        
        k6.addJalur(k7,1);
        k6.addJalur(k9,3);
        
        k7.addJalur(k9,2);
        k7.addJalur(k8,6);
        
        k8.addJalur(k11,5);
        
       k9.addJalur(k12,3);
        
        k10.addJalur(k12,6);
        
        k11.addJalur(k12,1);
        
        ArrayList<Kota> Open = new ArrayList<>();
        ArrayList<Kota> Closed = new ArrayList<>();
        ArrayList<Kota> Solusi = new ArrayList<>();
        
        Kota awal = new Kota();
        Kota akhir = new Kota();
        Kota BestNode = new Kota();
        Boolean gagal = false;
        akhir = k12;
        awal = k1;
        
        System.out.println("Sebelum : \n"
                +" > Open Node : ");
                for(int a=0; a<Open.size(); a++){
                    System.out.println(Open.get(a).getNama()+" F = "+Open.get(a).getF());
                }
                System.out.println("\n > Close Node : ");
                for(int a=0; a<Closed.size(); a++){
                    System.out.println(Closed.get(a).getNama()+" F = "+Closed.get(a).getF()+"\n");
                }
                
                Open.add(awal);
                
        while (Open.size()!=0 || BestNode!=akhir){
            if (Open.size()==0){
                System.out.println("Gagal");
                gagal = true;
                break;
            } else {
                System.out.println("\nSesudah : \n"
                +" > Open Node : ");
                for(int a=0; a<Open.size(); a++){
                    System.out.println(Open.get(a).getNama()+" F = "+Open.get(a).getF());
                }
                System.out.println("\n > Close Node : ");
                for(int a=0; a<Closed.size(); a++){
                    System.out.println(Closed.get(a).getNama()+" F = "+Closed.get(a).getF());
                }
                System.out.println("------------");
                int best=0;
                BestNode = Open.get(0);
                for(int i=0; i<Open.size()-1; i++){
                    if(Open.get(i+1).getF() <= Open.get(i).getF()){
                        best = i+1;
                        BestNode = Open.get(i+1);
                    } else {
                        best = i;
                        BestNode = Open.get(i);
                    }
                }
                System.out.println("BestNode : "+BestNode.getNama()+" F= "+BestNode.getF()+"\n"+"\n");
                
                if (BestNode != akhir){
                System.out.println("Sebelum : \n"
                +" > Open Node : ");
                for(int a=0; a<Open.size(); a++){
                    System.out.println(Open.get(a).getNama()+" F = "+Open.get(a).getF());
                }
                System.out.println("\n > Close Node : ");
                for(int a=0; a<Closed.size(); a++){
                    System.out.println(Closed.get(a).getNama()+" F = "+Closed.get(a).getF());
                }
                }
                Closed.add(BestNode);
                Open.remove(best);
                Kota lama = new Kota();
                if (BestNode == akhir){
                    break;
                } else{
                    for (int j=0; j<BestNode.getList().size(); j++){
                        
                        
                        double tampung_g = (BestNode.getG()+BestNode.getList().get(j).getJarak());
                        
                        Boolean ketemu_diOpen = false;
                        int index_ketemu_diOpen = 0;
                        Boolean ketemu_diClosed = false;
                        int index_ketemu_diClosed = 0;
                        int count = 0;
                        while (count<Open.size() && !ketemu_diOpen){
                            if (BestNode.getList().get(j).getKota_tujuan()==Open.get(count)){
                                ketemu_diOpen = true;
                                index_ketemu_diOpen=count;
                            }
                            count++;
                        }
                        count=0;
                        while (count<Closed.size() && !ketemu_diClosed){
                            if (BestNode.getList().get(j).getKota_tujuan()==Closed.get(count)){
                                ketemu_diClosed = true;
                                index_ketemu_diClosed=count;
                            }
                            count++;
                        }
                        if (ketemu_diOpen){
                            
                            lama = Open.get(index_ketemu_diOpen);
                            if(lama.getG()>tampung_g){
                                lama.setKota_asal(BestNode);
                                lama.setG(tampung_g);
                                lama.generateF();
                            }
                        } else if(ketemu_diClosed){
                           lama = Closed.get(index_ketemu_diClosed);
                           if (lama.getG()>tampung_g){
                               lama.setKota_asal(BestNode);
                               lama.setG(tampung_g);
                               lama.generateF();
                               propagasi(lama,Open);
                               
                           }
                            
                        } else {
                            Open.add(BestNode.getList().get(j).getKota_tujuan());
                            BestNode.getList().get(j).getKota_tujuan().setG(tampung_g);
                            BestNode.getList().get(j).getKota_tujuan().setKota_asal(BestNode);
                            BestNode.getList().get(j).getKota_tujuan().generateF();
                        }
                    }
                }
                
                
            }
        }
        if(!gagal){
            Solusi.add(k12);
       
            cek(k12, Solusi, awal);
        
            for (int b=Solusi.size()-1; b>=0; b--){
                System.out.print(Solusi.get(b).getNama()+" -> ");
            }
            System.out.println(" Jarak ="+k12.getF());
        }
        
        
    }
    
}
