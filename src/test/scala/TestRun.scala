import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object TestRun extends App {
  implicit val logger: Logger = Logger.getLogger(getClass)
  Logger.getLogger("org").setLevel(Level.ERROR)
  Logger.getLogger("netty").setLevel(Level.ERROR)
  implicit val spark: SparkSession = SparkSession
    .builder()
    .appName("CreatePotentialClients")
    .master("local[1]")
    .enableHiveSupport()
    .getOrCreate()
  spark.stop()


}
