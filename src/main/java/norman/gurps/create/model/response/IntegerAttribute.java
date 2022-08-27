package norman.gurps.create.model.response;

public class IntegerAttribute {
    private Integer base;
    private Integer adjustment;
    private Integer rate;

    public Integer getValue() {
        return base + adjustment;
    }

    public Integer getPoints() {
        return adjustment * rate;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
