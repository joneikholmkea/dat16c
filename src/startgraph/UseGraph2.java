package startgraph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Stack;

public class UseGraph2 extends Application {
    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Graph graph = new Graph();
        graph.addVertex(new Vertex("Los Angeles", 75, 275));
        graph.addVertex(new Vertex("Denver", 275, 150));
        graph.addVertex(new Vertex("Chicago", 450, 100));
        graph.addVertex(new Vertex("Kansas City", 400, 245));
        graph.addVertex(new Vertex("Boston", 700, 80));
        graph.addVertex(new Vertex("New York", 675, 120));


        graph.addEdge( new Edge(0,1,1015));
        graph.addEdge( new Edge(0,3, 1663));
        graph.addEdge( new Edge(1,2, 1003));
        graph.addEdge( new Edge(1,3, 1));
        graph.addEdge( new Edge(2,3, 533));
        graph.addEdge( new Edge(2,4, 983));
        graph.addEdge( new Edge(5,4, 214));
        graph.addEdge( new Edge(5,3, 1260));
        //graph.printGraph();

        Graph.Tree tree = graph.dfs(0);
        System.out.println(tree);
        Stack<Vertex> shortestPath = graph.dijkstra(4,0);

        // Create a scene and place it in the stage

        Pane pane = new GraphView(graph);
        Scene scene = new Scene(pane, 750, 450);
        addShortestPath(pane, shortestPath);
        primaryStage.setTitle("DisplayUSMap"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display

    }

    private void addShortestPath(Pane pane, Stack<Vertex> shortestPath) {
        double step = 0.0;
        System.out.println("color..");
        while(!shortestPath.isEmpty()) {
            Vertex vertex = shortestPath.pop();
            Circle circle = new Circle(vertex.x, vertex.y, 10);
            circle.setFill(Color.color(step, step, 1.0));
            pane.getChildren().add(circle); // Display a vertex
            step +=  0.2;

        }
    }
}
