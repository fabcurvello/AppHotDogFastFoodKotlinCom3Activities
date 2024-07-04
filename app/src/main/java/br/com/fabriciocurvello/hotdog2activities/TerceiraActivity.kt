package br.com.fabriciocurvello.hotdog2activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TerceiraActivity : AppCompatActivity() {

    //TA -> TerceiraActivity
    lateinit var clienteTvTA: TextView
    lateinit var novoPedidoBtTA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terceira)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        clienteTvTA = findViewById(R.id.tv_cliente_ta)
        novoPedidoBtTA = findViewById(R.id.bt_novo_pedido_ta)

        val dados = intent.extras
        val cliente = dados!!.getString("chave_cliente")

        if (cliente == "Cliente não informou nome"){
            clienteTvTA.text = ""
        } else {
            clienteTvTA.text = cliente + ","
        }

        novoPedidoBtTA.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            // Intent.FLAG_ACTIVITY_CLEAR_TOP: Se a MainActivity já estiver em execução na pilha de atividades, todas as atividades acima dela serão fechadas.
            // Intent.FLAG_ACTIVITY_NEW_TASK: Inicia a MainActivity em uma nova tarefa. Isso ajuda a garantir que a atividade seja reiniciada em seu estado padrão.
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish() // encerra esta activity
        }

    }
}