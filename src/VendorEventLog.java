import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Emil on 2017-09-15.
 */
public class VendorEventLog extends Observable {
    ExceptionsLog exceptionsLog = new ExceptionsLog();
    private Vendor vendor;
    private String currentDate;
    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM/dd:HH:mm:ss");
    PrintWriter writer;


    public VendorEventLog(Vendor vendor) {
        this.vendor = vendor;
        currentDate = sdf.format(cal.getTime());
        try {
            writer = new PrintWriter(new FileOutputStream((vendor.getName()+"_LOG.txt"), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void madeASale(Product product, Customer costumer){
        writer.println("{\"SALE BY\": \""+vendor.getName()+"\", \"ID\" : \""+vendor.getId()+"\",");
        writer.println("\"Costumer by name\": \""+costumer.getName()+"\", \"ID\" : \""+costumer.getId()+"\",");
        writer.println("\"Product name\" : \""+product.getName()+"\"");
        writer.println("\"Quantity\" : \""+product.getQuantity()+"\"");
        writer.println("\"Purchase date\" : \""+product.getPurchaseDate()+"\"}");
        writer.println();
        writer.close();
        costumer.addProducts(product);
        vendor.addProductSold(product);
    }

    public void costumerInteraction(Customer customer, String interactionTopic){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream((vendor.getName()+"_LOG.txt"), true));
            String log = "{\"COSTUMER INTERACTION\" , \"Vendor by name:\" : \"" + vendor.getName() + "\", \"ID\":\"" + vendor.getId() +"\"";
            writer.println(log);
            writer.println("\"Costumer by name\" : \"" + customer.getName() + "\" , \"ID\" : \""+customer.getId()+"\"");
            writer.println("\"Topic\" : \""+interactionTopic+"\"");
            writer.println("\"Date\" : \""+currentDate+"\"}");
            writer.println();
            writer.close();
        }catch (IOException e) {
            exceptionsLog.logException(e);
        }
    }

    public void notifyChangeOfCostumer(int id){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream((vendor.getName()+"_LOG.txt"), true));
            writer.println("\"COSTUMER MODIFIED\" : \""+id+"\"");
            writer.println("\"Date\" : \""+currentDate+"\"");
            writer.println();
            writer.close();
        }catch (IOException e) {
            exceptionsLog.logException(e);
        }
    }
    public void hasModifiedACostumer(Customer costumer){
        setChanged();
        notifyObservers(costumer.getId());
    }

}
