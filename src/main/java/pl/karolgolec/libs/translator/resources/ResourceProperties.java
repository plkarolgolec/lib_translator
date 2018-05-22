package pl.karolgolec.libs.translator.resources;

import pl.karolgolec.libs.translator.interfaces.IProperties;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * The type Resource properties.
 */
public class ResourceProperties implements IProperties {

    private String resource;

    /**
     * Instantiates a new Resource properties.
     *
     * @param resource the resource
     */
    public ResourceProperties(String resource) {
        this.resource = resource;
    }

    @Override
    public Properties get() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(this.resource);
        Reader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
        Properties props = new Properties();
        props.load(reader);
        reader.close();
        return props;
    }
}
