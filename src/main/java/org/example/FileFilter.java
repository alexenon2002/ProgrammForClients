package org.example;

import org.example.ReaderForOrder;

public class FileFilter {

    public ReaderForOrder create(String fileName) {

        if (fileName.endsWith(".txt")) {
            return new FileWithTxt();
        }

        return new Adapter();
    }

}