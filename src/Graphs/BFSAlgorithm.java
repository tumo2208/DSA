package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSAlgorithm {
    private List<Integer> result;               //List các đỉnh được sắp xếp theo BFS
    private boolean[] marked;                   //List bool xác định xem 1 đỉnh đã được thăm hay chưa
    private Queue<Integer> queue;               //Queue lưu các đỉnh liền kề với các đỉnh đã được thăm

    public BFSAlgorithm(Graph graph, int v) {
        result = new ArrayList<>();
        marked = new boolean[graph.V()];
        queue = new ArrayDeque<>();

        BFS(graph, v);
    }

    //Xây dựng thuật toán BFS
    private void BFS(Graph graph, int v) {
        marked[v] = true;
        queue.add(v);

        //Nếu queue chưa rỗng (BFS vẫn chưa duyệt hết các đỉnh)
        //Duyệt đỉnh đầu tiên được thêm vào queue
        while (!queue.isEmpty()) {
            int index = queue.remove();
            result.add(index);

            //Xét các đỉnh liền kề với đỉnh vừa được duyệt
            for (Edge edge : graph.adj(index)) {
                int w = edge.other(index);

                //Nếu đỉnh đó chưa được duyệt, thêm đỉnh đó vào queue và đánh dấu là đã thăm
                if (!marked[w]) {
                    marked[w] = true;
                    queue.add(w);
                }
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
