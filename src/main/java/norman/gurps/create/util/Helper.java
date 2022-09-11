package norman.gurps.create.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import norman.gurps.create.Application;
import norman.gurps.create.model.BalancedForParry;
import norman.gurps.create.model.DifficultyLevel;
import norman.gurps.create.model.data.AdvantageData;
import norman.gurps.create.model.data.ArmorData;
import norman.gurps.create.model.data.DefaultData;
import norman.gurps.create.model.data.DisadvantageData;
import norman.gurps.create.model.data.EquipmentData;
import norman.gurps.create.model.data.MeleeWeaponData;
import norman.gurps.create.model.data.MeleeWeaponModeData;
import norman.gurps.create.model.data.RangedWeaponData;
import norman.gurps.create.model.data.RangedWeaponModeData;
import norman.gurps.create.model.data.SkillData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static int calculateThrustDamageDice(int strength) {
        if (strength < 11) {
            return 1;
        }
        int[] xy = calculateThrustXandY(strength);
        return calculateDamageDice(strength, xy[0], xy[1]);
    }

    public static int calculateThrustDamageAdds(int strength) {
        if (strength < 11) {
            return (strength - 1) / 2 - 6;
        }
        int[] xy = calculateThrustXandY(strength);
        return calculateDamageAdds(strength, xy[0], xy[1]);
    }

    public static int calculateSwingDamageDice(int strength) {
        if (strength < 9) {
            return 1;
        }
        int[] xy = calculateSwingXandY(strength);
        return calculateDamageDice(strength, xy[0], xy[1]);
    }

    public static int calculateSwingDamageAdds(int strength) {
        if (strength < 9) {
            return (strength - 1) / 2 - 5;
        }
        int[] xy = calculateSwingXandY(strength);
        return calculateDamageAdds(strength, xy[0], xy[1]);
    }

    public static String calculateDamage(int damageDice, int damageAdds) {
        final StringBuilder sb = new StringBuilder();
        sb.append(damageDice).append('d');
        if (damageAdds > 0) {
            sb.append('+').append(damageAdds);
        } else if (damageAdds < 0) {
            sb.append(damageAdds);
        }
        return sb.toString();
    }

    public static double calculateBasicLift(int strength) {
        double basicLift = strength * strength / 5.0;
        if (basicLift >= 10.0) {
            return Math.round(basicLift);
        }
        return basicLift;
    }

    public static double calculateBasicSpeed(int dexterity, int health) {
        return (dexterity + health) / 4.0;
    }

    public static Map<String, AdvantageData> getAdvantageDataMap(File file, ObjectMapper mapper) throws IOException {
        AdvantageData[] dataArray = mapper.readValue(file, AdvantageData[].class);
        Map<String, AdvantageData> dataMap = new HashMap<>();
        for (AdvantageData oldData : dataArray) {
            AdvantageData newData = new AdvantageData();
            newData.setName(oldData.getName());
            newData.setMultiLevel(oldData.getMultiLevel() != null && oldData.getMultiLevel());
            newData.setFirstLevel(oldData.getFirstLevel() != null ? oldData.getFirstLevel() : Integer.valueOf(1));
            newData.setFirstLevelCost(
                    oldData.getFirstLevelCost() != null ? oldData.getFirstLevelCost() : oldData.getCostPerLevel());
            newData.setCostPerLevel(oldData.getCostPerLevel());
            dataMap.put(newData.getName(), newData);
        }
        return dataMap;
    }

    public static Map<String, DisadvantageData> getDisadvantageDataMap(File file, ObjectMapper mapper)
            throws IOException {
        DisadvantageData[] dataArray = mapper.readValue(file, DisadvantageData[].class);
        Map<String, DisadvantageData> dataMap = new HashMap<>();
        for (DisadvantageData oldData : dataArray) {
            DisadvantageData newData = new DisadvantageData();
            newData.setName(oldData.getName());
            newData.setSelfControlAllowed(oldData.getSelfControlAllowed() != null && oldData.getSelfControlAllowed());
            newData.setMultiLevel(oldData.getMultiLevel() != null && oldData.getMultiLevel());
            newData.setCostPerLevel(oldData.getCostPerLevel());
            dataMap.put(newData.getName(), newData);
        }
        return dataMap;
    }

    public static Map<String, SkillData> getSkillDataMap(File file, ObjectMapper mapper) throws IOException {
        SkillData[] dataArray = mapper.readValue(file, SkillData[].class);
        Map<String, SkillData> dataMap = new HashMap<>();
        for (SkillData oldData : dataArray) {
            SkillData newData = new SkillData();
            newData.setName(oldData.getName());
            newData.setControllingAttribute(oldData.getControllingAttribute());
            newData.setDifficultyLevel(oldData.getDifficultyLevel());
            for (DefaultData oldDft : oldData.getDefaults()) {
                DefaultData newDft = new DefaultData();
                if (oldDft.getAttribute() != null) {
                    newDft.setAttribute(oldDft.getAttribute());
                }
                if (oldDft.getSkill() != null) {
                    newDft.setSkill(oldDft.getSkill());
                }
                if (oldDft.getSpecialty() != null) {
                    newDft.setSpecialty(oldDft.getSpecialty());
                }
                newDft.setPenalty(oldDft.getPenalty() != null ? oldDft.getPenalty() : Integer.valueOf(0));
                newData.getDefaults().add(newDft);
            }
            dataMap.put(newData.getName(), newData);
        }
        return dataMap;
    }

    public static Map<String, EquipmentData> getEquipmentDataMap(File file, ObjectMapper mapper) throws IOException {
        EquipmentData[] dataArray = mapper.readValue(file, EquipmentData[].class);
        Map<String, EquipmentData> dataMap = new HashMap<>();
        for (EquipmentData oldData : dataArray) {
            EquipmentData newData = new EquipmentData();
            newData.setName(oldData.getName());
            newData.setCost(oldData.getCost() != null ? oldData.getCost() : Integer.valueOf(0));
            newData.setWeight(oldData.getWeight() != null ? oldData.getWeight() : Double.valueOf(0.0));
            newData.setQuantity(oldData.getQuantity() != null ? oldData.getQuantity() : Integer.valueOf(1));
            if (oldData.getNotes() != null) {
                newData.setNotes(oldData.getNotes());
            }

            // Melee Weapon
            MeleeWeaponData oldMelee = oldData.getMeleeWeapon();
            if (oldMelee != null) {
                MeleeWeaponData newMelee = new MeleeWeaponData();
                newMelee.setSkill(oldMelee.getSkill());
                for (MeleeWeaponModeData oldMode : oldMelee.getModes()) {
                    MeleeWeaponModeData newMode = new MeleeWeaponModeData();
                    if (oldMode.getDamageBase() != null) {
                        newMode.setDamageBase(oldMode.getDamageBase());
                    }
                    newMode.setDamageDice(
                            oldMode.getDamageDice() != null ? oldMode.getDamageDice() : Integer.valueOf(0));
                    newMode.setDamageAdds(
                            oldMode.getDamageAdds() != null ? oldMode.getDamageAdds() : Integer.valueOf(0));
                    newMode.setDamageType(oldMode.getDamageType());
                    if (oldMode.getReaches() != null && !oldMode.getReaches().isEmpty()) {
                        for (Integer reach : oldMode.getReaches()) {
                            newMode.getReaches().add(reach);
                        }
                    } else {
                        newMode.getReaches().add(1);
                    }
                    newMode.setParryAdjust(
                            oldMode.getParryAdjust() != null ? oldMode.getParryAdjust() : Integer.valueOf(0));
                    newMode.setBalancedForParry(
                            oldMode.getBalancedForParry() != null ? oldMode.getBalancedForParry() : BalancedForParry.B);
                    newMode.setMinimumStrength(
                            oldMode.getMinimumStrength() != null ? oldMode.getMinimumStrength() : Integer.valueOf(0));
                    newMode.setRequiresTwoHands(
                            oldMode.getRequiresTwoHands() != null ? oldMode.getRequiresTwoHands() : Boolean.FALSE);
                    if (oldMode.getNote() != null) {
                        newMode.setNote(oldMode.getNote());
                    }
                    newMelee.getModes().add(newMode);
                }
                newData.setMeleeWeapon(newMelee);
            }

            // Ranged Weapon
            RangedWeaponData oldRanged = oldData.getRangedWeapon();
            if (oldRanged != null) {
                RangedWeaponData newRanged = new RangedWeaponData();
                newRanged.setSkill(oldRanged.getSkill());
                for (RangedWeaponModeData oldMode : oldRanged.getModes()) {
                    RangedWeaponModeData newMode = new RangedWeaponModeData();
                    if (oldMode.getDamageBase() != null) {
                        newMode.setDamageBase(oldMode.getDamageBase());
                    }
                    newMode.setDamageDice(
                            oldMode.getDamageDice() != null ? oldMode.getDamageDice() : Integer.valueOf(0));
                    newMode.setDamageAdds(
                            oldMode.getDamageAdds() != null ? oldMode.getDamageAdds() : Integer.valueOf(0));
                    newMode.setDamageType(oldMode.getDamageType());
                    newMode.setAccuracy(oldMode.getAccuracy() != null ? oldMode.getAccuracy() : Integer.valueOf(0));
                    if (oldMode.getHalfDamageRange() != null) {
                        newMode.setHalfDamageRange(oldMode.getHalfDamageRange());
                    }
                    if (oldMode.getHalfDamageRangeMultiplier() != null) {
                        newMode.setHalfDamageRangeMultiplier(oldMode.getHalfDamageRangeMultiplier());
                    }
                    if (oldMode.getMaximumDamageRange() != null) {
                        newMode.setMaximumDamageRange(oldMode.getMaximumDamageRange());
                    }
                    if (oldMode.getMaximumDamageRangeMultiplier() != null) {
                        newMode.setMaximumDamageRangeMultiplier(oldMode.getMaximumDamageRangeMultiplier());
                    }
                    newMode.setRateOfFire(
                            oldMode.getRateOfFire() != null ? oldMode.getRateOfFire() : Integer.valueOf(1));
                    newMode.setShots(oldMode.getShots() != null ? oldMode.getShots() : Integer.valueOf(1));
                    newMode.setTimeToReload(
                            oldMode.getTimeToReload() != null ? oldMode.getTimeToReload() : Integer.valueOf(0));
                    newMode.setMinimumStrength(
                            oldMode.getMinimumStrength() != null ? oldMode.getMinimumStrength() : Integer.valueOf(0));
                    newMode.setRequiresTwoHands(
                            oldMode.getRequiresTwoHands() != null ? oldMode.getRequiresTwoHands() : Boolean.FALSE);
                    newMode.setBulk(oldMode.getBulk() != null ? oldMode.getBulk() : Integer.valueOf(0));
                    if (oldMode.getNote() != null) {
                        newMode.setNote(oldMode.getNote());
                    }
                    newRanged.getModes().add(newMode);
                }
                newData.setRangedWeapon(newRanged);
            }

            // Armor
            ArmorData oldArmor = oldData.getArmor();
            if (oldArmor != null) {
                ArmorData newArmor = new ArmorData();
                newArmor.setDamageResistance(
                        oldArmor.getDamageResistance() != null ? oldArmor.getDamageResistance() : Integer.valueOf(0));
                newData.setArmor(newArmor);
            }
            dataMap.put(newData.getName(), newData);
        }
        return dataMap;
    }

    public static int calculateSkillLevel(int skillPoints, int attributeValue, DifficultyLevel difficultyLevel,
            String skillName) {
        int index;
        if (skillPoints <= 0) {
            return 0;
        } else if (skillPoints <= 1) {
            index = 1;
        } else if (skillPoints <= 2) {
            index = 2;
        } else {
            index = (skillPoints / 4) + 2;
        }

        if (difficultyLevel == DifficultyLevel.E) {
            index -= 1;
        } else if (difficultyLevel == DifficultyLevel.A) {
            index -= 2;
        } else if (difficultyLevel == DifficultyLevel.H) {
            index -= 3;
        } else if (difficultyLevel == DifficultyLevel.VH) {
            index -= 4;
        }

        return index + attributeValue;
    }

    public static int calculateSkillPoints(int skillLevel, int attributeValue, DifficultyLevel difficultyLevel,
            String skillName) {
        int index = skillLevel - attributeValue;
        if (difficultyLevel == DifficultyLevel.E) {
            index += 1;
        } else if (difficultyLevel == DifficultyLevel.A) {
            index += 2;
        } else if (difficultyLevel == DifficultyLevel.H) {
            index += 3;
        } else if (difficultyLevel == DifficultyLevel.VH) {
            index += 4;
        }

        if (index <= 0) {
            return 0;
        } else if (index <= 1) {
            return 1;
        } else if (index <= 2) {
            return 2;
        } else {
            return (index - 2) * 4;
        }
    }

    // Private Methods ////////////////////////////////////////////////////////////////////////////////////////////////
    private static int[] calculateThrustXandY(int strength) {
        int[] xy = {0, 0};
        if (strength < 55) {
            xy[0] = 3;
            xy[1] = 8;
        } else if (strength < 70) {
            xy[0] = 4;
            xy[1] = 8;
        } else {
            xy[0] = -13;
            xy[1] = 10;
        }
        return xy;
    }

    private static int[] calculateSwingXandY(int strength) {
        int[] xy = {0, 0};
        if (strength < 27) {
            xy[0] = 5;
            xy[1] = 4;
        } else if (strength < 45) {
            xy[0] = -17;
            xy[1] = 8;
        } else if (strength < 60) {
            xy[0] = -30;
            xy[1] = 10;
        } else {
            xy[0] = -33;
            xy[1] = 10;
        }
        return xy;
    }

    private static int calculateDamageDice(int strength, int x, int y) {
        return (strength - x) / y;
    }

    private static int calculateDamageAdds(int strength, int x, int y) {
        return (strength - x) * 4 / y % 4 - 1;
    }
}
