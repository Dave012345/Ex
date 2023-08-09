import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Felfedezes> felfedezesek = new ArrayList<>();

    public static void main(String[] args) {
        feladat2();
        feladat3();
        feladat4();
        feladat5_6();
        feladat7();
        feladat8();
    }

    private static void feladat8() {
        System.out.println("8. feladat: Statisztika");
        int ev = 0;
        for(Felfedezes szamolando:felfedezesek){
            int szamlalo = 0;
            for(Felfedezes lista : felfedezesek){
                if (!szamolando.getEv().equals("Ókor") && !lista.getEv().equals("Ókor"))
                    if (Integer.parseInt(szamolando.getEv()) == Integer.parseInt(lista.getEv())) szamlalo++;
            }
            if (szamlalo > 3)
                if (ev != Integer.parseInt(szamolando.getEv())){
                    ev = Integer.parseInt(szamolando.getEv());
                    System.out.println("\t\t"+szamolando.getEv()+": "+szamlalo+" db");
                }
        }
    }

    private static void feladat7() {
        int legtobbEv = 0;
        for (int i = 0; i < felfedezesek.size()-1; i++)
            if (!felfedezesek.get(i).getEv().equals("Ókor")){
                int idoszak = Integer.parseInt(felfedezesek.get(i+1).getEv()) - Integer.parseInt(felfedezesek.get(i).getEv());
                if (idoszak > legtobbEv) legtobbEv = idoszak;
            }
        System.out.println("7. feladat: "+legtobbEv+" év volt a leghosszabb időszak két elem felfedezése között");
    }

    private static void feladat6(String vegyjel) {
        System.out.println("6. feladat: keresés");

        Felfedezes keresettVegyjel = new Felfedezes("","", nagyKezdoBetu(vegyjel),0,"");

        for (Felfedezes felfedezes: felfedezesek)
            if (felfedezes.getVegyjel().equals(keresettVegyjel.getVegyjel()))
                keresettVegyjel = felfedezes;
        if (keresettVegyjel.getNev().length() != 0){
            System.out.println("\t\tAz elem vegyjele: "+keresettVegyjel.getVegyjel());
            System.out.println("\t\tAz elem neve: "+keresettVegyjel.getNev());
            System.out.println("\t\tRendszáma: "+keresettVegyjel.getRendszam());
            System.out.println("\t\tFelfedezés éve: "+keresettVegyjel.getEv());
            System.out.println("\t\tFelfedező: "+keresettVegyjel.getFelfedezo());
        }else System.out.println("\t\tNincs ilyen elem az adatforrásban!");
    }
    private static String nagyKezdoBetu(String vegyjel) {
        return vegyjel.substring(0,1).toUpperCase() + vegyjel.substring(1).toLowerCase();
    }

    private static void feladat5_6() {
        String vegyjel;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("5. feladat: Kérek egy vegyjelet: ");
            vegyjel = sc.next();
        }while (vegyjel.length() < 1 || vegyjel.length() > 2 || !vegyjel.matches("[a-zA-Z]*$"));

        feladat6(vegyjel);
    }

    private static void feladat4() {
        int db = 0;
        for (Felfedezes felfedezes: felfedezesek) if (felfedezes.getEv().equals("Ókor")) db++;
        System.out.println("4. feladat: Felfedezések száma az ókorban:  "+db);
    }

    private static void feladat3() {
        System.out.println("3. feladat: Elemek száma: "+felfedezesek.size());
    }

    private static void feladat2() {
        try {
            FileReader fr = new FileReader("felfedezesek.csv");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();

            String sor;
            while ((sor = br.readLine()) != null){
                String[] var = sor.split(";");

                Felfedezes felfedezes = new Felfedezes(var[0],var[1],var[2],Integer.parseInt(var[3]),var[4]);
                felfedezesek.add(felfedezes);
            }


        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}