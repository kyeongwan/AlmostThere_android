package kr.almostthere.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by lk on 2017. 3. 4..
 */

public class MakePlanActivity extends AppCompatActivity{

    final int MAP_ACTIVITY_REQUEST_CODE = 100;

    private Button mBtDestination;
    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_register);

        initView();
        setEventListener();
    }

    private void setEventListener() {
        mBtDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), MapsActivity.class);
                startActivityForResult(i, MAP_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    private void initView() {
        mBtDestination = (Button) findViewById(R.id.bt_register_destination);
    }

    @Override
    protected void onActivityResult(int rqCode, int resultCode, Intent data) {
        if (rqCode == MAP_ACTIVITY_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                long lat = data.getIntExtra("lat", -1);
                long lng = data.getIntExtra("lat", -1);
                Toast.makeText(getApplicationContext(), lat + " / " + lng, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
