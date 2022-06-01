import java.util.Comparator;

public class Priorytet implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        return Double.compare(t1.getPriority(), t2.getPriority());
    }
}
