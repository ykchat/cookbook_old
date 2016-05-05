package cookbook

import java.nio.file.{Paths, Path, Files}
import scala.io.Source
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class RecipeFile private extends Recipe {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def title() = {

        logger debug "# File"

    }

    def cook() = {

        val path = Paths get "src/main/scala/Cooker.scala"

        // 基本情報

        logger debug s"dir=${path.getParent.toAbsolutePath}"
        logger debug s"file=${path.getFileName}"
        logger debug s"size=${Files size path}"

        // 行数カウント

        var src = Source fromFile path.toFile
        try {
            logger debug s"lc=${src.getLines.size}"
        } finally {
            src.close
        }

        src = Source fromFile path.toFile
        try {
            var counter = 0
            for(line <- src.getLines) {
                counter += 1
            }
            logger debug s"lc=${counter}"
        } finally {
            src.close
        }

    }

}

object RecipeFile {

    def apply() = {

        new RecipeFile

    }

    def main(args: Array[String]) {

        val recipe = RecipeFile.apply

        recipe.title
        recipe.cook

    }

}
