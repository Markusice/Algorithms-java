public record Edge(Vertex u, Vertex v) {
  @Override
  public String toString() {
    return "Edge{" + "u=" + u + ", v=" + v + '}';
  }
}
