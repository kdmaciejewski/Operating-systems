public class LRU {
    int blad = 0;
    int czas = 0;

    public void algorytm(Odwolanie tab [], int ramek, int stron){
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

            if (i>ramek-1){ ////????
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
            else { //błąd strony
                int min = Integer.MAX_VALUE;
                int indeks = 0;
                for (int j = 0; j < arr.length; j++) { //szukam ramki z najmniejszym czasem ostatniego odwołania
                    if (arr[j].getOstatnieOdw() < min) {       //(czyli tej która najdłużej jest nieruszana)
                        min = arr[j].getOstatnieOdw();
                        indeks = j;
                    }
                }
                arr[indeks] = tab[i];
                blad++;
            }
            czas++; // zwiększam czas
        }
        System.out.println("Liczba błędów strony LRU: " + blad);
    }
}
