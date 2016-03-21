package cookbook;

import java.util.Arrays;
import java.util.List;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeCommand implements Recipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeCommand.class);

    public void title() {

        LOGGER.debug("# Command");

    }

    public void cook() {

        List<String> commands = Arrays.asList("ls");

        // コマンド実行

        for(String command: commands) {

            ProcessBuilder builder = new ProcessBuilder(command);

            try {

                Process proc = builder.start();
                // コマンドのpid取得
                // -> 現在pidを取得するAPIがない
                // See also http://stackoverflow.com/questions/4750470/
                LOGGER.debug("{} started", command);
                // コマンド実行結果（標準出力）を取得
                BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    LOGGER.debug(line);
                }
                proc.waitFor();
                LOGGER.debug("{} ended", command);

            } catch (IOException ex) {
                LOGGER.error(ex.getMessage(), ex);
            } catch (InterruptedException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }

        }

    }

    public static void main(String[] args) throws Exception {

        Recipe recipe = new RecipeCommand();

        recipe.title();
        recipe.cook();

    }

}
