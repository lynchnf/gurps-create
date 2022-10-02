package norman.gurps.create.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import norman.gurps.create.LoggingException;
import norman.gurps.create.model.Affected;
import norman.gurps.create.model.ControllingAttribute;
import norman.gurps.create.model.data.AdvantageData;
import norman.gurps.create.model.data.DisadvantageData;
import norman.gurps.create.model.data.EffectData;
import norman.gurps.create.model.data.EquipmentData;
import norman.gurps.create.model.data.SkillData;
import norman.gurps.create.model.data.SourceBookData;
import norman.gurps.create.model.request.AdvantageRequest;
import norman.gurps.create.model.request.DisadvantageRequest;
import norman.gurps.create.model.request.EquipmentRequest;
import norman.gurps.create.model.request.GameCharacterRequest;
import norman.gurps.create.model.request.SkillRequest;
import norman.gurps.create.model.response.AdvantageResponse;
import norman.gurps.create.model.response.DisadvantageResponse;
import norman.gurps.create.model.response.DoubleAttribute;
import norman.gurps.create.model.response.EquipmentResponse;
import norman.gurps.create.model.response.GameCharacterResponse;
import norman.gurps.create.model.response.IntegerAttribute;
import norman.gurps.create.model.response.MeleeWeaponResponse;
import norman.gurps.create.model.response.OtherAttributes;
import norman.gurps.create.model.response.PrimaryAttributes;
import norman.gurps.create.model.response.RangedWeaponResponse;
import norman.gurps.create.model.response.SecondaryAttributes;
import norman.gurps.create.model.response.SkillResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static org.apache.commons.lang3.math.NumberUtils.DOUBLE_ZERO;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

public class Transformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Transformer.class);
    public static final int STRENGTH_BASE = 10;
    public static final int STRENGTH_RATE = 10;
    public static final int DEXTERITY_BASE = 10;
    public static final int DEXTERITY_RATE = 20;
    public static final int INTELLIGENCE_BASE = 10;
    public static final int INTELLIGENCE_RATE = 20;
    public static final int HEALTH_BASE = 10;
    public static final int HEALTH_RATE = 10;
    public static final int HIT_POINTS_RATE = 2;
    public static final int WILL_RATE = 5;
    public static final int PERCEPTION_RATE = 5;
    public static final int FATIGUE_POINTS_RATE = 3;
    public static final int BASIC_SPEED_RATE = 20;
    public static final int BASIC_MOVE_RATE = 5;
    public static final String CAMPAIGN_NAME_KEY = "campaign.name";
    public static final String DATA_FILE_NAMES_KEY = "data.file.names";
    public static final String PROPERTIES_EXTENSION = ".properties";
    public static final String JSON_EXTENSION = ".json";
    private ObjectMapper mapper;
    private String campaignName;
    private Map<String, AdvantageData> advantageDataMap = new HashMap<>();
    private Map<String, DisadvantageData> disadvantageDataMap = new HashMap<>();
    private Map<String, SkillData> skillDataMap = new HashMap<>();
    private Map<String, EquipmentData> equipmentDataMap = new HashMap<>();

    public Transformer(String campaignFileName, File campaignDir, File dataDir) throws Exception {
        mapper = new ObjectMapper();

        File campaignFile = new File(campaignDir, campaignFileName + PROPERTIES_EXTENSION);
        Properties campaignProps = new Properties();
        InputStream inputStream = new FileInputStream(campaignFile);
        campaignProps.load(inputStream);
        campaignName = campaignProps.getProperty(CAMPAIGN_NAME_KEY);
        String dataFileNames = campaignProps.getProperty(DATA_FILE_NAMES_KEY);

        // Read data files into data maps.
        String[] dataFileNameArray = StringUtils.split(dataFileNames, ',');
        for (String name : dataFileNameArray) {
            File file = new File(dataDir, name + JSON_EXTENSION);
            SourceBookData book = mapper.readValue(file, SourceBookData.class);
            for (AdvantageData adv : book.getAdvantageDataList()) {
                advantageDataMap.putIfAbsent(adv.getName(), adv);
            }
            for (DisadvantageData dis : book.getDisadvantageDataList()) {
                disadvantageDataMap.putIfAbsent(dis.getName(), dis);
            }
            for (SkillData skill : book.getSkillDataList()) {
                skillDataMap.putIfAbsent(skill.getName(), skill);
            }
            for (EquipmentData equip : book.getEquipmentDataList()) {
                equipmentDataMap.putIfAbsent(equip.getName(), equip);
            }
        }
    }

    public String transform(File reqFile) throws IOException {
        GameCharacterRequest req = mapper.readValue(reqFile, GameCharacterRequest.class);
        GameCharacterResponse resp = new GameCharacterResponse();
        resp.setCharacterName(req.getCharacterName());
        resp.setPlayerName(req.getPlayerName());
        resp.setCharacterType(req.getCharacterType());
        resp.setCampaignName(campaignName);

        // Primary Attributes
        transformPrimaryAttributes(req, resp);

        int strengthValue = resp.getPrimaryAttributes().getStrength().getValue();
        int dexterityValue = resp.getPrimaryAttributes().getDexterity().getValue();
        int intelligenceValue = resp.getPrimaryAttributes().getIntelligence().getValue();
        int healthValue = resp.getPrimaryAttributes().getHealth().getValue();

        // Secondary Attributes
        transformSecondaryAttributes(req, resp, strengthValue, dexterityValue, intelligenceValue, healthValue);

        int willValue = resp.getSecondaryAttributes().getWill().getValue();
        int perceptionValue = resp.getSecondaryAttributes().getPerception().getValue();

        // Other Attributes
        constructOtherAttributes(resp, strengthValue, intelligenceValue, healthValue);

        // Advantages
        transformAdvantages(req, resp, advantageDataMap);

        // Disadvantages
        transformDisadvantages(req, resp, disadvantageDataMap);

        // Quirks
        resp.getQuirks().addAll(req.getQuirks());

        // Skills
        transformSkills(req, resp, strengthValue, dexterityValue, intelligenceValue, healthValue, willValue,
                perceptionValue, skillDataMap);

        // Equipment
        transformEquipment(req, resp, equipmentDataMap);

        // Apply bonuses from Advantages.
        applyAdvantageEffects(resp, resp.getAdvantages(), advantageDataMap);

        // Apply penalties from Disadvantages.

        // Apply skill bonuses from Advantages.

        // Apply skill penalties from Disadvantages.

        // Apply point discounts from Defaults.

        // Sort
        sortForOutput(resp);

        LOGGER.debug("Total Points=" + resp.getTotalPoints());

        // Output JSON string.
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(resp);
    }

    private void transformPrimaryAttributes(GameCharacterRequest req, GameCharacterResponse resp) {
        PrimaryAttributes primary = new PrimaryAttributes();

        IntegerAttribute strength = new IntegerAttribute();
        strength.setBase(STRENGTH_BASE);
        strength.setAdjustment(req.getStrengthAdjustment());
        strength.setRate(STRENGTH_RATE);
        primary.setStrength(strength);

        IntegerAttribute dexterity = new IntegerAttribute();
        dexterity.setBase(DEXTERITY_BASE);
        dexterity.setAdjustment(req.getDexterityAdjustment());
        dexterity.setRate(DEXTERITY_RATE);
        primary.setDexterity(dexterity);

        IntegerAttribute intelligence = new IntegerAttribute();
        intelligence.setBase(INTELLIGENCE_BASE);
        intelligence.setAdjustment(req.getIntelligenceAdjustment());
        intelligence.setRate(INTELLIGENCE_RATE);
        primary.setIntelligence(intelligence);

        IntegerAttribute health = new IntegerAttribute();
        health.setBase(HEALTH_BASE);
        health.setAdjustment(req.getHealthAdjustment());
        health.setRate(HEALTH_RATE);
        primary.setHealth(health);

        resp.setPrimaryAttributes(primary);
    }

    private void transformSecondaryAttributes(GameCharacterRequest req, GameCharacterResponse resp, int strengthValue,
            int dexterityValue, int intelligenceValue, int healthValue) {
        SecondaryAttributes secondary = new SecondaryAttributes();
        IntegerAttribute hitPoints = new IntegerAttribute();
        hitPoints.setBase(strengthValue);
        hitPoints.setAdjustment(req.getHitPointsAdjustment());
        hitPoints.setRate(HIT_POINTS_RATE);
        secondary.setHitPoints(hitPoints);

        IntegerAttribute will = new IntegerAttribute();
        will.setBase(intelligenceValue);
        will.setAdjustment(req.getWillAdjustment());
        will.setRate(WILL_RATE);
        secondary.setWill(will);

        IntegerAttribute perception = new IntegerAttribute();
        perception.setBase(intelligenceValue);
        perception.setAdjustment(req.getPerceptionAdjustment());
        perception.setRate(PERCEPTION_RATE);
        secondary.setPerception(perception);

        IntegerAttribute fatiguePoints = new IntegerAttribute();
        fatiguePoints.setBase(healthValue);
        fatiguePoints.setAdjustment(req.getFatiguePointsAdjustment());
        fatiguePoints.setRate(FATIGUE_POINTS_RATE);
        secondary.setFatiguePoints(fatiguePoints);

        DoubleAttribute basicSpeed = new DoubleAttribute();
        basicSpeed.setBase(Helper.calculateBasicSpeed(dexterityValue, healthValue));
        basicSpeed.setAdjustment(req.getBasicSpeedAdjustment());
        basicSpeed.setRate(BASIC_SPEED_RATE);
        secondary.setBasicSpeed(basicSpeed);

        IntegerAttribute basicMove = new IntegerAttribute();
        basicMove.setBase(secondary.getBasicSpeed().getValue().intValue());
        basicMove.setAdjustment(req.getBasicMoveAdjustment());
        basicMove.setRate(BASIC_MOVE_RATE);
        secondary.setBasicMove(basicMove);

        resp.setSecondaryAttributes(secondary);
    }

    private static void constructOtherAttributes(GameCharacterResponse resp, int strengthValue, int intelligenceValue,
            int healthValue) {
        OtherAttributes other = new OtherAttributes();
        other.setDamageStrength(strengthValue);
        other.setThrustDamageDice(Helper.calculateThrustDamageDice(other.getDamageStrength()));
        other.setThrustDamageAdds(Helper.calculateThrustDamageAdds(other.getDamageStrength()));
        other.setThrustDamage(Helper.calculateDamage(other.getThrustDamageDice(), other.getThrustDamageAdds()));
        other.setSwingDamageDice(Helper.calculateSwingDamageDice(other.getDamageStrength()));
        other.setSwingDamageAdds(Helper.calculateSwingDamageAdds(other.getDamageStrength()));
        other.setSwingDamage(Helper.calculateDamage(other.getSwingDamageDice(), other.getSwingDamageAdds()));
        other.setLiftingStrength(strengthValue);
        other.setBasicLift(Helper.calculateBasicLift(other.getLiftingStrength()));
        other.setEncumbranceLevel(Helper.calculateEncumbranceLevel(DOUBLE_ZERO, other.getBasicLift()));
        other.setEncumberedMove(Helper.calculateEncumberedMove(resp.getSecondaryAttributes().getBasicMove().getValue(),
                other.getEncumbranceLevel()));
        other.setDamageResistance(INTEGER_ZERO);
        other.setDodge(Helper.calculateDodge(resp.getSecondaryAttributes().getBasicSpeed().getValue(),
                other.getEncumbranceLevel()));
        other.setFrightCheck(intelligenceValue);
        other.setMentalStunCheck(intelligenceValue);
        other.setPhysicalStunCheck(healthValue);
        other.setDeathCheck(healthValue);
        resp.setOtherAttributes(other);
    }

    private void transformAdvantages(GameCharacterRequest req, GameCharacterResponse resp,
            Map<String, AdvantageData> advMap) {
        for (AdvantageRequest advReq : req.getAdvantages()) {
            AdvantageResponse advResp = new AdvantageResponse();
            advResp.setName(advReq.getName());
            AdvantageData advData = advMap.get(advReq.getName());
            advResp.setMultiLevel(advData.getMultiLevel());
            advResp.setFirstLevel(advData.getFirstLevel());
            advResp.setFirstLevelCost(advData.getFirstLevelCost());
            advResp.setCostPerLevel(advData.getCostPerLevel());
            advResp.setDescription(advReq.getDescription());
            advResp.setLevel(advReq.getLevel());
            resp.getAdvantages().add(advResp);
        }
    }

    private void transformDisadvantages(GameCharacterRequest req, GameCharacterResponse resp,
            Map<String, DisadvantageData> disMap) {
        for (DisadvantageRequest disReq : req.getDisadvantages()) {
            DisadvantageResponse disResp = new DisadvantageResponse();
            disResp.setName(disReq.getName());
            DisadvantageData disData = disMap.get(disReq.getName());
            disResp.setSelfControlAllowed(disData.getSelfControlAllowed());
            disResp.setMultiLevel(disData.getMultiLevel());
            disResp.setCostPerLevel(disData.getCostPerLevel());
            disResp.setSelfControlLevel(disReq.getSelfControlLevel());
            disResp.setDescription(disReq.getDescription());
            disResp.setLevel(disReq.getLevel());
            resp.getDisadvantages().add(disResp);
        }
    }

    private void transformSkills(GameCharacterRequest req, GameCharacterResponse resp, int strengthValue,
            int dexterityValue, int intelligenceValue, int healthValue, int willValue, int perceptionValue,
            Map<String, SkillData> skillMap) {
        for (SkillRequest skillReq : req.getSkills()) {
            SkillResponse skillResp = new SkillResponse();
            skillResp.setName(skillReq.getName());
            SkillData skillData = skillMap.get(skillReq.getName());
            skillResp.setControllingAttribute(skillData.getControllingAttribute());
            skillResp.setDifficultyLevel(skillData.getDifficultyLevel());
            skillResp.setSpecialty(skillReq.getSpecialty());

            int attributeValue;
            if (skillData.getControllingAttribute() == ControllingAttribute.ST) {
                attributeValue = strengthValue;
            } else if (skillData.getControllingAttribute() == ControllingAttribute.DX) {
                attributeValue = dexterityValue;
            } else if (skillData.getControllingAttribute() == ControllingAttribute.IQ) {
                attributeValue = intelligenceValue;
            } else if (skillData.getControllingAttribute() == ControllingAttribute.HT) {
                attributeValue = healthValue;
            } else if (skillData.getControllingAttribute() == ControllingAttribute.Will) {
                attributeValue = willValue;
            } else if (skillData.getControllingAttribute() == ControllingAttribute.Per) {
                attributeValue = perceptionValue;
            } else {
                String msg = String.format("Illegal Controlling Attribute %s found for Skill %s.",
                        skillData.getControllingAttribute(), skillData.getName());
                throw new LoggingException(LOGGER, msg);
            }
            skillResp.setControllingAttributeValue(attributeValue);

            if (skillReq.getMinLevel() != null) {
                skillResp.setMinLevel(skillReq.getMinLevel());
                int points = Helper.calculateSkillPoints(skillReq.getMinLevel(), attributeValue,
                        skillData.getDifficultyLevel());
                skillResp.setPoints(points);
                int level = Helper.calculateSkillLevel(points, attributeValue, skillData.getDifficultyLevel());
                skillResp.setLevel(level);
            } else {
                skillResp.setMaxPoints(skillReq.getMaxPoints());
                skillResp.setPoints(skillReq.getMaxPoints());
                int level = Helper.calculateSkillLevel(skillReq.getMaxPoints(), attributeValue,
                        skillData.getDifficultyLevel());
                skillResp.setLevel(level);
            }
            resp.getSkills().add(skillResp);
        }
    }

    private void transformEquipment(GameCharacterRequest req, GameCharacterResponse resp,
            Map<String, EquipmentData> equipMap) {
        for (EquipmentRequest equipReq : req.getEquipmentList()) {
            EquipmentResponse equipResp = new EquipmentResponse();
            EquipmentData equipData = equipMap.get(equipReq.getName());
            equipResp.setName(equipReq.getName());
            equipResp.setQuantity(equipReq.getQuantity() != null ? equipReq.getQuantity() : Integer.valueOf(1));
            equipResp.setWeight(equipData.getWeight() != 0.0 ?
                    equipData.getWeight() * equipResp.getQuantity() / equipData.getQuantity() : 0.0);
            if (equipData.getNotes() != null) {
                equipResp.setNotes(equipData.getNotes());
            }
            resp.getEquipmentList().add(equipResp);
        }
    }

    private void applyAdvantageEffects(GameCharacterResponse resp, List<AdvantageResponse> advResps,
            Map<String, AdvantageData> advMap) {
        for (AdvantageResponse advResp : advResps) {
            AdvantageData advData = advMap.get(advResp.getName());
            for (EffectData effData : advData.getEffects()) {
                Affected affected = effData.getAffected();
                if (affected == Affected.OTHER_ATTRIBUTES_DODGE) {
                    resp.getOtherAttributes().setDodge(resp.getOtherAttributes().getDodge() + effData.getAdjustment());
                } else if (affected == Affected.OTHER_ATTRIBUTES_FRIGHT_CHECK) {
                    resp.getOtherAttributes()
                            .setFrightCheck(resp.getOtherAttributes().getFrightCheck() + effData.getAdjustment());
                } else if (affected == Affected.OTHER_ATTRIBUTES_MENTAL_STUN_CHECK) {
                    resp.getOtherAttributes().setMentalStunCheck(
                            resp.getOtherAttributes().getMentalStunCheck() + effData.getAdjustment());
                } else if (affected == Affected.OTHER_ATTRIBUTES_DEATH_CHECK) {
                    resp.getOtherAttributes()
                            .setDeathCheck(resp.getOtherAttributes().getDeathCheck() + effData.getAdjustment());
                } else if (affected == Affected.OTHER_ATTRIBUTES_PHYSICAL_STUN_CHECK) {
                    resp.getOtherAttributes().setPhysicalStunCheck(
                            resp.getOtherAttributes().getPhysicalStunCheck() + effData.getAdjustment());
                } else {
                    String msg = String.format("Illegal Affected %s found for Advantage %s.", affected,
                            advResp.getName());
                    throw new LoggingException(LOGGER, msg);
                }
            }
        }
    }

    private void sortForOutput(GameCharacterResponse resp) {
        resp.getAdvantages().sort(comparing(AdvantageResponse::getName).thenComparing(AdvantageResponse::getDescription,
                nullsLast(naturalOrder())));
        resp.getDisadvantages()
                .sort(comparing(DisadvantageResponse::getName).thenComparing(DisadvantageResponse::getDescription,
                        nullsLast(naturalOrder())));
        resp.getQuirks().sort(naturalOrder());
        resp.getSkills().sort(comparing(SkillResponse::getName).thenComparing(SkillResponse::getSpecialty,
                nullsLast(naturalOrder())));
        resp.getEquipmentList().sort(comparing(EquipmentResponse::getName).thenComparing(EquipmentResponse::getNotes,
                nullsLast(naturalOrder())));
        // TODO Add mode name to melee & ranged weapons.
        resp.getMeleeWeapons().sort(comparing(MeleeWeaponResponse::getName));
        resp.getRangedWeapons().sort(comparing(RangedWeaponResponse::getName));
    }
}
