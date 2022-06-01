import java.util.ArrayList;
import java.util.Collections;

public class CScan { //najpierw idziemy w prawo potem od początku

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
        int r = 0;
        int p = 0;

        while(p != prawo.size()){
            suma += Math.abs(punkt - prawo.get(p));
            punkt = prawo.get(p);

            p++;
        }
        punkt = 0;
        while(r != lewo.size()){
            suma += Math.abs(punkt - lewo.get(r));
            punkt = lewo.get(r);

            r++;
        }


        System.out.println("Suma przemieszczeń CSCAN = " + suma);
    }
}
