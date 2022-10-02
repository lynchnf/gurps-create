package norman.gurps.create.util;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class TransformerTest {
    Transformer transformer;
    ClassLoader loader;

    @BeforeEach
    void setUp() throws Exception {
        loader = Thread.currentThread().getContextClassLoader();
        String campaignFileName = "test-campaign";
        String resourceName = "integration" + File.separator + campaignFileName + Transformer.PROPERTIES_EXTENSION;
        URL url = loader.getResource(resourceName);
        File file = new File(url.toURI().getPath());
        File campaignDir = file.getParentFile();
        File dataDir = new File(campaignDir, "data");
        transformer = new Transformer(campaignFileName, campaignDir, dataDir);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void transform_01() throws Exception {
        testTransform("request01.json", "response01.json");
    }

    @Test
    void transform_02() throws Exception {
        testTransform("request02.json", "response02.json");
    }

    @Test
    void transform_03() throws Exception {
        testTransform("request03.json", "response03.json");
    }

    @Test
    void transform_04() throws Exception {
        testTransform("request04.json", "response04.json");
    }

    @Test
    void transform_05() throws Exception {
        testTransform("request05.json", "response05.json");
    }

    @Test
    void transform_06() throws Exception {
        testTransform("request06.json", "response06.json");
    }

    @Test
    void transform_07() throws Exception {
        testTransform("request07.json", "response07.json");
    }

    private void testTransform(String reqFileName, String respFileName)
            throws URISyntaxException, IOException, JSONException {
        String reqRscName = "integration/" + reqFileName;
        URL reqUrl = loader.getResource(reqRscName);
        String reqRscPath = reqUrl.toURI().getPath();
        File reqFile = new File(reqRscPath);
        String respRscName = "integration/" + respFileName;
        InputStream respRscStream = loader.getResourceAsStream(respRscName);
        String respJsonExpected = IOUtils.toString(respRscStream, StandardCharsets.UTF_8.name());

        String respJsonActual = transformer.transform(reqFile);

        JSONAssert.assertEquals(respJsonExpected, respJsonActual, true);
    }
}
