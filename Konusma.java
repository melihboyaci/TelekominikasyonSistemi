import java.time.LocalDate;
import java.time.LocalDateTime;

public class Konusma implements Comparable {
    private String arayanTelefon;
    private String arananTelefon;
    private int sure;
    private LocalDate tarih;

    public Konusma(String arayanTelefon, String arananTelefon, int sure, LocalDateTime tarih)
    {
        this.arayanTelefon=arayanTelefon;
        this.arananTelefon=arananTelefon;
        this.sure=sure;
        this.tarih= LocalDate.from(tarih);
    }
    public String toString() {
        String yazi= "\nArayan numara: " + arayanTelefon + " Aranan numara: " + arananTelefon+ " Süre: " + sure + " saniye" ;

        return yazi;
    }
    public int compareTo(Object o) {
        return 0;
    }

    public String getArayanNumara () {
        return arayanTelefon;
    }

    public void setArayanNumara(String arayanTelefon) {
        this.arayanTelefon = arayanTelefon;
    }

    public String getArananNumara() {
        return arananTelefon;
    }

    public void setArananNumara(String arananTelefon) {
        this.arananTelefon = arananTelefon;
    }

    public int getAramaSuresi() {
        return sure;
    }

    public void setAramaSuresi(int sure) {
        this.sure = sure;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }
}