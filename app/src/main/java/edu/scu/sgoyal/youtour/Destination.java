package edu.scu.sgoyal.youtour;

import android.os.Parcel;
import android.os.Parcelable;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.Region;
import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by raggupta on 2016-05-23.
 */
public class Destination implements Parcelable{

    private static ArrayList<Destination> destinations;
    private String name;
    private String youtube_url;
    private String description;
    private String image;
    private LatLng latLng;
    private double lat;
    private double lng;
    private Beacon beacon;
    private Region region;

    public Destination(String name, String youtube_url, String description, String image, double lat, double lng) {
        this.name = name;
        this.youtube_url = youtube_url;
        this.description = description;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
        this.latLng = new LatLng(lat, lng);
    }

    public Destination(String name, String youtube_url, String description, String image, double lat, double lng, Region region) {
        this.name = name;
        this.youtube_url = youtube_url;
        this.description = description;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
        this.latLng = new LatLng(lat, lng);
        this.region = region;
    }

    public Destination(String name, String youtube_url, String description, String image, double lat, double lng, Beacon beacon, Region region) {
        this.name = name;
        this.youtube_url = youtube_url;
        this.description = description;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
        this.latLng = new LatLng(lat, lng);
        this.beacon = beacon;
        this.region = region;

    }

    protected Destination(Parcel in)
    {
        name = in.readString();
        youtube_url = in.readString();
        description = in.readString();
        image = in.readString();
        latLng = in.readParcelable(LatLng.class.getClassLoader());
        lat = in.readDouble();
        lng = in.readDouble();
        beacon = in.readParcelable(Beacon.class.getClassLoader());
        region = in.readParcelable(Region.class.getClassLoader());
    }

    public static final Creator<Destination> CREATOR = new Creator<Destination>()
    {
        @Override
        public Destination createFromParcel(Parcel in)
        {
            return new Destination(in);
        }

        @Override
        public Destination[] newArray(int size)
        {
            return new Destination[size];
        }
    };

    public static ArrayList<Destination> getDestinations() {
        if (destinations == null) {
//            destinations = new ArrayList<Destination>();

            //TODO configure destinations by querying database

            destinations = Utility.configureDestination();


        }
        return destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getYoutube_url() {
        return youtube_url;
    }

    public void setYoutube_url(String youtube_url) {
        this.youtube_url = youtube_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeString(youtube_url);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeParcelable(latLng, flags);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeParcelable(beacon, flags);
        dest.writeParcelable(region, flags);
    }

    public static Destination getDestinationBasedOnName(String s) {
        for (Destination d : Destination.getDestinations()) {
            if(d.getName().equals(s)){
                return  d;
            }
        }
        return null;
    }
    public static Destination getDestinationBasedOnRegion(Region region) {
        for (Destination d :
                Destination.getDestinations()) {
            if(region == d.getRegion()){
                return d;
            }
        }
        return null;
    }

    public static Region getRegionBasedOnDestination(String s) {
        for (Destination d : Destination.getDestinations()) {
            if(d.getName().equals(s)){
                return  d.getRegion();
            }
        }
        return null;
    }
}
