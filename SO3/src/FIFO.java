public class FIFO {
    int blad = 0;
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
            for (int j = 0; j < arr.length; j++) { //inkrementacja czasu przebywania
                if (arr[j] != null){
                    arr[j].setCzas(arr[j].getCzas()+1);
                }
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
            }
            else { //błąd strony
                int max = 0;
                int indeks = 0;
                for (int j = 0; j < arr.length; j++) { //szukamy najdłużej przebywającego
                    if (arr[j].getCzas() > max) {
                        max = arr[j].getCzas();
                        indeks = j;
                    }
                }
                arr[indeks] = tab[i];
                blad++;
            }
        }
        System.out.println("Liczba błędów strony FIFO: " + blad);
    }
}
