import java.util.ArrayList;
import java.util.Stack;

public class OPT {
    int blad = 0;
    int czas = 0;

    public void algorytm(Odwolanie tab [], int ramek, int stron, int rozmiar){
        Odwolanie arr [] = new Odwolanie[ramek];

        boolean czyPusta = true;
        int pusta = 0;

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < arr.length; j++) { //sprawdzenie czy są puste ramki
                if (arr[j] == null){
                    czyPusta= true;
                    pusta = j;
                    break;
                }
                else czyPusta = false;
            }

            if (i>ramek-1){
                for (int j = 0; j < arr.length; j++) { //sprawdzenie czy jest strona taka jak szukana
                    if (arr[j].getStrona() == tab[i].getStrona()){
                        czyPusta= true;
                        pusta = j;
                        break;
                    }
                    else czyPusta = false;
                }
            }

            if (czyPusta){ //jeśli jest pusta lub taka jak szukana to dodajemy
                arr[pusta] = tab[i];
                arr[pusta].setOstatnieOdw(czas); // ustawienie czasu ostatniego odwołania
            }
            else { //błąd strony            //szukam ramki która najdłużej nie będzie używana
                Stack<Odwolanie> stack = new Stack<Odwolanie>();
                ArrayList<Integer> lista = new ArrayList<>();
                boolean dziala = true;
                for (int j = i+1; j < i+10; j++) { //BADAM NAJBLIŻSZE 10 ELEMENTÓW z przyszłości
                    int licznik = 0;
                    dziala = true;
                    if (j >= rozmiar) {
                        dziala = false;   // to nie tak
                        break;
                    }
                    lista.add(tab[j].getStrona());
                    for (int k = 0; k < lista.size(); k++) {
                        if (lista.get(k) == tab[j].getStrona()){
                            licznik++;
                        }
                    }
                    if (licznik <= 1 ) {//jeżeli to jest pierwsze wystąpienie
                        stack.push(tab[j]);
                    }
                }
                if (dziala){
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j].getStrona() == stack.peek().getStrona()){
                            arr[j] = tab[i];
                            break;
                        }
                    }
                    blad++;
                }

            }
        }
        System.out.println("Liczba błędów strony OPT: " + blad);
    }
}
//    int pomoc[] = new int [stron]; //przez następne 20 odwołań
//
//    int max = 0;
//    int indeks = 0;
//                for (int j = i+1; j < i+21; j++) {
//
//        pomoc[tab[i].getStrona()-1] -= 1; //jeśli nastąpiło odwołanie to odejmuje
//        for (int k = 0; k < pomoc.length; k++) {
//        if (tab[i].getStrona()-1 != k){
//        pomoc[i] +=1;
//        }
//        }
//        }
//        for (int j = 0; j < pomoc.length; j++) {
//        if (pomoc[j]>max){
//        max = pomoc[j];
//        indeks = j+1;
//        //indeks = pomoc
//        }
//        //trzeba będzie indeks +1
//        }
//        //arr[indeks] = tab[i];
//        arr[indeks] = tab[i];
//        blad++;
//        }
//