package com.taobao.paysecurity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.alipay.sdk.app.PayTask;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * description test$
 * created by jerry on 2020/5/7.
 */
public class test extends Activity {

    Activity activity;

    public String md5Decode32(String paramString)
    {
        try
        {
            paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
            StringBuilder localStringBuilder = new StringBuilder(paramString.length * 2);
            int j = paramString.length;
            int i = 0;
            while (i < j)
            {
                int k = paramString[i] & 0xFF;
                if (k < 16) {
                    localStringBuilder.append("0");
                }
                localStringBuilder.append(Integer.toHexString(k));
                i += 1;
            }
            return localStringBuilder.toString();
        }
        catch (UnsupportedEncodingException paramString)
        {
            throw new RuntimeException("UnsupportedEncodingException", paramString);
        }
        catch (NoSuchAlgorithmException paramString)
        {
            paramString = new RuntimeException("NoSuchAlgorithmException", paramString);
        }
        for (;;)
        {
            throw paramString;
        }
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(2131361820);
        this.activity = this;
        paramBundle = getIntent();
        paramBundle.getScheme();
        if (paramBundle.getData() != null)
        {
            Object localObject1 = paramBundle.getDataString().split("\\?")[1].split("&");
            Object localObject2 = localObject1[1].split("=");
            paramBundle = localObject1[2].split("=");
            localObject1 = localObject1[0].split("=")[1];
            String str = Uri.decode(localObject2[1]);
            localObject2 = Uri.parse(str);
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("alipay999");
            ((StringBuilder)localObject3).append(str);
            localObject3 = md5Decode32(((StringBuilder)localObject3).toString());
            if (((String)localObject1).equals("60009999"))
            {
                if (((String)localObject3).equals(paramBundle[1]))
                {
                    paramBundle = new Intent();
                    paramBundle.setData((Uri)localObject2);
                    paramBundle.setFlags(268435456);
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
            if (((String)localObject1).equals("60006789")) {
                startPddPay(str);
            }
        }
        else
        {
            System.exit(0);
        }
    }

    protected void onNewIntent(Intent paramIntent)
    {
        super.onNewIntent(paramIntent);
        setIntent(paramIntent);
    }

    protected void onResume()
    {
        super.onResume();
    }

    public void startH5Pay(final String paramString)
    {
        new Thread()
        {
            public void run()
            {
                super.run();
                new PayTask(test.this).pay(paramString, true);
            }
        }.start();
    }

    public void startPddPay(final String paramString)
    {
        new Thread()
        {
            public void run()
            {
                super.run();
                new PayTask(test.this).pay(paramString, true);
            }
        }.start();
    }
}
