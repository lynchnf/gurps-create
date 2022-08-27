package norman.gurps.create.model.data;

public class DisadvantageData {
    private String name;
    private Boolean selfControlAllowed;
    private Boolean multiLevel;
    private Integer costPerLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
