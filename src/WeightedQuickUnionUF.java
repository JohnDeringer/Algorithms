/****************************************************************************
 *  Compilation:  javac WeightedQuickUnionUF.java
 *  Execution:  java WeightedQuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Weighted quick-union (without path compression).
 *
 ****************************************************************************/

import java.util.Random;

public class WeightedQuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    // Create an empty union find data structure with N isolated sets.
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        
    }
    
    private static int getSeed() {
        Random r = new Random();
        return r.nextInt(10);
    }
/*    
    private int[] getSeeds(int[] indexes) {
        byte[] seeds = new byte[10];
        java.util.Random r = new Random();
        r.nextBytes(seeds);
        System.out.println("Seeds size [" + seeds.length + "]"); 
        System.out.println("indexes size [" + indexes.length + "]");
                           
        for (int i = 0; i < seeds.length; i++) {
            System.out.println("Setting index [" + i + "] with value [" + seeds[i] + "]");
            indexes[i] = seeds[i];
        }
                        
        return indexes;
    }
*/
    // Return the number of disjoint sets.
    public int count() {
        return count;
    }

    // Return component identifier for component containing p (find the root)
    public int find(int p) {
        int i = 0;
        while (p != id[p]) {
            p = id[p];
            i++;
        }
        System.out.println("Tree depth [" + i + "]");
        return p;
    }

	public int findValue(int index) {
		return id[index];
	}
	
   // Are objects p and q in the same set?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
   // Replace sets containing p and q with their union.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        // make smaller root point to larger one
        if (sz[i] < sz[j]) { 
            System.out.println("Ponting smaller p [" + id[i] + "] at q [" + j + "]");
            id[i] = j; 
            sz[j] += sz[i]; 
            System.out.println("Setting q [" + id[i] + "] root size to [" + sz[j] + "]");
        } else { 
            System.out.println("Pointing smaller q [" + id[j] + "] at p [" + i + "]");
            id[j] = i; 
            sz[i] += sz[j]; 
            System.out.println("Setting p [" + id[i] + "] root size to [" + sz[i] + "]");
        }
        count--;
    }


    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		//WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        // read in a sequence of pairs of integers (each in the range 0 to N-1),
         // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        StdOut.println("=== BEGIN PROCESS ===");
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            // Overrride with random
            //p = getSeed();
            int q = StdIn.readInt();
            // Overrride with random
            //q = getSeed();
            
            System.out.println("Reading values p [" + p + "] q [" + q + "]");
            if (uf.connected(p, q)) {
                System.out.println("p [" + p + "] q [" + q + "] connected [" + uf.connected(p, q) + "]");
                continue;
            }
            
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

