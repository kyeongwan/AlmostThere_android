package kr.almostthere.android;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lk on 2017. 3. 4..
 */

public class SendLocationService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class LocationListener implements android.location.LocationListener {
        public LocationListener(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {
            try {
//                sendDataToMain(location.getLatitude(), location.getLongitude(), location.getAltitude());
                Application.mLocation = new LatLng(location.getLatitude(), location.getLongitude());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
}
