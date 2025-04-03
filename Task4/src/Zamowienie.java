public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;
    public Zamowienie(int i, Klient klient, Produkt[] produkty, int[] ilosci, String dataZamowienia, String nowe){};
    public Zamowienie(int id, Klient klient, Produkt[] produkty,int[] ilosci, String dataZamowienia) {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.status = "Nowe";
        this.dataZamowienia = dataZamowienia;
    }
    public int getId() {return id;    }
    public void setId(int id) {
        this.id = id;
    }
    public Klient getKlient() {
        return klient;
    }
    public void setKlient(Klient klient) {
        this.klient = klient;
    }
    public Produkt[] getProdukty() {
        return produkty;
    }
    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }
    public int[] getIlosci() {
        return ilosci;
    }
    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }
    public String getDataZamowienia() {
        return dataZamowienia;
    }
    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double obliczWartoscZamowienia(){
        double wartoscZamowienia = 0;
        for(int i=0;i<produkty.length;i++){
            wartoscZamowienia+=produkty[i].getCena()*ilosci[i];
        }
        return wartoscZamowienia;
    }
    public void zastosujZnizke()
    {
        if(klient.isCzyStaly())
        {
            double wartoscZamowienia2 = obliczWartoscZamowienia();
            double znizka = wartoscZamowienia2*0.10;
            double wartoscZamowieniaFinalna = wartoscZamowienia2-znizka;
            System.out.println("Wartość po zniżkach "+wartoscZamowieniaFinalna);
        }
        System.out.println(obliczWartoscZamowienia());
    }
    public void wyswietlSzczegoly()
    {
        System.out.println(id+dataZamowienia+status);
        for(int i=0;i<produkty.length;i++)
        {
            System.out.println(produkty[i].getNazwa()+ilosci[i]+produkty[i].getCena());
        }
        System.out.println(obliczWartoscZamowienia());

    }
}
