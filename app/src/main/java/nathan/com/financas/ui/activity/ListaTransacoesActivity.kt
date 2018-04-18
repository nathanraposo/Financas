package nathan.com.financas.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import nathan.com.financas.R
import nathan.com.financas.model.Transacao
import nathan.com.financas.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal
import java.util.*


class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(valor = BigDecimal(20.50),
                categoria = "Comida",data = Calendar.getInstance()),
                Transacao(valor = BigDecimal(100.0),
                categoria = "Economia",data = Calendar.getInstance()))


        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }
}