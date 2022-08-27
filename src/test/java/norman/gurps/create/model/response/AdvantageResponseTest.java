package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvantageResponseTest {
    AdvantageResponse model;

    @BeforeEach
    void setUp() {
        model = new AdvantageResponse();
        model.setName("Name");
        model.setMultiLevel(false);
        model.setFirstLevel(123);
        model.setFirstLevelCost(234);
        model.setCostPerLevel(345);
        model.setLevel(456);
        model.setDescription("Description");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPoints_simple() {
        model.setMultiLevel(false);
        model.setCostPerLevel(15);

        assertEquals(15, model.getPoints());
    }

    @Test
    void getPoints_MultiLevel_0() {
        model.setMultiLevel(true);
        model.setFirstLevel(0);
        model.setFirstLevelCost(5);
        model.setCostPerLevel(10);
        model.setLevel(3);

        assertEquals(35, model.getPoints());
    }

    @Test
    void getPoints_MultiLevel_1() {
        model.setMultiLevel(true);
        model.setFirstLevel(1);
        model.setFirstLevelCost(5);
        model.setCostPerLevel(5);
        model.setLevel(3);

        assertEquals(15, model.getPoints());
    }

    @Test
    void getName() {
        assertEquals("Name", model.getName());
    }

    @Test
    void getMultiLevel() {
        assertEquals(false, model.getMultiLevel());
    }

    @Test
    void getFirstLevel() {
        assertEquals(123, model.getFirstLevel());
    }

    @Test
    void getFirstLevelCost() {
        assertEquals(234, model.getFirstLevelCost());
    }

    @Test
    void getCostPerLevel() {
        assertEquals(345, model.getCostPerLevel());
    }

    @Test
    void getLevel() {
        assertEquals(456, model.getLevel());
    }

    @Test
    void getDescription() {
        assertEquals("Description", model.getDescription());
    }
}
