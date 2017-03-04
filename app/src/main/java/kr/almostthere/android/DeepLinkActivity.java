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

        openDeepLink(intent.getData());
    }

    private void openDeepLink(Uri deepLink) {
        String path = deepLink.getPath();

        Toast.makeText(getApplicationContext(), path, Toast.LENGTH_SHORT).show();
//
//        if (MYCOLOR_DEEP_LINK.equals(path)) {
//            // Launch preferences
//            startActivity(new Intent(this, GetRGBInPhoto.class));
//        } else if (GOODCOLOR_DEEP_LINK.equals(path)) {
//            // Launch the inbox activity
//            startActivity(new Intent(this, GoodColor.class));
//        } else {
//            // Fall back to the main activity
//            startActivity(new Intent(this, MainActivity.class));
//        }
    }
}
