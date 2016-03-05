package cookbook

class RecipeLoop private extends Recipe {

    def title() = {

        println("# Loop")

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
        println(results)

        // 内包表記

        results = for (num <- nums) yield pow(num)
        println(results)

        // map関数

        results = nums.map(num => pow(num))
        println(results)

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
