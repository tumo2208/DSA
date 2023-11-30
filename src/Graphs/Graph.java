package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int v;                  //Số đỉnh
    private List<List<Edge>> adj;   //List cạnh của mỗi đỉnh

    //Tạo 1 graph mới gồm v đỉnh
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    //Trả về số đỉnh của graph
    public int V() {
        return this.v;
    }

    //Trả về list tất cả các cạnh của graph
    public List<Edge> edges() {
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < v; ++i) {
            for (Edge edge : adj.get(i)) {
                if (edge.other(i) > i) {
                    res.add(edge);
                }
            }
        }
        return res;
    }

    //Trả về list các cạnh bắt đầu từ đỉnh v
    public List<Edge> adj(int v) {
        return this.adj.get(v);
    }

    //Thêm 1 cạnh mới vào graph
    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        List<Edge> edgeV = new ArrayList<>(adj.get(v));
        List<Edge> edgeW = new ArrayList<>(adj.get(w));
        edgeV.add(edge);
        edgeW.add(edge);
        adj.set(v, edgeV);
        adj.set(w, edgeW);
    }
}
