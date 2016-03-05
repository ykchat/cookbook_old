package cookbook

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class RecipeLoop private extends Recipe {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def title() = {

        logger debug "# Loop"

    }

    def cook() = {

        val nums = (0 until 5).toList
        def pow(x: Int) = {
            x * x
        }

        // for文

        var results = List[Int]()
        for (num <- nums) {
            results = results :+ pow(num)
        }
        logger debug results.toString

        // 内包表記

        results = for (num <- nums) yield pow(num)
        logger debug results.toString

        // map関数

        results = nums.map(num => pow(num))
        logger debug results.toString

    }

}

object RecipeLoop {

    def apply() = {

        new RecipeLoop

    }

    def main(args: Array[String]) {

        val recipe = RecipeLoop.apply

        recipe.title
        recipe.cook

    }

}
