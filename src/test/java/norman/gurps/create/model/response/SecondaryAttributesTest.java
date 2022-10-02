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
    void getBasicSpeed() {
        assertEquals(6.25, model.getBasicSpeed().getValue());
    }

    @Test
    void getBasicMove() {
        assertEquals(12, model.getBasicMove().getValue());
    }
}
