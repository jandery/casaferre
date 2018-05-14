package se.casaferre.geolocation;

/**
 * Purpose of this file is ...
 * <p>
 * Created by Jorgen Andersson on 2018-05-04.
 */
public class Example {

    private static final Geolocation mOffice = new Geolocation(55.6044973,13.005021);
    private static final Geolocation mBjornstorp = new Geolocation(55.656372399999995,13.369866799999999);
    private static final Geolocation mNewYork = new Geolocation(40.7493302,-73.9898485);
    private static final Geolocation mSydney = new Geolocation(-33.8632658,151.2285838);

    // Up north
    // new Geolocation(80.0,-60.0), new Geolocation(90.0,-60.0)
    // new Geolocation(80.0,-60.0), new Geolocation(80.0,-70.0)
    // Eq
    // new Geolocation(10.0,10.0), new Geolocation(20.0,10.0)
    // new Geolocation(10.0,10.0), new Geolocation(10.0,20.0)


    public static void main(String[] args) {


        System.out.println("Office to Bjornstorp: ");
        System.out.println(distanceWithEarth(mOffice, mBjornstorp));
        System.out.println(distanceFlat(mOffice, mBjornstorp));
        System.out.println("Office to NY");
        System.out.println(distanceWithEarth(mOffice, mNewYork));
        System.out.println(distanceFlat(mOffice, mNewYork));
        System.out.println("Office to Sydney");
        System.out.println(distanceWithEarth(mOffice, mSydney));
        System.out.println(distanceFlat(mOffice, mSydney));
        System.out.println("NY to Sydney");
        System.out.println(distanceWithEarth(mNewYork, mSydney));
        System.out.println(distanceFlat(mNewYork, mSydney));



        System.out.println("Up North 10 deg Lat change");
        System.out.println(distanceWithEarth(new Geolocation(80.0,60.0), new Geolocation(90.0,60.0)));
        System.out.println(distanceFlat(new Geolocation(80.0,60.0), new Geolocation(90.0,60.0)));
        System.out.println("Up North 10 deg Long change");
        System.out.println(distanceWithEarth(new Geolocation(80.0,60.0), new Geolocation(80.0,70.0)));
        System.out.println(distanceFlat(new Geolocation(80.0,60.0), new Geolocation(80.0,70.0)));
        //
        System.out.println("Equator 10 deg Lat change");
        System.out.println(distanceWithEarth(new Geolocation(10.0,60.0), new Geolocation(20.0,60.0)));
        System.out.println(distanceFlat(new Geolocation(10.0,60.0), new Geolocation(20.0,60.0)));
        System.out.println("Equator 10 deg Long change");
        System.out.println(distanceWithEarth(new Geolocation(10.0,60.0), new Geolocation(10.0,70.0)));
        System.out.println(distanceFlat(new Geolocation(10.0,60.0), new Geolocation(10.0,70.0)));

    }


    private static double distanceWithEarth(Geolocation geolocation1, Geolocation geolocation2) {

        double earthRadius = 6370.693485653068; // 6371.0
        // Equator radius: 6 378 km
        // Polar radius: 6 356 km

        double dLat = Math.toRadians(geolocation2.getLatitude()-geolocation1.getLatitude());
        double dLng = Math.toRadians(geolocation2.getLongitude()-geolocation1.getLongitude());

        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);

        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(geolocation1.getLatitude())) * Math.cos(Math.toRadians(geolocation2.getLatitude()));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return earthRadius * c;

    }


    private static double distanceFlat(Geolocation geolocation1, Geolocation geolocation2) {
        double theta = geolocation1.getLongitude() - geolocation2.getLongitude();
        double dist =
                Math.sin(deg2rad(geolocation1.getLatitude())) *
                        Math.sin(deg2rad(geolocation2.getLatitude())) +
                        Math.cos(deg2rad(geolocation1.getLatitude())) *
                                Math.cos(deg2rad(geolocation2.getLatitude())) *
                                Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return dist * 1.609344;
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::	This function converts decimal degrees to radians			:*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::	This function converts radians to decimal degrees			:*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
