package Graphs;

import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    private int index;
    private double weight;

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
    private double[] shortestPath;
    private PriorityQueue<Pair> pq;

    public Dijkstra(Graph graph, int s) {
        shortestPath = new double[graph.V()];
        pq = new PriorityQueue<>(graph.V());

        for (int i = 0; i < graph.V(); ++i) {
            shortestPath[i] = Double.POSITIVE_INFINITY;
        }

        shortestPath[s] = 0.0;
        pq.add(new Pair(s, shortestPath[s]));

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int v = p.getIndex();
            for(Edge e : graph.adj(v)) {
                relax(e, v);
            }
        }
    }

    private void relax(Edge e, int v) {
        int  w = e.other(v);
        if (shortestPath[w] > shortestPath[v] + e.getWeight()) {
            shortestPath[w] = shortestPath[v] + e.getWeight();
            for (Pair pair : pq) {
                if (pair.getIndex() == w) {
                    pq.remove(pair);
                    break;
                }
            }
            pq.add(new Pair(w, shortestPath[w]));
        }
    }

    public double shortestPath(int w) {
        return shortestPath[w];
    }
}