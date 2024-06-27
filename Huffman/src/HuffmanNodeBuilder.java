class HuffmanNodeBuilder implements Builder<HuffmanNodeBuilder, HuffmanNode> {
  private HuffmanNode result;

  public HuffmanNodeBuilder() {
    this.result = new HuffmanNode();
  }

  @Override
  public HuffmanNodeBuilder setLetter(char letter) {
    result.setLetter(letter);
    return this;
  }

  @Override
  public HuffmanNodeBuilder setLetterFrequency(int letterFrequency) {
    result.setLetterFrequency(letterFrequency);
    return this;
  }

  @Override
  public HuffmanNodeBuilder setLeftChild(HuffmanNode leftChild) {
    result.setLeftChild(leftChild);
    return this;
  }

  @Override
  public HuffmanNodeBuilder setRightChild(HuffmanNode rightChild) {
    result.setRightChild(rightChild);
    return this;
  }

  @Override
  public HuffmanNode build() {
    HuffmanNode build = result;
    result = new HuffmanNode();
    return build;
  }
}
