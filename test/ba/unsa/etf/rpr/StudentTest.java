package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getImeStudenta() {
        assertEquals("Adnan", (new Student("Adnan","Imamović",17502)).getImeStudenta());
    }

     @Test
    void getPrezimeStudenta() {
        assertEquals("Imamović", (new Student("Adnan","Imamović",17502)).getPrezimeStudenta());
    }
    @Test
    void getBrojIndeksa() {
        assertEquals("17502", Integer.toString((new Student("Adnan","Imamović",17502)).getBrojIndeksa()));
    }

}