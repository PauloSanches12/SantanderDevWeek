package com.paulo.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.paulo.santanderdevweek.R
import com.paulo.santanderdevweek.data.Conta
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta){
        val nomeCliente: String = conta.cliente.nome
        val agConta: String = conta.agencia
        val ccConta: String = conta.numero

        tv_agencia.text = "Ag $agConta"
        tv_conta.text = "CC $ccConta"
        tv_usuario.text = "Olá, $nomeCliente"

        tv_saldo.text = conta.saldo
        valor_limite.text = conta.limite
        tv_cartao_final_valor.text = conta.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("Click", "Click no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}