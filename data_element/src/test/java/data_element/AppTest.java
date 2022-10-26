package data_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }
    @Test
    void testIsPhoneNumber_ValidNumbers(){
        String valid1 = "123-456-7890";
        assertEquals(true, App.isValid(valid1));
        String valid2 = "321-645-0987";
        assertEquals(true, App.isValid(valid2));
    }

    @Test
    void testIsPhoneNumber_InvalidNumbers(){
        String [] invalidNumbers = {
            "",
            " ",
            null,
            "55-55555555-55",
            "123 456 7890",
            "(123) 456-7890",
            "1234567890",
            "123-456-7890 "
        };

        for ( int i=0; i< invalidNumbers.length; i++){
            assertEquals(false, App.isValid(invalidNumbers[i]));
        }
        String invalid1 = "";
        assertEquals(false, App.isValid(invalid1));
        String invalid2 = "55-55555555-55";
        assertEquals(false, App.isValid(invalid2));
        String invalid3 = "123 456 7890";
        assertEquals(false, App.isValid(invalid3));
        String invalid4 = "(123) 456-7890";
        assertEquals(false, App.isValid(invalid4));
        String invalid5 = null;
        assertEquals(false, App.isValid(invalid5));
        String invalid6 = "1234567890";
        assertEquals(false, App.isValid(invalid6));
        String invalid7 = "123-456-7890 ";
        assertEquals(false, App.isValid(invalid7));
    }
}