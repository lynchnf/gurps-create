package norman.gurps.create.model.response;

public class AdvantageResponse {
    private String name;
    private Boolean multiLevel;
    private Integer firstLevel;
    private Integer firstLevelCost;
    private Integer costPerLevel;
    private String description;
    private Integer level;

    public Integer getPoints() {
        if (multiLevel) {
            return firstLevelCost + (level - firstLevel) * costPerLevel;
        }
        return costPerLevel;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
