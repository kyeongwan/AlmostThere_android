package kr.almostthere.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by lk on 2017. 3. 4..
 */

public class MakePlanActivity extends AppCompatActivity {

    final int MAP_ACTIVITY_REQUEST_CODE = 100;

    MakePlanActivity mActivity;
    private ImageButton mIbProfilePhoto;
    private EditText mEtUerName;
    private Button mBtDestination;
    private Button mBtDatePicker;
    private Button mBtCar;
    private Button mBtBus;
    private Button mBtWalk;
    private Button mBtBicycle;
    private Button mBtShare;

    @Override
    public void onCreate(Bundle savedBundle) {
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_register);

        init();
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


        mBtDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtBicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mBtShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ShareDialog dialog = new ShareDialog(mActivity);

                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dia) {
                    }
                });
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dia) {
                    }
                });
                dialog.show();
            }
        });
    }

    private void init() {
        mActivity = this;
        mBtDestination = (Button) findViewById(R.id.bt_register_destination);
        mBtDatePicker = (Button) findViewById(R.id.bt_register_datepicker);
        mBtCar = (Button) findViewById(R.id.bt_register_car);
        mBtBus = (Button) findViewById(R.id.bt_register_bus);
        mBtWalk = (Button) findViewById(R.id.bt_register_walk);
        mBtBicycle = (Button) findViewById(R.id.bt_register_bicycle);
        mBtShare = (Button) findViewById(R.id.bt_register_done);

    }

    @Override
    protected void onActivityResult(int rqCode, int resultCode, Intent data) {
        if (rqCode == MAP_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                double lat = data.getDoubleExtra("lat", -1);
                double lng = data.getDoubleExtra("lng", -1);
                Toast.makeText(getApplicationContext(), lat + " / " + lng, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
