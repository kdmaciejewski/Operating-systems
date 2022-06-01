import java.util.ArrayList;

public class EDF {

    public static void algorytm() {
        int punkt = 40;
        int suma = 0;
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task(80, 20));
        tasks.add(new Task(2, 12));
        tasks.add(new Task(45, 78));
        tasks.add(new Task(60, 11));
        tasks.add(new Task(159,34 ));
        tasks.add(new Task(7, 2));
        tasks.add(new Task(41, 56));
        tasks.add(new Task(114, 76));

        while (tasks.size() > 0) {
            tasks.sort(new Priorytet());
            Task task = tasks.get(0);
            tasks.remove(task);
            suma += task.oblicz(punkt);
            punkt = task.getPosition();
        }

        System.out.println("Suma przemieszczeń EDF = " + suma);
    }
}
