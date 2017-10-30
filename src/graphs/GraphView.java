package graphs;

import graphs.IGraph;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;

public class GraphView extends Pane {

    private IGraph<? extends Displayable> graph;


    public GraphView(IGraph<? extends Displayable> graph) {
        this.graph = graph;
        List<? extends Displayable> vertices = graph.getVertices(); // aha. her bruger vi
        // Generics, til at forudsige at elementerne skal have getX() metoden...

        displayVertices(graph, vertices);

        displayEdges(graph);
    }

    private void displayEdges(IGraph<? extends Displayable> graph) {
        for (int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            int x1 = graph.getVertex(i).getX();
            int y1 = graph.getVertex(i).getY();
            for(int v: neighbors){
                int x2 = graph.getVertex(v).getX();
                int y2 = graph.getVertex(v).getY();
                // Draw an edge
                getChildren().add(new Line(x1,y1,x2,y2));
            }
        }
    }

    private void displayVertices(IGraph<? extends Displayable> graph, List<? extends Displayable> vertices) {
        for (int i = 0; i < graph.getSize(); i++) {
            int x = vertices.get(i).getX();
            int y = vertices.get(i).getY();
            String name = vertices.get(i).getName();
            getChildren().add(new Circle(x, y, 16)); // Display a vertex
            getChildren().add(new Text(x - 8, y - 18, name));
        }
    }
}
