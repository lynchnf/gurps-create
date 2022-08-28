package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkillResponseTest {
    SkillResponse model;

    @BeforeEach
    void setUp() {
        model = new SkillResponse();
        model.setName("Name");
        model.setControllingAttribute("ControllingAttribute");
        model.setDifficultyLevel("DifficultyLevel");
        model.setSpecialty("Specialty");
        model.setMinLevel(123);
        model.setMaxPoints(234);
        model.setControllingAttributeValue(345);
        model.setLevel(456);
        model.setPoints(567);
        DefaultResponse bestDefault = new DefaultResponse();
        bestDefault.setSkill("BestDefaultSkill");
        model.setBestDefault(bestDefault);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        assertEquals("Name", model.getName());
    }

    @Test
    void getControllingAttribute() {
        assertEquals("ControllingAttribute", model.getControllingAttribute());
    }

    @Test
    void getDifficultyLevel() {
        assertEquals("DifficultyLevel", model.getDifficultyLevel());
    }

    @Test
    void getSpecialty() {
        assertEquals("Specialty", model.getSpecialty());
    }

    @Test
    void getMinLevel() {
        assertEquals(123, model.getMinLevel());
    }

    @Test
    void getMaxPoints() {
        assertEquals(234, model.getMaxPoints());
    }

    @Test
    void getControllingAttributeValue() {
        assertEquals(345, model.getControllingAttributeValue());
    }

    @Test
    void getLevel() {
        assertEquals(456, model.getLevel());
    }

    @Test
    void getPoints() {
        assertEquals(567, model.getPoints());
    }

    @Test
    void getBestDefault() {
        assertEquals("BestDefaultSkill", model.getBestDefault().getSkill());
    }
}
