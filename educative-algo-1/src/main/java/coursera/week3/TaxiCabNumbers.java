package coursera.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Taxicab numbers. A taxicab number is an integer that can be expressed as the sum of two cubes of positive integers in two different ways:
 a^3 + b^3 = c^3+d^3
 For example,
1729
1729 is the smallest taxicab number:
9^3 + 10^3 = 1^3+12^3
Design an algorithm to find all  taxicab numbers less than
n.


*/
public class TaxiCabNumbers {

    private static class  Pair{
        long sum;
        int a, b;

        Pair(long sum, int a, int b){
            this.sum = sum;
            this.a = a;
            this.b = b;
        }
    }

    // Version 1:  time proportional: n^2 log n ,  space ::: O(n^2)
    public void findAll(int N) {
        List<Pair> candidates = new ArrayList<>();
        int limit = (int) Math.cbrt(N);
        for (int a = 1 ; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                long sum  = (long) a *a*a + (long) b*b*b;
                candidates.add(new Pair(sum, a, b));
            }
        }
        candidates.sort(Comparator.comparingLong(p -> p.sum));
        for (int i  = 1 ; i < candidates.size(); i++) {
            if(candidates.get(i).sum == candidates.get(i-1).sum) {
                Pair p1 = candidates.get(i);
                Pair p2 = candidates.get(i-1);
                System.out.println(
                        p1.sum + " = " +
                                p1.a + "^3 + " + p1.b + "^3 = " +
                                p2.a + "^3 + " + p2.b + "^3"
                );
            }
        }
    }

    // Version 1:  time proportional: n^2 log n ,  space ::: O(n)
    public void findAllEfficient(int N) {

    }
}
