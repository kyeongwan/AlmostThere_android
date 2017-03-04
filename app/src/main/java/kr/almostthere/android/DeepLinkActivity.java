package kr.almostthere.android;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by lk on 2017. 3. 4..
 */

public class DeepLinkActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            finish();
        }
        Uri uri = intent.getData();
        String param = uri.getQueryParameter("join");

        if(param != null){              // Kakao link version
            Toast.makeText(getApplicationContext(), param, Toast.LENGTH_SHORT).show();
        }else {                         // General Deep Link version
            openDeepLink(uri);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void openDeepLink(Uri deepLink) {
        String path = deepLink.getPath();
        Toast.makeText(getApplicationContext(), path, Toast.LENGTH_SHORT).show();
    }
}
