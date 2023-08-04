public class Stadion {
    private String varos;
    private String nev;
    private String alternativNev;
    private int ferohely;

    public Stadion(String varos, String nev, String alternativNev, int ferohely) {
        this.varos = varos;
        this.nev = nev;
        this.alternativNev = alternativNev;
        this.ferohely = ferohely;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getAlternativNev() {
        return alternativNev;
    }

    public void setAlternativNev(String alternativNev) {
        this.alternativNev = alternativNev;
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }
}
