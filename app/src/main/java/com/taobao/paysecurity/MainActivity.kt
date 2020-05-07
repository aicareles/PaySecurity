package com.taobao.paysecurity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alipay.sdk.app.PayTask
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val URL_FORMAT =
    "intent://platformapi/startapp?saId=10000007&" +
    "clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F{urlCode}%3F_s" +
    "%3Dweb-other&_t=1472443966571#Intent;" + "scheme=alipayqr;package=com.eg.android.AlipayGphone;end"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        intent.scheme
//        if (intent?.data != null){
//
//        }

//        val intentFullUrl = "intent://platformapi/startapp?saId=10000007&" +
//        "clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F｛URLcode｝%3F_s" +  //这里把｛URLcode｝替换成第一步扫描的结果
//                "%3Dweb-other&_t=1472443966571#Intent;" +
//                "scheme=alipayqr;package=com.eg.android.AlipayGphone;end"


//        val intentFullUrl = "alipays://platformapi/startapp?appId=20000123%26actionType%3Dscan%26biz_data%3D%7B%22s%22%3A%22money%22%2C%22u%22%3A%222088831036590735%22%2C%22a%22%3A%221%22%2C%22m%22%3A%22TS202005071557102032461388%22%7D"


        val intentFullUrl = "alipays://platformapi/startapp?appId=20000123%26actionType%3Dscan%26biz_data%3D%7B%22s%22%3A%22money%22%2C%22u%22%3A%222088831036590735%22%2C%22a%22%3A%221%22%2C%22m%22%3A%22TS202005071557102032461388%22%7D"
//        var intentFullUrl = URL_FORMAT.replace("{urlCode}","fkx15812bqxbpigmhxvwv6f")
//        var intentFullUrl = "alipays://platformapi/startapp?appId=20000123&url="

        try {
//            val intent = Intent.parseUri(intentFullUrl, Intent.URI_INTENT_SCHEME)//
            val intent = Intent()
            intent.setData(Uri.parse(intentFullUrl))
            intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    fun startH5Pay(paramString:String){
        thread {
            PayTask(this).pay(paramString, true)
        }
    }

    fun startPddPay(paramString:String){
        thread {
            PayTask(this).pay(paramString, true)
        }
    }
}
