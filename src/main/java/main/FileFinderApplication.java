package main;

import menagers.ImageManger;

import java.io.File;
import java.util.List;

public class FileFinderApplication {
    public static void main(String[] args) {
        Gallery gallery = new Gallery(new ImageManger());
        List<File> example = gallery.findAll("Example");
        for (File file : example) {
            System.out.println(file);
        }
    }
}
