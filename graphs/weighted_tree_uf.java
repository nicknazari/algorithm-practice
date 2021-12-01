public class weighted_tree_uf {
   static int n = 8;
   static int count = n;
   static int[] id = new int[n];
   static int[] sz = new int[n];

   public static int find(int p) {
      while (p != id[p]) p = id[p];
      return p;
   }

   public static void union(int p, int q) {
      int i = find(p);
      int j = find(q);
      if (i == j) return;
      if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
      else { id[j] = i; sz[i] += sz[j]; }
      count --;
   }
   public static void main(String[] args) {

      for (int i = 0; i < n; i ++) {
         id[i] = i; sz[i] = 1; 
      }
      union(2,0);
      union(7,4);
      union(1,2);
      union(1, 3); 
      union(4, 5);
      union(5, 7);
      union(5, 3);

      System.out.println(find(0));


   
   }
}