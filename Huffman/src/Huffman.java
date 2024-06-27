import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Huffman {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(FileLoader.read("input.txt"))) {
      if (scanner.hasNextLine()) {
        String text = scanner.nextLine();
        System.out.println(text);

        HashMap<Character, Integer> letterFrequencies = new HashMap<>();
        setLetterFrequencies(text, letterFrequencies);
        System.out.println(letterFrequencies);

        HuffmanNodeBuilder huffmanNodeBuilder = new HuffmanNodeBuilder();
        PriorityQueue<HuffmanNode> minPriorityQueue = new PriorityQueue<>();

        for (char c : letterFrequencies.keySet()) {
          minPriorityQueue.add(
              huffmanNodeBuilder.setLetter(c).setLetterFrequency(letterFrequencies.get(c)).build());
        }
        //        printMinPriorityQueue(minPriorityQueue);

        HuffmanNode root = null;
        if (minPriorityQueue.size() == 1) {
          HuffmanNode huffmanNode = minPriorityQueue.poll();
          root =
              huffmanNodeBuilder
                  .setLetterFrequency(huffmanNode.getLetterFrequency())
                  .setLeftChild(huffmanNode)
                  .build();
        }

        while (minPriorityQueue.size() > 1) {
          HuffmanNode left = minPriorityQueue.poll();
          HuffmanNode right = minPriorityQueue.poll();
          HuffmanNode parent =
              huffmanNodeBuilder
                  .setLetterFrequency(left.getLetterFrequency() + right.getLetterFrequency())
                  .setLeftChild(left)
                  .setRightChild(right)
                  .build();
          minPriorityQueue.add(parent);
          //          System.out.println("Left: " + left);
          //          System.out.println("Right: " + right);
          //          System.out.println("Parent: " + parent);
          //          System.out.println();

          root = parent;
        }
        HashMap<Character, String> letterCodes = new HashMap<>();
        treePreorder(root, "", letterCodes);
        System.out.println(letterCodes);

        StringBuilder encodedHuffmanText = new StringBuilder();
        encodedHuffmanText.append("Encoded Huffman text: ");
        for (char c : text.toCharArray()) {
          if (letterCodes.containsKey(c)) {
            encodedHuffmanText.append(letterCodes.get(c));
          }
        }
        System.out.println(encodedHuffmanText);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void setLetterFrequencies(
      String text, HashMap<Character, Integer> letterFrequencies) {
    for (char c : text.toCharArray()) {
      letterFrequencies.put(c, letterFrequencies.getOrDefault(c, 0) + 1);
    }
  }

  private static void printMinPriorityQueue(PriorityQueue<HuffmanNode> minPriorityQueue) {
    System.out.println("Min priority queue elements:");

    while (!minPriorityQueue.isEmpty()) {
      HuffmanNode huffmanNode = minPriorityQueue.poll();
      System.out.println(huffmanNode.getLetter() + " " + huffmanNode.getLetterFrequency());
    }
  }

  public static void treePreorder(
      HuffmanNode huffmanNode, String code, HashMap<Character, String> letterCodes) {
    if (huffmanNode != null) {
      //      System.out.println(huffmanNode);

      char letter;
      if ((letter = huffmanNode.getLetter()) != '\0') {
        //        System.out.println(letter + ": " + code);
        letterCodes.put(letter, code);
      }
      treePreorder(huffmanNode.getLeftChild(), code + "0", letterCodes);
      treePreorder(huffmanNode.getRightChild(), code + "1", letterCodes);
    }
  }
}
