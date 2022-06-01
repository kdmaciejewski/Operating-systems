// pamięć wirtualna ma 10 stron
// pamięć fizyczna ma 5 ramek

import java.util.Random;

public class Test {
    Odwolanie [] tab;
    int rozmiar = 2000;
    int ram = 7; //liczba ramek
    int s = 10;  //liczba stron

    public static void main(String[] args) {
        Test t = new Test();
        t.generuj();
        FIFO f = new FIFO();
        f.algorytm(t.tab, t.ram, t.s);
        RAND rand = new RAND();
        rand.algorytm(t.tab, t.ram);
        LRU l = new LRU();
        l.algorytm(t.tab, t.ram, t.s);
        ALRU a = new ALRU();
        a.algorytm(t.tab, t.ram, t.s);
        OPT o = new OPT();
        o.algorytm(t.tab, t.ram, t.s, t.rozmiar);
    }
    public void generuj(){
        tab = new Odwolanie[rozmiar];
        int str = 0;
        for (int i = 0; i < rozmiar; i++) {
            Random r = new Random(); //prawdopodobieństwo
            int a = r.nextInt(15);
            if (a<=11){ //do kolejnej
                int strona = str+1;
                strona %= s;
                str = strona;
                Odwolanie o = new Odwolanie( strona );
                tab[i] = o;
            }
            else if (a<=13){ //do dalszej

                int strona = str+4;
                strona %= s;
                str = strona;
                Odwolanie o = new Odwolanie( strona );
                tab[i] = o;
            }
            else { // do losowej
                Random r3 = new Random();
                int strona = r3.nextInt(s);
                Odwolanie o = new Odwolanie(strona );
                tab[i] = o;
            }
        }
    }

}
