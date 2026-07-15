package org.appForClients.adapter;


import org.appForClients.model.Order;
import org.appForClients.reader.FileWithoutTxt;
import org.appForClients.reader.ReaderForOrder;

import java.io.IOException;
import java.util.List;

public class Adapter implements ReaderForOrder {

    private final FileWithoutTxt adapter = new FileWithoutTxt();

    @Override
    public boolean supports(String fileName) {
        return !fileName.contains(".");
    }

    @Override
    public List<Order> catalog (String fileName) throws IOException {

        return adapter.decrypts(fileName);

    }
}