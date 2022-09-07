package norman.gurps.create.model.data;

import norman.gurps.create.model.BalancedForParry;
import norman.gurps.create.model.DamageBase;
import norman.gurps.create.model.DamageType;

import java.util.ArrayList;
import java.util.List;

public class MeleeWeaponModeData {
    private DamageBase damageBase;
    private Integer damageDice;
    private Integer damageAdds;
    private DamageType damageType;
    private List<Integer> reaches = new ArrayList<>();
    private Integer parryAdjust;
    private BalancedForParry balancedForParry;
    private Integer minimumStrength;
    private Boolean requiresTwoHands;
    private String note;

    public DamageBase getDamageBase() {
        return damageBase;
    }

    public void setDamageBase(DamageBase damageBase) {
        this.damageBase = damageBase;
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

    public Integer getParryAdjust() {
        return parryAdjust;
    }

    public void setParryAdjust(Integer parryAdjust) {
        this.parryAdjust = parryAdjust;
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
