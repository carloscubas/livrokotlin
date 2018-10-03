package br.cubas.monitoramento

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.telephony.SmsMessage

import kotlinx.android.synthetic.main.activity_principal.*
import java.util.logging.Logger

class PrincipalActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        configureReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("br.cubas.monitoramento.ModoAviao")
        filter.addAction("android.intent.action.AIRPLANE_MODE")
        receiver = ModoAviao()
        registerReceiver(receiver, filter)
    }
}
