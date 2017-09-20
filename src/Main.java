import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class Main {

    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel customerNameLabel;
    private JLabel customerDetails;
    private JTextField customerNameField;
    private JLabel customerAddressLabel;
    private JTextField customerAddressField;
    private JTextField customerIdField;
    private JButton updateCustomerButton;
    private JLabel customerIdLabel;
    private JPanel mainPanel;

    public static ArrayList<Customer> customers = new ArrayList<>();

    public Main() {

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                super.focusGained(focusEvent);
                searchField.setText("");
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        SaleAnalyzer saleAnalyzer = new SaleAnalyzer();


        Customer a = new Customer(1, 1);
        a.setId(1);
        a.setName("Lars");
        a.setAddress("Trogsta");
        customers.add(a);

        Customer b = new Customer(2, 2);
        b.setId(2);
        b.setName("Emil");
        b.setAddress("Gävle");
        customers.add(b);


        JFrame frame = new JFrame("CRM-Prototype");
        Main main = new Main();

        frame.setContentPane(main.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Customer customer1 = new Customer(2, 2);
        customer1.setId(1234);
        customer1.setName("Emil");
        customer1.setAddress("Fleminggatan 35");

        Customer customer2 = new Customer(4, 5);
        customer2.setId(5555);
        customer2.setName("Herp");
        customer2.setAddress("Gatan 4");

        Product product1 = new Product("Apple", 7000);
        Product product2 = new Product("Orange", 2000);

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

        vendor2.madeASale(product2, customer1);
        vendor1.madeASale(product1, customer1);
        vendor1.madeASale(product1, customer2);

        vendor1.customerInteraction(customer1, "Change of address");

        //Här loggas det också för vendor2 att hans kund (costumer1) blir modifierad
        vendor1.modifyCustomerAddress(customer1, "Fleminggatan 35A");
        //samma här fast tvärtom
        vendor2.modifyCustomerAddress(customer1, "Trähattsvägen 4");

        saleAnalyzer.saleForProductTable(product1.getName());
        saleAnalyzer.saleForProductTable(product2.getName());
       // saleAnalyzer.saleByVendorTable(1111);

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 4, new Insets(0, 0, 0, 0), -1, -1));
        searchLabel = new JLabel();
        searchLabel.setInheritsPopupMenu(true);
        searchLabel.setText("Search customer: ");
        mainPanel.add(searchLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchField = new JTextField();
        searchField.setText("Enter search here..");
        mainPanel.add(searchField, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetails = new JLabel();
        customerDetails.setText("Customer details:");
        mainPanel.add(customerDetails, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerNameLabel = new JLabel();
        customerNameLabel.setRequestFocusEnabled(false);
        customerNameLabel.setText("Name: ");
        mainPanel.add(customerNameLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerNameField = new JTextField();
        mainPanel.add(customerNameField, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        searchButton = new JButton();
        searchButton.setLabel("Search");
        searchButton.setMargin(new Insets(2, 14, 2, 14));
        searchButton.setText("Search");
        mainPanel.add(searchButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerAddressLabel = new JLabel();
        customerAddressLabel.setText("Address: ");
        mainPanel.add(customerAddressLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerAddressField = new JTextField();
        mainPanel.add(customerAddressField, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerIdLabel = new JLabel();
        customerIdLabel.setText("ID: ");
        mainPanel.add(customerIdLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerIdField = new JTextField();
        mainPanel.add(customerIdField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        updateCustomerButton = new JButton();
        updateCustomerButton.setText("Update customer");
        mainPanel.add(updateCustomerButton, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchLabel.setLabelFor(searchField);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
