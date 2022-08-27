package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerAttributeTest {
    IntegerAttribute model;

    @BeforeEach
    void setUp() {
        model = new IntegerAttribute();
        model.setBase(12);
        model.setAdjustment(23);
        model.setRate(34);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValue() {
        assertEquals(35, model.getValue());
    }

    @Test
    void getPoints() {
        assertEquals(782, model.getPoints());
    }

    @Test
    void getBase() {
        assertEquals(12, model.getBase());
    }

    @Test
    void getAdjustment() {
        assertEquals(23, model.getAdjustment());
    }

    @Test
    void getRate() {
        assertEquals(34, model.getRate());
    }
}
