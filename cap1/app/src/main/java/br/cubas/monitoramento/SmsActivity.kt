package br.cubas.monitoramento

import android.Manifest
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.telephony.SmsMessage
import android.util.Log
import android.util.Log.WARN

import kotlinx.android.synthetic.main.activity_sms.*
import java.util.logging.Logger

class SmsActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null
    val MY_PERMISSIONS_REQUEST_SMS_RECEIVE = 10
    val list = listOf<String>(
            Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        setupPermissions()
        configureReceiver()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_SMS_RECEIVE) {
            Logger.getLogger("monitoramento").info("Permission RECEIVE SMS")
        }
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("android.provider.Telephony.SMS_RECEIVED")
        receiver = SMSReceiver()
        registerReceiver(receiver, filter)
    }

    private fun setupPermissions() {

        ActivityCompat.requestPermissions(this,
                list.toTypedArray(), MY_PERMISSIONS_REQUEST_SMS_RECEIVE);
        val permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS)
        if (permission != PackageManager.GET_SERVICES) {
            Log.i("monitorameno", "Permissão não liberada")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

}
