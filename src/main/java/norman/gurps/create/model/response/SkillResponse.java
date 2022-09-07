package norman.gurps.create.model.response;

import norman.gurps.create.model.ControllingAttribute;
import norman.gurps.create.model.DifficultyLevel;

public class SkillResponse {
    private String name;
    private ControllingAttribute controllingAttribute;
    private DifficultyLevel difficultyLevel;
    private String specialty;
    private Integer minLevel;
    private Integer maxPoints;
    private Integer controllingAttributeValue;
    private Integer level;
    private Integer points;
    private DefaultResponse bestDefault;

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public Integer getControllingAttributeValue() {
        return controllingAttributeValue;
    }

    public void setControllingAttributeValue(Integer controllingAttributeValue) {
        this.controllingAttributeValue = controllingAttributeValue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public DefaultResponse getBestDefault() {
        return bestDefault;
    }

    public void setBestDefault(DefaultResponse bestDefault) {
        this.bestDefault = bestDefault;
    }
}
