package ports;

import services.IFileService;
import type_definders.ExtensionType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleFileServiceImpl implements IFileService {
    private List<ExtensionType> extensionTypes;

    public SimpleFileServiceImpl(List<ExtensionType> extensionTypes){
        this.extensionTypes = extensionTypes;
    }

    @Override
    public void getByName (String name, String sourcePath, String targetPath) {
        Optional<File> file = findByName(name, sourcePath);
        File targetFile = new File(targetPath);
        if (file.isPresent() && targetFile.exists()) {
            try (InputStream inputStream = new FileInputStream(file.get());
                 OutputStream outputStream = new FileOutputStream(new File(targetFile.getPath() + "\\" + name))) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                file.get().delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteByName(String name, String sourcePath) {
        Optional<File> file = findByName(name, sourcePath);
        file.ifPresent(File::delete);
    }

    @Override
    public void clearAll(String sourcePath) {
        List<File> allFilesInSource = findAll(sourcePath);
        for (File currentFile : allFilesInSource) {
            currentFile.delete();
        }
    }

    @Override
    public List<File> findAll(String sourcePath) {
        List<File> fileList = new ArrayList<>();
        return findFileInDirectory(sourcePath, fileList);
    }

    public List<File> findFileInDirectory(String sourcePath, List<File> fileList) {
        File file = new File(sourcePath);
        File[] listFile = file.listFiles();
        if (listFile != null) {
            for (File currentFile : listFile) {
                if (currentFile.isDirectory()) {
                    findFileInDirectory(currentFile.getPath(), fileList);
                } else {
                    if (checkExtension(currentFile)) {
                        fileList.add(currentFile);
                    }
                }
            }
        } else {
            if (checkExtension(file)) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    @Override
    public Optional<File> findByName(String name, String sourcePath) {
        List<File> allFilesInSource = findAll(sourcePath);
        for (File currentFile : allFilesInSource) {
            if (currentFile.getName().equals(name)) {
                return Optional.of(currentFile);
            }
        }
        return Optional.empty();
    }

    private boolean checkExtension(File file) {
        String[] fileSplitter = file.getPath().split("\\.");
        String fileExtension = fileSplitter[fileSplitter.length - 1];
        for (ExtensionType ex : extensionTypes) {
            if (fileExtension.equals(ex.getExtension())) {
                return true;
            }
        }
        return false;
    }
}
