public class Main {

    public static void main(String[] args) {
        FCFS f = new FCFS();
        f.pracuj2();

        int tab[] = { 80, 2, 45, 60, 159, 7, 41, 114 };

        SSTF.algorytm(tab, 40);
        Scan2.algorytm(tab);
        CScan.algorytm(tab);
        EDF.algorytm();
        FDScan.algorytm();

    }
}
