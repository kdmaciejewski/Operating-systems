public class SSTF {
//punkt to miejsce w którym zaczynamy, potem punkt staje sie adresem wykonanego procesu

    public static void algorytm(int tab[], int punkt)
    {
        if (tab.length == 0){
            return;
        }
        Proces roznica[] = new Proces[tab.length]; //tablica procesów

        for (int i = 0; i < roznica.length; i++){
            roznica[i] = new Proces();
        }
        int przemieszczenie = 0; //kryterium oceny przemieszczenie

        for (int i = 0; i < tab.length; i++) {

            jakaOdleglosc(tab, punkt, roznica); //podana tablica
            int index = minOdl(roznica);

            roznica[index].wykonany = true;

            przemieszczenie += roznica[index].odleglosc; //zwiększam przemieszczenie o najkrótszą odległość
            punkt = tab[index]; //zmieniam punkt na adres dokonanego procesu
        }
        System.out.println("Suma przemieszczeń SSTF = " + przemieszczenie);
    }

    public static void jakaOdleglosc(int procesy[], int punkt, Proces roznica[])
    //odległość adresu od punktu
    {
        for (int i = 0; i < roznica.length; i++)
            roznica[i].odleglosc = Math.abs(procesy[i] - punkt);
    }

    public static int minOdl(Proces roznica[]) //minimalna odległość niewykonanego procesu od punktu
    {
        int index = -1;
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < roznica.length; i++) {
            if (!roznica[i].wykonany && minimum > roznica[i].odleglosc) {
//jeśli nie został wykonany i odl jest mniejsza od minimum
                minimum = roznica[i].odleglosc;
                index = i;
            }
        }
        return index;
    }
}