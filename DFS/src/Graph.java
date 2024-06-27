import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
  private final List<Vertex> vertices;
  private final List<Edge> edges;

  public Graph() {
    this.vertices = new ArrayList<>();
    this.edges = new ArrayList<>();
  }

  public void addVertex(Vertex vertex) {
    vertices.add(vertex);
  }

  public void addEdge(Edge edge) {
    edges.add(edge);
  }

  public List<Vertex> getVertices() {
    return List.copyOf(vertices);
  }

  public List<Edge> getEdges() {
    return List.copyOf(edges);
  }

  public List<Edge> getEdgesOf(Vertex vertex) {
    List<Edge> edgesOf = new LinkedList<>();
    for (Edge edge : edges) {
      if (edge.u().equals(vertex) || edge.v().equals(vertex)) {
        edgesOf.add(edge);
      }
    }
    return edgesOf;
  }

  @Override
  public String toString() {
    return "Graph{\n" + "vertices=" + vertices + ",\nedges=" + edges + "\n}";
  }
}
