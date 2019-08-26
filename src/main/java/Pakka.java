import java.util.ArrayList;
import java.util.Random;

public class Pakka {
    
    private ArrayList<Integer> pakka;
    private Random random;
    
   
    public Pakka(){
        this.random = new Random();
        this.pakka = new ArrayList<>();
        
        int indeksi = 0;
     
        while (indeksi < 13){ //luodaan listalle jokaiseen indeksiin arvo 4 (saman korttiluvun määrä)
            pakka.add(4);
            indeksi++;
            }
    }
    
    public int nostaKortti(){
        int nostettu = 0;
        while (true){
        nostettu = random.nextInt(14 - 2 + 1) + 2; //(ylaraja - alaraja + 1) + ylaraja      
        if (!(this.pakka.get(nostettu - 2) == 0)){            
            break;
            }
        }
        
        this.pakka.set(nostettu-2,this.pakka.get(nostettu-2)-1); //vähentää indeksin kohdalta nykyistä arvoa yhdellä (alk.4kpl)
         
        return nostettu;
    }
    
    /*public void tulostaPakka(){
        int indeksi = 0;
        while (indeksi < 13){
            System.out.println(this.pakka.get(indeksi));
            indeksi++;
        }        
    }*/
}

