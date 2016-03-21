package cookbook;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeBase implements Recipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeBase.class);

    public void title() {

        LOGGER.debug("# Base");

    }

    public void cook() {

        // 変数展開

        String name = "Recipe";
        String hello = String.format("Hello %s!", name);
        LOGGER.debug(hello);

        // 現在時刻

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        LOGGER.debug(now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

        now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        LOGGER.debug(now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

    }

    public static void main(String[] args) throws Exception {

        Recipe recipe = new RecipeBase();

        recipe.title();
        recipe.cook();

    }

}
