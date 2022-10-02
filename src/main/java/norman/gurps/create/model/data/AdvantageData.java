package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class AdvantageData {
    private String name; // Should not be null.
    private String page;
    private Boolean multiLevel = Boolean.FALSE;
    private Integer firstLevel = INTEGER_ONE;
    private Integer firstLevelCost; // Special getter. Should default to costPerLevel;
    private Integer costPerLevel = INTEGER_ZERO;
    private List<EffectData> effects = new ArrayList<>();

    public Integer getFirstLevelCost() {
        return firstLevelCost != null ? firstLevelCost : getCostPerLevel();
    }

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

    public Boolean getMultiLevel() {
        return multiLevel;
    }

    public void setMultiLevel(Boolean multiLevel) {
        this.multiLevel = multiLevel;
    }

    public Integer getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(Integer firstLevel) {
        this.firstLevel = firstLevel;
    }

    public void setFirstLevelCost(Integer firstLevelCost) {
        this.firstLevelCost = firstLevelCost;
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
