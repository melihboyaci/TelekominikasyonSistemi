import java.time.LocalDateTime;
import java.util.ArrayList;

public class FaturasizHat  extends Hat {
    private int bakiye = 0;
    private String telefonNo;
    public FaturasizHat(String telefonNo, int bakiye) {
        super(telefonNo);
        this.bakiye = bakiye;

    }
    public void AramaYap(String arananTelefon, int sure) {
        double konusmaUcreti = (sure)*(0.05);
        if (bakiye<konusmaUcreti) {
            int yeniSure = (int) (bakiye/(0.05));
            bakiye=0;
            Konusma konusma = new Konusma(getTelefonNo(), arananTelefon, yeniSure, LocalDateTime.now());
            getAramalar().add(konusma);
        }else if(bakiye==0){
            System.out.printf("Bakiyeniz yok. Arama yapılamadı.");
        }else{
            bakiye-=konusmaUcreti;
            Konusma konusma = new Konusma(getTelefonNo(), arananTelefon, sure, LocalDateTime.now());
            getAramalar().add(konusma);
        }

    }
    public void GelenArama(String arayanTelefon, int sure) {
        Konusma konusma = new Konusma(arayanTelefon, getTelefonNo(), sure, LocalDateTime.now());
        getAramalar().add(konusma);
    }

    public void bakiyeYukle(int miktar){
        if(miktar<0)
            System.out.printf("Geçerli bir miktar giriniz.");
        else{
            bakiye+=miktar;
        }
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }
}