public class Odwolanie {

    int strona;
    int czas; //czas przebywania w ramce
    int ostatnieOdw;
    boolean bit;

    public Odwolanie(int strona) {
        this.strona = strona;
        this.bit = false;
        this.czas = 0;
        this.ostatnieOdw = 0;
    }

    public int getStrona() {
        return strona;
    }

    public void setStrona(int strona) {
        this.strona = strona;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public boolean isBit() {
        return bit;
    }

    public void setBit(boolean bit) {
        this.bit = bit;
    }

    public int getOstatnieOdw() {
        return ostatnieOdw;
    }

    public void setOstatnieOdw(int ostatnieOdw) {
        this.ostatnieOdw = ostatnieOdw;
    }
}
