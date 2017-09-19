public class Main {

    public static void main(String[] args) {


        Customer customer1 = new Customer(2, 2);
        customer1.setId(1234);
        customer1.setName("Emil");
        customer1.setAddress("Fleminggatan 35");

        Customer customer2 = new Customer(4, 5);
        customer2.setId(5555);
        customer2.setName("Herp");
        customer2.setAddress("Gatan 4");

        Product product1 = new Product("Apple", 7000);

        Vendor vendor2 = new Vendor(2222, "EmilusMaximus", "Hejgatan 2");
        vendor2.addCustomer(customer1);
        vendor2.addCustomer(customer2);
        customer1.addVendor(vendor2);
        customer2.addVendor(vendor2);

        Vendor vendor3 = new Vendor(5555, "HejSan", "Gatan");
        vendor3.addCustomer(customer2);



        Vendor vendor1 = new Vendor(1111, "john", "doucheSteet 3");
        vendor1.addCustomer(customer1);
        vendor1.addCustomer(customer2);
        customer1.addVendor(vendor1);
        customer2.addVendor(vendor1);

        vendor1.madeASale(product1, customer1);
        vendor1.customerInteraction(customer1, "Change of address");

        //Här loggas det också för vendor2 att hans kund (costumer1) blir modifierad
        vendor1.modifyCostumerAddress(customer1, "Fleminggatan 35A");

        //samma här fast tvärtom
        vendor2.modifyCostumerAddress(customer1, "Trähattsvägen 4");




    }
}
