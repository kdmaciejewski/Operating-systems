public class ALRU {
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

            if (i>ramek-1){
                for (int j = 0; j < arr.length; j++) { //sprawdzenie czy jest strona taka jak szukana
                    if (arr[j].getStrona() == tab[i].getStrona()){
                        arr[j].setBit(true); //ustawiamy bit drugiej sznasy na jeden
                        czyPusta= true;
                        pusta = j; //ustawiamy indeks znalezionego
                        break;
                    }
                    else {
                        czyPusta = false;
                        //arr[j].setBit(false);
                    }
                }
            }

            if (czyPusta){ //jeśli jest pusta lub taka jak szukana to dodajemy
                arr[pusta] = tab[i];
                arr[pusta].setBit(true);
            }
            else { //błąd strony
                int min = Integer.MAX_VALUE;
                int indeks = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].isBit() == false){
                        arr[j] = tab[i];
                        arr[j].setBit(true);
                        break;
                    }

                }
                int j = 0;
                do{ // szukam ramki w której bit jest ustawiony na 0
                    if (j == arr.length) j = 0;

                    if (arr[j].isBit() == false){
                        arr[j] = tab[i];
                        arr[j].setBit(true);
                        break;
                    }
                    else if (arr[j].isBit() == true){
                        arr[j].setBit(false);
                    }
                    j++;

                }while(arr[j].isBit() != true);

                blad++;
            }
        }
        System.out.println("Liczba błędów strony ALRU: " + blad);
    }
}
