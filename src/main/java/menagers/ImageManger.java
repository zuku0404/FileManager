package menagers;

import ports.SimpleFileServiceImpl;
import type_definders.ExtensionType;

import java.util.Arrays;
import java.util.List;

public class ImageManger extends SimpleFileServiceImpl {
    private static final String NAME = "IMAGE";
    private static final List<ExtensionType> extensionTypeList = Arrays.asList(ExtensionType.JPG, ExtensionType.GIF, ExtensionType.SVG,ExtensionType.PNG);

    public ImageManger() {
        super(extensionTypeList);
    }
}
