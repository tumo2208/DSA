package Graphs;

import java.util.*;

public class DFSAlgorithm {
    private List<Integer> result;           //List các đỉnh được sắp xếp theo DFS
    private boolean[] marked;               //List bool xác định xem 1 đỉnh đã được thăm hay chưa

    public DFSAlgorithm(Graph graph, int v) {
        result = new ArrayList<>();
        marked = new boolean[graph.V()];
        DFS(graph, v);
    }

    //Xây dựng thuật toán DFS
    private void DFS(Graph graph, int v) {
        marked[v] = true;
        result.add(v);

        //Thêm các đỉnh liền kề với đỉnh vừa được thăm vào stack
        Iterator<Edge> ite = graph.adj(v).listIterator();

        //Nếu stack vẫn chưa rỗng (dfs chưa duyệt qua tất cả các đỉnh)
        //Duyệt đỉnh được thêm vào stack gần nhất
        while (ite.hasNext()) {
            int index = ite.next().other(v);
            if (!marked[index]) {
                DFS(graph, index);
            }
        }
    }

    //Trả về danh sách các đỉnh sắp xếp theo DFS
    public List<Integer> getResult() {
        for (int i : result) {
            System.out.print(i + " ");
        }
        return result;
    }
}
