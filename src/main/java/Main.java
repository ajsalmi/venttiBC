import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Integer> pelaaja = new ArrayList<>();
        ArrayList<Integer> emanta = new ArrayList<>();
        Pakka pakka = new Pakka();
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Tervetuloa pelaamaan Venttiä!");
        System.out.println("");
        System.out.println("Blaa blaa blaa säännöt");
        System.out.println("");
        
        //Pelaajan pelivuoro
        System.out.println("Pelivuorossa pelaaja:");
        pelaaja.add(pakka.nostaKortti());
        System.out.println("Ensimmäinen kortti on: " + pelaaja.get(0));
        int indeksi = 1;
        
        while (true) {
            System.out.println("Nostetaanko uusi kortti? [kyllä/ei]");
            String vastaus = lukija.nextLine();
            
            if (vastaus.equals("ei")) {
                break;
            } else if (vastaus.equals("kyllä")) {
                pelaaja.add(pakka.nostaKortti());
                System.out.println("Kortti on: " + pelaaja.get(indeksi)); 
                indeksi++;
            } else {
                System.out.println("Virheellinen syöte");
            }
            
            int summa = 0;     // lasketaan listan arvojen summa
            for (Integer arvo : pelaaja) {
                summa = summa + arvo;
            }
            
            if (summa > 21) {
                System.out.println("Korttien arvo on yli 21");
                System.out.println("Pelaaja häviää.");
                break;
            }
           
        }
        
        //Emännän pelivuoro
        
    }
    
}
