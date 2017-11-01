package ch.fhnw.swc.mrs.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatementTest {
    
    private Statement s;
    private List<Rental> rentals;

    @Before
    public void setup() {
        Rental r1 = mock(Rental.class);
        Rental r2 = mock(Rental.class);
        Rental r3 = mock(Rental.class);

        rentals = new ArrayList<>(3);
        rentals.add(r1);
        rentals.add(r2);
        rentals.add(r3);
    }

    @Test
    public void testStatement() {
        s = new Statement2("Muster", "Hans", rentals);

        assertEquals("Muster", s.getLastName());
        assertEquals("Hans", s.getFirstName());
        assertEquals(3, s.getRentals().size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFirstName() {
        new Statement2("Muster", "Maximilian", rentals);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testLastName() {
       new Statement2("Mustermann", "Hans", rentals);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRentals() {
       new Statement2("Muster", "Hans", null);
    }


}

class Statement2 extends Statement{

    /**
     * Creates a statement object for a person (with the given name parameter) and a list of rentals.
     *
     * @param name      the family name.
     * @param firstName the first name.
     * @param rentals   a list of rentals to be billed.
     */
    public Statement2(String name, String firstName, List<Rental> rentals) {
        super(name, firstName, rentals);
    }

    public String print(){
        return "";
    }
}
