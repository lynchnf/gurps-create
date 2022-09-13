//package norman.gurps.create;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import norman.gurps.create.model.ControllingAttribute;
//import norman.gurps.create.model.DamageBase;
//import norman.gurps.create.model.data.AdvantageData;
//import norman.gurps.create.model.data.DefaultData;
//import norman.gurps.create.model.data.DisadvantageData;
//import norman.gurps.create.model.data.EquipmentData;
//import norman.gurps.create.model.data.MeleeWeaponData;
//import norman.gurps.create.model.data.MeleeWeaponModeData;
//import norman.gurps.create.model.data.RangedWeaponData;
//import norman.gurps.create.model.data.RangedWeaponModeData;
//import norman.gurps.create.model.data.SkillData;
//import norman.gurps.create.model.request.AdvantageRequest;
//import norman.gurps.create.model.request.DisadvantageRequest;
//import norman.gurps.create.model.request.EquipmentRequest;
//import norman.gurps.create.model.request.GameCharacterRequest;
//import norman.gurps.create.model.request.SkillRequest;
//import norman.gurps.create.model.response.DefaultResponse;
//import norman.gurps.create.model.response.EquipmentResponse;
//import norman.gurps.create.model.response.GameCharacterResponse;
//import norman.gurps.create.model.response.MeleeWeaponResponse;
//import norman.gurps.create.model.response.OtherAttributes;
//import norman.gurps.create.model.response.RangedWeaponResponse;
//import norman.gurps.create.model.response.SkillResponse;
//import norman.gurps.create.util.Helper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.ResourceBundle;
//
//public class ApplicationOld {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationOld.class);
//    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");
//
//    public static void main_01(String[] args) {
//        LOGGER.debug("Starting Application");
//
//        // Create example request object.
//        GameCharacterRequest req = new GameCharacterRequest();
//        req.setCharacterName("Anton");
//        req.setStrengthAdjustment(4);
//        req.setDexterityAdjustment(3);
//        req.setIntelligenceAdjustment(-2);
//        req.setHealthAdjustment(4);
//        req.setHitPointsAdjustment(5);
//        req.setWillAdjustment(0);
//        req.setPerceptionAdjustment(0);
//        req.setFatiguePointsAdjustment(0);
//        req.setBasicSpeedAdjustment(0.00);
//        req.setBasicMoveAdjustment(0);
//
//        req.getAdvantages().add(new AdvantageRequest("Catfall"));
//        req.getAdvantages().add(new AdvantageRequest("Damage Resistance", 3));
//        req.getAdvantages().add(new AdvantageRequest("Dark Vision"));
//        req.getAdvantages().add(new AdvantageRequest("Discriminatory Smell"));
//        req.getAdvantages().add(new AdvantageRequest("Extended Lifespan", 5));
//        req.getAdvantages().add(new AdvantageRequest("Fearlessness", 2));
//        req.getAdvantages().add(new AdvantageRequest("Hard to Kill", 2));
//        req.getAdvantages().add(new AdvantageRequest("Sharp Claws"));
//        req.getAdvantages().add(new AdvantageRequest("Sharp Teeth"));
//
//        req.getDisadvantages().add(new DisadvantageRequest("Bloodlust", 12));
//        req.getDisadvantages().add(new DisadvantageRequest("Illiteracy"));
//        req.getDisadvantages().add(new DisadvantageRequest("Lecherousness", 15));
//        req.getDisadvantages().add(new DisadvantageRequest("Obsession", 12, "Hats/Heterodynes"));
//        req.getDisadvantages().add(new DisadvantageRequest("Repulsive Appearance"));
//
//        req.getQuirks().add("Hates being called \"kid\", \"junior\", or \"boy\".");
//        req.getQuirks().add("Brags about how the ladies all love him.");
//        req.getQuirks().add("Preoccupied with his looks.");
//        req.getQuirks().add("Spouts poetry.");
//        req.getQuirks().add("Claims anything he doesn't like is \"for sissies\".");
//
//        req.getSkills().add(new SkillRequest("Acrobatics", 14));
//        req.getSkills().add(new SkillRequest("Area Knowledge", "Europa", null, 2));
//        req.getSkills().add(new SkillRequest("Bartender", 12));
//        req.getSkills().add(new SkillRequest("Brawling", 15));
//        req.getSkills().add(new SkillRequest("Broadsword", 14));
//        req.getSkills().add(new SkillRequest("Carousing", 14));
//        req.getSkills().add(new SkillRequest("Climbing", 14));
//        req.getSkills().add(new SkillRequest("Escape", 12));
//        req.getSkills().add(new SkillRequest("Fast-Draw", 13));
//        req.getSkills().add(new SkillRequest("Guns", 14));
//        req.getSkills().add(new SkillRequest("Jumping", 13));
//        req.getSkills().add(new SkillRequest("Knife", 14));
//        req.getSkills().add(new SkillRequest("Poetry", null, null, 1));
//        req.getSkills().add(new SkillRequest("Soldier", null, null, 1));
//        req.getSkills().add(new SkillRequest("Swimming", 14));
//        req.getSkills().add(new SkillRequest("Throwing", 14));
//        req.getSkills().add(new SkillRequest("Thrown Knife", null, null, 1));
//        req.getSkills().add(new SkillRequest("Two-Handed Sword"));
//
//        req.getEquipmentList().add(new EquipmentRequest("Broadsword"));
//        req.getEquipmentList().add(new EquipmentRequest("Large Knife"));
//        req.getEquipmentList().add(new EquipmentRequest("Jager Rifle"));
//        req.getEquipmentList().add(new EquipmentRequest("Bullets", 20));
//        req.getEquipmentList().add(new EquipmentRequest("Jager Uniform"));
//        req.getEquipmentList().add(new EquipmentRequest("Backpack, Small"));
//        req.getEquipmentList().add(new EquipmentRequest("Blanket"));
//        req.getEquipmentList().add(new EquipmentRequest("Bottle, Ceramic"));
//        req.getEquipmentList().add(new EquipmentRequest("Climbing Gear"));
//        req.getEquipmentList().add(new EquipmentRequest("Personal Basics"));
//        req.getEquipmentList().add(new EquipmentRequest("Rope, 20 yrds"));
//        req.getEquipmentList().add(new EquipmentRequest("Hand held mirror"));
//        req.getEquipmentList().add(new EquipmentRequest("Brush, comb, etc."));
//    }
//
//    public static void main(String[] args) {
//        LOGGER.debug("Starting Application");
//
//        // Create example request object.
//        GameCharacterRequest req = new GameCharacterRequest();
//        //req.setCharacterName("Default Values Guy");
//        //req.setCharacterName("Primary Attributes Guy");
//        req.setCharacterName("Skills Guy");
//
//        req.setStrengthAdjustment(-2);
//        req.setDexterityAdjustment(1);
//        req.setIntelligenceAdjustment(2);
//        req.setHealthAdjustment(-1);
//
//        req.setHitPointsAdjustment(3);
//        req.setWillAdjustment(-2);
//        req.setPerceptionAdjustment(-3);
//        req.setFatiguePointsAdjustment(2);
//        req.setBasicSpeedAdjustment(0.25);
//        req.setBasicMoveAdjustment(-1);
//
//        req.getSkills().add(new SkillRequest("Brawling", 13));
//        req.getSkills().add(new SkillRequest("Carousing", null, null, 2));
//        req.getSkills().add(new SkillRequest("Climbing", 12));
//        req.getSkills().add(new SkillRequest("Broadsword", 15));
//        req.getSkills().add(new SkillRequest("Knife", 12));
//        req.getSkills().add(new SkillRequest("Swimming", null, null, 1));
//        req.getSkills().add(new SkillRequest("Thrown Weapon (Knife)", 14));
//
//        try {
//            // Get file directory.
//            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            URL url = loader.getResource("example.json");
//            File file = new File(url.toURI().getPath());
//            File fileDir = file.getParentFile();
//
//            // Write request file in a pretty format.
//            File reqFile = new File(fileDir, "request.json");
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            mapper.writerWithDefaultPrettyPrinter().writeValue(reqFile, req);
//
//            // Create response string.
//            ApplicationOld me = new ApplicationOld();
//            String respJson = me.transform(reqFile, true);
//
//            // Write request file.
//            File respFile = new File(fileDir, "response.json");
//            Files.write(Paths.get(respFile.getPath()), respJson.getBytes(StandardCharsets.UTF_8));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    protected String transform(File reqFile, boolean prettify) throws IOException {
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        ObjectMapper mapper = new ObjectMapper();
//
//        GameCharacterRequest req = mapper.readValue(reqFile, GameCharacterRequest.class);
//        cleanRequest(req);
//        GameCharacterResponse resp = new GameCharacterResponse();
//        resp.setCharacterName(req.getCharacterName());
//
//        // Primary Attributes
//        transformPrimaryAttributes(req, resp);
//
//        int strengthValue = resp.getPrimaryAttributes().getStrength().getValue();
//        int dexterityValue = resp.getPrimaryAttributes().getDexterity().getValue();
//        int intelligenceValue = resp.getPrimaryAttributes().getIntelligence().getValue();
//        int healthValue = resp.getPrimaryAttributes().getHealth().getValue();
//
//        // Secondary Attributes
//        transformSecondaryAttributes(req, resp, strengthValue, dexterityValue, intelligenceValue, healthValue);
//
//        int willValue = resp.getSecondaryAttributes().getWill().getValue();
//        int perceptionValue = resp.getSecondaryAttributes().getPerception().getValue();
//
//        // Advantages
//        //        Map<String, AdvantageData> advMap = Helper.getAdvantageDataMap("data/advantageData.json", loader, mapper);
//        //        transformAdvantages(req, resp, advMap);
//        //
//        //        // Disadvantages
//        //        Map<String, DisadvantageData> disMap = Helper.getDisadvantageDataMap("data/disadvantageData.json", loader,
//        //                mapper);
//        //        transformDisadvantages(req, resp, disMap);
//
//        // Quirks
//        resp.getQuirks().addAll(req.getQuirks());
//
//        // Skills
//        //        Map<String, SkillData> skillMap = Helper.getSkillDataMap("data/skillData.json", loader, mapper);
//        //        transformSkills(req, resp, strengthValue, dexterityValue, intelligenceValue, healthValue, willValue,
//        //                perceptionValue, skillMap);
//        //
//        //        // Equipment
//        //        Map<String, EquipmentData> equipMap = Helper.getEquipmentDataMap("data/equipmentData.json", loader, mapper);
//        //        transformEquipment(req, resp, equipMap);
//
//        // Other Attributes
//        constructOtherAttributes(resp, intelligenceValue, healthValue);
//
//        // Melee Weapons
//        //constructMeleeWeapons(resp, strengthValue, equipMap);
//
//        // Ranged Weapons
//        //rangedMeleeWeapons(resp, strengthValue, equipMap);
//
//        // Defaults
//        //applySkillDefaults(resp, strengthValue, dexterityValue, intelligenceValue, healthValue, willValue, perceptionValue, skillMap);
//
//        // Sort
//        sortForOutput(resp);
//
//        LOGGER.debug("Total Points=" + resp.getTotalPoints());
//
//        // Output JSON string.
//        if (prettify) {
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        }
//        return mapper.writeValueAsString(resp);
//    }
//
//    private void cleanRequest(GameCharacterRequest req) {
//    }
//
//    private static void transformPrimaryAttributes(GameCharacterRequest req, GameCharacterResponse resp) {
//    }
//
//    private static void transformSecondaryAttributes(GameCharacterRequest req, GameCharacterResponse resp,
//            int strengthValue, int dexterityValue, int intelligenceValue, int healthValue) {
//    }
//
//    private static void transformAdvantages(GameCharacterRequest req, GameCharacterResponse resp,
//            Map<String, AdvantageData> advMap) {
//    }
//
//    private static void transformDisadvantages(GameCharacterRequest req, GameCharacterResponse resp,
//            Map<String, DisadvantageData> disMap) {
//    }
//
//    private static void transformSkills(GameCharacterRequest req, GameCharacterResponse resp, int strengthValue,
//            int dexterityValue, int intelligenceValue, int healthValue, int willValue, int perceptionValue,
//            Map<String, SkillData> skillMap) {
//    }
//
//    private static void transformEquipment(GameCharacterRequest req, GameCharacterResponse resp,
//            Map<String, EquipmentData> equipMap) {
//    }
//
//    private static void constructOtherAttributes(GameCharacterResponse resp, int intelligenceValue, int healthValue) {
//        OtherAttributes other = new OtherAttributes();
//        int move;
//        if (resp.getEquipmentWeight() <= resp.getSecondaryAttributes().getBasicLift()) {
//            other.setEncumbranceLevel(0);
//            move = resp.getSecondaryAttributes().getBasicMove().getValue();
//        } else if (resp.getEquipmentWeight() <= 2.0 * resp.getSecondaryAttributes().getBasicLift()) {
//            other.setEncumbranceLevel(1);
//            move = (int) (0.8 * resp.getSecondaryAttributes().getBasicMove().getValue());
//        } else if (resp.getEquipmentWeight() <= 3.0 * resp.getSecondaryAttributes().getBasicLift()) {
//            other.setEncumbranceLevel(2);
//            move = (int) (0.6 * resp.getSecondaryAttributes().getBasicMove().getValue());
//        } else if (resp.getEquipmentWeight() <= 6.0 * resp.getSecondaryAttributes().getBasicLift()) {
//            other.setEncumbranceLevel(3);
//            move = (int) (0.4 * resp.getSecondaryAttributes().getBasicMove().getValue());
//        } else if (resp.getEquipmentWeight() <= 10.0 * resp.getSecondaryAttributes().getBasicLift()) {
//            other.setEncumbranceLevel(4);
//            move = (int) (0.2 * resp.getSecondaryAttributes().getBasicMove().getValue());
//        } else {
//            other.setEncumbranceLevel(5);
//            move = 0;
//        }
//        other.setEncumberedMove(Math.max(move, 1));
//        other.setDamageResistance(0);
//        int dodge = (int) (resp.getSecondaryAttributes().getBasicSpeed().getValue() + 3 - other.getEncumbranceLevel());
//        other.setDodge(Math.max(dodge, 1));
//        other.setFrightCheck(intelligenceValue);
//        other.setMentalStunCheck(intelligenceValue);
//        other.setPhysicalStunCheck(healthValue);
//        other.setDeathCheck(healthValue);
//        resp.setOtherAttributes(other);
//    }
//
//    private void constructMeleeWeapons(GameCharacterResponse resp, int strengthValue,
//            Map<String, EquipmentData> equipMap) {
//        for (EquipmentResponse equipResp : resp.getEquipmentList()) {
//            EquipmentData equipData = equipMap.get(equipResp.getName());
//            MeleeWeaponData meleeData = equipData.getMeleeWeapon();
//            if (meleeData != null) {
//                for (MeleeWeaponModeData modeData : meleeData.getModes()) {
//                    MeleeWeaponResponse meleeResp = new MeleeWeaponResponse();
//                    meleeResp.setName(equipResp.getName());
//                    int skill = 0;
//                    for (SkillResponse skillResp : resp.getSkills()) {
//                        if (skillResp.getName().equals(meleeData.getSkill())) {
//                            skill = skillResp.getLevel();
//                        }
//                    }
//                    if (modeData.getMinimumStrength() > strengthValue) {
//                        skill += strengthValue - modeData.getMinimumStrength();
//                    }
//                    meleeResp.setSkill(skill);
//                    int damageDice = 0;
//                    int damageAdds = 0;
//                    if (modeData.getDamageBase() != null) {
//                        if (modeData.getDamageBase() == DamageBase.sw) {
//                            damageDice = resp.getSecondaryAttributes().getSwingDamageDice();
//                            damageAdds = resp.getSecondaryAttributes().getSwingDamageAdds();
//                        } else if (modeData.getDamageBase() == DamageBase.thr) {
//                            damageDice = resp.getSecondaryAttributes().getThrustDamageDice();
//                            damageAdds = resp.getSecondaryAttributes().getThrustDamageAdds();
//                        } else {
//                            String msg = String.format("Illegal Damage Base %s found for Melee Weapon %s.",
//                                    modeData.getDamageBase(), equipResp.getName());
//                            throw new LoggingException(LOGGER, msg);
//                        }
//                    }
//                    damageDice += modeData.getDamageDice();
//                    damageAdds += modeData.getDamageAdds();
//                    meleeResp.setDamageDice(damageDice);
//                    meleeResp.setDamageAdds(damageAdds);
//                    meleeResp.setDamageType(modeData.getDamageType());
//                    meleeResp.getReaches().addAll(modeData.getReaches());
//                    meleeResp.setParry(skill / 2 + 3 + modeData.getParryAdjust());
//                    meleeResp.setBalancedForParry(modeData.getBalancedForParry());
//                    meleeResp.setMinimumStrength(modeData.getMinimumStrength());
//                    meleeResp.setRequiresTwoHands(modeData.getRequiresTwoHands());
//                    if (modeData.getNote() != null) {
//                        meleeResp.setNote(modeData.getNote());
//                    }
//                    resp.getMeleeWeapons().add(meleeResp);
//                }
//            }
//        }
//    }
//
//    private void rangedMeleeWeapons(GameCharacterResponse resp, int strengthValue,
//            Map<String, EquipmentData> equipMap) {
//        for (EquipmentResponse equipResp : resp.getEquipmentList()) {
//            EquipmentData equipData = equipMap.get(equipResp.getName());
//            RangedWeaponData rangedData = equipData.getRangedWeapon();
//            if (rangedData != null) {
//                for (RangedWeaponModeData modeData : rangedData.getModes()) {
//                    RangedWeaponResponse rangedResp = new RangedWeaponResponse();
//                    rangedResp.setName(equipResp.getName());
//
//                    int skill = 0;
//                    for (SkillResponse skillResp : resp.getSkills()) {
//                        if (skillResp.getName().equals(rangedData.getSkill())) {
//                            skill = skillResp.getLevel();
//                        }
//                    }
//                    if (modeData.getMinimumStrength() > strengthValue) {
//                        skill += strengthValue - modeData.getMinimumStrength();
//                    }
//                    rangedResp.setSkill(skill);
//                    int damageDice = 0;
//                    int damageAdds = 0;
//                    if (modeData.getDamageBase() != null) {
//                        if (modeData.getDamageBase() == DamageBase.sw) {
//                            damageDice = resp.getSecondaryAttributes().getSwingDamageDice();
//                            damageAdds = resp.getSecondaryAttributes().getSwingDamageAdds();
//                        } else if (modeData.getDamageBase() == DamageBase.thr) {
//                            damageDice = resp.getSecondaryAttributes().getThrustDamageDice();
//                            damageAdds = resp.getSecondaryAttributes().getThrustDamageAdds();
//                        } else {
//                            String msg = String.format("Illegal Damage Base %s found for Ranged Weapon %s.",
//                                    modeData.getDamageBase(), equipResp.getName());
//                            throw new LoggingException(LOGGER, msg);
//                        }
//                    }
//                    damageDice += modeData.getDamageDice();
//                    damageAdds += modeData.getDamageAdds();
//                    rangedResp.setDamageDice(damageDice);
//                    rangedResp.setDamageAdds(damageAdds);
//                    rangedResp.setDamageType(modeData.getDamageType());
//                    rangedResp.setAccuracy(modeData.getAccuracy());
//                    if (modeData.getHalfDamageRange() != null) {
//                        rangedResp.setHalfDamageRange(modeData.getHalfDamageRange());
//                    } else if (modeData.getHalfDamageRangeMultiplier() != null) {
//                        rangedResp.setHalfDamageRange((int) (modeData.getHalfDamageRangeMultiplier() * strengthValue));
//                    }
//                    if (modeData.getMaximumDamageRange() != null) {
//                        rangedResp.setMaximumDamageRange(modeData.getMaximumDamageRange());
//                    } else if (modeData.getMaximumDamageRangeMultiplier() != null) {
//                        rangedResp.setMaximumDamageRange(
//                                (int) (modeData.getMaximumDamageRangeMultiplier() * strengthValue));
//                    }
//                    rangedResp.setRateOfFire(modeData.getRateOfFire());
//                    rangedResp.setShots(modeData.getShots());
//                    rangedResp.setTimeToReload(modeData.getTimeToReload());
//                    rangedResp.setMinimumStrength(modeData.getMinimumStrength());
//                    rangedResp.setRequiresTwoHands(modeData.getRequiresTwoHands());
//                    rangedResp.setBulk(modeData.getBulk());
//                    if (modeData.getNote() != null) {
//                        rangedResp.setNote(modeData.getNote());
//                    }
//                    resp.getRangedWeapons().add(rangedResp);
//                }
//            }
//        }
//    }
//
//    private static void applySkillDefaults(GameCharacterResponse resp, int strengthValue, int dexterityValue,
//            int intelligenceValue, int healthValue, int willValue, int perceptionValue,
//            Map<String, SkillData> skillMap) {
//
//        // Sort skills by level (descending), name, specialty.
//        resp.getSkills()
//                .sort(Comparator.comparing(SkillResponse::getLevel).reversed().thenComparing(SkillResponse::getName)
//                        .thenComparing(SkillResponse::getSpecialty));
//
//        // Loop through all the skills, building possible defaults for each skill.
//        for (int outer = 0; outer < resp.getSkills().size(); outer++) {
//            SkillResponse outerSkill = resp.getSkills().get(outer);
//            List<DefaultResponse> possibleDefaults = new ArrayList<>();
//
//            // Chug through all the possible defaults for this skill.
//            SkillData skillData = skillMap.get(outerSkill.getName());
//            for (DefaultData dftData : skillData.getDefaults()) {
//
//                // If this is an attribute based default, build it.
//                if (dftData.getAttribute() != null) {
//                    DefaultResponse dftResp = new DefaultResponse();
//                    dftResp.setAttribute(dftData.getAttribute());
//                    int level;
//                    if (dftData.getAttribute() == ControllingAttribute.ST) {
//                        level = strengthValue;
//                    } else if (dftData.getAttribute() == ControllingAttribute.DX) {
//                        level = dexterityValue;
//                    } else if (dftData.getAttribute() == ControllingAttribute.IQ) {
//                        level = intelligenceValue;
//                    } else if (dftData.getAttribute() == ControllingAttribute.HT) {
//                        level = healthValue;
//                    } else if (dftData.getAttribute() == ControllingAttribute.Will) {
//                        level = willValue;
//                    } else if (dftData.getAttribute() == ControllingAttribute.Per) {
//                        level = perceptionValue;
//                    } else {
//                        String msg = String.format("Illegal Controlling Attribute %s found for Skill %s.",
//                                skillData.getControllingAttribute(), skillData.getName());
//                        throw new LoggingException(LOGGER, msg);
//                    }
//                    dftResp.setPenalty(dftData.getPenalty());
//                    level += dftData.getPenalty();
//                    dftResp.setLevel(level);
//                    int points = Helper.calculateSkillPoints(level, outerSkill.getControllingAttributeValue(),
//                            outerSkill.getDifficultyLevel(), outerSkill.getName());
//                    dftResp.setPoints(points);
//                    possibleDefaults.add(dftResp);
//                } else {
//
//                    // Otherwise, this is a skill based default. Loop through all the skills above (i.e. with eqaul or higher levels) the current skill.
//                    for (int inner = 0; inner < outer; inner++) {
//                        SkillResponse innerSkill = resp.getSkills().get(inner);
//
//                        // If the inner skill matches the skill default, we have a possible default for the outer skill.
//                        boolean skillNamesMatch =
//                                dftData.getSkill() != null && dftData.getSkill().equals(innerSkill.getName());
//                        boolean specialtiesBothNull =
//                                dftData.getSpecialty() == null && innerSkill.getSpecialty() == null;
//                        boolean specialtiesMatch = dftData.getSpecialty() != null &&
//                                dftData.getSpecialty().equals(innerSkill.getSpecialty());
//                        if (skillNamesMatch && (specialtiesBothNull || specialtiesMatch)) {
//                            DefaultResponse dftResp = new DefaultResponse();
//                            dftResp.setSkill(innerSkill.getName());
//                            if (innerSkill.getSpecialty() != null) {
//                                dftResp.setSpecialty(innerSkill.getSpecialty());
//                            }
//                            dftResp.setPenalty(dftData.getPenalty());
//                            int level = innerSkill.getLevel() + dftData.getPenalty();
//                            dftResp.setLevel(level);
//                            int points = Helper.calculateSkillPoints(level, outerSkill.getControllingAttributeValue(),
//                                    outerSkill.getDifficultyLevel(), outerSkill.getName());
//                            dftResp.setPoints(points);
//                            possibleDefaults.add(dftResp);
//                        }
//                    }
//                }
//
//                // Find the best default and update the current skill with it.
//                if (!possibleDefaults.isEmpty()) {
//                    possibleDefaults.sort(Comparator.comparing(DefaultResponse::getPoints).reversed());
//                    DefaultResponse bestDefault = possibleDefaults.get(0);
//                    outerSkill.setBestDefault(bestDefault);
//
//                    if (bestDefault.getLevel() >= outerSkill.getLevel()) {
//                        outerSkill.setLevel(bestDefault.getLevel());
//                        outerSkill.setPoints(0);
//                    } else if (bestDefault.getPoints() > 0) {
//                        int points = outerSkill.getPoints();
//                        outerSkill.setPoints(points - bestDefault.getPoints());
//                    }
//                }
//            }
//        }
//    }
//
//    private void sortForOutput(GameCharacterResponse resp) {
//    }
//}
