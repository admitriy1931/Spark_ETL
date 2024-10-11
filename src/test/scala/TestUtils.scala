import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import parameters.Parameters
import structures._

object TestUtils {
  val PATH_W4_SOH_CLIENT = "dataset/w4_soh_client.csv"
  val PATH_W4_SOH_ACNT_CONTRACT = "dataset/w4_soh_acnt_contract.csv"

  var tableInited = 0

  var args: Array[String] = Array(
    "W4_SOH_CLIENT_TABLE = W4_SOH_CLIENT_TABLE",
    "W4_SOH_ACNT_CONTRACT = W4_SOH_ACNT_CONTRACT"
  )
  def createTable(tableName: String, schema: StructType, path: String, delimiter: String = ";")(implicit spark:SparkSession): Unit = {
    spark.read
      .option("header", value = true)
      .option("nullValue", null)
      .option("dilimiter", delimiter)
      .schema(schema)
      .load(path)
      .createGlobalTempView(tableName)
    tableInited+=1
  }
  def InitTable(p: Parameters)(implicit spark: SparkSession): Unit = {
    createTable(tableName = s"$p.W4_SOH_ACNT_CONTRACT_TABLE", W4SohAcnContract.structType, PATH_W4_SOH_ACNT_CONTRACT)
    createTable(tableName = s"$p.W4_SOH_CLIENT_TABLE", W4SohClient.structType, PATH_W4_SOH_CLIENT)
    println(s"$tableInited table initialized")
  }

}
