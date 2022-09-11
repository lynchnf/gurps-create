package norman.gurps.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import norman.gurps.create.model.request.AdvantageRequest;
import norman.gurps.create.model.request.DisadvantageRequest;
import norman.gurps.create.model.request.GameCharacterRequest;
import norman.gurps.create.util.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.debug("Starting Application");

        // Create example request object.
        GameCharacterRequest req = new GameCharacterRequest();
        //req.setCharacterName("Advantages Guy");
        //req.setCharacterName("Disadvantages Guy");
        req.setCharacterName("Quirks Guy");
        //req.setCharacterName("Skills Guy");

        req.setStrengthAdjustment(-2);
        req.setDexterityAdjustment(1);
        req.setIntelligenceAdjustment(2);
        req.setHealthAdjustment(-1);

        req.setHitPointsAdjustment(3);
        req.setWillAdjustment(-2);
        req.setPerceptionAdjustment(-3);
        req.setFatiguePointsAdjustment(2);
        req.setBasicSpeedAdjustment(0.25);
        req.setBasicMoveAdjustment(-1);

        req.getAdvantages().add(new AdvantageRequest("Combat Reflexes"));
        req.getAdvantages().add(new AdvantageRequest("Enhanced Defenses (Broadsword Parry)", 2));
        req.getAdvantages().add(new AdvantageRequest("Hard to Kill", 3));
        req.getAdvantages().add(new AdvantageRequest("High Pain Threshold"));
        req.getAdvantages().add(new AdvantageRequest("Talent (Smooth Operator)", 1));

        req.getDisadvantages().add(new DisadvantageRequest("Greed", 15));
        req.getDisadvantages().add(new DisadvantageRequest("Lecherousness", 12));
        req.getDisadvantages().add(new DisadvantageRequest("Overconfidence", 6));

        req.getQuirks().add("First quirk.");
        req.getQuirks().add("Second quirk.");
        req.getQuirks().add("Third quirk.");
        req.getQuirks().add("Fourth quirk.");
        req.getQuirks().add("Last quirk.");

        //req.getSkills().add(new SkillRequest("Brawling", 13));
        //req.getSkills().add(new SkillRequest("Carousing", null, null, 2));
        //req.getSkills().add(new SkillRequest("Climbing", 12));
        //req.getSkills().add(new SkillRequest("Broadsword", 15));
        //req.getSkills().add(new SkillRequest("Knife", 12));
        //req.getSkills().add(new SkillRequest("Swimming", null, null, 1));
        //req.getSkills().add(new SkillRequest("Thrown Weapon (Knife)", 14));

        try {
            // Get file directory.
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URL url = loader.getResource("logback.xml");
            File file = new File(url.toURI().getPath());
            File fileDir = file.getParentFile();

            // Write request file in a pretty format.
            File reqFile = new File(fileDir, "request.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.writerWithDefaultPrettyPrinter().writeValue(reqFile, req);

            // Create response string.
            String campaignFileName = "campaign";
            File dataDir = new File(fileDir, "data");
            File campaignDir = dataDir;
            File advantageDir = dataDir;
            File disadvantageDir = dataDir;
            File skillDir = dataDir;
            File equipmentDir = dataDir;
            Transformer transformer = new Transformer(campaignFileName, campaignDir, advantageDir, disadvantageDir,
                    skillDir, equipmentDir);
            String respJson = transformer.transform(reqFile);

            // Write request file.
            File respFile = new File(fileDir, "response.json");
            Files.write(Paths.get(respFile.getPath()), respJson.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
