import java.util.Arrays;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.management.ManagementFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cooker {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cooker.class);

    public static void cook(List<String> recipes) {

        for(String recipe: recipes) {

            try {

                Class<?> recipeCls = Class.forName(recipe);
                Object recipeObj = recipeCls.newInstance();

                LOGGER.debug("");
                recipeCls.getMethod("title").invoke(recipeObj);
                recipeCls.getMethod("cook").invoke(recipeObj);

            } catch(ClassNotFoundException ex) {
                LOGGER.error(ex.getMessage(), ex);
            } catch(NoSuchMethodException ex) {
                LOGGER.error(ex.getMessage(), ex);
            } catch(IllegalAccessException ex) {
                LOGGER.error(ex.getMessage(), ex);
            } catch(InstantiationException ex) {
                LOGGER.error(ex.getMessage(), ex);
            } catch(InvocationTargetException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }

        }

    }

    public static void main(String[] args) throws Exception {

        System.setProperty("pid", ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

        List<String> recipes = Arrays.asList(
            "cookbook.RecipeBase",
            "cookbook.RecipeLoop",
            "cookbook.RecipeFile",
            "cookbook.RecipeCommand",
            "cookbook.RecipeThread",
            "cookbook.RecipeHttp"
        );

        Cooker.cook(recipes);

    }

}
