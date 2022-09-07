package norman.gurps.create.model.response;

import norman.gurps.create.model.BalancedForParry;
import norman.gurps.create.model.DamageType;

import java.util.ArrayList;
import java.util.List;

public class MeleeWeaponResponse {
    private String name;
    private Integer skill;
    private Integer damageDice;
    private Integer damageAdds;
    private DamageType damageType;
    private List<Integer> reaches = new ArrayList<>();
    private Integer parry;
    private BalancedForParry balancedForParry;
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

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
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

    public BalancedForParry getBalancedForParry() {
        return balancedForParry;
    }

    public void setBalancedForParry(BalancedForParry balancedForParry) {
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
