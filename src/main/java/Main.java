
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> pelaaja = new ArrayList<>();
        ArrayList<Integer> emanta = new ArrayList<>();
        Pakka pakka = new Pakka();
        Scanner lukija = new Scanner(System.in);

        System.out.println("Tervetuloa pelaamaan Venttiä!\n\nPelin säännöt");

        System.out.println("Tarkoituksena on saada korttien yhteissummaksi 21 tai mahdollisimman lähelle sitä.");
        System.out.println("Lähemmäksi 21 päässyt osanottaja voittaa.");
        System.out.println("Mikäli pelaajan tai emännän korttien summa ylittää 21, häviää summan ylittänyt taho automaattisesti.");
        System.out.println("Mikäli tilanne on tasan, emäntä voittaa. Lisäksi emäntä voittaa mikäli hän saa yhteissummaksi 20 tai 21.");
        System.out.println("Mikäli pelaajalla on kädessään 5 korttia, eikä summa 21 ole ylittynyt, korttien arvoksi lasketaan 21.");
        System.out.println("Pelaajan saadessa kortiksi ässän, kortin arvo voi olla joko 1 tai 14. (Peli valitsee automaattisesti järkevämmän vaihtoehdon)");
        System.out.println("Emännän saadessa ässän on kortin arvo aina 1.");
        System.out.println("Pelaaja on ensimmäisenä pelivuorossa ja hänelle jaetaan ensimmäinen kortti.");
        System.out.println("Pelaaja päättää kortin nähtyään, haluaako hän nostaa seuraavan kortin niin kauan, kunnes antaa pelivuoronsa emännälle.");
        System.out.println("Emäntä jakaa itselleen kortit pelivuoron saatuaan.");
        System.out.println("Peli päättyy emännän lopettaessa vuoronsa.");
        System.out.println("Onnea matkaan!");
        System.out.println("");

        //Pelaajan pelivuoro
        System.out.println("Pelivuorossa pelaaja:");
        pelaaja.add(pakka.nostaKortti());
        System.out.println("Ensimmäinen kortti on: " + pelaaja.get(0));

        while (true) { // pelaajan pelivuoro
            System.out.println("Nostetaanko uusi kortti? [kyllä/ei]");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("kyllä")) {
                int uusiKortti = pakka.nostaKortti();
                pelaaja.add(uusiKortti);
                System.out.println("\nKortti on: " + uusiKortti);
            } else if (vastaus.equals("ei")) {
                break;
            } else {
                System.out.println("\nvirheellinen syöte!\n");
                continue;
            }

            if (havisiko(pelaaja)) { //jos käsi ylittää 21, tarkistetaan onko ässiä
                assanMuunto(pelaaja);
            }

            if (havisiko(pelaaja)) { //tarkistetaan häviääkö pelaaja suoraan
                System.out.println("Korttien summa on: " + laskeSumma(pelaaja));
                System.out.println("\nPelaaja häviää.\nEmäntä voittaa!");
                break;
            } else if ( pelaaja.size() == 5) {
                System.out.println("Viisi korttia muodostaa Ventin!\n\"Korttien summa on: 21");
                pelaaja.clear();
                pelaaja.add(21);
                break;
            }
            System.out.println("Korttien summa on: " + laskeSumma(pelaaja));

        }

        //emännän pelivuoro
        if (!havisiko(pelaaja)) {

            System.out.println("\nPelivuorossa emäntä:");
            emanta.add(pakka.nostaKortti());
            assanMuunto(emanta);
            System.out.println("Ensimmäinen kortti on: " + emanta.get(0));

            while (true) {
                if (laskeSumma(emanta) >= laskeSumma(pelaaja)
                        || laskeSumma(emanta) == 20
                        || laskeSumma(emanta) == 21) {
                    System.out.println("\nPelaaja häviää.\nEmäntä voittaa!");
                    break;
                } else {
                    int kortti = pakka.nostaKortti();
                    System.out.println("\nSeuraava kortti on: " + kortti);
                    emanta.add(kortti);
                    assanMuunto(emanta);
                    System.out.println("Korttien summa on: " + laskeSumma(emanta));
                }

                if (havisiko(emanta)) {
                    System.out.println("\nEmäntä häviää.\nPelaaja voittaa!");
                    break;
                }
            }
        }
    }

    //metodit
    public static Integer laskeSumma(ArrayList<Integer> lista) {
        int summa = 0;
        for (Integer arvo : lista) {
            summa = summa + arvo;
        }
        return summa;
    }

    public static void assanMuunto(ArrayList<Integer> lista) { //tarkistaa löytyykö ässä ja muuttaa sen 1
        if (lista.contains(14)) {
            lista.remove(Integer.valueOf(14));
            lista.add(1);
        }
    }

    public static boolean havisiko(ArrayList<Integer> henkilo) {
        return (laskeSumma(henkilo) > 21);
    }
}
