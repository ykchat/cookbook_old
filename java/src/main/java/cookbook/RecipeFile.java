package cookbook;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.function.ToIntFunction;
import java.io.BufferedReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeFile implements Recipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeBase.class);

    public void title() {

        LOGGER.debug("# File");

    }

    public void cook() {

        Path path = Paths.get("src/main/java/Cooker.java");

        // 基本情報

        LOGGER.debug(String.format("dir=%s", path.getParent().toAbsolutePath()));
        LOGGER.debug(String.format("file=%s", path.getFileName()));
        try {
            LOGGER.debug(String.format("size=%d", Files.size(path)));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        // 行数カウント

        try {
            LOGGER.debug(String.format("lc=%d", Files.lines(path).count()));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        try {
            ToIntFunction<String> one = line -> 1;
            LOGGER.debug(String.format("lc=%d", Files.lines(path).mapToInt(one).sum()));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
            int counter = 0;
            String line;
            while((line = reader.readLine()) != null) {
                counter += 1;
            }
            LOGGER.debug(String.format("lc=%d", counter));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        Recipe recipe = new RecipeBase();

        recipe.title();
        recipe.cook();

    }

}
