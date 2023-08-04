import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    static private List<Stadion> stadionok = new ArrayList<>();
    static private String bekertVaros;

    public static void main(String[] args) {
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();
        feladat8();
        feladat9();
    }

    private static void feladat9() {
        HashSet<String> kulonbozok = new HashSet<>();
        for(Stadion stadion:stadionok)
            kulonbozok.add(stadion.getVaros());
        System.out.println("9. feladat: "+kulonbozok.size()+" különböző városban voltak mérkőzések.");
    }

    private static void feladat8() {
        for (int i = 0; i < stadionok.size(); i++)
            if (stadionok.get(i).getVaros().equals(bekertVaros)) {
                System.out.println("8. feladat: A megadott város VB helyszín.");
                break;
            }else if (i == stadionok.size()-1)
                System.out.println("8. feladat: A megadott város nem VB helyszín.");
    }

    private static void feladat7() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("7. feladat: Kérem a város nevét: ");
            bekertVaros = scanner.next();
        }while (bekertVaros.length()<3);
    }

    private static void feladat6() {
        int db = 0;
        for(Stadion stadion : stadionok)
            if (stadion.getAlternativNev().equals("n.a.") == false) db++;
        System.out.println("6. feladat: Két néven is ismert stadionok száma: "+db);
    }

    private static void feladat5() {
        float osszes = 0.0f;
        for (Stadion stadion : stadionok)
            osszes+= stadion.getFerohely();
        System.out.println("5. feladat: Átlagos férőhelyszám: "+String.format("%.1f",(osszes/stadionok.size())));
    }

    private static void feladat4() {
        System.out.println("4. feladat: A legkevesebb férőhely: ");
        int min = Integer.MAX_VALUE;
        for (Stadion stadion : stadionok)
            if (stadion.getFerohely() < min) min = stadion.getFerohely();
        for (Stadion stadion : stadionok)
            if (stadion.getFerohely() == min){
                System.out.println("\t\tVáros: "+stadion.getVaros());
                System.out.println("\t\tStadion neve: "+stadion.getNev());
                System.out.println("\t\tFérőhely: "+stadion.getFerohely());
            }
    }

    private static void feladat3() {
        System.out.println("3. feladat: Stadionok száma: "+stadionok.size());
    }

    private static void feladat2() {
        try {
            FileReader fr = new FileReader("vb2018.txt");
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); //elso sor (fejlec) eldobás

            String sor;
            while ((sor = br.readLine()) != null){
                String[] var = sor.split(";");
                Stadion stadion = new Stadion(var[0],var[1],var[2],Integer.parseInt(var[3]));
                stadionok.add(stadion);
            }
        }catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
    }
}