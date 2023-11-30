package DynamicConnectivity;

public class QuickFindUF {

    private int id[];

    public QuickFindUF(int n)  {
        id = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];
        for (int i = 0; i < id.length; ++i) {
            if (id[i] == pId) id[i] = qId;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return (find(p) == find(q));
    }
}
