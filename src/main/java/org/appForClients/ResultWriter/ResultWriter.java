package org.appForClients.ResultWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResultWriter {

    private static final String FILE_PREFIX = "result_";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public void write(List<String> result) throws IOException {

        String fileName = FILE_PREFIX + LocalDateTime.now().format(FORMATTER) + ".txt";

        Path path = Path.of(fileName);

        Files.write(path, result);

        System.out.println("Результат : " + path.toAbsolutePath());
    }
}