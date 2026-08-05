package org.appForClients.reader;

import org.appForClients.model.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;


public class FileWithTxt implements ReaderForOrder {
    private static final String TYPE_OF_FILE = ".txt";
    private static final String SEPARATOR = "\\|";

    @Override
    public boolean supports(String fileName) {
        return fileName.endsWith(TYPE_OF_FILE);
    }

    @Override
    public List<Order> catalog(String fileName) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            return lines.map(line -> line.split(SEPARATOR))
                    .map(name -> new Order(LocalDateTime.parse(name[0]),
                            name[1],
                            Integer.parseInt(name[2])))
                    .toList();
        }
    }
}