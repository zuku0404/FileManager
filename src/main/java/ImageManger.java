import java.util.Arrays;

public class ImageManger extends FileType {
    private static ImageManger instance;

    private FileManager fileManager;

    private ImageManger(){
        super("Image", Arrays.asList(ExtensionType.JPG, ExtensionType.GIF, ExtensionType.SVG, ExtensionType.PNG));
        this.fileManager = new FileManagerImpl<ImageManger>();
    }
    public static ImageManger getInstance() {
        if(instance == null){
            instance = new ImageManger();
        }
        return instance;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
