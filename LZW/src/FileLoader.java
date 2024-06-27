import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class FileLoader {
  public static File read(String filename) throws FileNotFoundException {
    URL fileURL = FileLoader.class.getClassLoader().getResource(filename);
    if (fileURL == null) {
      throw new FileNotFoundException(filename + " not found in resources folder!");
    }
    return new File(fileURL.getFile());
  }
}
