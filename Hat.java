import java.util.ArrayList;
public abstract class Hat {
    private String telefonNo;
    private ArrayList<Konusma> Aramalar = new ArrayList<Konusma>();

     public Hat(String telefonNo) {
        if (telefonNo.matches("\\d{10}")){
            this.telefonNo=telefonNo;
        }else {
            System.out.println("Geçerli bir telefon numarası gir!");
        }
    }


    public abstract void AramaYap(String a, int b);
    public abstract void GelenArama(String a, int b);

    public Konusma EnUzunKonusma() {

        Konusma maks = Aramalar.get(0);
        for(int i=0; i<Aramalar.size(); i++){
            if(Aramalar.get(i).getAramaSuresi() > maks.getAramaSuresi())
                maks = Aramalar.get(i);
        }
        return maks;
    }

    public ArrayList<String> AramaSikliginaGoreSirala() {
        ArrayList<String> numaralar = new ArrayList<>();
        ArrayList<Integer> frekanslar = new ArrayList<>();

        for (Konusma k : Aramalar) {
            String arayan = k.getArayanNumara();
            String aranan = k.getArananNumara();

            if(!arayan.equals(getTelefonNo())){
                int indexArayan = numaralar.indexOf(arayan);
                if (indexArayan >= 0) {
                    frekanslar.set(indexArayan, frekanslar.get(indexArayan) + 1);
                } else {
                    numaralar.add(arayan);
                    frekanslar.add(1);
                }
            }
            if(!aranan.equals(getTelefonNo())){
                int indexAranan = numaralar.indexOf(aranan);
                if (indexAranan >= 0) {
                    frekanslar.set(indexAranan, frekanslar.get(indexAranan) + 1);
                } else {
                    numaralar.add(aranan);
                    frekanslar.add(1);
                }
            }
        }

        // Sıralama işlemi (bubble sort kullanıldı, başka sıralama algoritmaları da kullanılabilir)
        for (int i = 0; i < numaralar.size() - 1; i++) {
            for (int j = 0; j < numaralar.size() - i - 1; j++) {
                if (frekanslar.get(j) < frekanslar.get(j + 1) ||
                        (frekanslar.get(j).equals(frekanslar.get(j + 1)) && numaralar.get(j).compareTo(numaralar.get(j + 1)) < 0)) {
                    // frekanslar ve numaraları yer değiştir
                    int tempFreq = frekanslar.get(j);
                    frekanslar.set(j, frekanslar.get(j + 1));
                    frekanslar.set(j + 1, tempFreq);

                    String tempNum = numaralar.get(j);
                    numaralar.set(j, numaralar.get(j + 1));
                    numaralar.set(j + 1, tempNum);
                }
            }
        }

        return numaralar;
    }


    public String toString(){
        return "Telefon Numarası: " + telefonNo;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public ArrayList<Konusma> getAramalar() {
        return Aramalar;
    }

    public void setAramalar(ArrayList<Konusma> aramalar) {
        Aramalar = aramalar;
    }
}
