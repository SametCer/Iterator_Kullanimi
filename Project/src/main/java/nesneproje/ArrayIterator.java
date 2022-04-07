package nesneproje;

/**
 *
 * @author samet çerezci
 */
public class ArrayIterator implements MyIterator {

    private Employee[] calisanlar;
    private int pozisyon;

    public int getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(int pozisyon) {
        this.pozisyon = pozisyon;
    }

    public ArrayIterator(Employee[] calisanlar) {
        setCalisanlar(calisanlar);
    }

    @Override
    public boolean hasNext() {
        if (pozisyon >= getCalisanlar().length
                || getCalisanlar()[pozisyon] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Employee calisan = getCalisanlar()[pozisyon];
        pozisyon++;
        return calisan;
    }

    public Employee[] getCalisanlar() {
        return calisanlar;
    }

    public void setCalisanlar(Employee[] calisanlar) {
        this.calisanlar = calisanlar;
    }
}
