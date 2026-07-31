package org.appForClients.service;

import org.appForClients.calculation.CalculationProgram;
import org.appForClients.calculation.OrderCalculator;
import org.appForClients.filter.FileFilter;
import org.appForClients.writer.ResultWriter;
import org.appForClients.model.Order;

import java.io.IOException;
import java.util.List;

public record OrderService(FileFilter fileFilter, OrderCalculator calculator, ResultWriter writer) {

    public OrderService() {
        this(new FileFilter(), new OrderCalculator(), new ResultWriter());
    }


    public void process(String fileName, CalculationProgram config) throws IOException {

        List<Order> orders = fileFilter
                .getReader(fileName)
                .catalog(fileName);

        writer.write(calculator.calculate(orders, config));
    }
}
