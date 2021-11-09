package consumer;

import services.IFileService;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FileConsumerImpl implements IFileConsumer {
    private IFileService iFileService;

    public FileConsumerImpl(IFileService iFileService) {
        this.iFileService = iFileService;
    }

    @Override
    public void getByName(String name, String sourcePath, String targetPath) {
        iFileService.getByName(name, sourcePath, targetPath);
    }

    @Override
    public Optional<File> findByName(String name, String sourcePath) {
        return iFileService.findByName(name, sourcePath);
    }

    @Override
    public List<File> findAll(String sourcePath) {
        return iFileService.findAll(sourcePath);
    }

    @Override
    public void deleteByName(String name, String sourcePath) {
        iFileService.deleteByName(name, sourcePath);
    }

    @Override
    public void clearAll(String sourcePath) {
        iFileService.clearAll(sourcePath);
    }
}
