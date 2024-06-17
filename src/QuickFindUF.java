/****************************************************************************
 *  Compilation:  javac QuickFindUF.java
 *  Execution:  java QuickFindUF < quickFind.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-find algorithm.
 *
 ****************************************************************************/

public class QuickFindUF {
    private int[] id;
    private int count;

    // instantiate N isolated components 0 through N-1
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
/*    
    private int getSeed(int index) {
        int[] seeds = {4,4,3,2,9,3};
        int seed = index;
        if (index < seeds.length) {
            seed = seeds[index];
        }
        
        return seed;
    }
*/
    // return number of connected components
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        return id[p];
    }
    
    public int findValue(int index) {
		return id[index];
	}

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        boolean connected = false;
        if (id[p] == id[q]) {
            connected = true;
        }
        
        //System.out.println("p [" + p + "] q [" + q + "] connected [" + connected + "]");
        return connected;
    }

    // merge components containing p and q
    public void union(int p, int q) {
        System.out.println("Union p [" + p + "] q [" + q + "]");
        if (connected(p, q)) return;
        int pid = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) { 
                id[i] = id[q]; 
                System.out.println("Setting p index [" + i + "] to value [" + id[q] + "]");
            }
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
         // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            System.out.println("Reading values p [" + p + "] q [" + q + "]");
            uf.union(p, q);
        }
        
        StdOut.println("=== FINAL ARRAY CONTENTS ===");
        StdOut.println(uf.count() + " components");
        
        for (int i = 0; i < 10; i++) {
			System.out.print(uf.findValue(i) + " ");
		}
        System.out.println("");
        
    }

}

