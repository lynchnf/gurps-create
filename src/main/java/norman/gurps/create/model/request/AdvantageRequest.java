package norman.gurps.create.model.request;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;

public class AdvantageRequest {
    private String name; // Should not be null.
    private String description;
    private Integer level = INTEGER_ONE;

    public AdvantageRequest() {
    }

    public AdvantageRequest(String name) {
        this.name = name;
    }

    public AdvantageRequest(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public AdvantageRequest(String name, String description, Integer level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
