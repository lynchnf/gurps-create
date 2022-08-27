package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

public class SkillData {
    private String name;
    private String controllingAttribute;
    private String difficultyLevel;
    private List<DefaultData> defaults = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getControllingAttribute() {
        return controllingAttribute;
    }

    public void setControllingAttribute(String controllingAttribute) {
        this.controllingAttribute = controllingAttribute;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<DefaultData> getDefaults() {
        return defaults;
    }

    public void setDefaults(List<DefaultData> defaults) {
        this.defaults = defaults;
    }
}
