package org.appForClients.reader;

import org.appForClients.model.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWithoutTxtTest {


    @Test
    void shouldReadOrdersFromFile() throws IOException {

        Path file = Files.createTempFile("orders", ".txt");

        Files.writeString(file,
                "2024-05-10T10:15:30#Ivan#500");


        FileWithoutTxt reader = new FileWithoutTxt();


        List<Order> orders = reader.decrypts(file.toString());


        assertEquals(1, orders.size());

        Order order = orders.get(0);

        assertEquals(
                LocalDateTime.of(2024, 5, 10, 10, 15, 30),
                order.dateOfPurchaseOfCement()
        );

        assertEquals(
                "Ivan",
                order.buyer()
        );

        assertEquals(
                500,
                order.numberOfKilograms()
        );
    }


    @Test
    void shouldReturnEmptyListWhenFileIsEmpty() throws IOException {

        Path file = Files.createTempFile("empty", ".txt");


        FileWithoutTxt reader = new FileWithoutTxt();
        List<Order> orders = reader.decrypts(file.toString());
        assertTrue(orders.isEmpty());
    }


    @Test
    void shouldThrowIOExceptionWhenFileDoesNotExist() {

        FileWithoutTxt reader = new FileWithoutTxt();
        assertThrows(
                IOException.class,
                () -> reader.decrypts("wrong-path.txt")
        );
    }

    @Test
    void shouldThrowExceptionWhenDateIsWrong() throws IOException {

        Path file = Files.createTempFile("wrong-date", ".txt");

        Files.writeString(file,
                "hello#Ivan#500");

        FileWithoutTxt reader = new FileWithoutTxt();
        assertThrows(
                DateTimeParseException.class,
                () -> reader.decrypts(file.toString())
        );
    }
}