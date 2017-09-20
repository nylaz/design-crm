import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Emil on 2017-09-15.
 */
public class Product {
    private String name;
    private int quantity;
    private String purchaseDate;
    private Calendar cal = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM/dd:HH:mm:ss");

    public Product(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
        purchaseDate = sdf.format(cal.getTime());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
