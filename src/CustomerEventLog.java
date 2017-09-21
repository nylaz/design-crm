import java.io.*;

/**
 * Created by Emil on 2017-09-21.
 */
public class CustomerEventLog extends EventLog {
    private Customer customer;
    ExceptionsLog exceptionsLog = new ExceptionsLog();
    PrintWriter writer;
    public CustomerEventLog(Customer customer) {
        this.customer = customer;
        try {
            this.writer = new PrintWriter(new FileOutputStream(customer.getName()+"_CUSTOMER_LOG.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            exceptionsLog.logException(e);
        }
    }

    public void madeAPurchase(Product product){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(customer.getName()+"_CUSTOMER_LOG.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.println("{\"Costumer by name\" : \""+customer.getName()+"\", \"ID \": \""+customer.getId()+"\",");
        writer.println("\"Product name\" : \""+product.getName()+"\",");
        writer.println("\"Quantity\" : \""+product.getQuantity()+"\",");
        writer.println("\"Purchase date\" : \""+product.getPurchaseDate()+"\"}");
        writer.println();
        writer.close();
    }
}
