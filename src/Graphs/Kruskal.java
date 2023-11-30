package Graphs;

import DynamicConnectivity.QuickUnionUF;

import java.util.*;

public class Kruskal {

    private List<Edge> result = new ArrayList<>();      //List các cạnh của cây bao trùm nhỏ nhất theo thuật toán kruskal

    //xây dựng thuật toán kruskal
    public Kruskal(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();     //Queue lưu các cạnh của đồ thị
        pq.addAll(graph.edges());
        QuickUnionUF uf = new QuickUnionUF(graph.V());      //UnionFind để xác định tính liên thông giữa các đỉnh trong cây bao trùm

        //Nếu cây bao trùm chưa đủ số cạnh (số cạnh = số đỉnh - 1) thì duyệt
        while (!pq.isEmpty() && result.size() < graph.V() - 1) {
            Edge edge = pq.remove();        //Lấy ra cạnh có trọng số nhỏ nhất
            int v = edge.either();
            int w = edge.other(v);

            //Nếu 2 đỉnh của cạnh đó chx liên thông trong cây bao trùm, thêm cạnh đó vào cây
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                result.add(edge);
            }
        }
    }

    //Trả về list các cạnh của cây bao trùm nhỏ nhất
    public List<Edge> getResult() {
        return result;
    }

    //Trả về tổng trọng số của cây bao trùm nhỏ nhất
    public double mst() {
        double mst = 0.d;
        for (Edge edge : result) {
            mst += edge.getWeight();
        }
        return mst;
    }
}
