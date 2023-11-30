package PriorityQueue;
//All methods of PriorityQueue
/*
    //remove(): return the head of pq and remove this
    //remove(Object o): remove o from pq
    //add(E e): add e to PriorityQueue<E>
    //size(): return size of pq
    //clear(): remove all elements of pq
    //peek(): return the head of pq
    //toArray(): return a array E[]
*/

//All methods of Stack
/*
    //push(E e): add e to the end of Stack
    //peek(): return the end of stack
    //pop(): return the end of stack and remove this
    //isEmpty(): return true if stack is Empty and otherwise
    //search(Object o): return the position of o if it is in stack
*/

public class MaxPQ {
    private int[] pq;
    private int n;

    public MaxPQ(int maxN) {
        pq = new int[maxN + 1];
    }

    public boolean isEmpty() {
        return (n == 0);
    }

    public void insert(int key) {
        pq[++n] = key;
        swim(n);
    }

    public int maxKey() {
        return pq[1];
    }

    public int delMax() {
        int _max = pq[1];
        swap(1, n--);
        sink(1);
        return _max;
    }

    public void printf() {
        for (int i : pq) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && pq[k] > pq[k/2]) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && pq[j] < pq[j+1])
                j++;
            if (pq[k] > pq[j]) break;
            swap(k, j);
            k = j;
        }
    }
}
