package pl.karolgolec.libs.translator.resources;

import pl.karolgolec.libs.translator.interfaces.IProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * The type Http properties.
 */
public class HttpProperties implements IProperties {

    private URL url;

    /**
     * Instantiates a new Http properties.
     *
     * @param url the url
     */
    public HttpProperties(URL url) {
        this.url = url;
    }

    @Override
    public Properties get() throws IOException {
        InputStream in = this.url.openStream();
        Reader reader = new InputStreamReader(in, Charset.forName("UTF-8"));
        Properties props = new Properties();
        props.load(reader);
        reader.close();
        return props;
    }
}
