package DynamicConnectivity;

public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }

    private int find(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int v, int w) {
        return (find(v) == find(w));
    }

    public void union(int v, int w) {
        int i = find(v);
        int j = find(w);
        id[i] = j;
    }

}
