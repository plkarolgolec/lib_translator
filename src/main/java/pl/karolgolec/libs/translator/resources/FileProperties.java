package pl.karolgolec.libs.translator.resources;

import pl.karolgolec.libs.translator.interfaces.IProperties;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * The type File properties.
 */
public class FileProperties implements IProperties {

    private File file;

    /**
     * Instantiates a new File properties.
     *
     * @param file the file
     */
    public FileProperties(File file) {
        this.file = file;
    }

    @Override
    public Properties get() throws IOException {
        FileInputStream fis = new FileInputStream(this.file);
        Reader reader = new InputStreamReader(fis, Charset.forName("UTF-8"));
        Properties props = new Properties();
        props.load(reader);
        reader.close();
        return props;
    }
}
