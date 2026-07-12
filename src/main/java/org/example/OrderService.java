package org.example;


import java.io.IOException;
import java.util.List;

public class OrderService {

    private final FileFilter fileFilter = new FileFilter();

    private final OrderCalculator calculator = new OrderCalculator();

    private final ResultWriter writer = new ResultWriter();

    public void process(String fileName) throws IOException {

        ReaderForOrder reader = fileFilter.create(fileName);

        List<Order> orders = reader.catalog(fileName);

        List<String> result = calculator.calculate(orders);

        writer.write(result);

        result.forEach(System.out::println);

    }

}