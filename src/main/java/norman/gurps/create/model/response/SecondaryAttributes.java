package norman.gurps.create.model.response;

public class SecondaryAttributes {
    private IntegerAttribute hitPoints;
    private IntegerAttribute will;
    private IntegerAttribute perception;
    private IntegerAttribute fatiguePoints;
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
