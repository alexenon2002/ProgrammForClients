package org.example;

import java.io.IOException;
import java.util.List;

public interface ReaderForOrder {

        List<Order> read(String fileName) throws IOException;

}