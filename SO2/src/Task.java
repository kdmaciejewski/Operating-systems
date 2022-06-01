import java.util.Objects;

public class Task {
    private int position;
    private int priority;

    public Task( int position, int priority) {
        this.position = position;
        this.priority = priority;
    }

    public int oblicz(int obecna) {
        return Math.abs(obecna - position);
    }

    public int getPosition() {
        return position;
    }

    public int getPriority() {
        return priority;
    }

}
