import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Emil on 2017-09-15.
 */
//A seller with unique fields, that has costumers and its own event log
public class Vendor extends User implements Observer {
    private ArrayList<Customer> customers;
    private VendorEventLog vendorEventLog;

    public Vendor(int id, String name, String adress){
        this.setId(id);
        this.setName(name);
        this.setAddress(adress);
        customers = new ArrayList<>();
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

    @Override
    public void update(Observable o, Object arg) {
        String message = (String) arg;
        System.out.println("OBSERVED --- "+message);
    }
}
