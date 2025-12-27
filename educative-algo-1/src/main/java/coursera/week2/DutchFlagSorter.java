package coursera.week2;

public class DutchFlagSorter {

    public void sort(DutchFlag flag, int n) {
        int lo = 0, hi = n-1, mid = 0;
        while( mid <= hi) {
            if(flag.color(mid) == 0){
                flag.swap(mid,lo);
                lo++;
                mid++;
            } else if (flag.color(mid) == 1) {
                mid++;
            }else{
                flag.swap(mid,hi);
                hi--;
            }
        }

    }

    public static void main(String[] args) {
        DutchFlag flag = new DutchFlag(10);
        DutchFlagSorter ds  =new DutchFlagSorter();
        ds.sort(flag,10);

    }
}
