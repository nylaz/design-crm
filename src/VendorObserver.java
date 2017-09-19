import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Emil on 2017-09-19.
 */
public class VendorObserver implements Observer {
    private static ArrayList<Vendor> vendors = new ArrayList<>();

    public VendorObserver(){
    }

    public void addVendor(Vendor vendor){
        this.vendors.add(vendor);
    }

    @Override
    public void update(Observable o, Object arg) {
        //Checking if other vendors has the same costumer that has been modified and updates their respective event logs
        for(int j = 0; j < vendors.size(); j++){

            for (int k = 0; k < vendors.get(j).getCustomers().size(); k++){
                if(vendors.get(j).getCustomers().get(k).getId() == (int) arg){
                    vendors.get(j).getVendorEventLog().notifyChangeOfCostumer((int) arg);
                }
            }
        }

    }
}
