import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static JFrame frame = new JFrame("CRM");

    private JPanel mainPanel;
    private JButton startButton;
    private JButton detailsButton;
    private JButton cuUserButton;
    private JButton reportButton;
    private JButton Products;
    private JPanel contentPanel;
    private JPanel detailsPanel;
    private JPanel startPanel;
    private JPanel userPanel;
    private JPanel reportPanel;
    private JPanel productsPanel;
    private JLabel customerLabel;
    private JLabel eventLabel;
    private JTextArea startCustomerTextArea;
    private JTextField customerSearchTextField;
    private JButton customerSearchButton;
    private JLabel customerDetailsLabel;
    private JTextField customerDetailsIdTextField;
    private JLabel customerDetailsIdLabel;
    private JTextField customerDetailsNameTextField;
    private JTextField customerDetailsAddressTextField;
    private JLabel customerDetailsNameLabel;
    private JLabel customerDetailsAddressLabel;
    private JTextArea customerEventLog;
    private JLabel customerSearchLabel;
    private JTextArea startEventLog;
    private JLabel createCustomerLabel;
    private JLabel createCustomerIdLabel;
    private JTextField createCustomerIdTextField;
    private JLabel createCustomerCoordsLabel;
    private JTextField createCustomerCoordsTextField;
    private JLabel createCustomerNameLabel;
    private JTextField createCustomerNameTextField;
    private JLabel createCustomerAddressLabel;
    private JTextField createCustomerAddressTextField;
    private JButton createCustomerButton;
    private JPanel createCustomerPanel;
    private JPanel updateCustomerPanel;
    private JLabel updateCustomerLabel;
    private JTextField updateCustomerSearchTextField;
    private JButton updateCustomerSearchButton;
    private JPanel customerToUpdatePanel;
    private JLabel customerToUpdateIdLabel;
    private JTextField customerToUpdateIdTextField;
    private JLabel customerToUpdateCoordsLabel;
    private JTextField customerToUpdateCoordsTextField;
    private JLabel customerToUpdateNameLabel;
    private JTextField customerToUpdateNameTextField;
    private JLabel customerToUpdateAddressLabel;
    private JTextField customerToUpdateAddressTextField;
    private JButton customerToUpdateButton;
    private JLabel customerToUpdateLabel;
    private JTextField customerDetailsCoordsTextField;
    private JLabel customerDetailsCoordsLabel;
    private JPanel createProductPanel;
    private JLabel createProductLabel;
    private JTextField createProductNameTextField;
    private JLabel createProductNameLabel;
    private JLabel createProductQuantLabel;
    private JTextField createProductQuantTextField;
    private JButton createProductButton;
    private JLabel vendorNameLabel;
    private JLabel vendorRealNameLabel;
    private JButton exportReportToHtml;
    private JLabel customerDetailsSocialLabel;
    private JTextField customerDetailsSocialTextField;
    private JLabel customerDetailsFinanceLabel;
    private JTextField customerDetailsFinanceTextField;
    private JTextField customerDetailsWeatherTextField;
    private JLabel customerDetailsWeatherLabel;

    public static Vendor vendor1 = new Vendor(1111, "john", "doucheSteet 3");
    public static ArrayList<Product> products = new ArrayList<>();
    public static SaleAnalyzer saleAnalyzer = new SaleAnalyzer();
    public static ResearchFacade researchFacade = ResearchFacade.getInstance();

    public Main() {

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contentPanel.removeAll();
                contentPanel.repaint();
                contentPanel.revalidate();
                startCustomerTextArea.setText(null);
                for (int i = 0; i < vendor1.getCustomers().size(); i++) {
                    startCustomerTextArea.append(vendor1.getCustomers().get(i).getName() + "\n");
                }

                startEventLog.setText(null);
                File file = new File("EmilusMaximus.txt");
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (scanner.hasNext()) {
                    startEventLog.append(scanner.nextLine() + "\n");
                }

                contentPanel.add(startPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contentPanel.removeAll();
                contentPanel.repaint();
                contentPanel.revalidate();

                contentPanel.add(detailsPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });
        cuUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contentPanel.removeAll();
                contentPanel.repaint();
                contentPanel.revalidate();

                contentPanel.add(userPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contentPanel.removeAll();
                contentPanel.repaint();
                contentPanel.revalidate();

                vendorRealNameLabel.setText(vendor1.getName());

                contentPanel.add(reportPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });
        Products.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contentPanel.removeAll();
                contentPanel.repaint();
                contentPanel.revalidate();

                contentPanel.add(productsPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });
        customerSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = customerSearchTextField.getText();
                for (int i = 0; i < vendor1.getCustomers().size(); i++) {
                    if (vendor1.getCustomers().get(i).getName().equalsIgnoreCase(s)) {
                        customerDetailsIdTextField.setText(String.valueOf(vendor1.getCustomers().get(i).getId()));
                        customerDetailsCoordsTextField.setText(vendor1.getCustomers().get(i).getLatitude() + ", " + vendor1.getCustomers().get(i).getLongitude());
                        customerDetailsNameTextField.setText(vendor1.getCustomers().get(i).getName());
                        customerDetailsAddressTextField.setText(vendor1.getCustomers().get(i).getAddress());

                        researchFacade.researchCustomer(vendor1.getCustomers().get(i), customerDetailsSocialTextField, customerDetailsFinanceTextField, customerDetailsWeatherTextField);

                        customerEventLog.setText(null);
                        File file2 = new File("VendorEventLog.txt");
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(file2);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        while (scanner.hasNext()) {
                            customerEventLog.append(scanner.nextLine() + "\n");
                        }
                        break;
                    } else {
                        customerDetailsIdTextField.setText(null);
                        customerDetailsCoordsTextField.setText(null);
                        customerDetailsNameTextField.setText(null);
                        customerDetailsAddressTextField.setText(null);
                        customerEventLog.setText(null);
                    }
                }
            }
        });
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int id = Integer.parseInt(createCustomerIdTextField.getText());
                int x = Integer.parseInt(createCustomerCoordsTextField.getText().substring(0, 1));
                int y = Integer.parseInt(createCustomerCoordsTextField.getText().substring(1, 2));
                String name = createCustomerNameTextField.getText();
                String address = createCustomerAddressTextField.getText();
                Customer customer = new Customer(x, y);
                customer.setId(id);
                customer.setName(name);
                customer.setAddress(address);
                vendor1.getCustomers().add(customer);
            }
        });
        updateCustomerSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = updateCustomerSearchTextField.getText();
                for (int i = 0; i < vendor1.getCustomers().size(); i++) {
                    if (vendor1.getCustomers().get(i).getName().equalsIgnoreCase(s)) {
                        customerToUpdateIdTextField.setText(String.valueOf(vendor1.getCustomers().get(i).getId()));
                        customerToUpdateCoordsTextField.setText(vendor1.getCustomers().get(i).getLatitude() + ", " + vendor1.getCustomers().get(i).getLongitude());
                        customerToUpdateNameTextField.setText(vendor1.getCustomers().get(i).getName());
                        customerToUpdateAddressTextField.setText(vendor1.getCustomers().get(i).getAddress());
                        break;
                    } else {
                        customerToUpdateIdTextField.setText(null);
                        customerToUpdateCoordsTextField.setText(null);
                        customerToUpdateNameTextField.setText(null);
                        customerToUpdateAddressTextField.setText(null);
                    }
                }
            }
        });
        customerToUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int id = Integer.parseInt(customerToUpdateIdTextField.getText());
                int lat = Integer.parseInt(customerToUpdateCoordsTextField.getText().substring(0, 1));
                int log = Integer.parseInt(customerToUpdateCoordsTextField.getText().substring(3));
                String name = customerToUpdateNameTextField.getText();
                String address = customerToUpdateAddressTextField.getText();

                for (int i = 0; i < vendor1.getCustomers().size(); i++) {
                    if (vendor1.getCustomers().get(i).getId() == id) {
                        vendor1.getCustomers().get(i).setLatitude(lat);
                        vendor1.getCustomers().get(i).setLongitude(log);
                        vendor1.getCustomers().get(i).setName(name);
                        vendor1.getCustomers().get(i).setAddress(address);
                        break;
                    } else {
                        Customer customer = new Customer(lat, log);
                        customer.setId(id);
                        customer.setName(name);
                        customer.setAddress(address);
                        vendor1.getCustomers().add(customer);
                    }
                }
                customerToUpdateIdTextField.setText(null);
                customerToUpdateCoordsTextField.setText(null);
                customerToUpdateNameTextField.setText(null);
                customerToUpdateAddressTextField.setText(null);
            }
        });
        createProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = createCustomerNameTextField.getText();
                int quant = Integer.parseInt(createProductQuantTextField.getText());
                products.add(new Product(name, quant));
                System.out.println(name.toString());
            }
        });
        exportReportToHtml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saleAnalyzer.saleByVendorToHTML(vendor1);
            }
        });
    }


    public static void main(String[] args) {

        frame.setContentPane(new Main().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
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


        vendor1.addCustomer(customer1);
        vendor1.addCustomer(customer2);
        customer1.addVendor(vendor1);
        customer2.addVendor(vendor1);

        vendor2.madeASale(product2, customer1);
        vendor1.madeASale(product1, customer1);
        vendor1.madeASale(product1, customer1);
        vendor1.madeASale(product1, customer2);

        vendor1.customerInteraction(customer1, "Change of address");

        //Här loggas det också för vendor2 att hans kund (costumer1) blir modifierad
        vendor1.modifyCustomerAddress(customer1, "Fleminggatan 35A");
        //samma här fast tvärtom
        vendor2.modifyCustomerAddress(customer1, "Trähattsvägen 4");

        //saleAnalyzer.saleForProductTable(product1.getName());
        //saleAnalyzer.saleForProductTable(product2.getName());
        //saleAnalyzer.saleByVendorToHtml(vendor1);
        //saleAnalyzer.salesToCostumerTableToHTML(customer1);


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setMaximumSize(new Dimension(500, 500));
        mainPanel.setMinimumSize(new Dimension(500, 500));
        startButton = new JButton();
        startButton.setText("Start");
        mainPanel.add(startButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        detailsButton = new JButton();
        detailsButton.setText("Details");
        mainPanel.add(detailsButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cuUserButton = new JButton();
        cuUserButton.setText("C/U User");
        mainPanel.add(cuUserButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reportButton = new JButton();
        reportButton.setText("Report");
        mainPanel.add(reportButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout(0, 0));
        mainPanel.add(contentPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(50, 45), null, new Dimension(5000, 4500), 0, false));
        startPanel = new JPanel();
        startPanel.setLayout(new GridBagLayout());
        contentPanel.add(startPanel, "Card1");
        customerLabel = new JLabel();
        customerLabel.setText("Your customers:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        startPanel.add(customerLabel, gbc);
        eventLabel = new JLabel();
        eventLabel.setText("EventLog");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        startPanel.add(eventLabel, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        startPanel.add(scrollPane1, gbc);
        startEventLog = new JTextArea();
        startEventLog.setEditable(false);
        scrollPane1.setViewportView(startEventLog);
        startCustomerTextArea = new JTextArea();
        startCustomerTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        startPanel.add(startCustomerTextArea, gbc);
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentPanel.add(detailsPanel, "Card2");
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        detailsPanel.add(panel1);
        customerSearchLabel = new JLabel();
        customerSearchLabel.setText("Search customer:");
        panel1.add(customerSearchLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerSearchTextField = new JTextField();
        panel1.add(customerSearchTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerSearchButton = new JButton();
        customerSearchButton.setText("Search");
        panel1.add(customerSearchButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(15, 1, new Insets(0, 0, 0, 0), -1, -1));
        detailsPanel.add(panel2);
        customerDetailsLabel = new JLabel();
        customerDetailsLabel.setText("Details:");
        panel2.add(customerDetailsLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsIdTextField = new JTextField();
        customerDetailsIdTextField.setEditable(false);
        panel2.add(customerDetailsIdTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetailsIdLabel = new JLabel();
        customerDetailsIdLabel.setText("Id:");
        panel2.add(customerDetailsIdLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsNameLabel = new JLabel();
        customerDetailsNameLabel.setText("Name:");
        panel2.add(customerDetailsNameLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsNameTextField = new JTextField();
        customerDetailsNameTextField.setEditable(false);
        panel2.add(customerDetailsNameTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetailsAddressLabel = new JLabel();
        customerDetailsAddressLabel.setText("Address:");
        panel2.add(customerDetailsAddressLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsAddressTextField = new JTextField();
        customerDetailsAddressTextField.setEditable(false);
        panel2.add(customerDetailsAddressTextField, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetailsCoordsLabel = new JLabel();
        customerDetailsCoordsLabel.setText("Coords:");
        panel2.add(customerDetailsCoordsLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsCoordsTextField = new JTextField();
        customerDetailsCoordsTextField.setEditable(false);
        panel2.add(customerDetailsCoordsTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetailsSocialLabel = new JLabel();
        customerDetailsSocialLabel.setText("Social:");
        panel2.add(customerDetailsSocialLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsSocialTextField = new JTextField();
        customerDetailsSocialTextField.setEditable(false);
        panel2.add(customerDetailsSocialTextField, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetailsFinanceLabel = new JLabel();
        customerDetailsFinanceLabel.setText("Finance:");
        panel2.add(customerDetailsFinanceLabel, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsFinanceTextField = new JTextField();
        customerDetailsFinanceTextField.setEditable(false);
        panel2.add(customerDetailsFinanceTextField, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerDetailsWeatherLabel = new JLabel();
        customerDetailsWeatherLabel.setText("Weather:");
        panel2.add(customerDetailsWeatherLabel, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerDetailsWeatherTextField = new JTextField();
        customerDetailsWeatherTextField.setEditable(false);
        panel2.add(customerDetailsWeatherTextField, new com.intellij.uiDesigner.core.GridConstraints(14, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        detailsPanel.add(panel3);
        final JScrollPane scrollPane2 = new JScrollPane();
        panel3.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        customerEventLog = new JTextArea();
        customerEventLog.setEditable(false);
        scrollPane2.setViewportView(customerEventLog);
        userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentPanel.add(userPanel, "Card3");
        createCustomerPanel = new JPanel();
        createCustomerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 1, new Insets(0, 0, 0, 0), -1, -1));
        userPanel.add(createCustomerPanel);
        createCustomerLabel = new JLabel();
        createCustomerLabel.setText("Create customer:");
        createCustomerPanel.add(createCustomerLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createCustomerIdLabel = new JLabel();
        createCustomerIdLabel.setText("Id:");
        createCustomerPanel.add(createCustomerIdLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createCustomerIdTextField = new JTextField();
        createCustomerPanel.add(createCustomerIdTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createCustomerCoordsLabel = new JLabel();
        createCustomerCoordsLabel.setText("Coords:");
        createCustomerPanel.add(createCustomerCoordsLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createCustomerCoordsTextField = new JTextField();
        createCustomerPanel.add(createCustomerCoordsTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createCustomerNameLabel = new JLabel();
        createCustomerNameLabel.setText("Name:");
        createCustomerPanel.add(createCustomerNameLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createCustomerNameTextField = new JTextField();
        createCustomerPanel.add(createCustomerNameTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createCustomerAddressLabel = new JLabel();
        createCustomerAddressLabel.setText("Address:");
        createCustomerPanel.add(createCustomerAddressLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createCustomerAddressTextField = new JTextField();
        createCustomerPanel.add(createCustomerAddressTextField, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createCustomerButton = new JButton();
        createCustomerButton.setLabel("Create");
        createCustomerButton.setText("Create");
        createCustomerPanel.add(createCustomerButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateCustomerPanel = new JPanel();
        updateCustomerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        userPanel.add(updateCustomerPanel);
        updateCustomerLabel = new JLabel();
        updateCustomerLabel.setText("Update customer:");
        updateCustomerPanel.add(updateCustomerLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateCustomerSearchTextField = new JTextField();
        updateCustomerPanel.add(updateCustomerSearchTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        updateCustomerSearchButton = new JButton();
        updateCustomerSearchButton.setText("Search");
        updateCustomerPanel.add(updateCustomerSearchButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerToUpdatePanel = new JPanel();
        customerToUpdatePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 1, new Insets(0, 0, 0, 0), -1, -1));
        userPanel.add(customerToUpdatePanel);
        customerToUpdateIdLabel = new JLabel();
        customerToUpdateIdLabel.setText("Id:");
        customerToUpdatePanel.add(customerToUpdateIdLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerToUpdateIdTextField = new JTextField();
        customerToUpdatePanel.add(customerToUpdateIdTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerToUpdateCoordsLabel = new JLabel();
        customerToUpdateCoordsLabel.setText("Coords:");
        customerToUpdatePanel.add(customerToUpdateCoordsLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerToUpdateCoordsTextField = new JTextField();
        customerToUpdatePanel.add(customerToUpdateCoordsTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerToUpdateNameLabel = new JLabel();
        customerToUpdateNameLabel.setText("Name:");
        customerToUpdatePanel.add(customerToUpdateNameLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerToUpdateNameTextField = new JTextField();
        customerToUpdatePanel.add(customerToUpdateNameTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerToUpdateAddressLabel = new JLabel();
        customerToUpdateAddressLabel.setText("Address:");
        customerToUpdatePanel.add(customerToUpdateAddressLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerToUpdateAddressTextField = new JTextField();
        customerToUpdatePanel.add(customerToUpdateAddressTextField, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        customerToUpdateButton = new JButton();
        customerToUpdateButton.setText("Update");
        customerToUpdatePanel.add(customerToUpdateButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customerToUpdateLabel = new JLabel();
        customerToUpdateLabel.setText("CustomerToUpdate:");
        customerToUpdatePanel.add(customerToUpdateLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reportPanel = new JPanel();
        reportPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentPanel.add(reportPanel, "Card4");
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        reportPanel.add(panel4);
        vendorNameLabel = new JLabel();
        vendorNameLabel.setText("Vendor:");
        panel4.add(vendorNameLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vendorRealNameLabel = new JLabel();
        vendorRealNameLabel.setText("");
        reportPanel.add(vendorRealNameLabel);
        exportReportToHtml = new JButton();
        exportReportToHtml.setText("Export to Html");
        reportPanel.add(exportReportToHtml);
        productsPanel = new JPanel();
        productsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentPanel.add(productsPanel, "Card5");
        createProductPanel = new JPanel();
        createProductPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        productsPanel.add(createProductPanel);
        createProductLabel = new JLabel();
        createProductLabel.setText("Create product:");
        createProductPanel.add(createProductLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createProductNameTextField = new JTextField();
        createProductPanel.add(createProductNameTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createProductNameLabel = new JLabel();
        createProductNameLabel.setText("Name:");
        createProductPanel.add(createProductNameLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createProductQuantLabel = new JLabel();
        createProductQuantLabel.setText("Quant:");
        createProductPanel.add(createProductQuantLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createProductQuantTextField = new JTextField();
        createProductPanel.add(createProductQuantTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createProductButton = new JButton();
        createProductButton.setText("Button");
        createProductPanel.add(createProductButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Products = new JButton();
        Products.setText("Products");
        mainPanel.add(Products, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
