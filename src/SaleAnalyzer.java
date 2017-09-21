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


    public void salesToCostumerTable(Customer customer) {
        //Takes costumers own array with products and prints them out along with dates
        for(int i = 0; i < customer.getProducts().size() ; i++) {
            System.out.println(customer.getProducts().get(i).getPurchaseDate());
            System.out.println(customer.getProducts().get(i).getName());
        }
    }

    public void saleByVendorTable(Vendor vendor){
        //Takes a vendors own array with sold products and prints them along with dates
        for(int i = 0; i < vendor.getProductsSold().size() ; i++) {
            System.out.println(vendor.getProductsSold().get(i).getPurchaseDate());
            System.out.println(vendor.getProductsSold().get(i).getName());
        }

    }

    public void saleForProductTable(String productName){
        //Takes saleAalyzers own array of sold products and prints them out along with date and quantity
        int tempQuantity =0;

        for(int i = 0; i < soldProducts.size(); i++){
            if(soldProducts.get(i).getName().equalsIgnoreCase(productName)){

                //Transfer this to table UI? return type product mb?
                System.out.print("Product: "+productName+". ");
                System.out.print("Purchase date: "+ soldProducts.get(i).getPurchaseDate()+".");
                System.out.println(" Quantity: "+ soldProducts.get(i).getQuantity()+".");
                tempQuantity = tempQuantity + soldProducts.get(i).getQuantity();




            }
        }
        //If you want to add up all quantity
        //System.out.println(tempQuantity);

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
