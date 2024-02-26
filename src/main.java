import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import Graphs.*;
import Sort.*;
import PriorityQueue.*;
import DynamicConnectivity.*;
import SubString.BoyerMoore;
import Tree.AVL;
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


        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
           /  \
          35   45
              /
             43
               \
                44
        */
        /*BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(35);
        tree.insert(45);
        tree.insert(43);
        tree.insert(44);

        tree.delete(40);
        tree.inorder();*/


        AVL tree = new AVL();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(15);
        tree.insert(35);
        //tree.insert(45);
        //tree.insert(43);
        //tree.insert(44);

        tree.delete(60);
        tree.inorder();


        /*Graph graph = new Graph(11);
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
        Prim prim = new Prim(graph);
        System.out.println(prim.mst());
        Dijkstra dijkstra = new Dijkstra(graph, 0);
        for (int i = 0; i < 8; ++i) {
            System.out.print(dijkstra.shortestPath(i) + " ");
        }*/


        /*Graph graph = new Graph(11);
        graph.addEdge(new Edge(1, 4, 0));
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
        DFSAlgorithm dfs = new DFSAlgorithm(graph, 1);
        dfs.getResult();*/


        // Tìm thành phần liên thông
        /*List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(1,2));
        edges.add(List.of(2,5));
        edges.add(List.of(5,9));
        edges.add(List.of(1,9));
        edges.add(List.of(9,6));
        edges.add(List.of(3,7));
        edges.add(List.of(7,8));
        edges.add(List.of(8,4));
        edges.add(List.of(10,11));
        edges.add(List.of(10,12));
        int V = 13;
        QuickUnionUF uf = new QuickUnionUF(V);
        int res = 1;
        for (List<Integer> edge : edges) {
            int v = edge.get(0);
            int w = edge.get(1);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
            }
        }
        int[] id = new int[13];
        for (int i = 1; i < 13; ++i) {
            id[i] = uf.find(i);
        }
        Arrays.sort(id);
        for (int i = 2; i < 13; ++i) {
            if (id[i] != id[i-1]) res++;
        }
        System.out.println(res);*/


        /*String pat = "fuck";
        String txt = "yourmotherisfuckkingbitch";
        System.out.println(BoyerMoore.search(pat, txt));*/


        // Trích xuất testcase dài hackkerrank
        /*try {
            FileReader fd = new FileReader("C:\\Users\\ADMIN\\Desktop\\DSA\\File\\data.txt");
            BufferedReader bf = new BufferedReader(fd);
            FileWriter fw = new FileWriter("C:\\Users\\ADMIN\\Desktop\\DSA\\File\\data2.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            int cnt = 0;
            String line;
            for (int i = 0; i < 82066; ++i) {
                line = bf.readLine();
            }
            while (cnt < 25943 && (line = bf.readLine()) != null) {
                bw.write(line + "\n");
                cnt++;
            }
            bf.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //CHECK GIT
    }
}
