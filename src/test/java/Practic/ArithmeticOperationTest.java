package Practic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationTest {


    @Test
    void testSum() {
        ArithmeticOperation arithmeticOperation = new ArithmeticOperation();
        int add = arithmeticOperation.sum(2,4);
        assertEquals(6,add);
    }

    @Test
    void testAll() {
        ArithmeticOperation arithmeticOperation = new ArithmeticOperation();
        double testadd = arithmeticOperation.all(2.3,3.5);
        assertEquals(4.0249999999999995,testadd);

    }
}