package pl.karolgolec.libs.translator.tools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * The type Trans files.
 */
public class FileTools {

    /**
     * Create.
     *
     * @param file    the file
     * @param content the content
     * @throws IOException the io exception
     */
    public static File create(File file, String content) throws IOException {
        File dirParent = file.getParentFile();
        if (!dirParent.exists()){
            dirParent.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
        return file;
    }

    /**
     * Create.
     *
     * @param dirParent the dir parent
     * @param name      the name
     * @param content   the content
     * @throws IOException the io exception
     */
    public static File create(File dirParent, String name, String content) throws IOException {
        return create(new File(dirParent, name), content);
    }
}
