import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class LZW {
  public static void main(String[] args) {
    Map<String, Integer> codeTable = new LinkedHashMap<>();
    codeTable.put("A", 1);
    codeTable.put("B", 2);
    codeTable.put("C", 3);
    int initialSize = codeTable.size();
    System.out.println(codeTable);

    try (BufferedReader bufferedReader =
        new BufferedReader(new FileReader(FileLoader.read("input.txt")))) {
      StringBuilder encodedText = new StringBuilder();

      int value;
      String readWord = "";
      while ((value = bufferedReader.read()) != -1) {
        readWord += String.valueOf((char) value);

        int newLetter = -1;
        String previousWord = readWord;
        while (codeTable.containsKey(readWord) && (newLetter = bufferedReader.read()) != -1) {
          readWord += String.valueOf((char) newLetter);

          if (codeTable.containsKey(readWord)) {
            previousWord = readWord;
          }
        }

        if (!codeTable.containsKey(readWord)) {
          if (previousWord.equals(readWord)) {
            previousWord = readWord.substring(0, 1);
          }
          if (newLetter == -1) {
            newLetter =
                readWord.charAt(readWord.length() - 1); // set newLetter to last letter if not set
          }
          codeTable.put(readWord, codeTable.size() + 1);
          //          System.out.println(
          //              newLetter + "\t" + "readWord: " + readWord + ", newLetter: " + (char)
          // newLetter);
          readWord = String.valueOf((char) newLetter);
        }
        encodedText.append(codeTable.get(previousWord));
      }

      if (codeTable.size()
          > initialSize) { // for the last word, if text length is 1 then it's already encoded
        encodedText.append(codeTable.get(readWord));
      }
      System.out.println(codeTable);
      System.out.println("Encoded text: " + encodedText);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
