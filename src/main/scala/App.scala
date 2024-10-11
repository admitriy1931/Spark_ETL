import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object App extends App{
  implicit val logger: Logger = Logger.getLogger(getClass)
  Logger.getLogger("org").setLevel(Level.ERROR)
  Logger.getLogger("netty").setLevel(Level.ERROR)
  implicit  val spark: SparkSession = SparkSession.builder()
    .appName("Create Potential Clients")
    .master("local[1]")
    .enableHiveSupport()
    .getOrCreate()
  val df = spark.read.option("header", value = true)
    .option("nullvalue", null)
    .option("delimiter", ";")
    .option("encoding", "windows-1251")
    .csv("dataset/w4_soh_client.csv")
  df.show()


}
