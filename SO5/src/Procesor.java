import java.util.ArrayList;

public class Procesor {
    int obciazenie;
    ArrayList<Proces> zadania;
    ArrayList<Proces> obecne; // obecnie wykonywane zadania

    public Procesor() {

        this.zadania = new ArrayList<>();
        this.obecne = new ArrayList<>();
        this.obciazenie = obecne.size();
    }

    public int getObciazenie() {
        return obciazenie;
    }

    public void setObciazenie(int obciazenie) {
        this.obciazenie = obciazenie;
    }

    public ArrayList<Proces> getZadania() {
        return zadania;
    }

    public void setZadania(ArrayList<Proces> zadania) {
        this.zadania = zadania;
    }
}
