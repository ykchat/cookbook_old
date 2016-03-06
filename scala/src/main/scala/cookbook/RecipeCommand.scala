package cookbook

import scala.sys.process.Process
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class RecipeCommand private extends Recipe {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def title() = {

        logger debug "# Command"

    }

    def cook() = {

        val commands = List("ls")

        // コマンド実行

        for (command <- commands) {

            val proc = Process(command)
            // コマンドのpid取得
            // -> 現在pidを取得するAPIがない
            // See also http://stackoverflow.com/questions/23279898/
            logger.debug(s"${command} started")
            // コマンド実行結果（標準出力）を取得
            for (line <- proc.lineStream) {
                logger debug line
            }
            logger.debug(s"${command} ended")

        }

    }

}

object RecipeCommand {

    def apply() = {

        new RecipeCommand

    }

    def main(args: Array[String]) {

        val recipe = RecipeCommand.apply

        recipe.title
        recipe.cook

    }

}
