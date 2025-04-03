public class SklepKomputerowy {
    private Produkt[] produkty=new Produkt[10];
    private Klient[] klienci=new Klient[10];
    private Zamowienie[] zamowienia=new Zamowienie[10];
    private int liczbaProduktow = 0;
    private int liczbaKlientow = 0;
    private int liczbaZamowien = 0;

    public void dodajProdukt(Produkt produkt) {
        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow] = produkt;
            liczbaProduktow++;
        } else {
            System.out.println("Za dużo produktów");
        }
    }

    public void dodajKlienta(Klient klient) {
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow] = klient;
            liczbaKlientow++;
        } else {
            System.out.println("Za duzo klientow");
        }
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        if (liczbaZamowien < produkty.length) {
            String dataZamowienia="12-04-2025";
            Zamowienie zamowienie = new Zamowienie(liczbaZamowien + 1, klient, produkty, ilosci, dataZamowienia,"Nowe");
            zamowienia[liczbaZamowien] = zamowienie;
            liczbaZamowien++;
            aktualizujStanMagazynowy(zamowienie);
        }
        return null;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for (int i = 0; i < zamowienie.getProdukty().length; i++) {
            Produkt produkt = zamowienie.getProdukty()[i];
            int ilosc = zamowienie.getIlosci()[i];
            produkt.setIloscWMagazynie(produkt.getIloscWMagazynie() - ilosc);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                break;
            }
        }
    }
    public void wyswietlProduktyWKategorii(String kategoria)
    {
        for(int i = 0; i < liczbaProduktow; i++)
        {
            if(produkty[i].getKategoria().equals(kategoria))
            {
                produkty[i].wyswietlInformacje();
            }
        }
    }
    public void wyswietlZamowienieKlienta(int idKlienta)
    {
        for(int i = 0; i < liczbaKlientow; i++)
        {
            if(zamowienia[i].getKlient().getId() == idKlienta)
            {
                zamowienia[i].wyswietlSzczegoly();
            }
        }
    }
}
