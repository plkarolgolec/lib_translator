package pl.karolgolec.libs.translator.interfaces;

import java.io.IOException;
import java.util.Properties;

/**
 * The interface Properties.
 */
public interface IProperties {

    /**
     * Get properties.
     *
     * @return the properties
     */
    Properties get() throws IOException;
}
