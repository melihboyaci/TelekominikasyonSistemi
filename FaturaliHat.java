import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FaturaliHat extends Hat {
    private int ucretsizKonusmaSuresi;
    private int sabitFaturaTutari;
    private int ekUcret = 0;
    //private String telefonNo;

    public FaturaliHat(String telefonNo, int ucretsizKonusmaSuresi, int sabitFaturaTutari) {
        super(telefonNo);
        if(ucretsizKonusmaSuresi<0)
            System.out.println("Geçerli bir değer gir!");
        else
            this.ucretsizKonusmaSuresi=ucretsizKonusmaSuresi;
        if (sabitFaturaTutari<0)
            System.out.println("Geçerli bir tutar gir!");
        else
            this.sabitFaturaTutari=sabitFaturaTutari;

    }

    public void AramaYap(String arananTelefon, int sure) {
        ucretsizKonusmaSuresi -= sure;
        if(ucretsizKonusmaSuresi<0){
            ekUcret += Math.ceil(Math.abs(ucretsizKonusmaSuresi)/60)*2;
            ucretsizKonusmaSuresi = 0;
        }


        Konusma konusma = new Konusma(getTelefonNo(), arananTelefon, sure, LocalDateTime.now());
        getAramalar().add(konusma);
    }

    public void GelenArama(String arayanNumara, int sure) {
        Konusma konusma = new Konusma(arayanNumara, getTelefonNo(), sure, LocalDateTime.now());
        getAramalar().add(konusma);
    }

    public int faturaHesapla(){
        return sabitFaturaTutari+ekUcret;
    }

    public int getUcretsizKonusmaSuresi() {
        return ucretsizKonusmaSuresi;
    }

    public void setUcretsizKonusmaSuresi(int ucretsizKonusmaSuresi) {
        this.ucretsizKonusmaSuresi = ucretsizKonusmaSuresi;
    }

    public int getFaturaTutari() {
        return sabitFaturaTutari+ekUcret;
    }

    public void setSabitFaturaTutari(int sabitFaturaTutari) {
        this.sabitFaturaTutari = sabitFaturaTutari;
    }
}
