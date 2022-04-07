
package nesneproje;

public class Officer implements Employee{
    
    private String adSoyad;
    private int maas;

    
    public Officer(String adSoyad,int maas){
        this.adSoyad = adSoyad;
        this.maas = maas;
    }
    
    @Override
    public void listeleme(){ // listelemede sadece kendi adı yazdırılıyor. altında kimse çalışmıyor.
        System.out.println("Memur : "+adSoyad);
    }
    @Override
    public int maliyetHesapla(){ // maliyeti sadece kendi maaşıdır
        return maas;
    }
    @Override
    public ArrayIterator getIterator(){ // iteratoru null döndürüyor çünkü dolaşmamız gerkeen  bir elemanı yok.
        return null;
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
