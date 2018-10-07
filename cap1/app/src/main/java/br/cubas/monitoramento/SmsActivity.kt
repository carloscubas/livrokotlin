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
import android.util.Log

import kotlinx.android.synthetic.main.activity_sms.*

class SmsActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null
    val MY_PERMISSIONS_REQUEST_SMS_RECEIVE = 10
    val list = listOf<String>(
            Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        setupPermissions()
        configureReceiver()
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
            Log.i("monitorameno", "Permission to record denied")
        }
    }

}
