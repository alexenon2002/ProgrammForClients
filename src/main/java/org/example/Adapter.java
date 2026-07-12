package org.example;

import java.io.IOException;
import java.util.List;

public class Adapter implements ReaderForOrder {

    private final FileWithoutTxt reader = new FileWithoutTxt();

    @Override
    public List<Order> catalog(String fileName) throws IOException {
        return reader.decrypts(fileName);
    }
}