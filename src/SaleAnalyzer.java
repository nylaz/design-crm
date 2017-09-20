import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Emil on 2017-09-20.
 */
public class SaleAnalyzer {
    public static ArrayList<Product> soldProducts = new ArrayList<>();;
    public static Map<Customer, Product> soldProductAndCustomer = new HashMap<>(); // Maybe better to use Map? hmm
    private static Map<Vendor, Product> vendorProductMap = new HashMap<>();


    public SaleAnalyzer(){
    }


    public void salesToCostumerTable(int customerId) {
        for (Map.Entry<Customer, Product> entry : soldProductAndCustomer.entrySet()) {
            Customer key = entry.getKey();
            Product value = entry.getValue();
            if(key.getId() == customerId) {
                System.out.println("Customer: "+key.getName());
                System.out.println("Bought: "+value.getName());
            }
            //todo
        }
    }

    public void saleByVendorTable(int vendorId){
        for (Map.Entry<Vendor, Product> entry : vendorProductMap.entrySet())
        {
            Vendor key = entry.getKey();
            Product value = entry.getValue();
            if(key.getId() == vendorId){
                System.out.println("Vendor: "+key.getName()+ ". Sales made:");
                System.out.println(value.getName());
                //todo: need list or smt
            }
        }

    }

    public void saleForProductTable(String productName){
        int tempQuantity =0;

        for(int i = 0; i < soldProducts.size(); i++){
            if(soldProducts.get(i).getName().equalsIgnoreCase(productName)){

                //Transfer this to table UI?
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
        soldProductAndCustomer.put(customer, product);
    }

    public void addVendorToSoldProduct(Product product, Vendor vendor){
        vendorProductMap.put(vendor, product);
    }

}
