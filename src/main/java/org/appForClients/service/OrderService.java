package org.appForClients.service;

import org.appForClients.CalculationFunctional.CalculationProgram;
import org.appForClients.CalculationFunctional.OrderCalculator;
import org.appForClients.FileFilter.FileFilter;
import org.appForClients.ResultWriter.ResultWriter;
import org.appForClients.model.Order;
import org.appForClients.reader.ReaderForOrder;

import java.io.IOException;
import java.util.List;

public class OrderService {

    private final FileFilter fileFilter;
    private final OrderCalculator calculator;
    private final ResultWriter writer;

    public OrderService() {
        this(new FileFilter(), new OrderCalculator(), new ResultWriter());
    }

    public OrderService(FileFilter fileFilter, OrderCalculator calculator, ResultWriter writer) {
        this.fileFilter = fileFilter;
        this.calculator = calculator;
        this.writer = writer;
    }


    public void process(String fileName, CalculationProgram config) throws IOException {

        ReaderForOrder reader = fileFilter.getReader(fileName);

        List<Order> orders = reader.catalog(fileName);

        List<String> result = calculator.calculate(orders, config);

        writer.write(result);
    }
}
