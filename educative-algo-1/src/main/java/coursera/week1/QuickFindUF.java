package coursera.week1;

import java.io.IOException;
import java.util.Scanner;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N){
        this.id = new int[N];
        for(int i = 0; i < N; i++){
            this.id[i] = i;
        }
    }
    public boolean connected(int p, int q){
        return  id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i=0; i< id.length;i++){
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main( String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Read the array size
        int n = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(n);

        sc.nextLine(); // consume the leftover newline after n

        while (true) {
            if (!sc.hasNextLine()) break;        // no more input
            String line = sc.nextLine().trim();

            if (line.isEmpty()) break;           // stop on empty line

            String[] parts = line.split("\\s+");
            int p = Integer.parseInt(parts[0]);
            int q = Integer.parseInt(parts[1]);

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + "  " + q);
            }
        }

    }
}
