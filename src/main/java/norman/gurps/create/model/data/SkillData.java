package norman.gurps.create.model.data;

import norman.gurps.create.model.ControllingAttribute;
import norman.gurps.create.model.DifficultyLevel;

import java.util.ArrayList;
import java.util.List;

public class SkillData {
    private String name;
    private ControllingAttribute controllingAttribute;
    private DifficultyLevel difficultyLevel;
    private List<DefaultData> defaults = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ControllingAttribute getControllingAttribute() {
        return controllingAttribute;
    }

    public void setControllingAttribute(ControllingAttribute controllingAttribute) {
        this.controllingAttribute = controllingAttribute;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<DefaultData> getDefaults() {
        return defaults;
    }

    public void setDefaults(List<DefaultData> defaults) {
        this.defaults = defaults;
    }
}
