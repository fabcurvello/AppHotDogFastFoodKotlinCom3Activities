package br.com.fabriciocurvello.hotdog2activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Iniciando as variáveis e definindo os seus tipos:
    lateinit var proteinaRg: RadioGroup
    lateinit var catchupCb: CheckBox
    lateinit var mostardaCb: CheckBox
    lateinit var maioneseCb: CheckBox
    lateinit var alfaceSw: Switch
    lateinit var tomateSW: Switch
    lateinit var queijoRaladoSw: Switch
    lateinit var nomeEt: EditText
    lateinit var pedidoBt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //"Linkando" as variáveis às views do activity_main.xml
        nomeEt = findViewById(R.id.et_nome)
        pedidoBt = findViewById(R.id.bt_pedido)
        proteinaRg = findViewById(R.id.rg_proteina)
        catchupCb = findViewById(R.id.cb_catchup)
        mostardaCb = findViewById(R.id.cb_mostarda)
        maioneseCb = findViewById(R.id.cb_maionese)
        alfaceSw = findViewById(R.id.sw_alface)
        tomateSW = findViewById(R.id.sw_tomate)
        queijoRaladoSw = findViewById(R.id.sw_queijo_ralado)

        //Ocultar o teclado quando terminar de digitar no EditText e clicar em outro item.
        nomeEt.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                // Oculta o teclado quando o EditText perde o foco
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(nomeEt.windowToken, 0)
            }
        }

        //Listener no Botão
        pedidoBt.setOnClickListener {

            //Acionando as funções que retornam os dados inseridos pelo usuário
            val cliente = nomeCliente()
            val proteinaSelecionada = proteina()
            val molhosSelecionados = molhos()
            val acompanhamentosSelecionados = acompanhamentos()


            //Criar intent que vai iniciar a SegundaActivity
            val intent = Intent(this, SegundaActivity::class.java)

            //Passar dados pela intent
            intent.putExtra("chave_cliente", cliente)
            intent.putExtra("chave_proteina_selecionada", proteinaSelecionada)
            intent.putExtra("chave_molhos_selecionados", molhosSelecionados)
            intent.putExtra("chave_acompanhamentos_selecionados", acompanhamentosSelecionados)

            //Iniciar a intent
            startActivity(intent)

            // Toast.makeText(this, "CLICOU", Toast.LENGTH_SHORT).show()
//            Log.i("SELECOES", cliente + "\n" +
//                    proteinaSelecionada + "\n" +
//                    molhosSelecionados + "\n" +
//                    acompanhamentosSelecionados)
        }

    }//fim do onCreate()

    private fun nomeCliente(): String {
        var cliente = nomeEt.text.toString()
        if (cliente.isNullOrEmpty()) {
            cliente = "Cliente não informou nome"
        }
        return cliente
    }

    private fun proteina(): String {
        val proteinaSelecionadaId = proteinaRg.checkedRadioButtonId
        var proteinaSelecionadaStr: String = ""

        if (proteinaSelecionadaId != -1) {
            val proteinaSelecionada: RadioButton = findViewById(proteinaSelecionadaId)

            if (proteinaSelecionada.toString().contains("linguica")) {
                proteinaSelecionadaStr = "- Linguiça"
            }
            if (proteinaSelecionada.toString().contains("salsicha")) {
                proteinaSelecionadaStr = "- Salsicha"
            }
        }
        return proteinaSelecionadaStr
    }

    private fun molhos(): String {
        val molhosSelecionados = mutableListOf<String>()

        if (catchupCb.isChecked) molhosSelecionados.add("Catchup")
        if (mostardaCb.isChecked) molhosSelecionados.add("Mostarda")
        if (maioneseCb.isChecked) molhosSelecionados.add("Maionese")

        return if (molhosSelecionados.isEmpty()) "Sem molho"
        else " - ${molhosSelecionados.joinToString("\n - ")}"
    }


    private fun acompanhamentos(): String {
        val acompanhamentosSelecionados = mutableListOf<String>()

        if (alfaceSw.isChecked) acompanhamentosSelecionados.add("Alface")
        if (tomateSW.isChecked) acompanhamentosSelecionados.add("Tomate")
        if (queijoRaladoSw.isChecked) acompanhamentosSelecionados.add("Queijo Ralado")

        return if (acompanhamentosSelecionados.isEmpty()) "Sem acompanhamentos"
        else " - ${acompanhamentosSelecionados.joinToString("\n - ")}"
    }

}