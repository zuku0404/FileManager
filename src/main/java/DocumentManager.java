import java.util.Arrays;

public class DocumentManager extends FileType{
    private static DocumentManager instance;
    private FileManager fileManager;

    private DocumentManager(){
        super("Document", Arrays.asList(ExtensionType.PDF, ExtensionType.DOC));
        this.fileManager = new FileManagerImpl<DocumentManager>();
    }

    public static DocumentManager getInstance() {
        if(instance == null){
            instance = new DocumentManager();
        }
        return instance;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
