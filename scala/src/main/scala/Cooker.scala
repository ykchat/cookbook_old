import scala.reflect.runtime.universe.TermName
import java.lang.management.ManagementFactory
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object Cooker {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def cook(recipes: List[String]) = {

        for (recipe <- recipes) {

            val recipeMod = __loadModule(recipe)
            val recipeObj = __invokeMethod(recipeMod, "apply")

            logger debug ""
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

        System.setProperty("pid", ManagementFactory.getRuntimeMXBean.getName.split('@').head)

        val recipes = List(
            "cookbook.RecipeBase",
            "cookbook.RecipeLoop",
            "cookbook.RecipeCommand",
            "cookbook.RecipeThread"
        )

        Cooker cook recipes

    }

}
