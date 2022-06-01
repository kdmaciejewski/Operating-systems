import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Algorytm {
    ArrayList<Proces> lista = new ArrayList<Proces>();
    AComparator acomp = new AComparator();
    BComparator bcomp = new BComparator();

    public void zapis() throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("listaprocesów"));

        String p = null;
        while(( p = bf.readLine() ) != null ){
            String[] tab2 =  p.split(" ");
            Proces pr = new Proces(Integer.parseInt(tab2[0]), Integer.parseInt(tab2[1]),Integer.parseInt(tab2[2]), 0, 0 );
            lista.add(pr);
        }
    }
    public void zwiekszWaitsGlobal(){
        for (int i = 0; i < lista.size(); i++) {

        }
    }
    public void sortowanieA(){
        Collections.sort(lista,acomp);
    }
    public void sortowanieB(){
        Collections.sort(lista,bcomp);
    }
    class AComparator implements Comparator<Proces> {
        @Override
        public int compare(Proces o1, Proces o2) {
            return Integer.compare(o1.getAtime(), o2.getAtime());
        }
    }
    class BComparator implements Comparator<Proces>{
        @Override
        public int compare(Proces o1, Proces o2) {
            return Integer.compare(o1.getBtime(), o2.getBtime());
        }
    }
    public void wyswietl(){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
    public void srednia(){
        int suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma+= lista.get(i).getWaits();
        }
        int srednia = suma/(lista.size());
        System.out.println("średni czas oczekiwania dla FCFS wynosi: " + srednia);
    }
    public void obliczanieC(){
        int suma = 0;
        for (int i = 0; i < lista.size(); i++) {

            if (i==0){
                lista.get(i).setCtime(lista.get(i).getBtime());
                suma+=lista.get(i).getBtime();
            }
            else{
                //lista.get(i).setCtime(lista.get(i).getBtime() + lista.get(i-1).getBtime());
                suma+=lista.get(i).getBtime();
                if(suma>=lista.get(i).getAtime())
                    lista.get(i).setCtime(suma);
                else{
                    lista.get(i).setCtime(lista.get(i).getAtime() + lista.get(i).getBtime());
                }
            }

        }
    }
    public void obliczanieWaits(){  //ustawienie czasu faktycznego oczekiwania

        for (int i = 1; i < lista.size(); i++) {        //TUTAJ DAŁEM OD 1

            if (lista.get(i).getAtime() > lista.get(i-1).getCtime()){

                lista.get(i).setWaits(0);  //czy tak

            }
            else{
                lista.get(i).setWaits(lista.get(i).getCtime() - lista.get(i).getAtime());
            }
        }
    }
}
