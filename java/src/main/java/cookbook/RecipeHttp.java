package cookbook;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeHttp implements Recipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeHttp.class);

    public void title() {

        LOGGER.debug("# Http");

    }

    public void cook() {

        String host = "weather.livedoor.com";
        String api = "/forecast/webservice/json/v1?city=130010";

        try {

            // HTTPリクエスト

            URL url = new URL("http://" + host + api);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("GET");
            http.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder buf = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buf.append(line);
            }

            // HTTPレスポンス解析

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> data = mapper.readValue(buf.toString(), new TypeReference<Map<String, Object>>(){});

            @SuppressWarnings("unchecked")
            Map<String, Object> location = (Map<String, Object>)data.get("location");
            LOGGER.debug(String.format("%s, %s", location.get("prefecture"), location.get("city")));

            @SuppressWarnings("unchecked") 
            List<Map<String, Object>> forecasts = (List<Map<String, Object>>)data.get("forecasts");
            for(Map<String, Object> forecast: forecasts) {
                LOGGER.debug(String.format("%s[%s]: %s", forecast.get("dateLabel"), forecast.get("date"), forecast.get("telop")));
            }

        } catch (MalformedURLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (ProtocolException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

    }

    public static void main(String[] args) throws Exception {

        Recipe recipe = new RecipeHttp();

        recipe.title();
        recipe.cook();

    }

}
