import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Emil on 2017-09-21.
 */
public class CustomerEventLog extends EventLog {
    private Customer customer;
    ExceptionsLog exceptionsLog = new ExceptionsLog();
    File file;
    public CustomerEventLog(Customer customer){
        this.customer = customer;
        file = new File(customer.getName()+"_CUSTOMER_LOG.txt");


    }

    public void madeAPurchase(Product product){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
            writer.println("{\"Costumer by name\" : \""+customer.getName()+"\", \"ID \": \""+customer.getId()+"\",");
            writer.println("\"Product name\" : \""+product.getName()+"\",");
            writer.println("\"Quantity\" : \""+product.getQuantity()+"\",");
            writer.println("\"Purchase date\" : \""+product.getPurchaseDate()+"\"}");
            writer.println();
            writer.close();
        } catch (IOException e) {
            exceptionsLog.logException(e);
        }
    }
}
