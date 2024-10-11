package extract

import org.apache.log4j.Logger
import org.apache.spark.sql.{SparkSession, DataFrame}
import parameters.Parameters

object Loader {
  def readW4sohClient()(implicit spark: SparkSession, logger: Logger, parameters: Parameters): DataFrame = {
    logger.info(s"reading ${parameters.W4_SHO_CLIENT_TABLE}")

    spark.read.table(s"${parameters.W4_SHO_CLIENT_TABLE}")
      .select(
        "id",
        "odsis_active_flg",
        "amnd_state",
        "odseffective_to_dt"
      )
      .filter(
        "odsis_active_flg === 1 && amnd_state === A"
      )
  }

  def readW4sohAcntContract()(implicit spark: SparkSession, logger: Logger, parameters: Parameters): DataFrame = {
    logger.info(s"reading ${parameters.W4_SHO_CONTRACT_TABLE}")
    import spark.implicits._

    spark.read.table(s"${parameters.W4_SHO_CONTRACT_TABLE}")
      .select(
        "id",
        "client_id",
        "add_info_03",
        "contract_number",
        "comment_text",
        "merchant_id",
        "admnd_state",
        "is_ready",
        "odsis_active_flg",
        "odseffective_to_dt",
        "acnt_contract__oid"
      )
      .filter(
        "odsis_active_flg === 1 && amnd_state === A " +
          "$$ is_ready =!= C"
      )
  }

}
