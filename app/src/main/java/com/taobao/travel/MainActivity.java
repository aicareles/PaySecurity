package com.taobao.travel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alipay.sdk.app.PayTask;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent.getData() != null)
        {
            Log.e(TAG, "onCreate: 原始数据："+intent.getDataString());
            String[] localObject1 = intent.getDataString().split("\\?")[1].split("&");//appid=60009999    url=alipays...257D    sign=58291....76e1
            String[] localObject2 = localObject1[1].split("=");// url    alipays.....257D
            String[] sss2 = localObject1[2].split("=");//sign     58291.....76e1
            String sss0 = localObject1[0].split("=")[1];//appid   60009999
            Log.e(TAG, "onCreate: sss0"+sss0);
            String str = Uri.decode(localObject2[1]);//alipays....257D
            Log.e(TAG, "onCreate: str"+str);
            Uri uri = Uri.parse(str);
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("alipay999");
            ((StringBuilder)localObject3).append(str);
            localObject3 = md5Decode32(((StringBuilder)localObject3).toString());
            Log.e(TAG, "onCreate: localObject3"+localObject3);
            Log.e(TAG, "onCreate: sss2[1]"+sss2[1]);
            if (((String)sss0).equals("60009999"))
            {
                if (((String)localObject3).equals(sss2[1]))
                {
                    Intent paramBundle = new Intent();
                    paramBundle.setData((Uri)uri);
                    paramBundle.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
                    startActivity(paramBundle);
                    finish();
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
                System.exit(0);
                return;
            }
            if (((String)sss0).equals("60006789")) {
//                String orderInfo = getOrderInfo("测试的商品", "该测试商品的详细描述", "0.01");
                final String payInfo = "" + "&sign=\"" + "055c401a699b0b809a3e5cf42e5361ed" + "\"&" + "sign_type=\"RSA\"";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new PayTask(MainActivity.this).pay(payInfo, true);
                    }
                }).start();
                Log.e(TAG, "onCreate: sss0"+"60006789");
            }
        }
        else
        {
//            System.exit(0);
        }
    }


    public String md5Decode32(String paramString)
    {
        try
        {
            byte[] data = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
            StringBuilder localStringBuilder = new StringBuilder(data.length * 2);
            int j = data.length;
            int i = 0;
            while (i < j)
            {
                int k = data[i] & 0xFF;
                if (k < 16) {
                    localStringBuilder.append("0");
                }
                localStringBuilder.append(Integer.toHexString(k));
                i += 1;
            }
            return localStringBuilder.toString();
        }
        catch (UnsupportedEncodingException ss)
        {
            throw new RuntimeException("UnsupportedEncodingException", ss);
        }
        catch (NoSuchAlgorithmException s) {
        }
        return "";
    }

        public void startH5Pay(final String paramString)
    {
        Log.e(TAG, "startH5Pay: "+paramString);
        new Thread()
        {
            public void run()
            {
                super.run();
                new PayTask(MainActivity.this).pay(paramString, true);
            }
        }.start();
    }

    public void startPddPay(final String paramString)
    {
        Log.e(TAG, "startPddPay: "+paramString);
        new Thread()
        {
            public void run()
            {
                super.run();
                new PayTask(MainActivity.this).pay(paramString, true);
            }
        }.start();
    }
}
