import java.util.Random;

public class SJFwozniak {
    private Proces[] procesy;
    private int dlugoscCiagu;
    private static int tick=0;
    private static final int szansa = 6;
    private Random rand = new Random();

    SJFwozniak(int dlugosc){
        dlugoscCiagu=dlugosc;
        procesy = new Proces[dlugoscCiagu];
        while(nieukonczone())
            krok(tick);
    }

    public void krok(int tick) {

        if(rand.nextInt(11)<=szansa) {
            if(czyPelna()==false)
                dodaj(new Proces(tick));
        }
        operacja();
    }

    public void przesun(int a) {
        for(int i=dlugoscCiagu-1;i>a;i--)
            procesy[i]=procesy[i-1];
    }

    public boolean czyPelna() {
        if(procesy[dlugoscCiagu-1]==null)
            return false;
        return true;
    }

    public void dodaj(Proces a) {
        for(int i=0; i<dlugoscCiagu; i++) {
            if(procesy[i]==null) {
                procesy[i]=a;
                break;
            }
            if(procesy[i].dlugosc-procesy[i].czas>a.dlugosc) {
                if(procesy[i].czas>0) {
                    przesun(i+1);
                    procesy[i+1]=a;
                }
                else {
                    przesun(i+1);
                    procesy[i+1]=a;
                }
                break;
            }
        }
    }

    public void operacja() {
        for(int i=0; i<dlugoscCiagu; i++) {
            if(procesy[i]==null)
                break;
            if(procesy[i].ukonczony==false) {
                if(++procesy[i].czas==procesy[i].dlugosc) {
                    procesy[i].ukonczony=true;
                    procesy[i].koniec=tick-procesy[i].zgloszenie;
                }
                break;
            }
        }
        tick++;
    }

    public boolean nieukonczone() {
        for(int i=0; i<dlugoscCiagu;i++) {
            if(procesy[i]==null)
                return true;
            if(procesy[i].ukonczony==false)
                return true;
        }
        return false;
    }

    public void wypisz() {
        for(Proces a: procesy)
            System.out.println(a);
    }
}
