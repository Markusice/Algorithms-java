import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;

public class FileLoader {
  public static Path load(String filename) throws FileNotFoundException {
    URL url = FileLoader.class.getResource(filename);
    if (url == null) {
      throw new FileNotFoundException("File not found: " + filename);
    }
    return Path.of(url.getPath());
  }
}
