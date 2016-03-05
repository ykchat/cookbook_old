package cookbook

import java.time.{ZonedDateTime, ZoneId}

class RecipeBase private extends Recipe {

    def title() = {

        println("# Base")

    }

    def cook() = {

        // 変数展開

        val name = "Recipe"
        val hello = s"Hello ${name}!"
        println(hello)

        // 現在時刻

        var now = ZonedDateTime now (ZoneId of "UTC")
        println(now)

        now = ZonedDateTime now (ZoneId of "Asia/Tokyo")
        println(now)

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
