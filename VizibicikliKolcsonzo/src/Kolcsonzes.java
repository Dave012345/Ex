/**
 * @param nev Kölcsönző neve
 * @param JAzon Jármű azonosítója
 * @param EOra Elvitel órája
 * @param EPerc Elvitel perce
 * @param VOra Visszahozatal órája
 * @param VPerc Visszahozatal perce
 */
public record Kolcsonzes(String nev, char JAzon, short EOra, String EPerc, short VOra, String VPerc) {

    @Override
    public String EPerc() {
        if (Integer.parseInt(EPerc) < 10)
            return "0" + EPerc;
        return EPerc;
    }

    @Override
    public String VPerc() {
        if (Integer.parseInt(VPerc) < 10)
            return "0" + VPerc;
        return VPerc;
    }
}
