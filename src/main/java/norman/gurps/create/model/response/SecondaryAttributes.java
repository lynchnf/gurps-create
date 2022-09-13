package norman.gurps.create.model.response;

public class SecondaryAttributes {
    private IntegerAttribute hitPoints;
    private IntegerAttribute will;
    private IntegerAttribute perception;
    private IntegerAttribute fatiguePoints;
    private Integer thrustDamageDice;
    private Integer thrustDamageAdds;
    private String thrustDamage;
    private Integer swingDamageDice;
    private Integer swingDamageAdds;
    private String swingDamage;
    private Double basicLift;
    private DoubleAttribute basicSpeed;
    private IntegerAttribute basicMove;

    public Integer getPoints() {
        return hitPoints.getPoints() + will.getPoints() + perception.getPoints() + fatiguePoints.getPoints() +
                basicSpeed.getPoints() + basicMove.getPoints();
    }

    // Generated Getters and Setters //////////////////////////////////////////////////////////////////////////////////
    public IntegerAttribute getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(IntegerAttribute hitPoints) {
        this.hitPoints = hitPoints;
    }

    public IntegerAttribute getWill() {
        return will;
    }

    public void setWill(IntegerAttribute will) {
        this.will = will;
    }

    public IntegerAttribute getPerception() {
        return perception;
    }

    public void setPerception(IntegerAttribute perception) {
        this.perception = perception;
    }

    public IntegerAttribute getFatiguePoints() {
        return fatiguePoints;
    }

    public void setFatiguePoints(IntegerAttribute fatiguePoints) {
        this.fatiguePoints = fatiguePoints;
    }

    public Integer getThrustDamageDice() {
        return thrustDamageDice;
    }

    public void setThrustDamageDice(Integer thrustDamageDice) {
        this.thrustDamageDice = thrustDamageDice;
    }

    public Integer getThrustDamageAdds() {
        return thrustDamageAdds;
    }

    public void setThrustDamageAdds(Integer thrustDamageAdds) {
        this.thrustDamageAdds = thrustDamageAdds;
    }

    public String getThrustDamage() {
        return thrustDamage;
    }

    public void setThrustDamage(String thrustDamage) {
        this.thrustDamage = thrustDamage;
    }

    public Integer getSwingDamageDice() {
        return swingDamageDice;
    }

    public void setSwingDamageDice(Integer swingDamageDice) {
        this.swingDamageDice = swingDamageDice;
    }

    public Integer getSwingDamageAdds() {
        return swingDamageAdds;
    }

    public void setSwingDamageAdds(Integer swingDamageAdds) {
        this.swingDamageAdds = swingDamageAdds;
    }

    public String getSwingDamage() {
        return swingDamage;
    }

    public void setSwingDamage(String swingDamage) {
        this.swingDamage = swingDamage;
    }

    public Double getBasicLift() {
        return basicLift;
    }

    public void setBasicLift(Double basicLift) {
        this.basicLift = basicLift;
    }

    public DoubleAttribute getBasicSpeed() {
        return basicSpeed;
    }

    public void setBasicSpeed(DoubleAttribute basicSpeed) {
        this.basicSpeed = basicSpeed;
    }

    public IntegerAttribute getBasicMove() {
        return basicMove;
    }

    public void setBasicMove(IntegerAttribute basicMove) {
        this.basicMove = basicMove;
    }
}
