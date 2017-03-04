package kr.almostthere.android;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private final int LOCATION_REQUEST_CODE = 1;
    private final long FINISH_INTERVAL_TIME = 2000;
    private LatLng mLatLngDestination;
    private Marker mMarkerDestination;
    private long   markerClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mLatLngDestination = new LatLng(Application.mLocation.latitude, Application.mLocation.longitude);
        Toast.makeText(getApplicationContext(), "지도를 클릭하면 위치를 지정할 수 있습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        mMarkerDestination = map.addMarker(new MarkerOptions().position(mLatLngDestination));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLngDestination, 15));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_REQUEST_CODE);
            }
        }

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMarkerDestination.setPosition(latLng);
            }
        });

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                long currentMillis = System.currentTimeMillis();
                long intervalTime = currentMillis - markerClickTime;

                if(intervalTime <= FINISH_INTERVAL_TIME && intervalTime >= 0){
                    Intent intent = new Intent();
                    intent.putExtra("lat", mLatLngDestination.latitude);
                    intent.putExtra("lng", mLatLngDestination.longitude);
                    setResult(RESULT_OK, intent);
                    finish();
                    return false;
                }else {

                    Toast.makeText(getApplicationContext(), "마커를 한번 더 누르시면 위치가 지정됩니다.", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
    }
}