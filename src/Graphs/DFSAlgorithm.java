package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSAlgorithm {
    private List<Integer> result;           //List các đỉnh được sắp xếp theo DFS
    private boolean[] marked;               //List bool xác định xem 1 đỉnh đã được thăm hay chưa
    private Stack<Integer> st;              //Stack lưu các đỉnh liền kề với các đỉnh đã được thăm

    public DFSAlgorithm(Graph graph, int v) {
        result = new ArrayList<>();
        marked = new boolean[graph.V()];
        st = new Stack<>();
        DFS(graph, v);
    }

    //Xây dựng thuật toán DFS
    private void DFS(Graph graph, int v) {
        marked[v] = true;
        result.add(v);

        //Thêm các đỉnh liền kề với đỉnh vừa được thăm vào stack
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)] && !st.contains(edge.other(v)))
                st.push(edge.other(v));
        }

        //Nếu stack vẫn chưa rỗng (dfs chưa duyệt qua tất cả các đỉnh)
        //Duyệt đỉnh được thêm vào stack gần nhất
        while (!st.isEmpty()) {
            int index = st.pop();
            if (!marked[index]) {
                marked[index] = true;
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
