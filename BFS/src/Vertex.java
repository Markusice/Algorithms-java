public class Vertex {
  private final String name;
  private int d;
  private Vertex pi;

  public Vertex(String name) {
    this.name = name;
  }

  public Vertex(String name, Vertex pi) {
    this.name = name;
    this.pi = pi;
  }

  public int getD() {
    return d;
  }

  public void setD(int d) {
    this.d = d;
  }

  public void setPi(Vertex pi) {
    this.pi = pi;
  }

  @Override
  public String toString() {
    return "Vertex{" + "name='" + name + '\'' + ", d=" + d + ", pi=" + pi + '}';
  }

  /** for {@link Graph#getEdgesOf(Vertex)} to get all edges of a vertex */
  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    else if (that instanceof Vertex vertex) {
      return this.name.equals(vertex.name) && this.d == vertex.d; // parent can be different
    } else return false;
  }

  @Override
  public int hashCode() {
    return name.hashCode() + d;
  }
}
