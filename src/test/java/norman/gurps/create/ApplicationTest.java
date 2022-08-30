package norman.gurps.create;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class ApplicationTest {
    Application me;
    ClassLoader loader;

    @BeforeEach
    void setUp() {
        me = new Application();
        loader = Thread.currentThread().getContextClassLoader();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doIt() throws Exception {
        URL reqUrl = loader.getResource("integration/request01.json");
        File reqFile = new File(reqUrl.toURI().getPath());
        String respJsonExpected = IOUtils.toString(loader.getResourceAsStream("integration/response01.json"),
                StandardCharsets.UTF_8.name());

        String respJsonActual = me.doIt(reqFile, false);

        JSONAssert.assertEquals(respJsonExpected, respJsonActual, true);
    }
}
