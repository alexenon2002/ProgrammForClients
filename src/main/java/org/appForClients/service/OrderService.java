package org.appForClients.service;

import org.appForClients.ResultWriter;
import org.appForClients.model.Order;
import org.appForClients.reader.ReaderForOrder;

import java.io.IOException;
import java.util.List;

public class OrderService {

    private final FileFilter fileFilter = new FileFilter();
    private final OrderCalculator calculator = new OrderCalculator();
    private final ResultWriter writer = new ResultWriter();

    public void process(String fileName, CalculationProgram config) throws IOException {

        ReaderForOrder reader = fileFilter.getReader(fileName);

        List<Order> orders = reader.catalog(fileName);

        List<String> result = calculator.calculate(orders, config);

        writer.write(result);
    }
}