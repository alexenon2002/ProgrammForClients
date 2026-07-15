package org.appForClients.service;


import org.appForClients.reader.ReaderForOrder;
import org.appForClients.ResultWriter;
import org.appForClients.model.Order;

import java.io.IOException;
import java.util.List;

public class OrderService {

    private final FileFilter fileFilter = new FileFilter();

    private final OrderCalculator calculator = new OrderCalculator();

    private final ResultWriter resultWriter= new ResultWriter();

    public void process(String fileName) throws IOException {

        ReaderForOrder reader = fileFilter.getReader(fileName);

        List<Order> orders = reader.catalog(fileName);

        List<String> result = calculator.calculate(orders);

        resultWriter.write(result);

    }

}