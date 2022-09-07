package norman.gurps.create.model.response;

import norman.gurps.create.model.DamageType;

public class RangedWeaponResponse {
    private String name;
    private Integer skill;
    private Integer damageDice;
    private Integer damageAdds;
    private DamageType damageType;
    private Integer accuracy;
    private Integer halfDamageRange;
    private Integer maximumDamageRange;
    private Integer rateOfFire;
    private Integer shots;
    private Integer timeToReload;
    private Integer minimumStrength;
    private Boolean requiresTwoHands;
    private Integer bulk;
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

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getHalfDamageRange() {
        return halfDamageRange;
    }

    public void setHalfDamageRange(Integer halfDamageRange) {
        this.halfDamageRange = halfDamageRange;
    }

    public Integer getMaximumDamageRange() {
        return maximumDamageRange;
    }

    public void setMaximumDamageRange(Integer maximumDamageRange) {
        this.maximumDamageRange = maximumDamageRange;
    }

    public Integer getRateOfFire() {
        return rateOfFire;
    }

    public void setRateOfFire(Integer rateOfFire) {
        this.rateOfFire = rateOfFire;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getTimeToReload() {
        return timeToReload;
    }

    public void setTimeToReload(Integer timeToReload) {
        this.timeToReload = timeToReload;
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

    public Integer getBulk() {
        return bulk;
    }

    public void setBulk(Integer bulk) {
        this.bulk = bulk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
