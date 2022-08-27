package norman.gurps.create.model.request;

public class DisadvantageRequest {
    private String name;
    private Integer selfControlLevel;
    private String description;
    private Integer level;

    public DisadvantageRequest() {
    }

    public DisadvantageRequest(String name) {
        this.name = name;
    }

    public DisadvantageRequest(String name, Integer selfControlLevel) {
        this.name = name;
        this.selfControlLevel = selfControlLevel;
    }

    public DisadvantageRequest(String name, Integer selfControlLevel, String description) {
        this.name = name;
        this.selfControlLevel = selfControlLevel;
        this.description = description;
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
