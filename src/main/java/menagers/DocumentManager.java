package menagers;

import ports.SimpleFileServiceImpl;
import type_definders.ExtensionType;

import java.util.Arrays;
import java.util.List;

public class DocumentManager extends SimpleFileServiceImpl {
    private static final String NAME = "DOCUMENTS";
    private static final List<ExtensionType> extensionTypeList= Arrays.asList(ExtensionType.DOC, ExtensionType.PDF);

    public DocumentManager() {
        super(extensionTypeList);
    }
}
