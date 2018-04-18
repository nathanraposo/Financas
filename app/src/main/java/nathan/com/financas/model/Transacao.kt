package nathan.com.financas.model

import java.math.BigDecimal
import java.util.*

class Transacao(valor: BigDecimal,
                categoria: String,
                data: Calendar) {

    val valor: BigDecimal = valor
    val categoria: String = categoria
    val data: Calendar = data
}