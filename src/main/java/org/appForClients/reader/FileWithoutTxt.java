package org.appForClients.reader;

import org.appForClients.model.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class FileWithoutTxt {

    public List<Order> decrypts(String fileName) throws IOException {

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            return lines.map(line -> line.split("#")).map(name -> new Order(LocalDateTime.parse(name[0]), name[1], Integer.parseInt(name[2]))).toList();
        }
    }
}