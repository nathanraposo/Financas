package nathan.com.financas.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by nathan on 18/04/18.
 */

fun Calendar.formataParaBrasileiro() : String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}