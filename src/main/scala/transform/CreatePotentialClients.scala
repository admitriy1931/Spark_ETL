package transform
import extract.Loader
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import parameters.Parameters
import org.apache.log4j.Logger



object CreatePotentialClients {
  def createPotentialClients()(implicit  spark: SparkSession, logger: Logger, parameters: Parameters): DataFrame = {
    import spark.implicits._
    val client = Loader.readW4sohClient()
    val acntContract = Loader.readW4sohAcntContract()

    val actualClient = client
      .join(acntContract,
        Seq("id"),"inner")
      .filter(
        col("reg_number").rlike("^\\d{10}$") || col("reg_number").rlike("^\\d{12}$")
      ).distinct()
    return actualClient
  }

}
