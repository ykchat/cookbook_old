package cookbook;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeThread implements Recipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeThread.class);

    public void title() {

        LOGGER.debug("# Thread");

    }

    public void cook() {

        List<Double> secs = Arrays.asList(1.0, 2.0, 3.0);

        // スレッド生成

        List<Thread> threads = new ArrayList<>();
        for(double sec: secs) {
            Thread thread = new Thread(() -> {
                LOGGER.debug("sleep({}) started", sec);
                try {
                    Thread.sleep(Double.valueOf(sec*1000).longValue());
                    LOGGER.debug("sleep({}) ended", sec);
                } catch (InterruptedException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            });
            threads.add(thread);
        }

        // スレッド開始

        for(Thread thread: threads) {
            thread.start();
        }

        // スレッド終了待ち

        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }

    }

    public static void main(String[] args) throws Exception {

        Recipe recipe = new RecipeThread();

        recipe.title();
        recipe.cook();

    }

}
