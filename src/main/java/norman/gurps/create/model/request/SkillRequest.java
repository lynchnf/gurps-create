package norman.gurps.create.model.request;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class SkillRequest {
    private String name; // Should not be null.
    private String specialty;
    private Integer minLevel;
    private Integer maxPoints = INTEGER_ZERO;

    public SkillRequest() {
    }

    public SkillRequest(String name) {
        this.name = name;
    }

    public SkillRequest(String name, Integer minLevel) {
        this.name = name;
        this.minLevel = minLevel;
    }

    public SkillRequest(String name, String specialty, Integer minLevel) {
        this.name = name;
        this.specialty = specialty;
        this.minLevel = minLevel;
    }

    public SkillRequest(String name, String specialty, Integer minLevel, Integer maxPoints) {
        this.name = name;
        this.specialty = specialty;
        this.minLevel = minLevel;
        this.maxPoints = maxPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
