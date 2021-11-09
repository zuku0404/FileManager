package type_definders;

public enum ExtensionType {
    DOC ("doc"),
    PDF ("pdf"),
    JPG ("jpg"),
    PNG ("png"),
    SVG ("svg"),
    GIF ("gif");

    private String extension;

    ExtensionType(String extension){
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
