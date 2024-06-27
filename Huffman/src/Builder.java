// builder design pattern
interface Builder<T, V> {
  T setLetter(char letter);

  T setLetterFrequency(int letterFrequency);

  T setLeftChild(HuffmanNode leftChild);

  T setRightChild(HuffmanNode rightChild);

  V build();
}
