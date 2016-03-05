import scala.reflect.runtime.universe._

object Cooker {

    def cook(recipes: List[String]) = {

        for (recipe <- recipes) {

            val recipeMod = __loadModule(recipe)
            val recipeObj = __invokeMethod(recipeMod, "apply")

            println("")
            __invokeMethod(recipeObj, "title")
            __invokeMethod(recipeObj, "cook")

        }

    }

    def __loadModule(name: String): Any = {

        // クラスローダのミラー
        val clsLdrMir = scala.reflect.runtime.currentMirror

        // モジュールのシンボル
        val modSym = clsLdrMir staticModule name
        // モジュールのミラー
        val modMir = clsLdrMir reflectModule modSym

        // モジュールのインスタンス化
        modMir.instance

    }

    def __invokeMethod(obj: Any, name: String, args: Any*) = {

        // クラスローダのミラー
        val clsLdrMir = scala.reflect.runtime.currentMirror

        // インスタンスのミラー
        val objMir = clsLdrMir reflect obj
        // インスタンスのシンボル
        val objSym = objMir.symbol
        // インスタンスのタイプ
        val objTyp = objSym.typeSignature

        // メソッドのシンボル
        val methodSym = objTyp member TermName(name)
        // メソッドのミラー
        val methodMir = objMir reflectMethod methodSym.asMethod

        // メソッドの実行
        methodMir(args)

    }


    def main(args: Array[String]) {

        val recipes = List(
            "cookbook.RecipeBase",
            "cookbook.RecipeLoop"
        )

        Cooker cook recipes

    }

}
