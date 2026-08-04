package org.appForClients.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class ResultWriter {
    private static final Logger RESULT = Logger.getLogger(ResultWriter.class.getName());
    private static final String TYPE_OF_FILE = ".txt";
    private static final String FILE_PREFIX = "result_";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public void write(List<String> result) throws IOException {

        String fileName = FILE_PREFIX + LocalDateTime.now().format(FORMATTER) + TYPE_OF_FILE;

        Path path = Path.of(fileName);

        Files.write(path, result);

        RESULT.info("Результат : " + path.toAbsolutePath());
    }
}