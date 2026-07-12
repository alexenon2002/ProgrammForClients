package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ResultWriter {

    public void write(List<String> result) throws IOException {

        Files.write(Paths.get("result.txt"), result);

    }

}