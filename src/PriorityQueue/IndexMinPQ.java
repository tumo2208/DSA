package PriorityQueue;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private int n;
    private int[] pq;
    private int[] qp;
    private Key[] keys;


    public IndexMinPQ(int maxN) {
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        keys = (Key[]) new Comparable[maxN + 1];

        for (int i = 0; i <= maxN; ++i) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return (n == 0);
    }

    public boolean contains(int i) {
        return (qp[i] != -1);
    }

    public int size() {
        return n;
    }

    public void insert(int i, Key key) {
        if (!contains(i)) {
            n++;
            qp[i] = n;
            pq[n] = i;
            keys[i] = key;
            swim(n);
        }
    }

    public void changeKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public void decreaseKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
    }

    public void increaseKey(int i, Key key) {
        keys[i] = key;
        sink(qp[i]);
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public int delMin() {
        int min = pq[1];
        swap(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[n+1] = -1;        // not needed
        return min;
    }


    private void swim(int k) {
        while ((k > 1) && (keys[pq[k/2]].compareTo(keys[pq[k]]) > 0)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && (keys[pq[j]].compareTo(keys[pq[j+1]]) > 0)) j++;
            if (keys[pq[j]].compareTo(keys[pq[j+1]]) <= 0) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

}
