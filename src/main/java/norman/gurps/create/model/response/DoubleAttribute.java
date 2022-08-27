package norman.gurps.create.model.response;

public class DoubleAttribute {
    private Double base;
    private Double adjustment;
    private Integer rate;

    public Double getValue() {
        return base + adjustment;
    }

    public Integer getPoints() {
        return Math.toIntExact(Math.round(adjustment * rate));
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Double adjustment) {
        this.adjustment = adjustment;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
