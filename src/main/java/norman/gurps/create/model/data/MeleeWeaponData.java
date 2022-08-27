package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

public class MeleeWeaponData {
    private String skill;
    private List<MeleeWeaponModeData> modes = new ArrayList<>();

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public List<MeleeWeaponModeData> getModes() {
        return modes;
    }

    public void setModes(List<MeleeWeaponModeData> modes) {
        this.modes = modes;
    }
}
