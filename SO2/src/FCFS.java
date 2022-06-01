import java.util.ArrayList;
import java.util.Collections;

public class FCFS {
    ArrayList<Integer> tabl;
    public int suma=0;

    public void pracuj2(){
        tabl = new ArrayList<>();
        tabl.add(80);
        tabl.add(2);
        tabl.add(45);
        tabl.add(60);
        tabl.add(159);
        tabl.add(7);
        tabl.add(41);
        tabl.add(114);

        for (int i = 0; i < tabl.size()-1; i++) {
            suma += Math.abs(tabl.get(i) - tabl.get(i+1));
        }
        System.out.println("Suma przemieszczeń FCFS = " + suma);
    }

}

