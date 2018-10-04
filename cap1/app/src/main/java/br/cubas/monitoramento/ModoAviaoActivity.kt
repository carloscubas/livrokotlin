package br.cubas.monitoramento

import android.content.*
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ModoAviaoActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null
    var texto: TextView? = null
    var imagem: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        texto = findViewById<TextView>(R.id.texto)
        imagem = findViewById<ImageView>(R.id.aviao)

        configureReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    val modoAviao = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if(isAirplaneModeOn(contentResolver)){
                texto?.text = "Modo avião ligado"
                imagem?.setImageResource(R.drawable.flyon)
            }else{
                texto?.text = "Modo avião desligado"
                imagem?.setImageResource(R.drawable.flyoff)
            }
        }
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("android.intent.action.AIRPLANE_MODE")
        receiver = modoAviao
        registerReceiver(receiver, filter)
    }

    private fun isAirplaneModeOn(context: ContentResolver) : Boolean {
        return Settings.System.getInt(context, Settings.Global.AIRPLANE_MODE_ON , 0) != 0
    }
}
