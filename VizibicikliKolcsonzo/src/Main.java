import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Kolcsonzes> kolcsonzesek = new ArrayList<>();

        feladat4(kolcsonzesek);
        feladat5(kolcsonzesek);
        feladat6(kolcsonzesek);
        feladat7(kolcsonzesek);
        feladat8(kolcsonzesek);
        feladat9(kolcsonzesek);
        feladat10(kolcsonzesek);
    }

    private static void feladat10(List<Kolcsonzes> kolcsonzesek) {
        System.out.println("10. feladat: Statisztika");

        HashMap<Character,Integer> statMap = new HashMap<>();

        for (Kolcsonzes k1 : kolcsonzesek){
            int szamlalo = 0;

            for (Kolcsonzes k2 : kolcsonzesek)
                if (k1.JAzon() == k2.JAzon())
                    szamlalo++;
            statMap.put(k1.JAzon(),szamlalo);
        }
        for (Character c: statMap.keySet())
            System.out.println("\t\t" + c + " - " + statMap.get(c));

    }

    private static void feladat9(List<Kolcsonzes> kolcsonzesek) {
        String txt ="";

        for (Kolcsonzes k:kolcsonzesek) {
            if (k.JAzon() == 'F')
                txt += k.EOra()+":"+k.EPerc()+"-"+k.VOra()+":"+k.VPerc()+" : "+k.nev()+"\n";
        }
        try {
            FileWriter fr = new FileWriter("F.txt");
            fr.write(txt);
            fr.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    private static void feladat8(List<Kolcsonzes> kolcsonzesek) {
        int kredit = 0;
        for (Kolcsonzes k: kolcsonzesek){
            double percek = (k.VOra()*60 + Short.parseShort(k.VPerc())) - (k.EOra()*60 + Short.parseShort(k.EPerc()));
            kredit += Math.ceil(percek/30);
        }
        int bevetel = kredit * 2400;
        System.out.println("8. feladat: A napi bevétel: "+bevetel+" Ft");
    }

    private static void feladat7(List<Kolcsonzes> kolcsonzesek) {
        System.out.print("7. feladat: Adjon meg egy időpontot óra:perc ablakban: ");
        Scanner sc = new Scanner(System.in);
        String scIdopont = sc.next();

        System.out.println("\t\tA vizen lévő járművek:");

        short scOra = Short.parseShort(scIdopont.split(":")[0]);
        short scPerc = Short.parseShort(scIdopont.split(":")[1]);

        for (Kolcsonzes k : kolcsonzesek)
            if (
                    k.EOra() == scOra && Short.parseShort(k.EPerc()) < scPerc ||
                    k.EOra() < scOra && k.VOra() > scOra ||
                    k.VOra() == scOra && Short.parseShort(k.VPerc()) > scPerc
            ) System.out.println("\t\t"+k.EOra()+":"+k.EPerc()+"-"+k.VOra()+":"+k.VPerc()+" : "+k.nev());
    }

    private static void feladat6(List<Kolcsonzes> kolcsonzesek) {
        System.out.print("6. feladat: Kérek egy nevet: ");

        Scanner sc = new Scanner(System.in);
        String nev = sc.next();

        System.out.println("\t\t"+nev + " kölcsönzései:");

        int index = 0;
        for (Kolcsonzes k: kolcsonzesek)
            if (nev.equalsIgnoreCase(k.nev()))
                System.out.println("\t\t"+k.EOra()+":"+k.EPerc()+"-"+k.VOra()+":"+k.VPerc());
            else if (index++ == kolcsonzesek.size()-1){
                System.out.println("\t\tNem volt ilyen nevű kölcsönző");
                break;
            }
    }

    private static void feladat5(List<Kolcsonzes> kolcsonzesek) {
        System.out.println("5. feladat: Napi kölcsönzések száma: "+kolcsonzesek.size());
    }

    private static void feladat4(List<Kolcsonzes> kolcsonzesek) {
        try {
            FileReader fr = new FileReader("kolcsonzesek.txt");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();

            while (br.ready()){
                String[] var = br.readLine().split(";");
                
                Kolcsonzes k = new Kolcsonzes(
                        var[0],
                        var[1].charAt(0),
                        Short.parseShort(var[2]),
                        var[3],
                        Short.parseShort(var[4]),
                        var[5]
                );
                kolcsonzesek.add(k);
            }
        }catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
    }
}