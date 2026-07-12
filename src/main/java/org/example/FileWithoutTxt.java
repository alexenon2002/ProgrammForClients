package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWithoutTxt {

    public List<Order> decrypts(String fileName) throws IOException {

        return Files.lines(Paths.get(fileName))
                .map(line -> line.split("#"))
                .map(name -> new Order(
                        name[0],
                        name[1],
                        Integer.parseInt(name[2])))
                .toList();
    }
}