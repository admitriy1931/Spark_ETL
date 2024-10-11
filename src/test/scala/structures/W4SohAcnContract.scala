package structures

import org.apache.spark.sql.types.{StringType, StructField, StructType}

object W4SohAcnContract extends Enumeration {
  val id, client__id, add_info_03, contract_number, comment_text, merchant_id, amn_state, is_ready, adsis_active_flg, adseffective_to_dt, acnt_contract__oid = Value
  val structType: StructType = StructType(
    Seq(
      StructField(id.toString, StringType),
      StructField(client__id.toString, StringType),
      StructField(contract_number.toString, StringType),
      StructField(comment_text.toString, StringType),
      StructField(client__id.toString, StringType),
      StructField(merchant_id.toString, StringType),
      StructField(amn_state.toString, StringType),
      StructField(is_ready.toString, StringType),
      StructField(adsis_active_flg.toString, StringType),
      StructField(adseffective_to_dt.toString, StringType),
      StructField(acnt_contract__oid.toString, StringType)
    )
  )

}
