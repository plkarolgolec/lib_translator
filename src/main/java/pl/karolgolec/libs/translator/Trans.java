package pl.karolgolec.libs.translator;

import pl.karolgolec.libs.translator.resources.FileProperties;
import pl.karolgolec.libs.translator.resources.ResourceProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * The type Trans.
 */
public class Trans {

    private Properties propsFileEn;

    private Properties propsFileDefault;

    private Properties propsResEn;

    private Properties propsResDefault;

    /**
     * Instantiates a new Trans.
     *
     * @param dirPath the dir path
     * @throws IOException the io exception
     */
    public Trans(String dirPath) throws IOException {
        File fileEn = new File(dirPath, "en.properties");
        if (fileEn.exists()){
            this.propsFileEn = new FileProperties(fileEn).get();
        }
        File fileDefault = new File(dirPath, Locale.getDefault().getLanguage() + ".properties");
        if (fileDefault.exists()){
            this.propsFileDefault = new FileProperties(fileDefault).get();
        }
        InputStream isEn = getClass().getClassLoader().getResourceAsStream(dirPath + "/en.properties");
        if (isEn != null){
            this.propsResEn = new ResourceProperties(dirPath + "/en.properties").get();
        }
        InputStream isDefault = getClass().getClassLoader().getResourceAsStream(dirPath + "/" + Locale.getDefault().getLanguage()+".properties");
        if (isDefault != null){
            this.propsResDefault = new ResourceProperties(dirPath + "/" + Locale.getDefault().getLanguage()+".properties").get();
        }
    }

    /**
     * Get.
     *
     * @param key the key
     */
    public String get(String key) {
        if (this.propsFileDefault != null && this.propsFileDefault.containsKey(key)){
            return this.propsFileDefault.getProperty(key);
        } else if (this.propsFileEn != null && this.propsFileEn.containsKey(key)){
            return this.propsFileEn.getProperty(key);
        } else if (this.propsResDefault != null && this.propsResDefault.containsKey(key)){
            return this.propsResDefault.getProperty(key);
        } else if (this.propsResEn != null && this.propsResEn.containsKey(key)){
            return this.propsResEn.getProperty(key);
        }
        return "%%" + key + "%%";
    }
}
