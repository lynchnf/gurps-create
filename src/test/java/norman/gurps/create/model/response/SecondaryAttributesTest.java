package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondaryAttributesTest {
    SecondaryAttributes model;

    @BeforeEach
    void setUp() {
        model = new SecondaryAttributes();
        IntegerAttribute hitPoints = new IntegerAttribute();
        hitPoints.setBase(10);
        hitPoints.setAdjustment(1);
        hitPoints.setRate(2);
        model.setHitPoints(hitPoints);
        IntegerAttribute will = new IntegerAttribute();
        will.setBase(10);
        will.setAdjustment(2);
        will.setRate(5);
        model.setWill(will);
        IntegerAttribute perception = new IntegerAttribute();
        perception.setBase(10);
        perception.setAdjustment(3);
        perception.setRate(5);
        model.setPerception(perception);
        IntegerAttribute fatiguePoints = new IntegerAttribute();
        fatiguePoints.setBase(10);
        fatiguePoints.setAdjustment(4);
        fatiguePoints.setRate(3);
        model.setFatiguePoints(fatiguePoints);
        model.setThrustDamageDice(1);
        model.setThrustDamageAdds(-1);
        model.setThrustDamage("1d-1");
        model.setSwingDamageDice(2);
        model.setSwingDamageAdds(0);
        model.setSwingDamage("2d");
        model.setBasicLift(20.0);
        DoubleAttribute basicSpeed = new DoubleAttribute();
        basicSpeed.setBase(5.0);
        basicSpeed.setAdjustment(1.25);
        basicSpeed.setRate(20);
        model.setBasicSpeed(basicSpeed);
        IntegerAttribute basicMove = new IntegerAttribute();
        basicMove.setBase(6);
        basicMove.setAdjustment(6);
        basicMove.setRate(5);
        model.setBasicMove(basicMove);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPoints() {
        assertEquals(94, model.getPoints());
    }

    @Test
    void getHitPoints() {
        assertEquals(11, model.getHitPoints().getValue());
    }

    @Test
    void getWill() {
        assertEquals(12, model.getWill().getValue());
    }

    @Test
    void getPerception() {
        assertEquals(13, model.getPerception().getValue());
    }

    @Test
    void getFatiguePoints() {
        assertEquals(14, model.getFatiguePoints().getValue());
    }

    @Test
    void getThrustDamageDice() {
        assertEquals(1, model.getThrustDamageDice());
    }

    @Test
    void getThrustDamageAdds() {
        assertEquals(-1, model.getThrustDamageAdds());
    }

    @Test
    void getThrustDamage() {
        assertEquals("1d-1", model.getThrustDamage());
    }

    @Test
    void getSwingDamageDice() {
        assertEquals(2, model.getSwingDamageDice());
    }

    @Test
    void getSwingDamageAdds() {
        assertEquals(0, model.getSwingDamageAdds());
    }

    @Test
    void getSwingDamage() {
        assertEquals("2d", model.getSwingDamage());
    }

    @Test
    void getBasicLift() {
        assertEquals(20.0, model.getBasicLift());
    }

    @Test
    void getBasicSpeed() {
        assertEquals(6.25, model.getBasicSpeed().getValue());
    }

    @Test
    void getBasicMove() {
        assertEquals(12, model.getBasicMove().getValue());
    }
}
