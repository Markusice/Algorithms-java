public class Vertex {
  private final String name;
  private VertexColor color;
  private int d;
  private int f;
  private Vertex pi;

  public Vertex(String name) {
    this.name = name;
  }

  public Vertex(String name, Vertex pi) {
    this.name = name;
    this.pi = pi;
  }

  public VertexColor getColor() {
    return color;
  }

  public void setColor(VertexColor color) {
    this.color = color;
  }

  public void setD(int d) {
    this.d = d;
  }

  public void setF(int f) {
    this.f = f;
  }

  public void setPi(Vertex pi) {
    this.pi = pi;
  }

  @Override
  public String toString() {
    return "Vertex{"
        + "name='"
        + name
        + '\''
        + ", color="
        + color
        + ", d="
        + d
        + ", f="
        + f
        + ", pi="
        + pi
        + '}';
  }

  /** for {@link Graph#getEdgesOf(Vertex)} to get all edges of a vertex */
  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    else if (that instanceof Vertex vertex) {
      return this.name.equals(vertex.name);
    } else return false;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
