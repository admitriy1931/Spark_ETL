package structures

import org.apache.spark.sql.types.{StringType, StructField, StructType}

object W4SohClient extends Enumeration {
  val id, act_contract__oid, account_type, account_number, odsis_active_flg, odseffective_to_dt = Value
  val structType: StructType = StructType(
    Seq(
      StructField(id.toString, StringType),
      StructField(act_contract__oid.toString, StringType),
      StructField(account_type.toString, StringType),
      StructField(account_number.toString, StringType),
      StructField(odsis_active_flg.toString, StringType),
      StructField(odseffective_to_dt.toString, StringType)

    )
  )
}
