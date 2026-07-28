package org.appForClients.FileFilter;

import org.appForClients.adapter.Adapter;
import org.appForClients.reader.FileWithTxt;
import org.appForClients.reader.ReaderForOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileFilterTest {

    @Test
    void shouldReturnAdapterForFileWithoutExtension(){
FileFilter fileFilter = new FileFilter();
ReaderForOrder reader = fileFilter.getReader("order");
assertInstanceOf(Adapter.class,reader);
    }
@Test
void shouldReturnTxtReader() {
    FileFilter fileFilter = new FileFilter();
    ReaderForOrder reader = fileFilter.getReader("order.txt");
    assertInstanceOf(FileWithTxt.class,reader);
}
@Test
void shouldThrowExceptionForUnsupportedExtension() {
    FileFilter fileFilter = new FileFilter();
    assertThrowsExactly(IllegalArgumentException.class,() -> fileFilter.getReader("order.rvs"));
}
}