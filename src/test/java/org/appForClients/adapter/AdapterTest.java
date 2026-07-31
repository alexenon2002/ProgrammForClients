package org.appForClients.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdapterTest {

    Adapter adapter = new Adapter();

    @Test
    void supportsEmptyFile() {
        boolean result = adapter.supports("");
        assertTrue(result);
    }

    @Test
    void supportsFileWithotSymbol() {
        boolean result = adapter.supports("order");
        assertTrue(result);
    }

    @Test
    void supportsFileWithSymbol() {
        boolean result = adapter.supports(".");
        assertFalse(result);
    }
}