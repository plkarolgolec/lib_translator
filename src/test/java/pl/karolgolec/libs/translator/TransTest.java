package pl.karolgolec.libs.translator;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import pl.karolgolec.libs.translator.tools.FileTools;

import java.io.File;
import java.io.IOException;

/**
 * The type Trans test.
 */
public class TransTest {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @After
    public void tearDown() throws Exception {
        this.wireMockRule.stop();
    }

    @Test
    public void readPropertiesFromResources() throws IOException {
        String value = "Value 1";
        File file = FileTools.create(this.temp.newFolder(), "en.properties", "label=" + value);
        Trans trans = new Trans(file.getParentFile().getCanonicalPath());
        Assert.assertEquals(value, trans.get("label"));

        value = "Value 2";
        file = FileTools.create(this.temp.newFolder(), "pl.properties", "label=" + value);
        trans = new Trans(file.getParentFile().getCanonicalPath());
        Assert.assertEquals(value, trans.get("label"));
    }

}