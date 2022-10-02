package norman.gurps.create.model.data;

import norman.gurps.create.model.ControllingAttribute;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class DefaultData {
    // One and only one of attribute and skill should be non-null.
    private ControllingAttribute attribute;
    private String skill;
    private String forSpecialty;
    private String toSpecialty;
    private Boolean sameToSpecialty = Boolean.FALSE;
    private Integer penalty = INTEGER_ZERO;

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

    public String getForSpecialty() {
        return forSpecialty;
    }

    public void setForSpecialty(String forSpecialty) {
        this.forSpecialty = forSpecialty;
    }

    public String getToSpecialty() {
        return toSpecialty;
    }

    public void setToSpecialty(String toSpecialty) {
        this.toSpecialty = toSpecialty;
    }

    public Boolean getSameToSpecialty() {
        return sameToSpecialty;
    }

    public void setSameToSpecialty(Boolean sameToSpecialty) {
        this.sameToSpecialty = sameToSpecialty;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }
}
