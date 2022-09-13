package norman.gurps.create.model.data;

import norman.gurps.create.model.Affected;

public class EffectData {
    private Affected affected;
    private Integer adjustment;

    public Affected getAffected() {
        return affected;
    }

    public void setAffected(Affected affected) {
        this.affected = affected;
    }

    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
    }
}