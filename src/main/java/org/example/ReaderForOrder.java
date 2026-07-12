package org.example;

import java.io.IOException;
import java.util.List;

public interface ReaderForOrder {

        List<Order> catalog(String fileName) throws IOException;

}