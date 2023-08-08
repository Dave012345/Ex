import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Valogatott> valogatottak = new ArrayList<>();

    public static void main(String[] args) {
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();
    }

    private static void feladat7() {
        System.out.println("7. feladat: Statisztika");
        stat(0);
        stat(-1);
        stat(1);
    }

    private static void stat(int valtozas) {
        int db = 0;
        for (Valogatott valogatott: valogatottak){
            if (valogatott.getValtozas() == valtozas)
                db++;
        }
        System.out.println("\t\t"+valtozas+" helyet változott: "+db+" csapat");
    }

    private static void feladat6() {
        boolean van = false;

        for (Valogatott valogatott: valogatottak)
            if (valogatott.getOrszag().equals("Magyarország")) van = true;

        if (van) System.out.println("6. feladat: A csapatok között megtalálható Magyarország");
        else System.out.println("6. feladat: A csapatok között nincs Magyarország");
    }

    private static void feladat5() {
        Valogatott legtobbetJavitott = new Valogatott("",0,-1,0);

        for(Valogatott valogatott: valogatottak){
            if (valogatott.getValtozas() > legtobbetJavitott.getValtozas())
                legtobbetJavitott = valogatott;
        }
        System.out.println("5. feladat: A legtöbbet javító csapat:");
        System.out.println("\t\tHelyezés: " + legtobbetJavitott.getHelyezes());
        System.out.println("\t\tCsapat: " + legtobbetJavitott.getOrszag());
        System.out.println("\t\tPontszám: " + legtobbetJavitott.getPontszam());
    }

    private static void feladat4() {
        float sum = 0f;
        for(Valogatott valogatott: valogatottak){
            sum += valogatott.getPontszam();
        }
        System.out.println("4' feladat: A csapatok átlagos pontszáma: "+String.format("%.2f",(sum / valogatottak.size()))+" pont");
    }

    private static void feladat3() {
        System.out.println("3. feladat: A világranglistán "+valogatottak.size()+" csapat szerepel");
    }

    private static void feladat2() {
        try {
            FileReader fr = new FileReader("fifa.txt");
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); //elso sor (fejléc) kuka

            String sor;
            while ((sor = br.readLine()) != null){
                String[] var = sor.split(";");

                Valogatott valogatott = new Valogatott(var[0],Integer.parseInt(var[1]),Integer.parseInt(var[2]),Integer.parseInt(var[3]));
                valogatottak.add(valogatott);
            }

        }catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
    }
}