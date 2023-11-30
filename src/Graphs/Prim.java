package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    private List<Edge> result;               //List các cạnh của cây bao trùm nhỏ nhất theo thuật toán kruskal
    private boolean[] marked;                //List bool xác định xem 1 đỉnh đã được thăm hay chưa
    private PriorityQueue<Edge> pq;          //Queue lưu các cạnh có thể thêm vào cây khung


    //Xây dựng thuật toán Prim
    public Prim(Graph graph) {
        pq = new PriorityQueue<>();
        marked = new boolean[graph.V()];
        result = new ArrayList<>();

        //Xuất phát từ đỉnh A
        visit(graph, 0);

        ////Nếu cây bao trùm chưa đủ số cạnh (số cạnh = số đỉnh - 1) thì duyệt
        while (!pq.isEmpty() && result.size() < graph.V() - 1) {
            Edge edge = pq.remove();                //Lấy ra cạnh có trọng số nhỏ nhất trong priority queue
            int v = edge.either();
            int w = edge.other(v);

            //Nếu 1 trong 2 đỉnh của cạnh đó chx đc thăm (đỉnh đó chx tồn tại trong cây khung nhỏ nhất)
            if (!marked[v] || !marked[w]) {
                result.add(edge);                   //Thêm cạnh đó vào cây khung
                if (!marked[v]) visit(graph, v);    //Thăm đỉnh còn lại của cạnh đó
                else visit(graph, w);
            }
        }
    }

    //Thăm 1 đỉnh của đồ thị
    private void visit(Graph graph, int v) {
        marked[v] = true;                       //Set đỉnh đó là đã thăm

        //Thêm các cạnh của đỉnh đó vào priority queue nếu đỉnh còn lại của cạnh đó chx đc thăm
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)])
                pq.add(edge);
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
