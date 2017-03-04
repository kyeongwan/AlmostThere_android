package kr.almostthere.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    Context mContext;

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_splash);
        mContext = this;

        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            startMainActivity();
        }else{
            getDeepLinkData();
        }

    }

    private void getDeepLinkData() {
        Intent intent = getIntent();
        Uri uri = intent.getData();
        String param = uri.getQueryParameter("join");

        if(param != null){              // Kakao link version
            Toast.makeText(getApplicationContext(), param, Toast.LENGTH_SHORT).show();
        }else {                         // General Deep Link version
//            openDeepLink(uri);
        }
    }

    private void startMainActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, MainActivity.class));
            }
        }, 2000);
    }
}
