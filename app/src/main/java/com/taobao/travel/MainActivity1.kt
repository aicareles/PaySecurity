package com.taobao.travel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alipay.sdk.app.PayTask
import kotlin.concurrent.thread

class MainActivity1 : AppCompatActivity() {

    private val URL_FORMAT =
    "intent://platformapi/startapp?saId=10000007&" +
    "clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F{urlCode}%3F_s" +
//    "clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F{urlCode}%3F_s" +
    "%3Dweb-other&_t=1472443966571#Intent;" + "scheme=alipayqr;package=com.eg.android.AlipayGphone;end"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val str = Uri.decode("alipays%3A%2F%2Fplatformapi%2Fstartapp%3FsaId%3D10000007%26qrcode%3Dalipays%253A%252F%252Fplatformapi%252Fstartapp%253FappId%253D20000123%2526actionType%253Dscan%2526biz_data%253D%257B%2522a%2522%253A%2522299%2522%252C%2522s%2522%253A%2522money%2522%252C%2522u%2522%253A%25222088732283255906%2522%252C%2522m%2522%253A%2522G%25E4%25BA%25B2%25EF%25BC%258C%25E4%25BB%25A3%25E6%2594%25B6741909%2522%257D")
//        val str = Uri.decode("alipays%3A%2F%2Fplatformapi%2Fstartapp%3FsaId%3D10000007%26qrcode%3Dalipays%253A%252F%252Fplatformapi%252Fstartapp%253FappId%253D20000123%2526actionType%253Dscan%2526biz_data%253D%257B%2522a%2522%253A%2522299%2522%252C%2522s%2522%253A%2522money%2522%252C%2522u%2522%253A%25222088732283255906%2522%252C%2522m%2522%253A%2522G%25E4%25BA%25B2%25EF%25BC%258C%25E4%25BB%25A3%25E6%2594%25B6741909%2522%257D")
//        val parse = Uri.parse(str)
//        Log.e("MainActivity", "解密之后的值：>>>>>>"+parse)
        val dataString = intent.dataString
//        var localObject1 = dataString?.split("\\?")?.get(1)?.split("&")
//        var localObject2 = localObject1!![1].split("=")
//        localObject1 = localObject1[0].split("=")[1]
//        val str = Uri.decode(localObject2[1])
//        var uri = Uri.parse(str)

        Log.e("MainActivity", "onCreate: 获取到h5参数值：>>>>>>"+dataString)


//        intent.scheme
//        if (intent?.data != null){
//
//        }

//        val intentFullUrl = "intent://platformapi/startapp?saId=10000007&" +
//        "clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F｛URLcode｝%3F_s" +  //这里把｛URLcode｝替换成第一步扫描的结果
//                "%3Dweb-other&_t=1472443966571#Intent;" +
//                "scheme=alipayqr;package=com.eg.android.AlipayGphone;end"


//        val intentFullUrl = "alipays://platformapi/startapp?appId=20000123%26actionType%3Dscan%26biz_data%3D%7B%22s%22%3A%22money%22%2C%22u%22%3A%222088831036590735%22%2C%22a%22%3A%221%22%2C%22m%22%3A%22TS202005071557102032461388%22%7D"


//        val intentFullUrl = "alipays://platformapi/startapp?appId=20000123%26actionType%3Dscan%26biz_data%3D%7B%22s%22%3A%22money%22%2C%22u%22%3A%222088831036590735%22%2C%22a%22%3A%221%22%2C%22m%22%3A%22TS202005071557102032461388%22%7D"
//        var intentFullUrl = URL_FORMAT.replace("{urlCode}","fkx15812bqxbpigmhxvwv6f")
        //最终版
//        var intentFullUrl = "alipays://platformapi/startapp?saId=10000007&qrcode=alipays%3A%2F%2Fplatformapi%2Fstartapp%3FappId%3D20000123%26actionType%3Dscan%26biz_data%3D%7B%22s%22%3A%22money%22%2C%22u%22%3A%222088022784167043%22%2C%22a%22%3A%221%22%2C%22m%22%3A%22TS202005072039552006438395%22%7D"
//        var intentFullUrl = "alipays://platformapi/startapp?saId=10000007&qrcode=alipays%3A%2F%2Fplatformapi%2Fstartapp%3FappId%3D20000123%26actionType%3Dscan%26biz_data%3D%7B%22s%22%3A%22money%22%2C%22u%22%3A%222088832164798097%22%2C%22a%22%3A%221%22%2C%22m%22%3A%22TS202005072204488592934661%22%7D"
//        var intentFullUrl = "alipays://platformapi/startapp?saId=10000007&qrcode=alipays%3A%2F%2Fplatformapi%2Fstartapp%3FappId%3D20000123%26actionType%3Dscan%26biz_data%3D%7B%22a%22%3A%22299%22%2C%22s%22%3A%22money%22%2C%22u%22%3A%222088732283255906%22%2C%22m%22%3A%22G%E4%BA%B2%EF%BC%8C%E4%BB%A3%E6%94%B6741909%22%7D"

//        var intentFullUrl = "alipays://platformapi/startapp?appId=20000123&actionType=scan&biz_data={\"s\": \"money\",\"u\": \"2088002357544150\",\"a\": \"1.00\",\"m\":\"备注\"}  "
        var intentFullUrl = "alipays://platformapi/startapp?appId=09999988&actionType=toAccount&goBack=NO&amount=1.00&userId=2088832887888316&memo=备注"

        try {
            val intent = Intent.parseUri(intentFullUrl, Intent.URI_INTENT_SCHEME)//
//            val intent = Intent()
//            intent.setData(Uri.parse(intentFullUrl))
//            intent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND)
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


//    fun md5Decode32(paramString: String): String? {
//        var paramString = paramString
//        try {
//            paramString = MessageDigest.getInstance("MD5")
//                .digest(paramString.toByteArray(charset("UTF-8")))
//            val localStringBuilder =
//                StringBuilder(paramString.length * 2)
//            val j = paramString.length
//            var i = 0
//            while (i < j) {
//                val k: Int = paramString.get(i) and 0xFF
//                if (k < 16) {
//                    localStringBuilder.append("0")
//                }
//                localStringBuilder.append(Integer.toHexString(k))
//                i += 1
//            }
//            return localStringBuilder.toString()
//        } catch (paramString: UnsupportedEncodingException) {
//            throw RuntimeException("UnsupportedEncodingException", paramString)
//        } catch (paramString: NoSuchAlgorithmException) {
////            paramString = RuntimeException("NoSuchAlgorithmException", paramString)
//        }
//        while (true) {
//            throw paramString
//        }
//    }
}
