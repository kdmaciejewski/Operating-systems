import java.util.ArrayList;
import java.util.Collections;

public class Scan2 { //najpierw idziemy w lewo potem w prawo

    static int punkt = 40;
    static int suma = 0;

    public static void algorytm(int[] tab){
        ArrayList<Integer> lewo = new ArrayList<>(), prawo = new ArrayList<>();
        ArrayList<Integer> kolejka = new ArrayList<>();

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > punkt){
                prawo.add(tab[i]);
            }
            else if(tab[i] < punkt){
                lewo.add(tab[i]);
            }
        }
        Collections.sort(lewo);
        Collections.sort(prawo);
        int r = lewo.size()-1;
        int p = 0;

        while(!lewo.isEmpty()){
            suma += Math.abs(punkt - lewo.get(r));
            punkt = lewo.get(r);
            lewo.remove(r);
            r--;
        }
        while(p != prawo.size()){
            suma += Math.abs(punkt - prawo.get(p));
            punkt = prawo.get(p);

            p++;
        }

        System.out.println("Suma przemieszczeń SCAN = " + suma);
    }
}
