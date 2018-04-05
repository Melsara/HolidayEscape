package eu.escapeadvisor.holidayescape;

import android.graphics.drawable.Drawable;
import java.net.URL;

public class POI {

    private String mName;
    private URL mUrl;
    private String mEmail;
    private String mTel;
    private double mLat;
    private double mLng;
    private int mImage;
    private String mDescription;
    private String mAddress;
    private String mCategory;

    /**
     * Constructor for Points Of Interest
     * @param category
     * @param name
     * @param url
     * @param email
     * @param tel
     * @param lat
     * @param lng
     * @param image
     * @param description
     * @param address
     */

    public POI (String category, String name, URL url, String email, String tel, double lat, double lng, int image, String description, String address) {
        mCategory = category;
        mName = name;
        mUrl = url;
        mEmail = email;
        mTel = tel;
        mLat = lat;
        mLng = lng;
        mImage = image;
        mDescription = description;
        mAddress = address;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getName() {
        return mName;
    }

    public URL getUrl() {
        return mUrl;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getTel() {
        return mTel;
    }

    public double getLat() {
        return mLat;
    }

    public double getLng() {
        return mLng;
    }

    public int getImage() {
        return mImage;
    }

    public String getDescription (){
        return mDescription;
    }

    public String getAddress (){
        return mAddress;
    }
}
