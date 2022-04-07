/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneproje;

import java.util.ArrayList;

/**
 *
 * @author samet çerezci
 */
public class XmlOku implements Strategy{
    
    private ArrayList<String> tumCalisanlar = new ArrayList<String>(); // bu liste gelen xml verisini okuyup işlemden geçirerek nesne satırını verecek
    
    public ArrayList<String> readData(String dataPath){
        // XML okuma işlemleri burda yapılacak ve okunanlar string arraylsit olarak return edilecek
        // Böyle istendiği için sadece txt okuma gerçekleştirildi. İlerde farklı veritabanları ve ortamlarda da çalışabilmesi için gerekli esneklik sağlandı.
        return null;
    }
    public ArrayList<String> getTumCalisanlar() {
        return tumCalisanlar;
    }
    
}
