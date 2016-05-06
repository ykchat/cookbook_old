package cookbook

import scala.io.Source
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class RecipeHttp private extends Recipe {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def title() = {

        logger debug "# Base"

    }

    def cook() = {

        val host = "weather.livedoor.com";
        val api = "/forecast/webservice/json/v1?city=130010";

        // HTTPリクエスト

        val src = Source fromURL "http://" + host + api
        var body: String = null
        try {
            body = src.getLines.mkString
        } finally {
            src.close
        }

        // HTTPレスポンス解析

        val mapper = new ObjectMapper
        mapper registerModule DefaultScalaModule
        val data = mapper.readValue(body, classOf[Map[String, _]])

        val location = data("location").asInstanceOf[Map[String, _]]
        logger debug s"${location("prefecture")}, ${location("city")}"

        val forecasts = data("forecasts").asInstanceOf[List[Map[String, _]]]
        for(forecast <- forecasts) {
            logger debug s"${forecast("dateLabel")}[${forecast("date")}]: ${forecast("telop")}"
        }

    }

}

object RecipeHttp {

    def apply() = {

        new RecipeHttp

    }

    def main(args: Array[String]) {

        val recipe = RecipeHttp.apply

        recipe.title
        recipe.cook

    }

}
