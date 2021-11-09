package main;

import consumer.FileConsumerImpl;
import services.IFileService;

public class Gallery extends FileConsumerImpl {
    public Gallery(IFileService iFileService) {
        super(iFileService);
    }
}
