package org.appForClients.FileFilter;

import org.appForClients.adapter.Adapter;
import org.appForClients.reader.FileWithTxt;
import org.appForClients.reader.ReaderForOrder;

import java.util.List;

public class FileFilter {
    private final List<ReaderForOrder> readers = List.of(
            new FileWithTxt(),
            new Adapter()
    );

    public ReaderForOrder getReader(String fileName) {

        return readers.stream()
                .filter(reader -> reader.supports(fileName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Неизвестный формат файла"));

    }
}
