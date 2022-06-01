import java.util.Collections;
import java.util.Comparator;

public class FCFS extends Algorytm{
    AComparator acomp = new AComparator();

    class AComparator implements Comparator<Proces> {
        @Override
        public int compare(Proces o1, Proces o2) {
            return Integer.compare(o1.getAtime(), o2.getAtime());
        }
    }
    public void sortowanieA(){
        Collections.sort(lista, acomp);
    }
}
