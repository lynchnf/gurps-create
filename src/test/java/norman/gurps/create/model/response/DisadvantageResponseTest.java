package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisadvantageResponseTest {
    DisadvantageResponse model;

    @BeforeEach
    void setUp() {
        model = new DisadvantageResponse();
        model.setName("Name");
        model.setSelfControlAllowed(false);
        model.setMultiLevel(true);
        model.setCostPerLevel(123);
        model.setSelfControlLevel(234);
        model.setDescription("Description");
        model.setLevel(345);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPoints_simple() {
        model.setSelfControlAllowed(false);
        model.setMultiLevel(false);
        model.setCostPerLevel(15);

        assertEquals(15, model.getPoints());
    }

    @Test
    void getPoints_MultiLevel() {
        model.setSelfControlAllowed(false);
        model.setMultiLevel(true);
        model.setCostPerLevel(5);
        model.setLevel(2);

        assertEquals(10, model.getPoints());
    }

    @Test
    void getPoints_AllowSelfControl_6() {
        model.setSelfControlAllowed(true);
        model.setMultiLevel(false);
        model.setCostPerLevel(15);
        model.setSelfControlLevel(6);

        assertEquals(30, model.getPoints());
    }

    @Test
    void getPoints_AllowSelfControl_9() {
        model.setSelfControlAllowed(true);
        model.setMultiLevel(false);
        model.setCostPerLevel(15);
        model.setSelfControlLevel(9);

        assertEquals(22, model.getPoints());
    }

    @Test
    void getPoints_AllowSelfControl_12() {
        model.setSelfControlAllowed(true);
        model.setMultiLevel(false);
        model.setCostPerLevel(15);
        model.setSelfControlLevel(12);

        assertEquals(15, model.getPoints());
    }

    @Test
    void getPoints_AllowSelfControl() {
        model.setSelfControlAllowed(true);
        model.setMultiLevel(false);
        model.setCostPerLevel(15);
        model.setSelfControlLevel(15);

        assertEquals(7, model.getPoints());
    }

    @Test
    void getName() {
        assertEquals("Name", model.getName());
    }

    @Test
    void getAllowSelfControl() {
        assertEquals(false, model.getSelfControlAllowed());
    }

    @Test
    void getMultiLevel() {
        assertEquals(true, model.getMultiLevel());
    }

    @Test
    void getCostPerLevel() {
        assertEquals(123, model.getCostPerLevel());
    }

    @Test
    void getSelfControlLevel() {
        assertEquals(234, model.getSelfControlLevel());
    }

    @Test
    void getDescription() {
        assertEquals("Description", model.getDescription());
    }

    @Test
    void getLevel() {
        assertEquals(345, model.getLevel());
    }
}
