import java.util.Random;

public class RAND {
    int blad = 0;
    public void algorytm(Odwolanie tab [], int ramek){
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
            if (i>9){ //&& !czyPusta
                for (int j = 0; j < arr.length; j++) { //sprawdzenie czy jest strona taka jak szukana
                    if (arr[j].getStrona() == tab[i].getStrona()){
                        czyPusta= true;
                        pusta = j;
                        break;
                    }
                    else czyPusta = false;
                }
            }

            if (czyPusta){ //jeśli jest pusta to dodajemy
                arr[pusta] = tab[i];
            }
            else { //błąd strony
                Random ra = new Random();
                int indeks = ra.nextInt(ramek);
                arr[indeks] = tab[i];
                blad++;
            }
        }
        System.out.println("Liczba błędów strony RAND: " + blad);
    }
}
