package norman.gurps.create.model.response;

public class DisadvantageResponse {
    private String name;
    private Boolean selfControlAllowed;
    private Boolean multiLevel;
    private Integer costPerLevel;
    private Integer selfControlLevel;
    private String description;
    private Integer level;

    public Integer getPoints() {
        int points = 0;
        if (multiLevel) {
            points = level * costPerLevel;
        } else {
            points = costPerLevel;
        }
        if (selfControlAllowed) {
            if (selfControlLevel <= 6) {
                points *= 2;
            } else if (selfControlLevel <= 9) {
                points *= 1.5;
            } else if (selfControlLevel > 12 && selfControlLevel <= 15) {
                points *= 0.5;
            } else if (selfControlLevel > 15) {
                points = 0;
            }
        }
        return points;
    }

    // Generated Getters and Setters //////////////////////////////////////////////////////////////////////////////////
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

    public Integer getSelfControlLevel() {
        return selfControlLevel;
    }

    public void setSelfControlLevel(Integer selfControlLevel) {
        this.selfControlLevel = selfControlLevel;
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
