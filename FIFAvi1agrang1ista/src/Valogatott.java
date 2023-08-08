public class Valogatott {
    private String orszag;
    private int helyezes;
    private int valtozas;
    private int pontszam;

    public Valogatott(String orszag, int helyezes, int valtozas, int pontszam) {
        this.orszag = orszag;
        this.helyezes = helyezes;
        this.valtozas = valtozas;
        this.pontszam = pontszam;
    }

    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    public int getHelyezes() {
        return helyezes;
    }

    public void setHelyezes(int helyezes) {
        this.helyezes = helyezes;
    }

    public int getValtozas() {
        return valtozas;
    }

    public void setValtozas(int valtozas) {
        this.valtozas = valtozas;
    }

    public int getPontszam() {
        return pontszam;
    }

    public void setPontszam(int pontszam) {
        this.pontszam = pontszam;
    }
}
