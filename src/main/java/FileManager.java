import java.io.File;
import java.util.List;
import java.util.Optional;

public interface FileManager {
    void download(String name, String sourcePath, String targetPath);

    Optional<File> findByName(String name, String sourcePath);

    List<File> findAll(String sourcePath);

    void deleteByName(String name, String sourcePath);

    void clearAll(String sourcePath);
}
