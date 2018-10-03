package br.cubas.monitoramento

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import org.greenrobot.eventbus.EventBus

// https://stackoverflow.com/questions/47433467/how-to-send-the-value-from-broadcast-receiver-to-already-started-activity
// https://stackoverflow.com/questions/22869928/android-broadcastreceiver-onreceive-update-textview-in-mainactivity
// https://stackoverflow.com/questions/36743968/kotlin-can-we-use-subscribe-of-eventbus-greenrobot-in-kotlin
// https://github.com/square/otto

class ModoAviao : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        EventBus.getDefault().post(true);
    }
}