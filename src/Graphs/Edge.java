package Graphs;

public class Edge implements Comparable<Edge>{

    private int v, w;       //2 đỉnh của cạnh
    private double weight;  //trọng số của cạnh

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //Trả về 1 đỉnh của cạnh
    public int either() {
        return v;
    }

    //Trả về đỉnh còn lại của cạnh
    public int other(int vertex) {
        if (vertex == this.v) return this.w;
        else return this.v;
    }

    //Trả về trọng số của cạnh
    public double getWeight() {
        return this.weight;
    }

    //So sánh trọng số của 2 cạnh
    @Override
    public int compareTo(Edge edge) {
        return Double.compare(this.weight, edge.getWeight());
    }
}
