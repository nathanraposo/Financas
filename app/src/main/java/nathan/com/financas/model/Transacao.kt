package nathan.com.financas.model

import java.math.BigDecimal
import java.util.*

class Transacao(val valor: BigDecimal,
                val categoria: String = "Indefinida",
                val tipoTransacao: TipoTransacao,
                val data: Calendar = Calendar.getInstance())