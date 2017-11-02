package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<V> implements IGraph<V>{
    // hvordan skal vi gemme Verties?
    private List<V> vertices = new ArrayList<>();

    private Map<V, List<Edge>> neighbors = new HashMap();

    public Graph() {

    }

    public Graph(DisplayUSMap.City[] vertices, int[][] edges) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public List<V> getVertices() {
        return null;
    }

    @Override
    public V getVertex(int index) {
        if(index >= 0 && index < vertices.size()) {
            return vertices.get(index);
        }
        return null;

    }

    @Override
    public int getIndex(V v) {
        return 0;
    }

    @Override
    public List<Integer> getNeighbors(int index) {
        return null;
    }

    @Override
    public int getDegree(int v) {
        return 0;
    }

    @Override
    public void printEdges() {


    }

    @Override
    public void clear() {

    }

    @Override
    public boolean addVertex(V vertex) {
        if(!vertices.contains(vertex)){
            vertices.add(vertex);
            neighbors.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(int u, int v) {
        V vertex = getVertex(u);
        List<Edge> list = neighbors.get(vertex);
        Edge edge = new Edge(u,v);
        if(! list.contains(edge)){
            list.add(edge);
            return true;
        }
        return false;
    }

    public static class Edge{
        int u,v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
        public boolean equals(Object o) {
            return u == ((Edge)o).u  &&  v == ((Edge)o).v;
        }
    }
}
