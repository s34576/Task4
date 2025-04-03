import java.util.ArrayList;
import java.util.List;

public class SklepKomputerowy {
    private List<Produkt> produkty = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();
    private List<Zamowienie> zamowienia = new ArrayList<>();
    private int liczbaProduktow = 0;
    private int liczbaKlientow = 0;
    private int liczbaZamowien = 0;

    public SklepKomputerowy() {
        this.zamowienia=zamowienia;
        this.liczbaProduktow=liczbaProduktow;
        this.liczbaKlientow=liczbaKlientow;
        this.liczbaZamowien=liczbaZamowien;
    }

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {

        Zamowienie zamowienie = new Zamowienie(liczbaZamowien+1,klient,produkty, ilosci, "2025-04-03","Nowe");
        zamowienia.add(zamowienie);
        liczbaZamowien++;
        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for(int i=0; i<zamowienie.produkty.length; i++) {
            zamowienie.produkty[i].setIloscWMagazynie(zamowienie.produkty[i].getIloscWMagazynie()-zamowienie.ilosci[i]);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for(Zamowienie z : zamowienia) {
            if(z.getId() == idZamowienia) {
                z.setStatus(nowyStatus);
            }
        }
                }

    public void wyswietlProduktyWKategorii(String kategoria)
    {
        for(Produkt p : produkty) {
            if(p.getKategoria().equals(kategoria));
        }
    }
    public void wyswietlZamowienieKlienta(int idKlienta)
    {
        for(Zamowienie z : zamowienia) {
            if(z.klient.getId() == idKlienta)
                z.wyswietlSzczegoly();

        }
    }
}
