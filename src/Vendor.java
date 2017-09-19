import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Emil on 2017-09-15.
 */
//A seller with unique fields, that has costumers and is a proxy to VendorEventLog kind of
public class Vendor extends User {
    private ArrayList<Customer> customers;
    private VendorEventLog vendorEventLog;
    private static VendorObserver vendorObserver = new VendorObserver();

    public Vendor(int id, String name, String adress){
        this.setId(id);
        this.setName(name);
        this.setAddress(adress);
        this.customers = new ArrayList<>();
        this.vendorEventLog = new VendorEventLog(Vendor.this);
        vendorObserver.addVendor(Vendor.this);
        vendorEventLog.addObserver(vendorObserver);
    }

    public void modifyCostumerAddress(Customer customer, String address){
        customer.setAddress(address);
        vendorEventLog.hasModifiedACostumer(customer);
    }

    public void madeASale(Product product, Customer customer){
        vendorEventLog.madeASale(product, customer);
    }
    public void customerInteraction(Customer customer, String topic){
        vendorEventLog.costumerInteraction(customer, topic);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public VendorEventLog getVendorEventLog() {
        return vendorEventLog;
    }

    public void setVendorEventLog(VendorEventLog vendorEventLog) {
        this.vendorEventLog = vendorEventLog;
    }


}
