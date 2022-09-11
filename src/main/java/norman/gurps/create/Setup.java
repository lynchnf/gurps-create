package norman.gurps.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import norman.gurps.create.model.data.AdvantageData;
import norman.gurps.create.model.data.DisadvantageData;
import norman.gurps.create.model.data.EquipmentData;
import norman.gurps.create.model.data.SkillData;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setup {
    private static final Logger LOGGER = LoggerFactory.getLogger(Setup.class);
    public static final String APP_DIR_NAME = ".gurps-create";
    public static final String CAMPAIGN_DIR_NAME = "campaigns";
    public static final String ADVANTAGE_DIR_NAME = "advantages";
    public static final String DISADVANTAGE_NAME_DIR = "disadvantages";
    public static final String SKILL_DIR_NAME = "skills";
    public static final String EQUIPMENT_DIR_NAME = "equipment";
    public static final String CHARACTER_DIR_NAME = "characters";

    public static void main(String[] args) {
        LOGGER.debug("Starting Application");
        Setup me = new Setup();
        try {
            me.doIt();
        } catch (Exception e) {
            throw new RuntimeException("Something bad happened.", e);
        }
    }

    private void doIt() throws IOException {
        // Create home directory if it does not exist.
        File appDir = createDir(new File(SystemUtils.USER_HOME, APP_DIR_NAME));

        // Create other directories if they do not exist.
        File campaignDir = createDir(new File(appDir, CAMPAIGN_DIR_NAME));
        File advantageDir = createDir(new File(appDir, ADVANTAGE_DIR_NAME));
        File disadvantageDir = createDir(new File(appDir, DISADVANTAGE_NAME_DIR));
        File skillDir = createDir(new File(appDir, SKILL_DIR_NAME));
        File equipmentDir = createDir(new File(appDir, EQUIPMENT_DIR_NAME));
        //File characterDir = createDir(new File(appDir, CHARACTER_DIR_NAME));

        // Copy data files.
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        writeJsonFile("data/advantageData.json", "gurps-lite-advantage-data.json", advantageDir, AdvantageData[].class,
                loader, mapper);
        writeJsonFile("data/disadvantageData.json", "gurps-lite-disadvantage-data.json", disadvantageDir,
                DisadvantageData[].class, loader, mapper);
        writeJsonFile("data/skillData.json", "gurps-lite-skill-data.json", skillDir, SkillData[].class, loader, mapper);
        writeJsonFile("data/equipmentData.json", "gurps-lite-equipment-data.json", equipmentDir, EquipmentData[].class,
                loader, mapper);

        // Write campaign file.
        Properties campaignProps = new Properties();
        campaignProps.setProperty("campaign.name", "gurps-lite");
        campaignProps.setProperty("advantage.data.file.names", "gurps-lite-advantage-data");
        campaignProps.setProperty("disadvantage.data.file.names", "gurps-lite-disadvantage-data");
        campaignProps.setProperty("skill.data.file.names", "gurps-lite-skill-data");
        campaignProps.setProperty("equipment.data.file.names", "gurps-lite-equipment-data");

        File campaignFile = new File(campaignDir, "gurps-lite.properties");

        FileOutputStream outputStream = new FileOutputStream(campaignFile);
        campaignProps.store(outputStream, "GURPS Lite");
        outputStream.close();
    }

    private static File createDir(File parentDir) {
        File campaignDir = parentDir;
        if (!campaignDir.exists()) {
            campaignDir.mkdir();
        }
        return campaignDir;
    }

    private static <T> void writeJsonFile(String resourceName, String destFileName, File destFileDir,
            Class<T> valueType, ClassLoader loader, ObjectMapper mapper) throws IOException {
        InputStream inputStream = loader.getResourceAsStream(resourceName);
        T obj = mapper.readValue(inputStream, valueType);
        File destFile = new File(destFileDir, destFileName);
        mapper.writerWithDefaultPrettyPrinter().writeValue(destFile, obj);
    }
}
