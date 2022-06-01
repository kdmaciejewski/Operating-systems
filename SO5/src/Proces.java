import java.util.Random;

public class Proces {
    int obciazenie;
    int czasWykonania;
    int czasDodania;
    public Proces() {
        Random r = new Random();
        this.obciazenie = r.nextInt(4)+ 2;  // maksymalne obciążenie procesora to 5
        Random r2 = new Random();
        this.czasWykonania = r2.nextInt(8)+1;
    }
}
