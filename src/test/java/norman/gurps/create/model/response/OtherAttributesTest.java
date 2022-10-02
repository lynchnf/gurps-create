package norman.gurps.create.model.response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OtherAttributesTest {
    OtherAttributes model;

    @BeforeEach
    void setUp() {
        model = new OtherAttributes();
        model.setDamageStrength(11);
        model.setThrustDamageDice(1);
        model.setThrustDamageAdds(-1);
        model.setThrustDamage("1d-1");
        model.setSwingDamageDice(2);
        model.setSwingDamageAdds(0);
        model.setSwingDamage("2d");
        model.setLiftingStrength(12);
        model.setBasicLift(20.0);

        model.setEncumbranceLevel(123);
        model.setEncumberedMove(234);
        model.setDamageResistance(345);
        model.setDodge(456);
        model.setFrightCheck(567);
        model.setMentalStunCheck(678);
        model.setPhysicalStunCheck(789);
        model.setDeathCheck(890);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDamageStrength() {
        assertEquals(11, model.getDamageStrength());
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
    void getFoo() {
        assertEquals(12, model.getLiftingStrength());
    }

    @Test
    void getBasicLift() {
        assertEquals(20.0, model.getBasicLift());
    }

    @Test
    void getEncumbranceLevel() {
        assertEquals(123, model.getEncumbranceLevel());
    }

    @Test
    void getEncumberedMove() {
        assertEquals(234, model.getEncumberedMove());
    }

    @Test
    void getDamageResistance() {
        assertEquals(345, model.getDamageResistance());
    }

    @Test
    void getDodge() {
        assertEquals(456, model.getDodge());
    }

    @Test
    void getFrightCheck() {
        assertEquals(567, model.getFrightCheck());
    }

    @Test
    void getMentalStunCheck() {
        assertEquals(678, model.getMentalStunCheck());
    }

    @Test
    void getPhysicalStunCheck() {
        assertEquals(789, model.getPhysicalStunCheck());
    }

    @Test
    void getDeathCheck() {
        assertEquals(890, model.getDeathCheck());
    }
}
