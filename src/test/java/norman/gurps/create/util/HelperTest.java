package norman.gurps.create.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import norman.gurps.create.LoggingException;
import norman.gurps.create.model.data.AdvantageData;
import norman.gurps.create.model.data.DisadvantageData;
import norman.gurps.create.model.data.EquipmentData;
import norman.gurps.create.model.data.SkillData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HelperTest {
    int[] strengths = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
    String[] thrustDamages = {"1d-6", "1d-6", "1d-5", "1d-5", "1d-4", "1d-4", "1d-3", "1d-3", "1d-2", "1d-2", "1d-1",
            "1d-1", "1d", "1d", "1d+1", "1d+1", "1d+2", "1d+2", "2d-1", "2d-1", "2d", "2d", "2d+1", "2d+1", "2d+2",
            "2d+2", "3d-1", "3d-1", "3d", "3d", "3d+1", "3d+1", "3d+2", "3d+2", "4d-1", "4d-1", "4d", "4d", "4d+1",
            "4d+1", "5d", "5d+2", "6d", "7d-1", "7d+1", "8d", "8d+2", "9d", "9d+2", "10d", "10d+2", "11d"};
    String[] swingDamages = {"1d-5", "1d-5", "1d-4", "1d-4", "1d-3", "1d-3", "1d-2", "1d-2", "1d-1", "1d", "1d+1",
            "1d+2", "2d-1", "2d", "2d+1", "2d+2", "3d-1", "3d", "3d+1", "3d+2", "4d-1", "4d", "4d+1", "4d+2", "5d-1",
            "5d", "5d+1", "5d+1", "5d+2", "5d+2", "6d-1", "6d-1", "6d", "6d", "6d+1", "6d+1", "6d+2", "6d+2", "7d-1",
            "7d-1", "7d+1", "8d-1", "8d+1", "9d", "9d+2", "10d", "10d+2", "11d", "11d+2", "12d", "12d+2", "13d"};
    double[] basicLifts = {0.2, 0.8, 1.8, 3.2, 5.0, 7.2, 9.8, 13.0, 16.0, 20.0, 24.0, 29.0, 34.0, 39.0, 45.0, 51.0,
            58.0, 65.0, 72.0, 80.0};
    ClassLoader loader;
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        loader = Thread.currentThread().getContextClassLoader();
        mapper = new ObjectMapper();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateThrustDamage() {
        for (int idx = 0; idx < strengths.length; idx++) {
            int strength = strengths[idx];
            String expectedDamage = thrustDamages[idx];
            int damageDice = Helper.calculateThrustDamageDice(strength);
            int damageAdds = Helper.calculateThrustDamageAdds(strength);
            String actualDamage = Helper.calculateDamage(damageDice, damageAdds);
            assertEquals(expectedDamage, actualDamage, String.format("Assertion failed for strength %d.", strength));
        }
    }

    @Test
    void calculateSwingDamageDice() {
        for (int idx = 0; idx < strengths.length; idx++) {
            int strength = strengths[idx];
            String expectedDamage = swingDamages[idx];
            int damageDice = Helper.calculateSwingDamageDice(strength);
            int damageAdds = Helper.calculateSwingDamageAdds(strength);
            String actualDamage = Helper.calculateDamage(damageDice, damageAdds);
            assertEquals(expectedDamage, actualDamage, String.format("Assertion failed for strength %d.", strength));
        }
    }

    @Test
    void calculateBasicLift() {
        for (int idx = 0; idx < basicLifts.length; idx++) {
            int strength = idx + 1;
            double expected = basicLifts[idx];
            double actual = Helper.calculateBasicLift(strength);
            assertEquals(expected, actual, 0.001, String.format("Assertion failed for strength %d.", strength));
        }
    }

    @Test
    void calculateBasicSpeed() {
        assertEquals(4.50, Helper.calculateBasicSpeed(9, 9), 0.001);
        assertEquals(4.75, Helper.calculateBasicSpeed(9, 10), 0.001);
        assertEquals(5.00, Helper.calculateBasicSpeed(9, 11), 0.001);
        assertEquals(5.25, Helper.calculateBasicSpeed(9, 12), 0.001);

        assertEquals(4.75, Helper.calculateBasicSpeed(10, 9), 0.001);
        assertEquals(5.00, Helper.calculateBasicSpeed(10, 10), 0.001);
        assertEquals(5.25, Helper.calculateBasicSpeed(10, 11), 0.001);
        assertEquals(5.50, Helper.calculateBasicSpeed(10, 12), 0.001);

        assertEquals(5.00, Helper.calculateBasicSpeed(11, 9), 0.001);
        assertEquals(5.25, Helper.calculateBasicSpeed(11, 10), 0.001);
        assertEquals(5.50, Helper.calculateBasicSpeed(11, 11), 0.001);
        assertEquals(5.75, Helper.calculateBasicSpeed(11, 12), 0.001);

        assertEquals(5.25, Helper.calculateBasicSpeed(12, 9), 0.001);
        assertEquals(5.50, Helper.calculateBasicSpeed(12, 10), 0.001);
        assertEquals(5.75, Helper.calculateBasicSpeed(12, 11), 0.001);
        assertEquals(6.00, Helper.calculateBasicSpeed(12, 12), 0.001);
    }

    @Test
    void getAdvantageDataMap() {
        Map<String, AdvantageData> map = Helper.getAdvantageDataMap(loader, mapper);
        assertEquals(1, map.size());
        AdvantageData data = map.get("AdvantageName");
        assertEquals("AdvantageName", data.getName());
        assertEquals(false, data.getMultiLevel());
        assertEquals(12, data.getFirstLevel());
        assertEquals(23, data.getFirstLevelCost());
        assertEquals(34, data.getCostPerLevel());
    }

    @Test
    void getDisadvantageDataMap() {
        Map<String, DisadvantageData> map = Helper.getDisadvantageDataMap(loader, mapper);
        assertEquals(1, map.size());
        DisadvantageData data = map.get("DisadvantageName");
        assertEquals("DisadvantageName", data.getName());
        assertEquals(false, data.getSelfControlAllowed());
        assertEquals(true, data.getMultiLevel());
        assertEquals(-12, data.getCostPerLevel());
    }

    @Test
    void getSkillDataMap() {
        Map<String, SkillData> map = Helper.getSkillDataMap(loader, mapper);
        assertEquals(1, map.size());
        SkillData data = map.get("SkillName");
        assertEquals("SkillName", data.getName());
        assertEquals("ST", data.getControllingAttribute());
        assertEquals("E", data.getDifficultyLevel());
        assertEquals(1, data.getDefaults().size());
        assertEquals("ST", data.getDefaults().get(0).getAttribute());
        assertEquals(-4, data.getDefaults().get(0).getPenalty());
    }

    @Test
    void getEquipmentDataMap() {
        Map<String, EquipmentData> map = Helper.getEquipmentDataMap(loader, mapper);
        assertEquals(1, map.size());
        EquipmentData data = map.get("EquipmentName");
        assertEquals("EquipmentName", data.getName());
        assertEquals(1.23, data.getWeight(), 0.001);
        assertEquals(234, data.getQuantity());
        assertEquals("Test equipment", data.getNotes());
    }

    @Test
    void calculateSkillLevel_HappyPath() {
        assertEquals(10, Helper.calculateSkillLevel(1, 10, "E", "SkillName"));
        assertEquals(11, Helper.calculateSkillLevel(2, 10, "E", "SkillName"));
        assertEquals(12, Helper.calculateSkillLevel(4, 10, "E", "SkillName"));
        assertEquals(13, Helper.calculateSkillLevel(8, 10, "E", "SkillName"));
        assertEquals(14, Helper.calculateSkillLevel(12, 10, "E", "SkillName"));
        assertEquals(15, Helper.calculateSkillLevel(16, 10, "E", "SkillName"));

        assertEquals(9, Helper.calculateSkillLevel(1, 10, "A", "SkillName"));
        assertEquals(10, Helper.calculateSkillLevel(2, 10, "A", "SkillName"));
        assertEquals(11, Helper.calculateSkillLevel(4, 10, "A", "SkillName"));
        assertEquals(12, Helper.calculateSkillLevel(8, 10, "A", "SkillName"));
        assertEquals(13, Helper.calculateSkillLevel(12, 10, "A", "SkillName"));
        assertEquals(14, Helper.calculateSkillLevel(16, 10, "A", "SkillName"));

        assertEquals(8, Helper.calculateSkillLevel(1, 10, "H", "SkillName"));
        assertEquals(9, Helper.calculateSkillLevel(2, 10, "H", "SkillName"));
        assertEquals(10, Helper.calculateSkillLevel(4, 10, "H", "SkillName"));
        assertEquals(11, Helper.calculateSkillLevel(8, 10, "H", "SkillName"));
        assertEquals(12, Helper.calculateSkillLevel(12, 10, "H", "SkillName"));
        assertEquals(13, Helper.calculateSkillLevel(16, 10, "H", "SkillName"));

        assertEquals(7, Helper.calculateSkillLevel(1, 10, "VH", "SkillName"));
        assertEquals(8, Helper.calculateSkillLevel(2, 10, "VH", "SkillName"));
        assertEquals(9, Helper.calculateSkillLevel(4, 10, "VH", "SkillName"));
        assertEquals(10, Helper.calculateSkillLevel(8, 10, "VH", "SkillName"));
        assertEquals(11, Helper.calculateSkillLevel(12, 10, "VH", "SkillName"));
        assertEquals(12, Helper.calculateSkillLevel(16, 10, "VH", "SkillName"));
    }

    @Test
    void calculateSkillLevel_ZeroPoints() {
        assertEquals(0, Helper.calculateSkillLevel(0, 10, "E", "SkillName"));
    }

    @Test
    void calculateSkillLevel_BadDifficultyLevel() {
        assertThrows(LoggingException.class, () -> Helper.calculateSkillLevel(1, 10, "X", "SkillName"));
    }

    @Test
    void calculateSkillPoints_HappyPath() {
        assertEquals(0, Helper.calculateSkillPoints(7, 10, "E", "SkillName"));
        assertEquals(0, Helper.calculateSkillPoints(8, 10, "E", "SkillName"));
        assertEquals(0, Helper.calculateSkillPoints(9, 10, "E", "SkillName"));
        assertEquals(1, Helper.calculateSkillPoints(10, 10, "E", "SkillName"));
        assertEquals(2, Helper.calculateSkillPoints(11, 10, "E", "SkillName"));
        assertEquals(4, Helper.calculateSkillPoints(12, 10, "E", "SkillName"));
        assertEquals(8, Helper.calculateSkillPoints(13, 10, "E", "SkillName"));
        assertEquals(12, Helper.calculateSkillPoints(14, 10, "E", "SkillName"));
        assertEquals(16, Helper.calculateSkillPoints(15, 10, "E", "SkillName"));

        assertEquals(0, Helper.calculateSkillPoints(7, 10, "A", "SkillName"));
        assertEquals(0, Helper.calculateSkillPoints(8, 10, "A", "SkillName"));
        assertEquals(1, Helper.calculateSkillPoints(9, 10, "A", "SkillName"));
        assertEquals(2, Helper.calculateSkillPoints(10, 10, "A", "SkillName"));
        assertEquals(4, Helper.calculateSkillPoints(11, 10, "A", "SkillName"));
        assertEquals(8, Helper.calculateSkillPoints(12, 10, "A", "SkillName"));
        assertEquals(12, Helper.calculateSkillPoints(13, 10, "A", "SkillName"));
        assertEquals(16, Helper.calculateSkillPoints(14, 10, "A", "SkillName"));
        assertEquals(20, Helper.calculateSkillPoints(15, 10, "A", "SkillName"));

        assertEquals(0, Helper.calculateSkillPoints(7, 10, "H", "SkillName"));
        assertEquals(1, Helper.calculateSkillPoints(8, 10, "H", "SkillName"));
        assertEquals(2, Helper.calculateSkillPoints(9, 10, "H", "SkillName"));
        assertEquals(4, Helper.calculateSkillPoints(10, 10, "H", "SkillName"));
        assertEquals(8, Helper.calculateSkillPoints(11, 10, "H", "SkillName"));
        assertEquals(12, Helper.calculateSkillPoints(12, 10, "H", "SkillName"));
        assertEquals(16, Helper.calculateSkillPoints(13, 10, "H", "SkillName"));
        assertEquals(20, Helper.calculateSkillPoints(14, 10, "H", "SkillName"));
        assertEquals(24, Helper.calculateSkillPoints(15, 10, "H", "SkillName"));

        assertEquals(1, Helper.calculateSkillPoints(7, 10, "VH", "SkillName"));
        assertEquals(2, Helper.calculateSkillPoints(8, 10, "VH", "SkillName"));
        assertEquals(4, Helper.calculateSkillPoints(9, 10, "VH", "SkillName"));
        assertEquals(8, Helper.calculateSkillPoints(10, 10, "VH", "SkillName"));
        assertEquals(12, Helper.calculateSkillPoints(11, 10, "VH", "SkillName"));
        assertEquals(16, Helper.calculateSkillPoints(12, 10, "VH", "SkillName"));
        assertEquals(20, Helper.calculateSkillPoints(13, 10, "VH", "SkillName"));
        assertEquals(24, Helper.calculateSkillPoints(14, 10, "VH", "SkillName"));
        assertEquals(28, Helper.calculateSkillPoints(15, 10, "VH", "SkillName"));
    }

    @Test
    void calculateSkillPoints_BadDifficultyLevel() {
        assertThrows(LoggingException.class, () -> Helper.calculateSkillPoints(7, 10, "X", "SkillName"));
    }
}
