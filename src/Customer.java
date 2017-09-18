
import java.util.ArrayList;

/**
 * Created by Emil on 2017-09-15.
 */
//A customer with unique fields, that has an event log and location specifiers
public class Customer extends User {
    private int longitude;
    private int latitude;
    private ArrayList<Vendor> vendors;

    public Customer(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

}
