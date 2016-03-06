package cookbook

import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class RecipeThread private extends Recipe {

    val logger = Logger(LoggerFactory getLogger this.getClass)

    def title() = {

        logger debug "# Thread"

    }

    def cook() = {

        val secs = List(1.0, 2.0, 3.0)

        var threads = List[Future[Unit]]()

        // スレッド開始

        for (sec <- secs) {
            threads = threads :+ Future { __sleep(sec) }
        }

        // スレッド終了待ち

        for (thread <- threads) {
            Await.ready(thread, Duration.Inf)
        }

        logger debug "all ended"

    }

    def __sleep(sec: Double) = {

        logger debug s"sleep(${sec}) started"
        Thread sleep (sec * 1000).toLong
        logger debug s"sleep(${sec}) ended"

    }

}

object RecipeThread {

    def apply() = {

        new RecipeThread

    }

    def main(args: Array[String]) {

        val recipe = RecipeThread.apply

        recipe.title
        recipe.cook

    }

}
