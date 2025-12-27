package coursera.week2;

import java.util.Random;

public class DutchFlag {
    int [] buckets;

    DutchFlag(int N ) {
        this.buckets = new int[N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            buckets[i] = r.nextInt(3);
        }
    }

    public  void swap(int i, int j){
         int tmp = buckets[i];
         buckets[i] = buckets[j];
         buckets[j] = tmp;
    }

    public int color(int i) {
        return  buckets[i];
    }
}
