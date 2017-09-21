import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Emil on 2017-09-15.
 */
public class VendorEventLog extends Observable {
    private Vendor vendor;
    private String currentDate;
    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM/dd:HH:mm:ss");

    public VendorEventLog(Vendor vendor){
        this.vendor = vendor;
        currentDate = sdf.format(cal.getTime());
    }


    public void madeASale(Product product, Customer costumer){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(vendor.getName()+"_LOG.txt"), true));
            writer.println("SALE BY: "+vendor.getName()+" ID: "+vendor.getId());
            writer.println("Costumer by name: "+costumer.getName()+" ID: "+costumer.getId()+" has made the following purchase:");
            writer.println("Product name: "+product.getName());
            writer.println("Quantity: "+product.getQuantity());
            writer.println("Purchase date: "+product.getPurchaseDate());
            writer.println("-----------------------END OF LOG------------------------------");
            writer.close();
            costumer.addProducts(product);
            vendor.addProductSold(product);
        } catch (IOException e) {
            // do something, notify an exception log?
        }
    }

    public void costumerInteraction(Customer customer, String interactionTopic){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(vendor.getName()+"_LOG.txt"), true));
            String log = "COSTUMER INTERACTION\nVendor by name: " + vendor.getName() + ", ID: " + vendor.getId() + " met with costumer";
            writer.println("COSTUMER INTERACTION");
            writer.println("Vendor by name & ID: " + vendor.getName() + ", ID: " + vendor.getId());
            writer.println("Costumer by name & ID: " + customer.getName() + ", ID: "+customer.getId());
            writer.println("Topic: "+interactionTopic);
            writer.println("Date: "+currentDate);
            writer.println("--------------------------END OF LOG---------------------------");
            writer.close();
        }catch (IOException e) {
            //do stuff
        }
    }

    public void notifyChangeOfCostumer(int id){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(vendor.getName()+"_LOG.txt"), true));
            writer.println("COSTUMER MODIFIED");
            writer.println("Costumer by ID: "+id+" has had their address modified" );
            writer.println("Date: "+currentDate);
            writer.println("--------------------------END OF LOG---------------------------");
            writer.close();
        }catch (IOException e) {
            //do stuff
        }
    }
    public void hasModifiedACostumer(Customer costumer){
        setChanged();
        notifyObservers(costumer.getId());
    }

}
