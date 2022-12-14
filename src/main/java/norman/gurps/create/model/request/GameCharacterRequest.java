package norman.gurps.create.model.request;

import norman.gurps.create.model.GameCharacterType;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.DOUBLE_ZERO;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class GameCharacterRequest {
    private String characterName; // Should not be null.
    private String playerName;
    private GameCharacterType characterType = GameCharacterType.NPC;
    private Integer strengthAdjustment = INTEGER_ZERO;
    private Integer dexterityAdjustment = INTEGER_ZERO;
    private Integer intelligenceAdjustment = INTEGER_ZERO;
    private Integer healthAdjustment = INTEGER_ZERO;
    private Integer hitPointsAdjustment = INTEGER_ZERO;
    private Integer willAdjustment = INTEGER_ZERO;
    private Integer perceptionAdjustment = INTEGER_ZERO;
    private Integer fatiguePointsAdjustment = INTEGER_ZERO;
    private Double basicSpeedAdjustment = DOUBLE_ZERO;
    private Integer basicMoveAdjustment = INTEGER_ZERO;
    private List<AdvantageRequest> advantages = new ArrayList<>();
    private List<DisadvantageRequest> disadvantages = new ArrayList<>();
    private List<String> quirks = new ArrayList<>();
    private List<SkillRequest> skills = new ArrayList<>();
    private List<EquipmentRequest> equipmentList = new ArrayList<>();

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameCharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(GameCharacterType characterType) {
        this.characterType = characterType;
    }

    public Integer getStrengthAdjustment() {
        return strengthAdjustment;
    }

    public void setStrengthAdjustment(Integer strengthAdjustment) {
        this.strengthAdjustment = strengthAdjustment;
    }

    public Integer getDexterityAdjustment() {
        return dexterityAdjustment;
    }

    public void setDexterityAdjustment(Integer dexterityAdjustment) {
        this.dexterityAdjustment = dexterityAdjustment;
    }

    public Integer getIntelligenceAdjustment() {
        return intelligenceAdjustment;
    }

    public void setIntelligenceAdjustment(Integer intelligenceAdjustment) {
        this.intelligenceAdjustment = intelligenceAdjustment;
    }

    public Integer getHealthAdjustment() {
        return healthAdjustment;
    }

    public void setHealthAdjustment(Integer healthAdjustment) {
        this.healthAdjustment = healthAdjustment;
    }

    public Integer getHitPointsAdjustment() {
        return hitPointsAdjustment;
    }

    public void setHitPointsAdjustment(Integer hitPointsAdjustment) {
        this.hitPointsAdjustment = hitPointsAdjustment;
    }

    public Integer getWillAdjustment() {
        return willAdjustment;
    }

    public void setWillAdjustment(Integer willAdjustment) {
        this.willAdjustment = willAdjustment;
    }

    public Integer getPerceptionAdjustment() {
        return perceptionAdjustment;
    }

    public void setPerceptionAdjustment(Integer perceptionAdjustment) {
        this.perceptionAdjustment = perceptionAdjustment;
    }

    public Integer getFatiguePointsAdjustment() {
        return fatiguePointsAdjustment;
    }

    public void setFatiguePointsAdjustment(Integer fatiguePointsAdjustment) {
        this.fatiguePointsAdjustment = fatiguePointsAdjustment;
    }

    public Double getBasicSpeedAdjustment() {
        return basicSpeedAdjustment;
    }

    public void setBasicSpeedAdjustment(Double basicSpeedAdjustment) {
        this.basicSpeedAdjustment = basicSpeedAdjustment;
    }

    public Integer getBasicMoveAdjustment() {
        return basicMoveAdjustment;
    }

    public void setBasicMoveAdjustment(Integer basicMoveAdjustment) {
        this.basicMoveAdjustment = basicMoveAdjustment;
    }

    public List<AdvantageRequest> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<AdvantageRequest> advantages) {
        this.advantages = advantages;
    }

    public List<DisadvantageRequest> getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(List<DisadvantageRequest> disadvantages) {
        this.disadvantages = disadvantages;
    }

    public List<String> getQuirks() {
        return quirks;
    }

    public void setQuirks(List<String> quirks) {
        this.quirks = quirks;
    }

    public List<SkillRequest> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillRequest> skills) {
        this.skills = skills;
    }

    public List<EquipmentRequest> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentRequest> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
