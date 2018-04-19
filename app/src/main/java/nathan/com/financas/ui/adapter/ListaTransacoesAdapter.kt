package nathan.com.financas.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.transacao_item.view.*
import nathan.com.financas.R
import nathan.com.financas.extension.formataParaBrasileiro
import nathan.com.financas.extension.limitaEmAte
import nathan.com.financas.model.TipoTransacao
import nathan.com.financas.model.Transacao

class ListaTransacoesAdapter(private val transacoes: List<Transacao>,
                             private val context: Context) : BaseAdapter() {

    private val limiteDaCategoria = 14

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        addValor(transacao, viewCriada)
        addIcone(transacao, viewCriada)
        addCategoria(viewCriada, transacao)
        addData(viewCriada, transacao)

        return viewCriada
    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }

    private fun addData(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()
    }

    private fun addCategoria(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_categoria.text = transacao.categoria.limitaEmAte(limiteDaCategoria)
    }

    private fun addValor(transacao: Transacao, viewCriada: View) {
        val cor: Int = corPor(transacao.tipoTransacao)
        viewCriada.transacao_valor.setTextColor(cor)
        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()
    }

    private fun corPor(tipoTransacao: TipoTransacao): Int {
        if (tipoTransacao == TipoTransacao.RECEITA) {
            return ContextCompat.getColor(context, R.color.receita)
        }
        return ContextCompat.getColor(context, R.color.despesa)
    }

    private fun addIcone(transacao: Transacao, viewCriada: View) {
        val icone = iconePor(transacao.tipoTransacao)
        viewCriada.transacao_icone.setBackgroundResource(icone)
    }

    private fun iconePor(tipoTransacao: TipoTransacao): Int {
        if (tipoTransacao == TipoTransacao.RECEITA) {
            return R.drawable.icone_transacao_item_receita
        }
        return R.drawable.icone_transacao_item_despesa
    }
}