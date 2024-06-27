import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(FileLoader.load("graph1.txt"))) {
      Graph graph = new Graph();
      Vertex startingVertex;

      if (scanner.hasNextLine()) {
        startingVertex = new Vertex(scanner.nextLine());
      } else {
        throw new IOException("Starting vertex not found in file!");
      }

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] vertices = line.split(" ");
        Vertex parent = new Vertex(vertices[0]);

        if (!graph.getVertices().contains(parent)) graph.addVertex(parent);
        else parent = graph.getVertices().get(graph.getVertices().indexOf(parent));

        for (int i = 1; i < vertices.length; i++) {
          Vertex child = new Vertex(vertices[i], parent);

          if (!graph.getVertices().contains(child)) graph.addVertex(child);
          else child = graph.getVertices().get(graph.getVertices().indexOf(child));

          graph.addEdge(new Edge(parent, child));
        }
      }
      System.out.println(graph);
      System.out.println("Number of vertices: " + graph.getVertices().size());
      System.out.println("Number of edges: " + graph.getEdges().size());

      BFS(graph, startingVertex);
      System.out.println("BFS result: " + graph.getVertices());
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void BFS(Graph graph, Vertex s) {
    for (Vertex u : graph.getVertices()) {
      u.setD(Integer.MAX_VALUE);
      u.setPi(null);
    }
    s.setD(0);
    Queue<Vertex> vertexQueue = new LinkedList<>();
    vertexQueue.add(s);

    while (!vertexQueue.isEmpty()) {
      Vertex u = vertexQueue.remove();
      for (Edge edge : graph.getEdgesOf(u)) {
        if (edge.v().getD() == Integer.MAX_VALUE) {
          edge.v().setD(u.getD() + 1);
          edge.v().setPi(u);
          vertexQueue.add(edge.v());
        }
      }
    }
  }
}
