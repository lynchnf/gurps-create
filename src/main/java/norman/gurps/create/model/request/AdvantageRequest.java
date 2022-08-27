package norman.gurps.create.model.request;

public class AdvantageRequest {
    private String name;
    private String description;
    private Integer level;

    public AdvantageRequest() {
    }

    public AdvantageRequest(String name) {
        this.name = name;
    }

    public AdvantageRequest(String name, Integer level) {
        this.name = name;
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
