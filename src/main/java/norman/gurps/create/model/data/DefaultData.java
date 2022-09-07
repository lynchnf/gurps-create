package norman.gurps.create.model.data;

import norman.gurps.create.model.ControllingAttribute;

public class DefaultData {
    private ControllingAttribute attribute;
    private String skill;
    private String specialty;
    private Integer penalty;

    public ControllingAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(ControllingAttribute attribute) {
        this.attribute = attribute;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }
}
