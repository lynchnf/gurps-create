package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultResponseTest {
    DefaultResponse model;

    @BeforeEach
    void setUp() {
        model = new DefaultResponse();
        model.setAttribute("Attribute");
        model.setSkill("Skill");
        model.setSpecialty("Specialty");
        model.setPenalty(123);
        model.setLevel(234);
        model.setPoints(345);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAttribute() {
        assertEquals("Attribute", model.getAttribute());
    }

    @Test
    void getSkill() {
        assertEquals("Skill", model.getSkill());
    }

    @Test
    void getSpecialty() {
        assertEquals("Specialty", model.getSpecialty());
    }

    @Test
    void getPenalty() {
        assertEquals(123, model.getPenalty());
    }

    @Test
    void getLevel() {
        assertEquals(234, model.getLevel());
    }

    @Test
    void getPoints() {
        assertEquals(345, model.getPoints());
    }
}
