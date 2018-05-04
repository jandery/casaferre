package se.casaferre.geolocation;

import lombok.Getter;

/**
 * Purpose of this file is ...
 * <p>
 * Created by Jorgen Andersson on 2018-05-04.
 */
public class Geolocation {

    private double mLatitude;

    private double mLongitude;

    public Geolocation(double latitude, double longitude) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }

    public double getLongitude() {
        return  mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }
}
