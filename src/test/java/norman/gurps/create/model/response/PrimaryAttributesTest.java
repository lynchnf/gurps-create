package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimaryAttributesTest {
    PrimaryAttributes model;

    @BeforeEach
    void setUp() {
        model = new PrimaryAttributes();
        IntegerAttribute strength = new IntegerAttribute();
        strength.setBase(10);
        strength.setAdjustment(1);
        strength.setRate(10);
        model.setStrength(strength);
        IntegerAttribute dexterity = new IntegerAttribute();
        dexterity.setBase(10);
        dexterity.setAdjustment(2);
        dexterity.setRate(20);
        model.setDexterity(dexterity);
        IntegerAttribute intelligence = new IntegerAttribute();
        intelligence.setBase(10);
        intelligence.setAdjustment(3);
        intelligence.setRate(20);
        model.setIntelligence(intelligence);
        IntegerAttribute health = new IntegerAttribute();
        health.setBase(10);
        health.setAdjustment(4);
        health.setRate(10);
        model.setHealth(health);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPoints() {
        assertEquals(150, model.getPoints());
    }

    @Test
    void getStrength() {
        assertEquals(11, model.getStrength().getValue());
    }

    @Test
    void getDexterity() {
        assertEquals(12, model.getDexterity().getValue());
    }

    @Test
    void getIntelligence() {
        assertEquals(13, model.getIntelligence().getValue());
    }

    @Test
    void getHealth() {
        assertEquals(14, model.getHealth().getValue());
    }
}
