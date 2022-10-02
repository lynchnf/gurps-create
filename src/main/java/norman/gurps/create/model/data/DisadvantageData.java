package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class DisadvantageData {
    private String name; // Should not be null.
    private String page;
    private Boolean selfControlAllowed = Boolean.FALSE;
    private Boolean multiLevel = Boolean.FALSE;
    private Integer costPerLevel = INTEGER_ZERO;
    private List<EffectData> effects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Boolean getSelfControlAllowed() {
        return selfControlAllowed;
    }

    public void setSelfControlAllowed(Boolean selfControlAllowed) {
        this.selfControlAllowed = selfControlAllowed;
    }

    public Boolean getMultiLevel() {
        return multiLevel;
    }

    public void setMultiLevel(Boolean multiLevel) {
        this.multiLevel = multiLevel;
    }

    public Integer getCostPerLevel() {
        return costPerLevel;
    }

    public void setCostPerLevel(Integer costPerLevel) {
        this.costPerLevel = costPerLevel;
    }

    public List<EffectData> getEffects() {
        return effects;
    }

    public void setEffects(List<EffectData> effects) {
        this.effects = effects;
    }
}
