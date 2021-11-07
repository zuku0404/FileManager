import java.util.List;

public class FileType {
    private String type;
    private static List<ExtensionType> extensionTypes;

    public FileType(String type, List<ExtensionType> extensionTypes) {
        this.type = type;
        this.extensionTypes = extensionTypes;
    }

    public static List<ExtensionType> getExtensionTypes() {
        return extensionTypes;
    }

    public String getType() {
        return type;
    }
}
