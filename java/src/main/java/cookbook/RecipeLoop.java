package cookbook;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeLoop implements Recipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeLoop.class);

    public void title() {

        LOGGER.debug("# Loop");

    }

    public void cook() {

        List<Integer> nums = Arrays.asList(0, 1, 2, 3, 4);
        Function<Integer, Integer> pow = x -> {
            return x * x;
        };

        // for文

        List<Integer> results = new ArrayList<>();
        for(int num: nums) {
            results.add(pow.apply(num));
        }
        LOGGER.debug(results.toString());

        // map関数

        results = nums.stream().map(pow).collect(Collectors.toList());
        LOGGER.debug(results.toString());

    }

    public static void main(String[] args) throws Exception {

        Recipe recipe = new RecipeLoop();

        recipe.title();
        recipe.cook();

    }

}
