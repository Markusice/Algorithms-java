import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(FileLoader.load("graph1.txt"))) {
      Graph graph = new Graph();

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

      DFS(graph);
      System.out.println("DFS result: " + graph.getVertices());
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void DFS(Graph G) {
    for (Vertex u : G.getVertices()) {
      u.setColor(VertexColor.WHITE);
    }
    int time = 0;
    for (Vertex r : G.getVertices()) {
      if (r.getColor() == VertexColor.WHITE) {
        time = DFVisit(G, r, time);
      }
    }
    System.out.println("Final ending time: " + time);
  }

  private static int DFVisit(Graph G, Vertex u, int time) {
    u.setD(++time);
    u.setColor(VertexColor.GREY);
    for (Edge edge : G.getEdgesOf(u)) {
      if (edge.v().getColor().equals(VertexColor.WHITE)) {
        edge.v().setPi(u);
        time = DFVisit(G, edge.v(), time);
      } else if (edge.v().getColor().equals(VertexColor.GREY)) {
        // back edge can be found
      }
    }
    u.setF(++time);
    u.setColor(VertexColor.BLACK);
    return time;
  }
}
