import java.io.IOException;
//    int atime;  //arrival
//    int btime; //burst ile się ten jeden proces wykonuje
//    int ctime; //computing // burst[i] + burst[i-1] itd
public class Main {
    public static void main(String[] args) throws IOException {
        FCFS f = new FCFS();
//        f.zapis();
//
//        f.sortowanieA();
//        f.obliczanieC();
//
//        f.obliczanieWaits();
//        f.wyswietl();
//        f.srednia();
        SJF s = new SJF();
        s.start();
        s.przetwarzanie();
        Rotacyjny r = new Rotacyjny();
//        r.start();
//        r.przetwarzanieproste();
        SJFmati sm = new SJFmati();
        int [] tab = {4,12,2,1,45,5,29};
        sm.test(tab);
    }
}
