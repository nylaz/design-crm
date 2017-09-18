import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Emil on 2017-09-15.
 */
public class VendorEventLog extends Observable {
    private Vendor vendor;

    public VendorEventLog(Vendor vendor){
        this.vendor = vendor;
    }


    public void madeASale(Product product, Customer costumer){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("VendorEventLog.txt"), true));
            writer.println("SALE BY: "+vendor.getName()+" ID: "+vendor.getId());
            writer.println("Costumer by name: "+costumer.getName()+" ID: "+costumer.getId()+" has made the following purchase:");
            writer.println("Product name: "+product.getName());
            writer.println("Quantity: "+product.getQuantity());
            writer.println("Purchase date:"+product.getPurchaseDate());
            writer.println("-----------------------END OF LOG--------------------------");
            writer.close();
        } catch (IOException e) {
            // do something, notify an exception log?
        }
    }
    public void hasModifiedACostumer(Customer costumer, Vendor vendor){

        String message = "UPDATE: "+vendor.getId()+" Has made changes to costumer ID:"+costumer.getId();
        setChanged();
        notifyObservers(message);
    }

}
