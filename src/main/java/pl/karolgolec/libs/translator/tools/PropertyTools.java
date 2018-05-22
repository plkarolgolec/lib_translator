package pl.karolgolec.libs.translator.tools;

import pl.karolgolec.libs.translator.interfaces.IProperties;
import pl.karolgolec.libs.translator.resources.FileProperties;
import pl.karolgolec.libs.translator.resources.HttpProperties;
import pl.karolgolec.libs.translator.resources.ResourceProperties;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * The type Property tools.
 */
public class PropertyTools {


    /**
     * Get properties.
     *
     * @param path the path
     * @return the properties
     * @throws IOException the io exception
     */
    public static Properties get(String path) throws IOException {
        if (path.startsWith("http://") || path.startsWith("https://")){
            return new HttpProperties(new URL(path)).get();
        } else if (new File(path).exists()){
            return new FileProperties(new File(path)).get();
        } else {
            return new ResourceProperties(path).get();
        }
    }

    /**
     * Get properties.
     *
     * @param iProperties the properties
     * @return the properties
     * @throws IOException the io exception
     */
    public static Properties get(IProperties iProperties) throws IOException {
        return iProperties.get();
    }
}
