public class Main {

    public static void main(String[] args) {
        //bajs


        Customer customer1 = new Customer(2, 2);
        customer1.setId(1234);
        customer1.setName("Emil");
        customer1.setAddress("Fleminggatan 35");


        Customer customer2 = new Customer(4, 5);
        customer2.setId(5555);
        customer2.setName("Herp");
        customer2.setAddress("Gatan 4");


        Product product1 = new Product("Apple", 6);

        Vendor vendor1 = new Vendor(1111, "john", "doucheSteet 3");
        vendor1.addCustomer(customer1);
        vendor1.addCustomer(customer2);
        VendorEventLog vendorEventLog1 = new VendorEventLog(vendor1);
        vendorEventLog1.addObserver(vendor1);

        Vendor vendor2 = new Vendor(2222, "Frubadub", "HerpiderpAvenue 82");
        vendor2.addCustomer(customer2);
        VendorEventLog vendorEventLog2 = new VendorEventLog(vendor2);



        vendorEventLog1.madeASale(product1, customer1);
        vendorEventLog1.hasModifiedACostumer(customer1, vendor1);


    }
}
