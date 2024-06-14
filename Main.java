import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FaturaliHat faturaliHat = new FaturaliHat("5362428837", 120, 0);
        //Konusma konusma = new Konusma("1234567891", "1236547896", 15, LocalDate.of(24,05,19));
        //System.out.println(konusma);
        //System.out.println(faturaliHat);
        faturaliHat.AramaYap("5070259059", 181);
        System.out.println(faturaliHat.getFaturaTutari());

       faturaliHat.AramaYap("5070259059", 120);
       faturaliHat.AramaYap("5632147896", 25);
       faturaliHat.AramaYap("5632147896", 25);
       faturaliHat.AramaYap("5632147896", 25);

        System.out.println(faturaliHat.getFaturaTutari());
//        faturaliHat.GelenArama("504166256321", 10);
//        System.out.println(faturaliHat.getAramalar());
        System.out.println(faturaliHat.EnUzunKonusma().getAramaSuresi());
        System.out.println(faturaliHat.getAramalar());
        FaturaliHat faturaliHat1 = new FaturaliHat("5070259059", 50, 20);
        faturaliHat1.AramaYap(faturaliHat.getTelefonNo(), 30);
        System.out.println(faturaliHat1.getAramalar());
        System.out.println(faturaliHat.AramaSikliginaGoreSirala());
    }
}