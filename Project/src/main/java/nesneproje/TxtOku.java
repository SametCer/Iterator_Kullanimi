
package nesneproje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtOku implements Strategy{
    
    private ArrayList<String> tumCalisanlar = new ArrayList<String>(); // bu liste gelen dosyayı okuyup splitle ayırıp nesneye dönüştürme işlemi için

    public ArrayList<String> readData(String dataPath) {

        try {
            File f = new File(dataPath);
            Scanner dosya = null;
            
            dosya = new Scanner(f);
            
            while (dosya.hasNext()) { //
                String nesne = dosya.nextLine();
                getTumCalisanlar().add(nesne);
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(TxtOku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return getTumCalisanlar();
    }
    
    public ArrayList<String> getTumCalisanlar() {
        return tumCalisanlar;
    }
    // set fonksiyonumuz yok çünkü set etme işlemleri readDatadan yapılıp arraylistimize ekleniyor
}
