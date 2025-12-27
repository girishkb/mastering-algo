package coursera.week2;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationSame {


    public boolean sameSorting(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public boolean sameHashing(int[] a, int[] b) {

        if (a.length != b.length) return  false;

        HashMap<Integer,Integer> numFreq =  new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            numFreq.merge(a[i], 1, Integer::sum);
        }
        for (int i = 0; i < b.length; i++) {
            Integer val = numFreq.get(a[i]);
            boolean b1 = val != null;
            if(b1){
                numFreq.put(a[i],val-1);
            } else{
                return false;
            }
        }

        for (Integer value: numFreq.values()) {
            if (value != 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {

        int[] a ={2,5,1,21,30,11,2};
        int[] b ={2,11,30,21,1,5,2};
        PermutationSame ps = new PermutationSame();

        System.out.println("Sorting :::: are A and B same? " + ps.sameSorting(a,b));
        System.out.println("Hashing::::: are A and B same? " + ps.sameHashing(a,b));

    }
}
