public class Proces {
    int numer;
    int atime;
    int btime;
    int ctime;
    int waits;

    public Proces(int numer, int atime, int btime, int ctime, int waits) {
        this.numer = numer;
        this.atime = atime;
        this.btime = btime;
        this.ctime = ctime;
        this.waits = waits;
    }

    @Override
    public String toString() {
        return "Proces{" +
                "numer=" + numer +
                ", atime=" + atime +
                ", btime=" + btime +
                ", ctime=" + ctime + ", waits=" + waits +
                '}';
    }
    public int zwiekszA(){
        return ++atime;
    }
    public int zmniejszA(){
        return --atime;
    }
    public int zmniejszB(){
        return --btime;
    }
    public int zmniejszC(){
        return --ctime;
    }
    public int zwiekszWaits(){
        return ++waits;
    }
    public boolean wykonany(){
        if (btime == 0){
            return true;
        }
        else return false;
    }
    /////////////////////////GETERY

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getAtime() {
        return atime;
    }

    public void setAtime(int atime) {
        this.atime = atime;
    }

    public int getBtime() {
        return btime;
    }

    public void setBtime(int btime) {
        this.btime = btime;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public int getWaits() {
        return waits;
    }

    public void setWaits(int waits) {
        this.waits = waits;
    }
}

