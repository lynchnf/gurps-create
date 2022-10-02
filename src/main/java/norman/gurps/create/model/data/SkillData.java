package norman.gurps.create.model.data;

import norman.gurps.create.model.ControllingAttribute;
import norman.gurps.create.model.DifficultyLevel;
import norman.gurps.create.model.Specialize;

import java.util.ArrayList;
import java.util.List;

public class SkillData {
    private String name; // Should not be null.
    private String page;
    private Boolean tech = Boolean.FALSE;
    private Specialize specialize = Specialize.NOT;
    private ControllingAttribute controllingAttribute; // Should not be null.
    private DifficultyLevel difficultyLevel; // Should not be null.
    private List<String> suggestedSpecialties = new ArrayList<>();
    private List<DefaultData> defaults = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Boolean getTech() {
        return tech;
    }

    public void setTech(Boolean tech) {
        this.tech = tech;
    }

    public Specialize getSpecialize() {
        return specialize;
    }

    public void setSpecialize(Specialize specialize) {
        this.specialize = specialize;
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

    public List<String> getSuggestedSpecialties() {
        return suggestedSpecialties;
    }

    public void setSuggestedSpecialties(List<String> suggestedSpecialties) {
        this.suggestedSpecialties = suggestedSpecialties;
    }

    public List<DefaultData> getDefaults() {
        return defaults;
    }

    public void setDefaults(List<DefaultData> defaults) {
        this.defaults = defaults;
    }
}
