package startgraph;

public class UseGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(new Vertex("Los Angeles"));
        graph.addVertex(new Vertex("Denver"));
        graph.addVertex(new Vertex("Chicago"));
        graph.addVertex(new Vertex("Kansas City"));
        graph.addEdge (new Edge(0,1, 1015));
        graph.addEdge (new Edge(1,0, 1015));
        graph.addEdge (new Edge(1,2, 1003));
        graph.addEdge (new Edge(2,1, 1003));
        graph.addEdge (new Edge(2,3, 533));
        graph.addEdge (new Edge(3,2, 533));
        graph.addEdge (new Edge(3,1, 599));
        graph.addEdge (new Edge(1,3, 599));
        graph.addEdge (new Edge(0,3, 1663));
        graph.addEdge (new Edge(3,0,1663));
        System.out.println(graph.dfs(2));
    }
}
