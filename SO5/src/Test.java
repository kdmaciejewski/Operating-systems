import java.util.ArrayList;
import java.util.Random;

public class Test {
    ArrayList<Procesor> lista; // lista procesorów

    int N = 50; // liczba procesorów
    int seria = 50000; // jak długa ma być seria zadań do wykonania

    int z = 7;
    int sumaObciazenia = 0;
    int P = 70; // wartość progowa obciążenia 70%
    int srednieObciazenie = 0;
    int R = 20; // próg minimalnego obciążenia
    int migracje = 0;
    int zapytania = 0;
    int licznik = 0;
    double stand = 0.0;
    public void m1(){
        int d = 0;
        int p = 0;
        boolean warunek = true;
        while(warunek){
            warunek = czyDalej();

            if (p == lista.size()){
                p %= lista.size();
            }
            Procesor procesor = lista.get(p);

            boolean czyMozna = true;

            for (int i = 0; i < z; i++) {
                Random r = new Random();
                int pytany = r.nextInt(lista.size());
                zapytania++;
                if (0<lista.get(pytany).obecne.size() && lista.get(pytany).obecne.size() <= P){

                    if (procesor.getZadania().size() <= 0){
                        break;
                    }
                    migracje++;
                    lista.get(pytany).obecne.add(procesor.getZadania().remove(0));
                    czyMozna = false;
                    break;
                }
//                if (lista.get(pytany).getObciazenie()/100 <= P){
//                    migracje++;
//                    if (procesor.getZadania().size() <= 0){
//                        break;
//                    }
//                    lista.get(pytany).obecne.add(procesor.getZadania().remove(0));
//                    czyMozna = false;
//                    break;
//                }
            }
            if (czyMozna){
//                if (!(procesor.getZadania().size() <=0)){
//                    procesor.obecne.add(procesor.getZadania().remove(0));
//                }
                if (procesor.getZadania().size() !=0){
                    procesor.obecne.add(procesor.getZadania().remove(0));
                }
            }
            zliczObciazenie();

            p++;
            d++;
        }
        System.out.println("Średnie obciążenie procesorów dla 1 = " + srednieObciazenie);
        System.out.println("Odchylenie standardowe = "+ stand/ licznik);
        System.out.println("Ilość migracji dla 1 = " + migracje);
        System.out.println("Ilość zapytań dla 1 = " + zapytania);
    }
    public void m2(){
        int d = 0;
        int p = 0; // indeks obecnie badanego procesora
        boolean warunek = true;
        while(warunek){
            warunek = czyDalej();

            if (p == lista.size()){
                p %= lista.size();
            }
            Procesor procesor = lista.get(p);
//            if (procesor.getZadania().size()!=0){
//                procesor.obecne.add(procesor.getZadania().remove(0));
//            }

            if (procesor.getObciazenie() >= P){ // jeżeli wartość obciążenia obecnego procesu jest większa od progu
                boolean dalej = true;
                while(dalej){
                    Random r = new Random();
                    int pytany = r.nextInt(lista.size());
                    zapytania++;
                    if (lista.get(pytany).obecne.size() <= P){
                        if (procesor.getZadania().size() <= 0){
                            break;
                        }
                        migracje++;
                        lista.get(pytany).obecne.add(procesor.getZadania().remove(0));
                        dalej = false;
                        break;
                    }

                }

            }
            else{
                if (procesor.getZadania().size() !=0){
                    procesor.obecne.add(procesor.getZadania().remove(0));
                }
            }

            zliczObciazenie();
            odejmijCzas();
            p++;
            d++;
        }
        System.out.println("Średnie obciążenie procesorów dla 2 = " + srednieObciazenie);
        System.out.println("Odchylenie standardowe = "+ stand);
        System.out.println("Ilość migracji dla 2 = " + migracje);
        System.out.println("Ilość zapytań dla 2 = " + zapytania);
    }
    public void m3(){
        int d = 0;
        int p = 0; // indeks obecnie badanego procesora
        boolean warunek = true;
        while(warunek){
            warunek = czyDalej();

            if (p == lista.size()){
                p %= lista.size();
            }
            Procesor procesor = lista.get(p);
            if (procesor.getZadania().size()!=0){
                procesor.obecne.add(procesor.getZadania().remove(0));
            }
            if (0<procesor.obecne.size() && procesor.getObciazenie() <= R){ // jeżeli wartość obciążenia obecnego procesu jest mniejsze od progu to szukamy zbyt obciążonego procesu

                for (int i = 0; i < z; i++) {
                    Random r = new Random();
                    int pytany = r.nextInt(lista.size());
                    zapytania++;
                    if (lista.get(pytany).obecne.size() <= P){

                        if (procesor.getZadania().size() <= 0){
                            break;
                        }
                        for (int j = 0; j < 5; j++) { // przenoszę 5 procesów na nieobciążony procesor
                            if (lista.get(pytany).obecne.size()== 0) break;
                            migracje++;
                            procesor.obecne.add(lista.get(pytany).obecne.remove(0));
                        }

                        break;
                    }
                }

            }
            else{
                if (!(procesor.getZadania().size() <=0)){
                    procesor.obecne.add(procesor.getZadania().remove(0));
                }
            }

            zliczObciazenie();
            odejmijCzas();
            p++;
            d++;
        }
        System.out.println("Średnie obciążenie procesorów dla 3 = " + srednieObciazenie);
        System.out.println("Odchylenie standardowe = "+ stand);
        System.out.println("Ilość migracji dla 3 = " + migracje);
        System.out.println("Ilość zapytań dla 3 = " + zapytania);
    }

    public void zliczObciazenie(){
        sumaObciazenia = 0;

        for (int i = 0; i < lista.size(); i++) {
            sumaObciazenia += lista.get(i).obecne.size();  //lista.get(i).obciazenie;
        }
        int lic = sumaObciazenia/ lista.size(); // średnie obciążenie w tej turze

        stand = (stand+((sumaObciazenia - srednieObciazenie)/N))/2;


        if (lic <= 5){

            srednieObciazenie = (srednieObciazenie+lic)/2;
        }
        else{
            srednieObciazenie = (srednieObciazenie*30 + lic)/31; // wzór do zmniejszenie rangi dużych obciążeń
        }
        licznik++;

    }
    public void odejmijCzas(){
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).obecne.size()  ; j++) {
                lista.get(i).obecne.get(j).czasWykonania -=1;
                if ( lista.get(i).obecne.get(j).czasWykonania <= 0){
                    lista.get(i).obecne.remove(j);
                    if (j == lista.get(i).obecne.size()) break;
                }
            }
        }
    }
    public boolean czyDalej(){      // czy są jeszcze jakies zadania do wykonania
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getZadania().size() != 0 ){
                return true;
            }
//            if (lista.get(i).obecne.size() != 0 ){
//                return true;
//            }
        }
        return false;
    }
    public void generujProcesory(){
        lista = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lista.add(new Procesor());
        }
    }
    public void generujProcesy(){   // każdy procesor ma 100 procesów, które kiedyś się na nim pojawią
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < 100; j++) {
                lista.get(i).getZadania().add(new Proces());
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.generujProcesory();
        t.generujProcesy();
        t.m1();

        Test t1 = new Test();
        t1.generujProcesory();
        t1.generujProcesy();
        t1.m2();

        Test t2 = new Test();
        t2.generujProcesory();
        t2.generujProcesy();
        t2.m3();

    }
}
