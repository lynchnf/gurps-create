package norman.gurps.create.model.response;

import norman.gurps.create.model.GameCharacterType;

import java.util.ArrayList;
import java.util.List;

public class GameCharacterResponse {
    private String characterName;
    private String playerName;
    private GameCharacterType characterType;
    private String campaignName;
    private PrimaryAttributes primaryAttributes;
    private SecondaryAttributes secondaryAttributes;
    private OtherAttributes otherAttributes;
    private List<AdvantageResponse> advantages = new ArrayList<>();
    private List<DisadvantageResponse> disadvantages = new ArrayList<>();
    private List<String> quirks = new ArrayList<>();
    private List<SkillResponse> skills = new ArrayList<>();
    private List<EquipmentResponse> equipmentList = new ArrayList<>();
    private List<MeleeWeaponResponse> meleeWeapons = new ArrayList<>();
    private List<RangedWeaponResponse> rangedWeapons = new ArrayList<>();

    public Integer getAdvantagePoints() {
        int advantagePoints = 0;
        for (AdvantageResponse advantage : advantages) {
            advantagePoints += advantage.getPoints();
        }
        return advantagePoints;
    }

    public Integer getDisadvantagePoints() {
        int disadvantagePoints = 0;
        for (DisadvantageResponse disadvantage : disadvantages) {
            disadvantagePoints += disadvantage.getPoints();
        }
        return disadvantagePoints;
    }

    public Integer getQuirkPoints() {
        return quirks.size() * -1;
    }

    public Integer getSkillPoints() {
        int skillPoints = 0;
        for (SkillResponse skill : skills) {
            skillPoints += skill.getPoints();
        }
        return skillPoints;
    }

    public Integer getTotalPoints() {
        return primaryAttributes.getPoints() + secondaryAttributes.getPoints() + getAdvantagePoints() +
                getDisadvantagePoints() + getQuirkPoints() + getSkillPoints();
    }

    public Double getEquipmentWeight() {
        double weight = 0.0;
        for (EquipmentResponse equip : equipmentList) {
            weight += equip.getWeight();
        }
        return weight;
    }

    // Generated Getters and Setters //////////////////////////////////////////////////////////////////////////////////
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

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    public OtherAttributes getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(OtherAttributes otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    public List<AdvantageResponse> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<AdvantageResponse> advantages) {
        this.advantages = advantages;
    }

    public List<DisadvantageResponse> getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(List<DisadvantageResponse> disadvantages) {
        this.disadvantages = disadvantages;
    }

    public List<String> getQuirks() {
        return quirks;
    }

    public void setQuirks(List<String> quirks) {
        this.quirks = quirks;
    }

    public List<SkillResponse> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillResponse> skills) {
        this.skills = skills;
    }

    public List<EquipmentResponse> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentResponse> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<MeleeWeaponResponse> getMeleeWeapons() {
        return meleeWeapons;
    }

    public void setMeleeWeapons(List<MeleeWeaponResponse> meleeWeapons) {
        this.meleeWeapons = meleeWeapons;
    }

    public List<RangedWeaponResponse> getRangedWeapons() {
        return rangedWeapons;
    }

    public void setRangedWeapons(List<RangedWeaponResponse> rangedWeapons) {
        this.rangedWeapons = rangedWeapons;
    }
}
