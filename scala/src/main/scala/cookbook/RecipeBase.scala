package cookbook

import java.time.{ZonedDateTime, ZoneId}
import java.time.format.DateTimeFormatter
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class RecipeBase private extends Recipe {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def title() = {

        logger debug "# Base"

    }

    def cook() = {

        // 変数展開

        val name = "Recipe"
        val hello = s"Hello ${name}!"
        logger debug hello

        // 現在時刻

        var now = ZonedDateTime now (ZoneId of "UTC")
        logger debug (now format DateTimeFormatter.ISO_OFFSET_DATE_TIME)

        now = ZonedDateTime now (ZoneId of "Asia/Tokyo")
        logger debug (now format DateTimeFormatter.ISO_OFFSET_DATE_TIME)

    }

}

object RecipeBase {

    def apply() = {

        new RecipeBase

    }

    def main(args: Array[String]) {

        val recipe = RecipeBase.apply

        recipe.title
        recipe.cook

    }

}
