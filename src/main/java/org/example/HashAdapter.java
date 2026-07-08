package org.example;

import java.io.IOException;
import java.util.List;

public class HashAdapter implements ReaderForOrder {

    private final HashFileReader reader = new HashFileReader();

    @Override
    public List<Order> read(String fileName) throws IOException {
        return reader.reading(fileName);
    }
}