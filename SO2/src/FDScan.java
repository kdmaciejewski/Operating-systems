import java.util.ArrayList;

public class FDScan {
    public static void algorytm() {
        int punkt = 40;
        int kierunek = 1;
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
            Task pomoc = tasks.get(0);

            if (pomoc.getPosition() >= punkt)
                kierunek = 1;
            else if (pomoc.getPosition() < punkt)
                kierunek = -1;

            Task task = tasks.get(0);
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                int obecny = (t.getPosition() - punkt) * kierunek;

                if (obecny < min && obecny >= 0) {
                    min = obecny;
                    task = t;
                }
            }

            tasks.remove(task);
            suma += task.oblicz(punkt);
            punkt = task.getPosition();
        }

        System.out.println("Suma przemieszczeń FD-SCAN = " + suma);
    }
}
