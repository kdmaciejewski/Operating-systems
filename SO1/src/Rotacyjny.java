import java.util.ArrayList;
import java.util.Collections;

public class Rotacyjny extends Algorytm {

    ArrayList<Proces> pomoc = new ArrayList<>();
    int zmienna = 1;
    int kwant;
    public void start(){
        pomoc.add(new Proces(1, 1,3,3,0));
        pomoc.add(new Proces(2, 2,7,0,0));
        pomoc.add(new Proces(3, 3,4,0,0));
        pomoc.add(new Proces(4, 3,7,0,0));
        pomoc.add(new Proces(5, 6,2,0,0));
        pomoc.add(new Proces(6, 7,9,0,0));

    }
    public void przetwarzanie(int kwant) {
        int licznikczasu = 0;
        int pozycja = 1;
        this.kwant = kwant;
        lista.add(pomoc.get(0)); //trzeba odjąć od wszystkich istniejących elelmentów listy
        // w miejscu btime dwa kwanty czasu i dodać 2 kwanty do wait, w międzyczasie dodawac odpowiednie elementy
        while (lista.size() <= 0) {
            if (lista.size() <= 0) {
                break;
            }
            for (int i = 0; i < lista.size(); i++) {
                if (licznikczasu >= pomoc.get(i).getAtime()) {

                }
                int b = lista.get(i).getBtime();
                lista.get(i).setBtime(b - 2);
                licznikczasu += 2;
                sortowanieB();
            }
            if (lista.get(0).getBtime() == 0) {


            }
        }
    }
    public void przetwarzanieproste(){
        int suma = 0;
        int mian = pomoc.size();

        for (int i = 0; i < pomoc.size(); i++) {
            lista.add(pomoc.get(i));
        }

        Collections.sort(lista, acomp);
        int n = lista.size();
        while (n >= 0) {
            odejmowanieKwantu();
            zwiekszWszystkim();     //zwiększanie czasu oczekiwania wszystkim
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getBtime() == 0) {
                    suma += lista.get(i).getWaits();
                    lista.remove(i);
                }
            }
        }
        System.out.println("średni czas oczekiwania = " + suma/n);
    }
//    public void przetwarzanieproste(){
//        Collections.sort(lista, bcomp);
//        int w = lista.get(0).getNumer();
//        while( lista.size() <= pomoc.size()) {
//            for (int i = 0; i < pomoc.size(); i++) {
//                lista.add(pomoc.get(i));
//            }
//            Collections.sort(lista, acomp);
//            int n = lista.size();
//            while(n>=0){
//                odejmowanieKwantu();
//                zwiekszWszystkim();
//            }
//        }
//        int n = lista.size();
//        int suma = 0;
//        for (int i = 0; i < lista.size(); i++) {
//           suma += lista.get(i).getWaits();
//        }
//        System.out.println("średni czas oczekiwania = " + suma/n);
//    }
    public void dodawanie(){
        lista.add(pomoc.get(zmienna));
    }
    public void odejmowanieKwantu(){
        for (int i = 0; i < lista.size(); i++) {
            int n =lista.get(i).getBtime()-2;
            lista.get(i).setBtime(n);
        }
    }
    public void sortowanie(){
        Collections.sort(lista,bcomp);
    }

    public void zwiekszWszystkim(){
        for (int i = 1; i < lista.size(); ++i) {
            lista.get(i).zwiekszWaits();
        }
        }
    }
