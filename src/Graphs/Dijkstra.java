package Graphs;

import java.util.PriorityQueue;

// PriorityQueue có index
class Pair implements Comparable<Pair> {
    private int index;                      // index
    private double weight;                  // value

    public Pair(int index, double weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return this.index;
    }

    public int compareTo(Pair pair) {
        if (this.index != pair.getIndex()) {
            return Double.compare(this.weight, pair.weight);
        } else {
            return Integer.compare(this.index, pair.getIndex());
        }
    }

}


public class Dijkstra {
    private double[] shortestPath;              // Mảng lưu đường đi ngắn nhất từ 1 đỉnh đến các đỉnh còn lại
    private PriorityQueue<Pair> pq;             // PriorityQueue lưu các giá trị khi xét qua mỗi đỉnh

    public Dijkstra(Graph graph, int s) {
        shortestPath = new double[graph.V()];
        pq = new PriorityQueue<>(graph.V());

        for (int i = 0; i < graph.V(); ++i) {
            shortestPath[i] = Double.POSITIVE_INFINITY;
        }

        // Bắt đầu đi từ đỉnh s
        shortestPath[s] = 0.0;
        pq.add(new Pair(s, shortestPath[s]));

        // Khi pq chx rỗng, lấy ra giá trị nhỏ nhất của pq và duyệt các đỉnh liền kề với nó
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int v = p.getIndex();
            for(Edge e : graph.adj(v)) {
                relax(e, v);
            }
        }
    }

    // Duyệt các đỉnh liền kề
    private void relax(Edge e, int v) {
        int  w = e.other(v);        // w là đỉnh liền kề với v

        // Nếu đường đi từ s - w hiện tại có giá trị lớn hơn đường đi từ s - v công với cạnh vw
        if (shortestPath[w] > shortestPath[v] + e.getWeight()) {
            shortestPath[w] = shortestPath[v] + e.getWeight();          // Thay đổi giá trị đường đi từ s - w
            for (Pair pair : pq) {
                if (pair.getIndex() == w) {
                    pq.remove(pair);
                    break;
                }
            }
            pq.add(new Pair(w, shortestPath[w]));                       // Thêm giá trị đó vào pq và xóa giá trị trc đó của đỉnh w
        }
    }

    // Lấy ra trọng số của đường đi ngắn nhất từ đỉnh s - w
    public double shortestPath(int w) {
        return shortestPath[w];
    }
}