package nesneproje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NesneProje {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Verilerin okunacak olduğu dosya yolunu giriniz(xml,txt,dat vb..) : ");
        // D:\3.sinif\Nesne\Proje/girdi.txt   örnek dosya yolu girişi.
        Scanner girdi = new Scanner(System.in);
        String dosyaYolu = girdi.nextLine();

        ArrayList<String> tumCalisanlar = new ArrayList<>();
        // oluşturduğumuz Strategy design pattern'ı ile farklı veritabanı ve ortamlarda okuma yapabilmesi için esneklik sağlıyor.
        // Yani çalışma zamanında bir sınıfın davranışını veya algoritmasını o stratejiye göre değiştirmek için bu design pattern'ı kullanarak yapıyı oluşturduk
        // Strategy isimli interface'imizde alt sınıflar tarafından implement edilecek veri okuma metodu bulunuyor
        // Context isimli sınıfımız da kendisine gelen strategy türüne göre Strategy interface'i üzerinden ilgili metodu çağırıyor.
        // Böyle istendiği için sadece şuanlık txt okuma gerçekleştirildi. İlerde farklı veritabanları ve ortamlarda da çalışabilmesi için gerekli esneklik sağlandı.

        if (dosyaYolu.contains("txt")) { // Context sınıfı üzerinden strategy design patternımızı gerekli alt sınıfa göre oluşturduk
            Context context = new Context(new TxtOku());
            tumCalisanlar = context.executeStrategy(dosyaYolu);

        } else if (dosyaYolu.contains("xml")) {
            Context context = new Context(new XmlOku());
            tumCalisanlar = context.executeStrategy(dosyaYolu);
        } else if (dosyaYolu.contains("dat")) {
            /* diğer veri girdisi tipi işlemleri ...... */
        }

        ArrayList<Director> direktörler = new ArrayList<>();
        ArrayList<Officer> memurlar = new ArrayList<>();

        for (String nesne : tumCalisanlar) {// veri tipine göre okuduğumuz verileri satır satır alıyoruz
            String[] nesneOzellikleri = nesne.split(","); // nesne özelliklerini bir dizide topladık
            String calisanTuru = nesneOzellikleri[0];
            String calisanAdSoyad = nesneOzellikleri[1];
            int calisanMaas = Integer.parseInt(nesneOzellikleri[2]);
            String calisanDirector = nesneOzellikleri[3];

            Employee eklenecekCalisan; // eklenecek çalışanı employee değişkeninde tutup nesnesini oluşturuyoruz
            
            if (calisanTuru.equals("D")) { // çalışan türüne göre gerekli nesneyi oluşturup eklemeyi yapıyoruz.
                Director currentDirector = new Director(calisanAdSoyad, calisanMaas);
                direktörler.add(currentDirector);

                eklenecekCalisan = currentDirector;

            } else {
                Officer currentOfficer = new Officer(calisanAdSoyad, calisanMaas);
                memurlar.add(currentOfficer);

                eklenecekCalisan = currentOfficer;
            }
            for (Director d : direktörler) { // hangi direktöre eklenecekse eklemeler yapıldı
                if (d.getAdSoyad().contains(calisanDirector)) {
                    d.calisanEkle(eklenecekCalisan);
                }
            }
        } // tüm nesneler direktörlerine eklendi
        // burada verilenleri değiştirerek farklı nesnelerde de denemeler yapılabilir.
        String verilenDirektor1 = "Mustafa Turksever";
        String verilenDirektor2 = "Oguz Demir";
        String verilenMemur = "Ahmet Egeli";
        // D:\NetbeansProjects/girdi.txt    bizim dosya yolu
        for (Director direktor : direktörler) {
            if (direktor.getAdSoyad().contains(verilenDirektor1)) {
                System.out.println(verilenDirektor1 + " isimli direktörün maliyeti : " + direktor.maliyetHesapla());
                System.out.println(verilenDirektor1 + " isimli direktörün altında çalışanların listesi : ");
                direktor.listeleme();
                System.out.println("");
                break;
            }

        }
        for (Director direktor : direktörler) {
            if (direktor.getAdSoyad().contains(verilenDirektor2)) {
                System.out.println(verilenDirektor2 + " isimli direktörün maliyeti : " + direktor.maliyetHesapla());
                System.out.println(verilenDirektor2 + " isimli direktörün altında çalışanların listesi : ");
                direktor.listeleme();
                System.out.println("");
                break;
            }
        }
        for (Officer memur : memurlar) {
            if (memur.getAdSoyad().contains(verilenMemur)) {
                System.out.println(verilenMemur + " isimli memurun maliyeti : " + memur.maliyetHesapla());
                memur.listeleme();
                System.out.println("");
                break;
            }
        }

    }
}
