import cookbook.Recipe;
import java.util.Arrays;
import java.util.List;
import java.lang.management.ManagementFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cooker {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cooker.class);

    public static void cook(List<String> recipes) throws Exception {

        for(String recipe: recipes) {

            Class<?> recipeCls = Class.forName(recipe);
            Object recipeObj = recipeCls.newInstance();

            LOGGER.debug("");
            recipeCls.getMethod("title").invoke(recipeObj);
            recipeCls.getMethod("cook").invoke(recipeObj);

        }

    }

    public static void main(String[] args) throws Exception {

        System.setProperty("pid", ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

        List<String> recipes = Arrays.asList(
            "cookbook.RecipeBase",
            "cookbook.RecipeLoop"
        );

        Cooker.cook(recipes);

    }

}
