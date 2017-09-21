import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Emil on 2017-09-20.
 */
public class SaleAnalyzer {

    private ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Product> soldProducts = new ArrayList<>();;


    public SaleAnalyzer(){
    }


    public void salesToCostumerToHTML(Customer customer) {
        //Takes costumers own array with products and prints them out along with dates
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        File file = new File(customer.getName()+" HTML_REPORT.html");
        try {
            fWriter = new FileWriter(file);
            writer = new BufferedWriter(fWriter);
                for(int i = 0; i < customer.getProducts().size() ; i++) {
                    writer.write("<span>"+"DATE: "+customer.getProducts().get(i).getPurchaseDate()+" :NAME "+customer.getProducts().get(i).getName()+" :# "+ customer.getProducts().get(i).getQuantity()+"</span>");
                    writer.newLine(); //this is not actually needed for html files - can make your code more readable though
                }
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }

    public void saleByVendorToHTML(Vendor vendor){
        //Takes a vendors own array with sold products and prints them along with dates
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        File file = new File(vendor.getName() + " HTML_REPORT.html");
        try {
            fWriter = new FileWriter(file);
            writer = new BufferedWriter(fWriter);
            for(int i = 0; i < vendor.getProductsSold().size() ; i++) {
                    writer.write("<span>" +"DATE: "+ vendor.getProductsSold().get(i).getPurchaseDate() + " :NAME " + vendor.getProductsSold().get(i).getName() +" :# "+ vendor.getProductsSold().get(i).getQuantity() + "</span>");
                    writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            }
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }

    }

    public void saleReportForAllProductToHTML(){
        //Takes saleAalyzers own array of sold products and prints them out along with date and quantity
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        File file = new File("SOLD_PRODUCTS_HTML_REPORT.html");
        try {
            fWriter = new FileWriter(file);
            writer = new BufferedWriter(fWriter);
            for(int i = 0; i < soldProducts.size() ; i++) {
                writer.write("<span>" +"DATE: "+ soldProducts.get(i).getPurchaseDate() + " :NAME: " + soldProducts.get(i).getName() +" :# "+ soldProducts.get(i).getQuantity() + "</span>");
                writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            }
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }

    public void addSoldProduct(Product product, Customer customer){
        soldProducts.add(product);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

}
