class HuffmanNode implements Comparable<HuffmanNode> {
  private char letter;
  private int letterFrequency;
  private HuffmanNode leftChild;
  private HuffmanNode rightChild;

  public int getLetterFrequency() {
    return letterFrequency;
  }

  public char getLetter() {
    return letter;
  }

  public HuffmanNode getLeftChild() {
    return leftChild;
  }

  public HuffmanNode getRightChild() {
    return rightChild;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  public void setLetterFrequency(int letterFrequency) {
    this.letterFrequency = letterFrequency;
  }

  public void setLeftChild(HuffmanNode leftChild) {
    this.leftChild = leftChild;
  }

  public void setRightChild(HuffmanNode rightChild) {
    this.rightChild = rightChild;
  }

  @Override
  public int compareTo(HuffmanNode o) {
    return Integer.compare(this.letterFrequency, o.letterFrequency);
  }

  @Override
  public String toString() {
    return "HuffmanNode{"
        + "letter="
        + letter
        + ", letterFrequency="
        + letterFrequency
        + ", leftChild="
        + leftChild
        + ", rightChild="
        + rightChild
        + '}';
  }
}
