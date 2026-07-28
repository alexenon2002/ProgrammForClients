package org.appForClients.reader;

import org.appForClients.model.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FileWithTxtTest {

    @Test
    void shouldSupportTxtFile() {
        FileWithTxt fileWithTxt = new FileWithTxt();
        assertTrue(fileWithTxt.supports("order.txt"));
    }

    @Test
    void shouldNotSupportNotTxtFile() {
FileWithTxt fileWithTxt = new FileWithTxt();
assertFalse(fileWithTxt.supports("order.svm"));
    }

    @Test
    void shouldSupportIsEmptyFile() throws IOException {
        Path file = File.createTempFile("empty","file").toPath();
        FileWithTxt fileWithTxt = new FileWithTxt();
        List<Order> orders = fileWithTxt.catalog(file.toString());
        assertTrue(orders.isEmpty());
    }
    @Test
    void shouldReadOrdersFromFile() throws IOException {
        Path file = File.createTempFile("orders", "txt").toPath();
        Files.write(file, List.of("2024-07-23T10:15:22|Ivan|250", "2024-04-24T13:24:56|Petr|400"));
        FileWithTxt reader = new FileWithTxt();
        List<Order> orders = reader.catalog(file.toString());
        assertEquals(2, orders.size());
        Order firstOrder = orders.get(0);
        assertEquals(LocalDateTime.of(2024, 07, 23, 10, 15, 22),
                firstOrder.getDateOfPurchaseOfCement());
        assertEquals("Ivan", firstOrder.getBuyer());
        assertEquals(250, firstOrder.getNumberOfKilograms());
        Order secondOrder = orders.get(1);
        assertEquals(LocalDateTime.of(2024, 04, 24, 13, 24, 56),
                secondOrder.getDateOfPurchaseOfCement());
        assertEquals("Petr", secondOrder.getBuyer());
        assertEquals(400, secondOrder.getNumberOfKilograms());
    }

    @Test
    void shouldThrowExceptionWhenDateIsWrong() throws IOException{
        Path file = File.createTempFile("order","txt").toPath();
        Files.writeString(file,"wrong-date|Ivan|500");
        FileWithTxt reader = new FileWithTxt();
        assertThrows(DateTimeParseException.class,() -> reader.catalog(file.toString()));
    }

    @Test
    void shouldThrowIOExceptionWhenFileDoesNotExist(){
        FileWithTxt reader = new FileWithTxt();
        assertThrows(IOException.class,() ->reader.catalog("orders.txt"));
    }
    @Test
    void shouldThrowExceptionWhenKilogramsAreWrong() throws IOException {
        Path file = File.createTempFile("wrong-number","txt").toPath();
       Files.writeString(file,"2024-10-10T10:15:20|Alex|wrong");
       FileWithTxt reader = new FileWithTxt();
       assertThrows(NumberFormatException.class,() ->reader.catalog(file.toString()));
    }
}