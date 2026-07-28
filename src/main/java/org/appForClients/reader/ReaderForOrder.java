package org.appForClients.reader;

import org.appForClients.model.Order;

import java.io.IOException;
import java.util.List;

public interface ReaderForOrder {

        boolean supports (String fileName);

        List<Order> catalog (String fileName) throws IOException;


}

