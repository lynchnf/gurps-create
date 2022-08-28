package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentResponseTest {
    EquipmentResponse model;

    @BeforeEach
    void setUp() {
        model = new EquipmentResponse();
        model.setName("Name");
        model.setCost(123);
        model.setWeight(2.34);
        model.setQuantity(345);
        model.setNotes("Notes");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        assertEquals("Name", model.getName());
    }

    @Test
    void getCost() {
        assertEquals(123, model.getCost());
    }

    @Test
    void getWeight() {
        assertEquals(2.34, model.getWeight());
    }

    @Test
    void getQuantity() {
        assertEquals(345, model.getQuantity());
    }

    @Test
    void getNotes() {
        assertEquals("Notes", model.getNotes());
    }
}
