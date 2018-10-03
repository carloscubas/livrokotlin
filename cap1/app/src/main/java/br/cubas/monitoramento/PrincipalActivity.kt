package br.cubas.monitoramento

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.telephony.SmsMessage
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_principal.*
import org.greenrobot.eventbus.EventBus
import java.util.logging.Logger
import org.greenrobot.eventbus.Subscribe



class PrincipalActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        EventBus.getDefault().register(this);
        configureReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
        EventBus.getDefault().unregister(this)

    }

    @Subscribe
    fun onMessageEvent(event: Boolean) {
        val changePlaneMode = event
        Toast.makeText(this, "Broadcast : Flight mode changed.", Toast.LENGTH_LONG).show()
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("br.cubas.monitoramento.ModoAviao")
        filter.addAction("android.intent.action.AIRPLANE_MODE")
        receiver = ModoAviao()
        registerReceiver(receiver, filter)
    }
}
