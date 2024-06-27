import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;

class FileLoader {
  public static Path read(String filename) throws FileNotFoundException {
    URL fileURL = FileLoader.class.getClassLoader().getResource(filename);
    if (fileURL == null) {
      throw new FileNotFoundException(filename + " not found in resources folder!");
    }
    return Path.of(fileURL.getPath());
  }
}
