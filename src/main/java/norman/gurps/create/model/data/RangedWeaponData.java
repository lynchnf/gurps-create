package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

public class RangedWeaponData {
    private String skill;
    private List<RangedWeaponModeData> modes = new ArrayList<>();

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public List<RangedWeaponModeData> getModes() {
        return modes;
    }

    public void setModes(List<RangedWeaponModeData> modes) {
        this.modes = modes;
    }
}
