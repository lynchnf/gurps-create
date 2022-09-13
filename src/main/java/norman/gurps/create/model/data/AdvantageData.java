package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

public class AdvantageData {
    private String name;
    private Boolean multiLevel;
    private Integer firstLevel;
    private Integer firstLevelCost;
    private Integer costPerLevel;
    private String page;
    private List<EffectData> effects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getFirstLevelCost() {
        return firstLevelCost;
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<EffectData> getEffects() {
        return effects;
    }

    public void setEffects(List<EffectData> effects) {
        this.effects = effects;
    }
}
