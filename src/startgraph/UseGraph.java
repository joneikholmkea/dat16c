package startgraph;

public class UseGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(new Vertex("Los Angeles"));
        graph.addVertex(new Vertex("Dallas"));
        Edge edge1 = new Edge(0,1);
        Edge edge2 = new Edge(1,0);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.printGraph();
    }
}
