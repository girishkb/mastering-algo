package coursera.week1;

public class Building{
    int N;  // N story building
    private final int T;   // Tth floor. where the egg breaks or higher and doesn't break otherwise

    public Building(int n, int t) {
        if (t > n){
            throw new IllegalArgumentException(" n should be larger thant t");
        }
        this.N = n;
        this.T = t;
    }

    public int floors(){
        return  N;
    }
    public int getT() {
        return  T;
    }
    public boolean drop(int floor) {
        return  floor >= T;
    }

}

