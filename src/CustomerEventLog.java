import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Emil on 2017-09-21.
 */
public class CustomerEventLog extends EventLog {

    public void madeAPurchase(Product product, Customer custumer){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(custumer.getName()+"_CUSTOMER_LOG.txt"), true));
            writer.println("Costumer by name: "+custumer.getName()+" ID: "+custumer.getId()+" has made the following purchase:");
            writer.println("Product name: "+product.getName());
            writer.println("Quantity: "+product.getQuantity());
            writer.println("Purchase date: "+product.getPurchaseDate());
            writer.println("-----------------------END OF LOG------------------------------");
            writer.close();
        } catch (IOException e) {
            // do something, notify an exception log?
        }
    }
}
