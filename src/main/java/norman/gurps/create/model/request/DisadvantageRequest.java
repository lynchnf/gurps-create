package norman.gurps.create.model.request;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;

public class DisadvantageRequest {
    public static final int DISADVANTAGE_DEFAULT_SELF_CONTROL_LEVEL = 12;
    private String name; // Should not be null.
    private Integer selfControlLevel = DISADVANTAGE_DEFAULT_SELF_CONTROL_LEVEL;
    private String description;
    private Integer level = INTEGER_ONE;

    public DisadvantageRequest() {
    }

    public DisadvantageRequest(String name) {
        this.name = name;
    }

    public DisadvantageRequest(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public DisadvantageRequest(String name, String description, Integer level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public DisadvantageRequest(String name, Integer selfControlLevel, String description) {
        this.name = name;
        this.selfControlLevel = selfControlLevel;
        this.description = description;
    }

    public DisadvantageRequest(String name, Integer selfControlLevel, String description, Integer level) {
        this.name = name;
        this.selfControlLevel = selfControlLevel;
        this.description = description;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
