package co.imado;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

/**
 * ユーザー。
 *
 * 招集をかけたユーザーもかけられたユーザーも同じ扱い、とりあえず。
 */
@Model
public class User {
    @Attribute(primaryKey = true)
    private Key key;

    private String userId;
    private double lat;
    private double lon;

    // 多対一のおきまり？
    private ModelRef<Group> groupRef = new ModelRef<Group>(Group.class);

    public User() {
    }

    public User(String userId, double lat, double lon) {
        this.userId = userId;
        this.lat = lat;
        this.lon = lon;
    }



    /*
     * setter/getter
     */
    public void setKey(Key key) {
        this.key = key;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Key getKey() {
        return key;
    }

    public ModelRef<Group> getGroupRef() {
        return groupRef;
    }
}
