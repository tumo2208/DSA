package Graphs;

import java.util.PriorityQueue;
import PriorityQueue.IndexMinPQ;

public class Dijkstra {
    private double[] shortesPath;
    private IndexMinPQ<Double> pq;

    public Dijkstra(Graph graph, int s) {
        shortesPath = new double[graph.V()];
        pq = new IndexMinPQ<>(graph.V());

        for (int i = 0; i < graph.V(); ++i) {
            shortesPath[i] = Double.MAX_VALUE;
        }
        shortesPath[s] = 0.d;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge edge : graph.adj(v)) {
                relax(edge);
            }
        }
    }

    private void relax(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        if (shortesPath[w] > shortesPath[v] + edge.getWeight()) {
            shortesPath[w] = shortesPath[v] + edge.getWeight();
            if (pq.contains(w)) pq.decreaseKey(w, shortesPath[w]);
            else pq.insert(w, shortesPath[w]);
        }
    }

    public double shortestPath(int w) {
        return shortesPath[w];
    }
}
