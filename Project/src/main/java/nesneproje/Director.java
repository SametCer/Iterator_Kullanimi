package nesneproje;

public class Director implements Employee {

    private String adSoyad;
    private int maas;
    private int altCalisanSayisi = 1; // kendisi dahil olduğu için nesne oluşurken alt çalışan sayısı 1le başlıyor
    private Employee[] altindaCalisanlar = new Employee[10000];

    public Director(String adSoyad, int maas) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        altindaCalisanlar[0] = this; // alt çalışan dizisinin ilk elemanı onların direktörü olarak atanıyor.
    }

    @Override
    public void listeleme() { // elemanları recursive listeleyeceğiz
        ArrayIterator listIterator = this.getIterator();// listeyi dolaiırken  kullanacağımız iteratoru alıyoruz.

        System.out.println("Direktör : " + adSoyad);

        listIterator.next(); // calısanlarda kendisi de bulunduğu için kendisini fonksiyon başında direkt yazdırıp altındaki elemanları yazdırmaya geçiyoruz
        while (listIterator.hasNext()) {

            Employee calisan2 = (Employee) listIterator.next();

            calisan2.listeleme(); // işlemi recursive olarak tekrar devam ediyoruz çünnkü
            // direktörün altında çalışan direktör employee'sinin altında çalışan employee'ler de baş direktörün altında çalışıyor sayılır.

        }

    }

    @Override
    public int maliyetHesapla() {
        ArrayIterator maliyetIterator = this.getIterator(); // maliyet hesaplarken kullanacağımız iteratoru alıyoruz.

        int maliyet = maas; // ilk başta tek maliyeti maaşı olarak ayarlıyoruz
        maliyetIterator.next(); // ekleme yaparken altında çalışanlar listesinde kendisi de var olduğu için ve maaşı maliyette tuttuğumuz için
        // iteratorumuzu 1 kez nextliyoruz ve directorun altındaki çalışanların maaşını recursive olarak kendine ekliyoruz
        while (maliyetIterator.hasNext()) {

            Object altCalisan = maliyetIterator.next();
            if (altCalisan.getClass().getSimpleName().equals("Director")) { // gezilen class directorsa
                maliyet += ((Director) altCalisan).maliyetHesapla(); // kendi maliyetine recursive olarak altındaki directorlerin maliyetini ekleyecek

            } else {
                maliyet += ((Officer) altCalisan).getMaas(); // officersa maliyeti direkt officerın maaşı olyor ve ana maliyete ekleniyor

            }
        }

        return maliyet;
    }

    public void calisanEkle(Employee calisan) { // her çalışan eklendiğinde çalışan sayısını arttırıp eklemeyi yapıyor.

        altindaCalisanlar[altCalisanSayisi] = calisan;
        altCalisanSayisi++;
    }

    @Override
    public ArrayIterator getIterator() {
        return new ArrayIterator(getCalisanlar());
    }

    public void setCalisanlar(Employee[] altindaCalisanlar) {
        this.altindaCalisanlar = altindaCalisanlar;
    }

    public Employee[] getCalisanlar() { // direktörün altında çalışan employee nesnelerinin hepsine ulaşabiliyoruz ( kendisi dahil ) 
        return altindaCalisanlar;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

}
