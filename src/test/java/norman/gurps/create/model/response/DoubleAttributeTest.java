package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleAttributeTest {
    DoubleAttribute model;

    @BeforeEach
    void setUp() {
        model = new DoubleAttribute();
        model.setBase(1.25);
        model.setAdjustment(2.35);
        model.setRate(20);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValue() {
        assertEquals(3.60, model.getValue());
    }

    @Test
    void getPoints() {
        assertEquals(47, model.getPoints());
    }

    @Test
    void getBase() {
        assertEquals(1.25, model.getBase());
    }

    @Test
    void getAdjustment() {
        assertEquals(2.35, model.getAdjustment());
    }

    @Test
    void getRate() {
        assertEquals(20, model.getRate());
    }
}
