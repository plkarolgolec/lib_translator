package pl.karolgolec.libs.translator;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import pl.karolgolec.libs.translator.tools.FileTools;
import pl.karolgolec.libs.translator.tools.PropertyTools;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 22.05.2018
 * Time: 17:40
 * Project name: translator
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PropertyToolsTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @After
    public void tearDown() throws Exception {
        this.wireMockRule.stop();
    }

    @Test
    public void getProperty() throws IOException {
        stubFor(get(urlEqualTo("/file.properties"))
                .willReturn(aResponse().withBody("propertyOne=FirstProperty")));
        Properties properties = PropertyTools.get("http://localhost:" + wireMockRule.port() + "/file.properties");
        Assert.assertNotNull("Properties by http is null", properties);
        File file = FileTools.create(this.temp.newFolder(), "file.properties", "label.hello=Hello file!");
        file.deleteOnExit();
        properties = PropertyTools.get(file.getCanonicalPath());
        Assert.assertNotNull("Properties by file is null", properties);
        properties = PropertyTools.get("pl/karolgolec/libs/translator/lang/en.properties");
        Assert.assertNotNull("Properties by resource is null", properties);
    }
}