package norman.gurps.create.model.data;

import norman.gurps.create.model.Affected;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class EffectData {
    private Affected affected; // Should not be null.
    private Integer adjustment = INTEGER_ZERO;

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