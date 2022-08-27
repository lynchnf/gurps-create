package norman.gurps.create.model.data;

public class AdvantageData {
    private String name;
    private Boolean multiLevel;
    private Integer firstLevel;
    private Integer firstLevelCost;
    private Integer costPerLevel;

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
}
