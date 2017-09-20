import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Emil on 2017-09-20.
 */
public class SaleAnalyzer {
    public static ArrayList<Product> products = new ArrayList<>();;
    private static ArrayList<String> productPurchaseDates = new ArrayList<>();;
    private static ArrayList<Integer> productQuantity  = new ArrayList<>();;
    public static Map<List<String>, Integer> nameAndDateAndQuantity = new HashMap<>(); // Maybe better to use Map? hmm
    private static Map<Product, Vendor> vendorProductMap = new HashMap<>();


    public SaleAnalyzer(){
    }


    public void salesToCostumerTable(Customer customer){


    }

    public void saleByVendorTable(int vendorId){
        for(int i = 0; i < vendorProductMap.size(); i++){
            if(vendorId == (vendorProductMap.get(i).getId())){
                System.out.print("Help");
            }
        }

    }

    public void saleForProductTable(String productName){
        int tempQuantity =0;

        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equalsIgnoreCase(productName)){
                //productPurchaseDates.add(products.get(i).getPurchaseDate());
               // productQuantity.add(products.get(i).getQuantity());

                //Transfer this to table UI?
                System.out.print("Product: "+productName+". ");
                System.out.print("Purchase date: "+products.get(i).getPurchaseDate()+".");
                System.out.println(" Quantity: "+products.get(i).getQuantity()+".");
                tempQuantity = tempQuantity + products.get(i).getQuantity();




            }
        }
        //If you want to add up all quantity
        //System.out.println(tempQuantity);

    }

    public void addSoldProduct(Product product){
        products.add(product);
    }

    public void addVendorToSoldProduct(Product product, Vendor vendor){
        vendorProductMap.put(product, vendor);
    }

}
