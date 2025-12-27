package coursera.week3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DynamicMedian {

     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); // left  elements
     PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder()); // right elements

    public void insert(int e){
        if (maxHeap.isEmpty() || e <= maxHeap.peek()){
            maxHeap.offer(e);
        }else{
            minHeap.offer(e);
        }
        balance();
    }

    public void balance(){
        if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        } else if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
    }

    public Integer find(){
        if (maxHeap.isEmpty()){
            throw new IllegalArgumentException("No elements");
        }
        return maxHeap.peek();
    }

    public int remove(){
        if (maxHeap.isEmpty()){
            throw new IllegalArgumentException("No elements");
        }
        int median = maxHeap.poll();
        balance();
        return  median;
    }

    public static void main(String[] args) {
        DynamicMedian dm = new DynamicMedian();
        dm.insert(5);
        dm.insert(2);
        dm.insert(8);
        dm.insert(3);

        System.out.println("Median: " + dm.find()); // 5
        System.out.println("Removed: " + dm.remove()); // 5
        System.out.println("Median now: " + dm.find()); // 3

    }
}
