public UF( int n) {
   count = n;
   id = new int[n];
   sz = new int[n];
   for (int i = 0; i < n; i ++) { id[i] = i; sz[i] = 1; }
}
public int find ( int p) {
   while (p != id[p]) p = id[p];
   return p;
}
public void union (int p, int q) {
   int i = find (p), j = find (q);
   if (i == j) return ;
   if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
   else { id[j] = i; sz[i] += sz[j]; }
   count --;
}
