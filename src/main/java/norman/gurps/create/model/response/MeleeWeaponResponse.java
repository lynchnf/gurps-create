package norman.gurps.create.model.response;

import java.util.ArrayList;
import java.util.List;

public class MeleeWeaponResponse {
    private String name;
    private Integer skill;
    private Integer damageDice;
    private Integer damageAdds;
    private String damageType;
    private List<Integer> reaches = new ArrayList<>();
    private Integer parry;
    private String balancedForParry;
    private Integer minimumStrength;
    private Boolean requiresTwoHands;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getDamageDice() {
        return damageDice;
    }

    public void setDamageDice(Integer damageDice) {
        this.damageDice = damageDice;
    }

    public Integer getDamageAdds() {
        return damageAdds;
    }

    public void setDamageAdds(Integer damageAdds) {
        this.damageAdds = damageAdds;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public List<Integer> getReaches() {
        return reaches;
    }

    public void setReaches(List<Integer> reaches) {
        this.reaches = reaches;
    }

    public Integer getParry() {
        return parry;
    }

    public void setParry(Integer parry) {
        this.parry = parry;
    }

    public String getBalancedForParry() {
        return balancedForParry;
    }

    public void setBalancedForParry(String balancedForParry) {
        this.balancedForParry = balancedForParry;
    }

    public Integer getMinimumStrength() {
        return minimumStrength;
    }

    public void setMinimumStrength(Integer minimumStrength) {
        this.minimumStrength = minimumStrength;
    }

    public Boolean getRequiresTwoHands() {
        return requiresTwoHands;
    }

    public void setRequiresTwoHands(Boolean requiresTwoHands) {
        this.requiresTwoHands = requiresTwoHands;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
