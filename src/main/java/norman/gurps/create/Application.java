package norman.gurps.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import norman.gurps.create.model.data.AdvantageData;
import norman.gurps.create.model.data.DefaultData;
import norman.gurps.create.model.data.DisadvantageData;
import norman.gurps.create.model.data.EquipmentData;
import norman.gurps.create.model.data.SkillData;
import norman.gurps.create.model.request.AdvantageRequest;
import norman.gurps.create.model.request.DisadvantageRequest;
import norman.gurps.create.model.request.EquipmentRequest;
import norman.gurps.create.model.request.GameCharacterRequest;
import norman.gurps.create.model.request.SkillRequest;
import norman.gurps.create.model.response.AdvantageResponse;
import norman.gurps.create.model.response.DefaultResponse;
import norman.gurps.create.model.response.DisadvantageResponse;
import norman.gurps.create.model.response.DoubleAttribute;
import norman.gurps.create.model.response.EquipmentResponse;
import norman.gurps.create.model.response.GameCharacterResponse;
import norman.gurps.create.model.response.IntegerAttribute;
import norman.gurps.create.model.response.OtherAttributes;
import norman.gurps.create.model.response.PrimaryAttributes;
import norman.gurps.create.model.response.SecondaryAttributes;
import norman.gurps.create.model.response.SkillResponse;
import norman.gurps.create.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");

    public static void main(String[] args) {
        LOGGER.debug("Starting Application");
        Application me = new Application();
        try {
            me.doIt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void doIt() throws URISyntaxException, IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper();

        // Get file directory.
        URL url = loader.getResource("example.json");
        String path = url.toURI().getPath();
        File file = new File(path);
        File fileDir = file.getParentFile();

        // Equipment
        Map<String, EquipmentData> equipMap = Helper.getEquipmentDataMap(loader, mapper);

        // Write equipment file.
        File equipFile = new File(fileDir, "equipment.json");
        mapper.writeValue(equipFile, equipMap.values());
    }

    private void doIt2() throws URISyntaxException, IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Create request object.
        GameCharacterRequest req = new GameCharacterRequest();
        req.setCharacterName("Anton");
        req.setStrengthAdjustment(4);
        req.setDexterityAdjustment(3);
        req.setIntelligenceAdjustment(-2);
        req.setHealthAdjustment(4);
        req.setHitPointsAdjustment(5);
        req.setWillAdjustment(0);
        req.setPerceptionAdjustment(0);
        req.setFatiguePointsAdjustment(0);
        req.setBasicSpeedAdjustment(0.00);
        req.setBasicMoveAdjustment(0);

        req.getAdvantages().add(new AdvantageRequest("Catfall"));
        req.getAdvantages().add(new AdvantageRequest("Damage Resistance", 3));
        req.getAdvantages().add(new AdvantageRequest("Dark Vision"));
        req.getAdvantages().add(new AdvantageRequest("Discriminatory Smell"));
        req.getAdvantages().add(new AdvantageRequest("Extended Lifespan", 5));
        req.getAdvantages().add(new AdvantageRequest("Fearlessness", 2));
        req.getAdvantages().add(new AdvantageRequest("Hard to Kill", 2));
        req.getAdvantages().add(new AdvantageRequest("Sharp Claws"));
        req.getAdvantages().add(new AdvantageRequest("Sharp Teeth"));

        req.getDisadvantages().add(new DisadvantageRequest("Bloodlust", 12));
        req.getDisadvantages().add(new DisadvantageRequest("Illiteracy"));
        req.getDisadvantages().add(new DisadvantageRequest("Lecherousness", 15));
        req.getDisadvantages().add(new DisadvantageRequest("Obsession", 12, "Hats/Heterodynes"));
        req.getDisadvantages().add(new DisadvantageRequest("Repulsive Appearance"));

        req.getQuirks().add("Hates being called \"kid\", \"junior\", or \"boy\".");
        req.getQuirks().add("Brags about how the ladies all love him.");
        req.getQuirks().add("Preoccupied with his looks.");
        req.getQuirks().add("Spouts poetry.");
        req.getQuirks().add("Claims anything he doesn't like is \"for sissies\".");

        req.getSkills().add(new SkillRequest("Acrobatics", 14));
        req.getSkills().add(new SkillRequest("Area Knowledge", "Europa", null, 2));
        req.getSkills().add(new SkillRequest("Bartender", 12));
        req.getSkills().add(new SkillRequest("Brawling", 15));
        req.getSkills().add(new SkillRequest("Broadsword", 14));
        req.getSkills().add(new SkillRequest("Carousing", 14));
        req.getSkills().add(new SkillRequest("Climbing", 14));
        req.getSkills().add(new SkillRequest("Escape", 12));
        req.getSkills().add(new SkillRequest("Fast-Draw", 13));
        req.getSkills().add(new SkillRequest("Guns", 14));
        req.getSkills().add(new SkillRequest("Jumping", 13));
        req.getSkills().add(new SkillRequest("Knife", 14));
        req.getSkills().add(new SkillRequest("Poetry", null, null, 1));
        req.getSkills().add(new SkillRequest("Soldier", null, null, 1));
        req.getSkills().add(new SkillRequest("Swimming", 14));
        req.getSkills().add(new SkillRequest("Throwing", 14));
        req.getSkills().add(new SkillRequest("Thrown Knife", null, null, 1));
        req.getSkills().add(new SkillRequest("Two-Handed Sword"));

        req.getEquipmentList().add(new EquipmentRequest("Broadsword"));
        req.getEquipmentList().add(new EquipmentRequest("Large Knife"));
        req.getEquipmentList().add(new EquipmentRequest("Jager Rifle"));
        req.getEquipmentList().add(new EquipmentRequest("Bullets", 20));
        req.getEquipmentList().add(new EquipmentRequest("Jager Uniform"));
        req.getEquipmentList().add(new EquipmentRequest("Backpack, Small"));
        req.getEquipmentList().add(new EquipmentRequest("Blanket"));
        req.getEquipmentList().add(new EquipmentRequest("Bottle, Ceramic"));
        req.getEquipmentList().add(new EquipmentRequest("Climbing Gear"));
        req.getEquipmentList().add(new EquipmentRequest("Personal Basics"));
        req.getEquipmentList().add(new EquipmentRequest("Rope, 20 yrds"));
        req.getEquipmentList().add(new EquipmentRequest("Hand held mirror"));
        req.getEquipmentList().add(new EquipmentRequest("Brush, comb, etc."));

        // Get file directory.
        URL url = loader.getResource("example.json");
        String path = url.toURI().getPath();
        File file = new File(path);
        File fileDir = file.getParentFile();

        // Write request file.
        File reqFile = new File(fileDir, "request.json");
        mapper.writeValue(reqFile, req);

        // Transform request object to response object.
        GameCharacterResponse resp = transform(req, loader, mapper);

        // Write request file.
        File respFile = new File(fileDir, "response.json");
        mapper.writeValue(respFile, resp);

        LOGGER.debug("Total Points=" + resp.getPoints());
    }

    private GameCharacterResponse transform(GameCharacterRequest req, ClassLoader loader, ObjectMapper mapper) {
        GameCharacterResponse resp = new GameCharacterResponse();
        resp.setCharacterName(req.getCharacterName());

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

        // Advantages
        Map<String, AdvantageData> advMap = Helper.getAdvantageDataMap(loader, mapper);
        transformAdvantages(req, resp, advMap);

        // Disadvantages
        Map<String, DisadvantageData> disMap = Helper.getDisadvantageDataMap(loader, mapper);
        transformDisadvantages(req, resp, disMap);

        // Quirks
        resp.getQuirks().addAll(req.getQuirks());

        // Skills
        Map<String, SkillData> skillMap = Helper.getSkillDataMap(loader, mapper);
        transformSkills(req, resp, strengthValue, dexterityValue, intelligenceValue, healthValue, willValue,
                perceptionValue, skillMap);

        // Equipment
        Map<String, EquipmentData> equipMap = Helper.getEquipmentDataMap(loader, mapper);
        transformEquipment(req, resp, equipMap);

        // Other Attributes
        constructOtherAttributes(resp, intelligenceValue, healthValue);

        // Defaults
        applySkillDefaults(resp, strengthValue, dexterityValue, intelligenceValue, healthValue, willValue,
                perceptionValue, skillMap);

        // Sort for output
        resp.getAdvantages().sort(Comparator.comparing(AdvantageResponse::getName)
                .thenComparing(AdvantageResponse::getDescription));
        resp.getDisadvantages().sort(Comparator.comparing(DisadvantageResponse::getName)
                .thenComparing(DisadvantageResponse::getDescription));
        resp.getSkills().sort(Comparator.comparing(SkillResponse::getName).thenComparing(SkillResponse::getSpecialty));
        resp.getEquipmentList()
                .sort(Comparator.comparing(EquipmentResponse::getName).thenComparing(EquipmentResponse::getNotes));
        return resp;
    }

    private static void transformPrimaryAttributes(GameCharacterRequest req, GameCharacterResponse resp) {
        PrimaryAttributes primary = new PrimaryAttributes();

        IntegerAttribute strength = new IntegerAttribute();
        strength.setBase(Integer.parseInt(BUNDLE.getString("strength.base")));
        strength.setAdjustment(req.getStrengthAdjustment());
        strength.setRate(Integer.parseInt(BUNDLE.getString("strength.rate")));
        primary.setStrength(strength);

        IntegerAttribute dexterity = new IntegerAttribute();
        dexterity.setBase(Integer.parseInt(BUNDLE.getString("dexterity.base")));
        dexterity.setAdjustment(req.getDexterityAdjustment());
        dexterity.setRate(Integer.parseInt(BUNDLE.getString("dexterity.rate")));
        primary.setDexterity(dexterity);

        IntegerAttribute intelligence = new IntegerAttribute();
        intelligence.setBase(Integer.parseInt(BUNDLE.getString("intelligence.base")));
        intelligence.setAdjustment(req.getIntelligenceAdjustment());
        intelligence.setRate(Integer.parseInt(BUNDLE.getString("intelligence.rate")));
        primary.setIntelligence(intelligence);

        IntegerAttribute health = new IntegerAttribute();
        health.setBase(Integer.parseInt(BUNDLE.getString("health.base")));
        health.setAdjustment(req.getHealthAdjustment());
        health.setRate(Integer.parseInt(BUNDLE.getString("health.rate")));
        primary.setHealth(health);

        resp.setPrimaryAttributes(primary);
    }

    private static void transformSecondaryAttributes(GameCharacterRequest req, GameCharacterResponse resp,
            int strengthValue, int dexterityValue, int intelligenceValue, int healthValue) {
        SecondaryAttributes secondary = new SecondaryAttributes();
        IntegerAttribute hitPoints = new IntegerAttribute();
        hitPoints.setBase(strengthValue);
        hitPoints.setAdjustment(req.getHitPointsAdjustment());
        hitPoints.setRate(Integer.parseInt(BUNDLE.getString("hitPoints.rate")));
        secondary.setHitPoints(hitPoints);

        IntegerAttribute will = new IntegerAttribute();
        will.setBase(intelligenceValue);
        will.setAdjustment(req.getWillAdjustment());
        will.setRate(Integer.parseInt(BUNDLE.getString("will.rate")));
        secondary.setWill(will);

        IntegerAttribute perception = new IntegerAttribute();
        perception.setBase(intelligenceValue);
        perception.setAdjustment(req.getPerceptionAdjustment());
        perception.setRate(Integer.parseInt(BUNDLE.getString("perception.rate")));
        secondary.setPerception(perception);

        IntegerAttribute fatiguePoints = new IntegerAttribute();
        fatiguePoints.setBase(healthValue);
        fatiguePoints.setAdjustment(req.getFatiguePointsAdjustment());
        fatiguePoints.setRate(Integer.parseInt(BUNDLE.getString("fatiguePoints.rate")));
        secondary.setFatiguePoints(fatiguePoints);

        secondary.setThrustDamageDice(Helper.calculateThrustDamageDice(strengthValue));
        secondary.setThrustDamageAdds(Helper.calculateThrustDamageAdds(strengthValue));
        secondary.setThrustDamage(
                Helper.calculateDamage(secondary.getThrustDamageDice(), secondary.getThrustDamageAdds()));
        secondary.setSwingDamageDice(Helper.calculateSwingDamageDice(strengthValue));
        secondary.setSwingDamageAdds(Helper.calculateSwingDamageAdds(strengthValue));
        secondary.setSwingDamage(
                Helper.calculateDamage(secondary.getSwingDamageDice(), secondary.getSwingDamageAdds()));
        secondary.setBasicLift(Helper.calculateBasicLift(strengthValue));

        DoubleAttribute basicSpeed = new DoubleAttribute();
        basicSpeed.setBase(Helper.calculateBasicSpeed(dexterityValue, healthValue));
        basicSpeed.setAdjustment(req.getBasicSpeedAdjustment());
        basicSpeed.setRate(Integer.parseInt(BUNDLE.getString("basicSpeed.rate")));
        secondary.setBasicSpeed(basicSpeed);

        IntegerAttribute basicMove = new IntegerAttribute();
        basicMove.setBase(secondary.getBasicSpeed().getValue().intValue());
        basicMove.setAdjustment(req.getBasicMoveAdjustment());
        basicMove.setRate(Integer.parseInt(BUNDLE.getString("basicMove.rate")));
        secondary.setBasicMove(basicMove);

        resp.setSecondaryAttributes(secondary);
    }

    private static void transformAdvantages(GameCharacterRequest req, GameCharacterResponse resp,
            Map<String, AdvantageData> advMap) {
        for (AdvantageRequest advReq : req.getAdvantages()) {
            AdvantageResponse advResp = new AdvantageResponse();
            advResp.setName(advReq.getName());
            AdvantageData advData = advMap.get(advReq.getName());
            advResp.setMultiLevel(advData.getMultiLevel());
            advResp.setFirstLevel(advData.getFirstLevel());
            advResp.setFirstLevelCost(advData.getFirstLevelCost());
            advResp.setCostPerLevel(advData.getCostPerLevel());
            if (advReq.getDescription() != null) {
                advResp.setDescription(advReq.getDescription());
            }
            advResp.setLevel(advReq.getLevel() != null ? advReq.getLevel() : Integer.valueOf(1));
            resp.getAdvantages().add(advResp);
        }
    }

    private static void transformDisadvantages(GameCharacterRequest req, GameCharacterResponse resp,
            Map<String, DisadvantageData> disMap) {
        for (DisadvantageRequest disReq : req.getDisadvantages()) {
            DisadvantageResponse disResp = new DisadvantageResponse();
            disResp.setName(disReq.getName());
            DisadvantageData disData = disMap.get(disReq.getName());
            disResp.setSelfControlAllowed(disData.getSelfControlAllowed());
            disResp.setMultiLevel(disData.getMultiLevel());
            disResp.setCostPerLevel(disData.getCostPerLevel());
            disResp.setSelfControlLevel(disReq.getSelfControlLevel() != null ? disReq.getSelfControlLevel() :
                    Integer.valueOf(BUNDLE.getString("disadvantage.defaultSelfControlLevel")));
            if (disReq.getDescription() != null) {
                disResp.setDescription(disReq.getDescription());
            }
            disResp.setLevel(disReq.getLevel() != null ? disReq.getLevel() : Integer.valueOf(1));
            resp.getDisadvantages().add(disResp);
        }
    }

    private static void transformSkills(GameCharacterRequest req, GameCharacterResponse resp, int strengthValue,
            int dexterityValue, int intelligenceValue, int healthValue, int willValue, int perceptionValue,
            Map<String, SkillData> skillMap) {
        for (SkillRequest skillReq : req.getSkills()) {
            SkillResponse skillResp = new SkillResponse();
            skillResp.setName(skillReq.getName());
            SkillData skillData = skillMap.get(skillReq.getName());
            skillResp.setControllingAttribute(skillData.getControllingAttribute());
            skillResp.setDifficultyLevel(skillData.getDifficultyLevel());
            if (skillReq.getSpecialty() != null) {
                skillResp.setSpecialty(skillReq.getSpecialty());
            }

            int attributeValue = 0;
            if (skillData.getControllingAttribute().equals("ST")) {
                attributeValue = strengthValue;
            } else if (skillData.getControllingAttribute().equals("DX")) {
                attributeValue = dexterityValue;
            } else if (skillData.getControllingAttribute().equals("IQ")) {
                attributeValue = intelligenceValue;
            } else if (skillData.getControllingAttribute().equals("HT")) {
                attributeValue = healthValue;
            } else if (skillData.getControllingAttribute().equals("Will")) {
                attributeValue = willValue;
            } else if (skillData.getControllingAttribute().equals("Per")) {
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
                        skillData.getDifficultyLevel(), skillReq.getName());
                skillResp.setPoints(points);
                int level = Helper.calculateSkillLevel(points, attributeValue, skillData.getDifficultyLevel(),
                        skillReq.getName());
                skillResp.setLevel(level);
            } else if (skillReq.getMaxPoints() != null) {
                skillResp.setMaxPoints(skillReq.getMaxPoints());
                skillResp.setPoints(skillReq.getMaxPoints());
                int level = Helper.calculateSkillLevel(skillReq.getMaxPoints(), attributeValue,
                        skillData.getDifficultyLevel(), skillReq.getName());
                skillResp.setLevel(level);
            } else {
                skillResp.setLevel(0);
                skillResp.setPoints(0);
            }
            resp.getSkills().add(skillResp);
        }
    }

    private static void applySkillDefaults(GameCharacterResponse resp, int strengthValue, int dexterityValue,
            int intelligenceValue, int healthValue, int willValue, int perceptionValue,
            Map<String, SkillData> skillMap) {

        // Sort skills by level (descending), name, specialty.
        resp.getSkills()
                .sort(Comparator.comparing(SkillResponse::getLevel).reversed().thenComparing(SkillResponse::getName)
                        .thenComparing(SkillResponse::getSpecialty));

        // Loop through all the skills, building possible defaults for each skill.
        for (int outer = 0; outer < resp.getSkills().size(); outer++) {
            SkillResponse outerSkill = resp.getSkills().get(outer);
            List<DefaultResponse> possibleDefaults = new ArrayList<>();

            // Chug through all the possible defaults for this skill.
            SkillData skillData = skillMap.get(outerSkill.getName());
            for (DefaultData dftData : skillData.getDefaults()) {

                // If this is an attribute based default, build it.
                if (dftData.getAttribute() != null) {
                    DefaultResponse dftResp = new DefaultResponse();
                    dftResp.setAttribute(dftData.getAttribute());
                    int level;
                    if (dftData.getAttribute().equals("ST")) {
                        level = strengthValue;
                    } else if (dftData.getAttribute().equals("DX")) {
                        level = dexterityValue;
                    } else if (dftData.getAttribute().equals("IQ")) {
                        level = intelligenceValue;
                    } else if (dftData.getAttribute().equals("HT")) {
                        level = healthValue;
                    } else if (dftData.getAttribute().equals("Will")) {
                        level = willValue;
                    } else if (dftData.getAttribute().equals("Per")) {
                        level = perceptionValue;
                    } else {
                        String msg = String.format("Illegal Controlling Attribute %s found for Skill %s.",
                                skillData.getControllingAttribute(), skillData.getName());
                        throw new LoggingException(LOGGER, msg);
                    }
                    dftResp.setPenalty(dftData.getPenalty());
                    level += dftData.getPenalty();
                    dftResp.setLevel(level);
                    int points = Helper.calculateSkillPoints(level, outerSkill.getControllingAttributeValue(),
                            outerSkill.getDifficultyLevel(), outerSkill.getName());
                    dftResp.setPoints(points);
                    possibleDefaults.add(dftResp);
                } else {

                    // Otherwise, this is a skill based default. Loop through all the skills above (i.e. with eqaul or higher levels) the current skill.
                    for (int inner = 0; inner < outer; inner++) {
                        SkillResponse innerSkill = resp.getSkills().get(inner);

                        // If the inner skill matches the skill default, we have a possible default for the outer skill.
                        boolean skillNamesMatch =
                                dftData.getSkill() != null && dftData.getSkill().equals(innerSkill.getName());
                        boolean specialtiesBothNull =
                                dftData.getSpecialty() == null && innerSkill.getSpecialty() == null;
                        boolean specialtiesMatch = dftData.getSpecialty() != null &&
                                dftData.getSpecialty().equals(innerSkill.getSpecialty());
                        if (skillNamesMatch && (specialtiesBothNull || specialtiesMatch)) {
                            DefaultResponse dftResp = new DefaultResponse();
                            dftResp.setSkill(innerSkill.getName());
                            if (innerSkill.getSpecialty() != null) {
                                dftResp.setSpecialty(innerSkill.getSpecialty());
                            }
                            dftResp.setPenalty(dftData.getPenalty());
                            int level = innerSkill.getLevel() + dftData.getPenalty();
                            dftResp.setLevel(level);
                            int points = Helper.calculateSkillPoints(level, outerSkill.getControllingAttributeValue(),
                                    outerSkill.getDifficultyLevel(), outerSkill.getName());
                            dftResp.setPoints(points);
                            possibleDefaults.add(dftResp);
                        }
                    }
                }

                // Find the best default and update the current skill with it.
                if (!possibleDefaults.isEmpty()) {
                    possibleDefaults.sort(Comparator.comparing(DefaultResponse::getPoints).reversed());
                    DefaultResponse bestDefault = possibleDefaults.get(0);
                    outerSkill.setBestDefault(bestDefault);

                    if (bestDefault.getLevel() >= outerSkill.getLevel()) {
                        outerSkill.setLevel(bestDefault.getLevel());
                        outerSkill.setPoints(0);
                    } else if (bestDefault.getPoints() > 0) {
                        int points = outerSkill.getPoints();
                        outerSkill.setPoints(points - bestDefault.getPoints());
                    }
                }
            }
        }
    }

    private static void transformEquipment(GameCharacterRequest req, GameCharacterResponse resp,
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

    private static void constructOtherAttributes(GameCharacterResponse resp, int intelligenceValue, int healthValue) {
        OtherAttributes other = new OtherAttributes();
        int move;
        if (resp.getEquipmentWeight() <= resp.getSecondaryAttributes().getBasicLift()) {
            other.setEncumbranceLevel(0);
            move = resp.getSecondaryAttributes().getBasicMove().getValue();
        } else if (resp.getEquipmentWeight() <= 2.0 * resp.getSecondaryAttributes().getBasicLift()) {
            other.setEncumbranceLevel(1);
            move = (int) (0.8 * resp.getSecondaryAttributes().getBasicMove().getValue());
        } else if (resp.getEquipmentWeight() <= 3.0 * resp.getSecondaryAttributes().getBasicLift()) {
            other.setEncumbranceLevel(2);
            move = (int) (0.6 * resp.getSecondaryAttributes().getBasicMove().getValue());
        } else if (resp.getEquipmentWeight() <= 6.0 * resp.getSecondaryAttributes().getBasicLift()) {
            other.setEncumbranceLevel(3);
            move = (int) (0.4 * resp.getSecondaryAttributes().getBasicMove().getValue());
        } else if (resp.getEquipmentWeight() <= 10.0 * resp.getSecondaryAttributes().getBasicLift()) {
            other.setEncumbranceLevel(4);
            move = (int) (0.2 * resp.getSecondaryAttributes().getBasicMove().getValue());
        } else {
            other.setEncumbranceLevel(5);
            move = 0;
        }
        other.setEncumberedMove(Math.max(move, 1));
        other.setDamageResistance(0);
        int dodge = (int) (resp.getSecondaryAttributes().getBasicSpeed().getValue() + 3 - other.getEncumbranceLevel());
        other.setDodge(Math.max(dodge, 1));
        other.setFrightCheck(intelligenceValue);
        other.setMentalStunCheck(intelligenceValue);
        other.setPhysicalStunCheck(healthValue);
        other.setDeathCheck(healthValue);
        resp.setOtherAttributes(other);
    }
}
