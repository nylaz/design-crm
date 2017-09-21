
import java.util.ArrayList;

/**
 * Created by Emil on 2017-09-15.
 */
//A customer with unique fields, that has an event log and location specifiers
public class Customer extends User {
    private int longitude;
    private int latitude;
    private ArrayList<Vendor> vendors;
    private CustomerEventLog customerEventLog;

    private ArrayList<Product> productToList = new ArrayList<>();

    public Customer(int longitude, int latitude){
        vendors = new ArrayList<>();
        customerEventLog = new CustomerEventLog(Customer.this);
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void addVendor(Vendor vendor){
        vendors.add(vendor);
    }

    public ArrayList<Vendor> getVendors(){
        return vendors;
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

    public ArrayList<Product> getProducts() {
        return productToList;
    }

    public void addProducts(Product product) {
        this.productToList.add(product);
    }

    public void madeAPurchase(Product product){
        customerEventLog.madeAPurchase(product);
    }
}
