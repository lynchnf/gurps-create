package norman.gurps.create.util;

import norman.gurps.create.Application;
import norman.gurps.create.model.DifficultyLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static int calculateEncumbranceLevel(double equipmentWeight, double basicLift) {
        int encLvl = 5;
        if (equipmentWeight <= basicLift) {
            encLvl = 0;
        } else if (equipmentWeight <= 2.0 * basicLift) {
            encLvl = 1;
        } else if (equipmentWeight <= 3.0 * basicLift) {
            encLvl = 2;
        } else if (equipmentWeight <= 6.0 * basicLift) {
            encLvl = 3;
        } else if (equipmentWeight <= 10.0 * basicLift) {
            encLvl = 4;
        }
        return encLvl;
    }

    public static int calculateEncumberedMove(int basicMove, int encumbranceLevel) {
        int move = 0;
        if (encumbranceLevel == 0) {
            move = basicMove;
        } else if (encumbranceLevel == 1) {
            move = (int) (0.8 * basicMove);
        } else if (encumbranceLevel == 2) {
            move = (int) (0.6 * basicMove);
        } else if (encumbranceLevel == 3) {
            move = (int) (0.4 * basicMove);
        } else if (encumbranceLevel == 4) {
            move = (int) (0.2 * basicMove);
        }
        return Math.max(move, 1);
    }

    public static int calculateDodge(double basicSpeed, int encumbranceLevel) {
        return (int) (basicSpeed + 3 - encumbranceLevel);
    }

    public static int calculateSkillLevel(int skillPoints, int attributeValue, DifficultyLevel difficultyLevel) {
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

    public static int calculateSkillPoints(int skillLevel, int attributeValue, DifficultyLevel difficultyLevel) {
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
