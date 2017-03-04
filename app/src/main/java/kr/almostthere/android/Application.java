package kr.almostthere.android;

import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lk on 2017. 3. 4..
 */

public class Application extends android.app.Application {


    public static LatLng mLocation;

    public void onCreate() {
        if(mLocation == null){
            mLocation = new LatLng(37.5653203,126.9745829);
        }
    }
}
