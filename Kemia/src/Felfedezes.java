public class Felfedezes {
    private String ev;
    private String nev;
    private String vegyjel;
    private int rendszam;
    private String felfedezo;

    public Felfedezes(String ev, String nev, String vegyjel, int rendszam, String felfedezo) {
        this.ev = ev;
        this.nev = nev;
        this.vegyjel = vegyjel;
        this.rendszam = rendszam;
        this.felfedezo = felfedezo;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getVegyjel() {
        return vegyjel;
    }

    public void setVegyjel(String vegyjel) {
        this.vegyjel = vegyjel;
    }

    public int getRendszam() {
        return rendszam;
    }

    public void setRendszam(int rendszam) {
        this.rendszam = rendszam;
    }

    public String getFelfedezo() {
        return felfedezo;
    }

    public void setFelfedezo(String felfedezo) {
        this.felfedezo = felfedezo;
    }
}
