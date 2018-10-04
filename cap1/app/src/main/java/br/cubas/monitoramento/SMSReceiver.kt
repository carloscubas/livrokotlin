package br.cubas.monitoramento

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.media.MediaPlayer
import android.widget.Toast

const val SMS_BUNDLE = "pdus" //

class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val intentExtras = intent.extras
        val subId = intentExtras.getInt("subscription", -1)
        val sms = intentExtras.get(SMS_BUNDLE) as Array<Any>
        var smsMessage : SmsMessage? = null

        (0 until sms.size).forEach { i ->
            val format = intentExtras.getString("format")
            smsMessage = SmsMessage.createFromPdu( sms[i] as ByteArray, format )
        }

        var messageBody = smsMessage?.displayMessageBody?.toUpperCase()
        Toast.makeText(context, messageBody, Toast.LENGTH_SHORT).show()

        if(messageBody != null && messageBody?.contains("GOL")){
            val mp = MediaPlayer.create(context, R.raw.gol4)
            mp.start()
        }
    }
}
