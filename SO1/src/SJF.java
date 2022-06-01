import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//niewywłaszczający

public class SJF extends Algorytm {
    ArrayList<Proces> pomoc = new ArrayList<>();
    int zmienna = 1;
    public void start(){
        pomoc.add(new Proces(1, 1,3,3,3));
        pomoc.add(new Proces(2, 2,7,0,0));
        pomoc.add(new Proces(3, 3,4,0,0));
        pomoc.add(new Proces(4, 3,7,0,0));
        pomoc.add(new Proces(5, 6,2,0,0));
        pomoc.add(new Proces(6, 7,9,0,0));

    }
    public void przetwarzanie(){
        int licznik = 0;
        int suma = 0;
        lista.add(pomoc.get(0));
        while(licznik <= pomoc.size()){
            if (lista.size() <= 0 ) {
                break;}

            lista.get(0).zmniejszB(); //zmniejszam czas wykonywania bo się wykonuje

            zwiekszWszystkim(); //zwiększam wszystkim oprócz pierwszemu czas oczekiwania
            if(lista.get(0).getBtime() == 0  ){
                while(zmienna < pomoc.size() && lista.get(0).getWaits() + lista.get(0).getAtime()>=pomoc.get(zmienna).getAtime()){
                    dodawanie();
                    zmienna++;
                }

                sortowanie();
                suma+=lista.get(0).getWaits();
                lista.remove(0);
                licznik++;
            }
        }
        System.out.println("średni czas oczekiwania = " + suma/licznik);

    }
//    public void przetwarzanie(){
//        int licznik = 0;
//        int suma = 0;
//        while(lista != null){
//            if (lista.size() <= 0 ) return;
//            lista.get(0).zmniejszB();
//
//            zwiekszWszystkim();
//            if(lista.get(0).wykonany()){
//                suma+=lista.get(0).getWaits();
//                lista.remove(0);
//                licznik++;
//            }
//        }
//
//    }
    public void dodawanie(){
        lista.add(pomoc.get(zmienna));
    }
    public void sortowanie(){
        Collections.sort(lista,bcomp);
    }
    public void zwiekszWszystkim(){
        for (int i = 1; i < lista.size(); ++i) {
            lista.get(i).setWaits(lista.get(i).getWaits()+1);
        }
    }
}
