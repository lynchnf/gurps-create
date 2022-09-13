package norman.gurps.create.model.response;

public class PrimaryAttributes {
    private IntegerAttribute strength;
    private IntegerAttribute dexterity;
    private IntegerAttribute intelligence;
    private IntegerAttribute health;

    public Integer getPoints() {
        return strength.getPoints() + dexterity.getPoints() + intelligence.getPoints() + health.getPoints();
    }

    // Generated Getters and Setters //////////////////////////////////////////////////////////////////////////////////
    public IntegerAttribute getStrength() {
        return strength;
    }

    public void setStrength(IntegerAttribute strength) {
        this.strength = strength;
    }

    public IntegerAttribute getDexterity() {
        return dexterity;
    }

    public void setDexterity(IntegerAttribute dexterity) {
        this.dexterity = dexterity;
    }

    public IntegerAttribute getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(IntegerAttribute intelligence) {
        this.intelligence = intelligence;
    }

    public IntegerAttribute getHealth() {
        return health;
    }

    public void setHealth(IntegerAttribute health) {
        this.health = health;
    }
}
