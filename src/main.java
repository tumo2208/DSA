import java.util.*;

import Graphs.*;
import Sort.*;
import PriorityQueue.*;
import DynamicConnectivity.*;
import Tree.BST;

public class main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        /*int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(sc.nextInt());
        }

        //Chua sort
        System.out.println("Chua sort:");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();*/

        //Selection Sort
        /*SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println("Selection Sort");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();*/

        //Insertion Sort
        /*InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        System.out.println("Insertion Sort");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();*/

        //Bubble Sort
        /*BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println("Bubble Sort");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();*/

        //Merge Sort
        /*MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println("Merge Sort");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();*/

        //Quick Sort
        /*QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        System.out.println("Quick Sort");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();*/

        /*MaxPQ maxPQ = new UnorderedMaxPQ(9);
        maxPQ.insert(2);
        maxPQ.insert(7);
        maxPQ.insert(8);
        maxPQ.insert(1);
        maxPQ.insert(9);
        maxPQ.insert(5);
        maxPQ.insert(3);
        maxPQ.insert(6);
        maxPQ.insert(4);

        System.out.println(unorderedMaxPQ.isEmpty());
        System.out.println(unorderedMaxPQ.delMax());
        unorderedMaxPQ.printf();*/

        /*QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);
        uf.printList();
        System.out.println(uf.connected(3, 4));*/

        BST tree = new BST();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        /*tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(25);
        tree.insert(24);

        // Print inorder traversal of the BST
        //tree.inorder();
        tree.delete(20);
        tree.inorder();*/

        Graph graph = new Graph(11);
        graph.addEdge(new Edge(0, 1, 7));
        graph.addEdge(new Edge(0, 2, 6));
        graph.addEdge(new Edge(0, 3, 9));
        graph.addEdge(new Edge(1, 2, 2));
        graph.addEdge(new Edge(1, 4, 5));
        graph.addEdge(new Edge(1, 5, 10));
        graph.addEdge(new Edge(2, 3, 12));
        graph.addEdge(new Edge(2, 6, 1));
        graph.addEdge(new Edge(3, 6, 14));
        graph.addEdge(new Edge(3, 7, 20));
        graph.addEdge(new Edge(4, 5, 4));
        graph.addEdge(new Edge(4, 7, 13));
        graph.addEdge(new Edge(5, 6, 3));
        graph.addEdge(new Edge(5, 7, 8));
        graph.addEdge(new Edge(6, 7, 16));
        /*Prim prim = new Prim(graph);
        System.out.println(prim.mst());*/
        Dijkstra dijkstra = new Dijkstra(graph, 0);
        for (int i = 0; i < 8; ++i) {
            System.out.println(dijkstra.shortestPath(i));
        }
        /*graph.addEdge(new Edge(1, 4, 0));
        graph.addEdge(new Edge(4,3,0));
        graph.addEdge(new Edge(3,10,0));
        graph.addEdge(new Edge(1,2,0));
        graph.addEdge(new Edge(2,3,0));
        graph.addEdge(new Edge(3,9,0));
        graph.addEdge(new Edge(2,8,0));
        graph.addEdge(new Edge(8,7,0));
        graph.addEdge(new Edge(7,5,0));
        graph.addEdge(new Edge(5,2,0));
        graph.addEdge(new Edge(2,7,0));
        graph.addEdge(new Edge(5,8,0));
        graph.addEdge(new Edge(5,6,0));
        BFSAlgorithm bfs = new BFSAlgorithm(graph, 1);
        bfs.getResult();*/
    }
}
