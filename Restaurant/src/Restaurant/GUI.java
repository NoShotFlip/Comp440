package Restaurant;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a GUI interface for a Restaurant system.
 * Contains visual components and related actions for interacting with the Restaurant system.
 * @author 
 * @version 1.0
 * <p>

 * </p>
 */


public class GUI {
     /** The first name of the guest. */
     public static String firstName1String;
    
     /** The last name of the guest. */
     public static String lastName1String;
     
     /** The email address of the guest. */
     public static String email1String;
     
     /** The check-in date string. */
     public static String checkIn1String;
     
   

     public static String time1;
     
     /** The type of the table reserved by the guest. */
     public static String tableType1String;
     
     /** Any additional message or notes associated with the reservation. */
     public static String message1String;
    
     /** The number of adults for the reservation. */
     static String adults;
     
     /** The number of children for the reservation. */
     static String children;
     
     /** The table number assigned for the reservation. */
     public static int tableNumber;
      /**
     * The main entry point for the Restaurant reservation system.
     * <p>
     * Initializes the Restaurant tables and their properties.
     * </p>
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        /**
         * Initialization of various tables in the Restaurant.
         */
        Tables r1 = new Tables(1 ,"Sit by the bar" , true);
        Tables r2 = new Tables(2 ,"Table for two" , true);
        Tables r3 = new Tables(3 ,"Group" , true);
        Tables r4 = new Tables(4 ,"Sit by the bar" , true);
        Tables r5 = new Tables(5 ,"Table for two" , true);
        Tables r6 = new Tables(6 ,"Group" , true);
        Tables r7 = new Tables(7 ,"Sit by the bar" , true);
        Tables r8 = new Tables(8 ,"Table for two" , true);
        Tables r9 = new Tables(9 ,"Group" , true);
        Tables r10 = new Tables(10 ,"Party" , true);
        
        /**
         * Aggregate all initialized Tables into an array to represent them collectively.
         */
        // Create an array of Tables to add to a Table object
        Tables[] tables = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        /**
         * Create a Restaurant object, passing in the collection of initialized Tables.
         */
        // Create Restaurant element
        Restaurant H = new Restaurant(tables);
    
        /**
         * Main GUI frame for the Restaurant application.
         */
        // Create GUI frame
        JFrame frame = new JFrame("Restaurant GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        /**
         * Initialize various panels for different sections and functionalities of the Restaurant GUI.
         * For instance, these might represent different screens or sections within the application such 
         * as home, booking, table view, etc.
         */
        // Create panels
        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel homePanel = new JPanel(new BorderLayout());
        JPanel bookingPanel = new JPanel(new BorderLayout());
        JPanel tablesPanel = new JPanel(new BorderLayout());
        JPanel amenitiesPanel = new JPanel(new BorderLayout());
        JPanel logoAndButtonPanel = new JPanel(new BorderLayout());
        JPanel P1Panel = new JPanel(new BorderLayout());
        JPanel P3Panel = new JPanel(new BorderLayout());
        JPanel P1aPanel = new JPanel(new BorderLayout());
        JPanel P3aPanel = new JPanel(new BorderLayout());
        JPanel hPanel = new JPanel(new BorderLayout());



        /**
         * Initialization and setup of GUI components for the restaurant application.
         */

        // Nested button panel for housing top navigation buttons.
        /**
         * Panel that holds the top navigation buttons.
         */
        // Create nested buttons panel for top buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        /**
         * Creation of buttons with specific styling for navigation and user actions.
         */
        // Create buttons
        JButton homeButton = buttonStyling("Home", Color.BLUE);
        JButton tablesButton = buttonStyling("Tables", Color.GREEN);
        JButton amenitiesButton = buttonStyling("Menu", Color.CYAN);
        JButton bookingButton = buttonStyling("Reserve now", Color.RED);
        JButton cancelReservationButton = buttonStyling("Cancel Reservation",Color.MAGENTA);
        JButton adminButton = buttonStyling("Admin",Color.ORANGE);

        /**
         * Scrollable panels to ensure the content of certain sections can be scrolled if they extend beyond the visible area.
         */
        // scrollable panels
        JScrollPane homeScrollPane = new JScrollPane(homePanel);
        JScrollPane amenitiesScrollPane = new JScrollPane(amenitiesPanel);
        JScrollPane TablesScrollPane = new JScrollPane(tablesPanel); 
        JScrollPane BookingScrollPane = new JScrollPane(bookingPanel);

        /**
         * Adding the created buttons to the button panel.
         */
        // Add buttons to button panel
        buttonPanel.add(homeButton);
        buttonPanel.add(tablesButton);
        buttonPanel.add(amenitiesButton);
        buttonPanel.add (cancelReservationButton);
        buttonPanel.add(adminButton);
        
        /**
         * Load an image representing the restaurant and create a label to display it within the GUI.
         */

        // Load the restaurant image and create a JLabel for the image
        ImageIcon imageIcon = new ImageIcon("src/Restaurant/images/r2.png");
        JLabel imageLabel = new JLabel(imageIcon);
       
        /**
         * Color definitions for possible GUI customization or styling.
         */
        //colors
        Color myColor = new Color(18, 13, 13); 
        Color myColor1 = new Color(51, 51, 51);
        Color myColor2 = new Color(251, 241, 241); 
        
        /**
         * GUI components related to the footer section of the restaurant application.
         */

        /**
         * Footer label with a custom border.
         */
        //footer
        JLabel footerLabel = new JLabel();
        MatteBorder footerBorder = BorderFactory.createMatteBorder(78, 0, 2, 0, myColor1);
        footerLabel.setBorder(footerBorder);
        
        /**
         * Secondary footer label with a custom border.
         */
        JLabel footerLabel2 = new JLabel();
        MatteBorder footerBorder2 = BorderFactory.createMatteBorder(210, 0, 15, 0,myColor);
        footerLabel2.setBorder(footerBorder2);
       
       /**
         * Copyright label with predefined text and styling.
         */
        //footer labels/styling
        JLabel t = new JLabel("<html>Copyright \u00A9 2024 Flippers and Dippers. <br>\r\n" + //
                "All rights reserved. All trademarks, service marks, trade names, trade dress, product names and logos appearing on the site are the property of their respective owners\r\n" + //
                        "\r\n");
        Font  tt  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 12);
        t.setFont(tt);
        t.setForeground(Color.WHITE);
        t.setBounds(44,612,511,411);

        /**
         * About us label with predefined text and styling.
         */
        JLabel t1 = new JLabel("ABOUT US");
        Font  tt1  = new Font(Font.DIALOG, Font.BOLD, 18);
        t1.setFont(tt1);
        t1.setForeground(myColor2);
        t1.setBounds(114,670,511,411);

        /**
         * Description label detailing the charm and allure of Restaurant.
         */
        JLabel t2 = new JLabel("<html>Embracing the lovely views of the beach at  Flippers and Dippers<br>have your favorite at our restaurant.\r\n" + //
                "<br>Flippers and Dippers offers wonderful view of the Pafice ocean.\r\n" + //
                        "<br>\r\n" + //
                                "\r\n" + //
                                " </html>");
        Font  ttt  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 14);
        t2.setFont(ttt);
        t2.setForeground(Color.WHITE);
        t2.setBounds(44,742,511,411);

        /**
         * Label to showcase the location heading.
         */
        JLabel t3 = new JLabel("LOCATION");
        t3.setFont(tt1);
        t3.setForeground(myColor2);
        t3.setBounds(624,680,511,411);

        /**
         * Address label displaying the location of Restaurant.
         */
        JLabel t4 = new JLabel("100 Santa Monica , Santa Monica, CA 90401\n" + //
                "");
        t4.setFont(ttt);
        t4.setForeground(Color.WHITE);
        t4.setBounds(524,712,511,411);

       
        /**
         * GUI components and styling related to the "Contact Us" section, logos, and table types of the restaurant application.
         */

        /**
         * Label for "CONTACT US" header.
         */      
        JLabel t5 = new JLabel("CONTACT US");
        t5.setFont(tt1);
        t5.setForeground(myColor2);
        t5.setBounds(1074,680,511,411);

        /**
         * Label displaying the email and phone contact details of the restaurant.
         */
        JLabel t6 = new JLabel("<html> Email: FlippersandDippers@gmail.com <br><br>Phone: 818-555-5555 </html>");
        t6.setFont(ttt);
        t6.setForeground(Color.WHITE);
        t6.setBounds(1024,742,511,411);

        /**
         * Adding footer labels to a nested panel.
         */
        //add footer labels to nested panel
        hPanel.add(t);
        hPanel.add(t1);
        hPanel.add(t2);
        hPanel.add(t3);
        hPanel.add(t4);
        hPanel.add(t5);
        hPanel.add(t6);
   
        hPanel.add(imageLabel, BorderLayout.NORTH);
        hPanel.add(footerLabel, BorderLayout.CENTER);
        hPanel.add(footerLabel2, BorderLayout.SOUTH);
       
        /**
         * Nesting labels to the main panel.
         */
        //add nested labels to main panel
        homePanel.add(hPanel, BorderLayout.CENTER);

        // homePanel.add(footerLabel, BorderLayout.SOUTH);
        /**
         * Logo label with predefined image and border styling.
         */
        //add logo
        ImageIcon logo = new ImageIcon("src/Restaurant/images/loggo.png");
        JLabel logoLabel = new JLabel(logo);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        logoLabel.setBorder(border);

        /**
         * Nesting elements to the logo and button panel.
         */
        logoAndButtonPanel.add(bookingButton, BorderLayout.EAST);
        logoAndButtonPanel.add(logoLabel, BorderLayout.WEST);
        logoAndButtonPanel.add(buttonPanel, BorderLayout.CENTER);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);
        buttonPanel.setBackground(Color.DARK_GRAY);
        
        logoAndButtonPanel.setBackground(Color.LIGHT_GRAY);
        
        //padding
        /**
         * Setting padding for buttons and panels.
         */
        EmptyBorder b = new EmptyBorder(22, 120, 0, 0);    
        buttonPanel.setBorder(b);
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
    
        // Tables panel start
        
       /**
         * Loading images for different Table types.
         */
        // Load images
        ImageIcon P1 = new ImageIcon("src/Restaurant/images/sittbybar2.png");
        ImageIcon P2 = new ImageIcon("src/Restaurant/images/tableForTwo.png");
        ImageIcon P3 = new ImageIcon("src/Restaurant/images/group.png");
        ImageIcon P4 = new ImageIcon("src/Restaurant/images/party.png");

       /**
         * Label for "Sit By the Bar" title and its styling.
         */
        // label for title/ title styling
        JLabel P1LabelT = new JLabel("Sit By the Bar");
        Font  f3  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 32);
        P1LabelT.setFont(f3);
        P1LabelT.setForeground(Color.GRAY);
        P1LabelT.setBounds(1244,312,511,111);
        
        /**
         * Description label for "Sit By the Bar" table type.
         */
        // label for text/ styling
        JLabel P1LabelTT = new JLabel("<html> Sit down in one of our wonder vbar sitting area\r\n" + //
                "experience<br> the comfort of air-conditioned spaces seamlessly\r\n" + //
                "ensuring a truly enjoy the views of the beach</html>");
        Font  f3T  = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 22);
        P1LabelTT.setFont(f3T);
        P1LabelTT.setForeground(Color.BLACK);
        P1LabelTT.setBounds(1044,162,711,711);

        /**
         * Label for "Table for two" title and its styling.
         */
        JLabel P2LabelT = new JLabel("Table for two");
        P2LabelT.setFont(f3);
        P2LabelT.setForeground(Color.GRAY);
        P2LabelT.setBounds(444,1212,511,111);

        /**
         * Description label for "Table for two" table type.
         */
        JLabel P3LabelTT = new JLabel("<html> Have a wonderful date with a Table for two \r\n" + 
                "which is the views dont amaze you the you scener will.\r\n" + //
                        "\r\n" + //
                ".\r\n" + //
                      "</html>");
        P3LabelTT.setFont(f3T);
        P3LabelTT.setForeground(Color.BLACK);
        P3LabelTT.setBounds(244,1072,711,711);

        /**
         * Label for "Group" title and its styling.
         */
        JLabel P3LabelT = new JLabel("Group");
        P3LabelT.setFont(f3);
        P3LabelT.setForeground(Color.GRAY);
        P3LabelT.setBounds(1114,242,511,111);

        /**
         * Description label for "Group" table type.
         */
        JLabel P4LabelTT = new JLabel("<html> For a group of peole that around 3 or 4 people ,\r\n" + //
                "\r\n" + //
                "are able to sit a one of our booth that are not like traditional \r\n" + //
                        "\r\n" + //
                "bootn , they have a more beachy feel.\r\n" + //
                 "</html>");
        P4LabelTT.setFont(f3T);
        P4LabelTT.setForeground(Color.BLACK);
        P4LabelTT.setBounds(944,122,711,711);

        /**
         * Label for "Party Table" title and its styling.
         */
        JLabel P4LabelT = new JLabel("Party Table");
        P4LabelT.setFont(f3);
        P4LabelT.setForeground(Color.GRAY);
        P4LabelT.setBounds(544,1122,511,111);

       
        /**
         * Description label for "Party Table" table type.
         */
        JLabel P5LabelTT = new JLabel("<html> If you are looking to through a party we have a perfect table for you \r\n" + //
                "\r\n" + //
                "this is one of our biggest tables that we have a the restaurant.\r\n" + //
                        "\r\n" + //
                "Comes with a inlcuded free cake when thoughing a party. \r\n" + //
                        "\r\n" + //
                 "</html>");
        P5LabelTT.setFont(f3T);
        P5LabelTT.setForeground(Color.BLACK);
        P5LabelTT.setBounds(244,972,711,711);

        /**
         * Image labels for table types.
         */
        //img labels
        JLabel P1Label = new JLabel(P1);
        JLabel P2Label = new JLabel(P2);
        JLabel P3Label = new JLabel(P3);
        JLabel P4Label = new JLabel(P4);


         /**
         * Padding for table type images.
         */
         // Adds padding through an empty border
        EmptyBorder paddingBorder = new EmptyBorder(122, 240, 0, 1244);   
        

        /**
         * Configures the borders for various labels.
         * <p>
         * P1Label and P3Label are given the same padding via {@code paddingBorder}.
         * P2Label uses {@code paddingBorder1} and P4Label uses {@code paddingBorder4}.
         * </p>
         */
        P1Label.setBorder(paddingBorder);
        P3Label.setBorder(paddingBorder);     

         
        /**
         * Adds images and text components to Panel.
         * <p>
         * This nests various labels, possibly representing images or text, into the P1Panel.
         * </p>
         */
     // Add img/text to nested panel   
        P1Panel.add(P1LabelT); 
        P1Panel.add(P1LabelTT);
        P1Panel.add(P3LabelTT);

     // Add img/text to nested panel   
        P3Panel.add(P4LabelTT);
        P3Panel.add(P5LabelTT);

        P1Panel.add(P2Label, BorderLayout.SOUTH);
        P1Panel.add(P2LabelT); 

        P3Panel.add(P4Label, BorderLayout.SOUTH);
        P3Panel.add(P3LabelT);
        P3Panel.add(P4LabelT);

        P1Panel.add(P1Label);
        P3Panel.add(P3Label);
        /**
         * Adds the nested panels P1Panel and P3Panel to the main panel called TablesPanel.
         */
        // add nested panels to main panel
        tablesPanel.add(P1Panel, BorderLayout.CENTER);
        tablesPanel.add(P3Panel, BorderLayout.SOUTH);

         // Tables panel end


    // amenities tab start
        /**
         * Starts the configuration for the amenities tab.
         * 
         * Here we're loading up images for various amenities from specified paths.
         */

        // Load images
        ImageIcon P1a = new ImageIcon("src/Restaurant/images/menu2.png");
       

      
        /**
         * Initializes labels to hold images for various amenities.
         */
        // img labels
        JLabel P1aLabel = new JLabel(P1a);
    


         /**
         * Applies padding to the image labels.
         * Different borders are applied to different labels as defined earlier in the code.
         */
        // padding
        P1aLabel.setBorder(paddingBorder);
        


        P1aPanel.add(P1aLabel);
    

        /**
         * Adds the P1aPanel and P3aPanel to the main amenities panel.
         */
        // add nested panels to main panel
        amenitiesPanel.add(P1aPanel, BorderLayout.CENTER);
        amenitiesPanel.add(P3aPanel, BorderLayout.SOUTH);

        // This marks the end of configuration for the amenities tab

        /**
         * Adds different scrollable panels to the main panel using CardLayout.
         * This allows for switching between different panels based on user interaction.
         */
        // amenities tab end

        // Add panels to the main panel with CardLayout
        mainPanel.add(homeScrollPane, "Home");
        mainPanel.add(BookingScrollPane, "Booking");
        mainPanel.add(TablesScrollPane, "Tables"); 
        mainPanel.add(amenitiesScrollPane, "Menu");
       
        /**
         * Adds the main panel to the main application frame.
         */
        // Add main panel to the frame
        frame.add(mainPanel);

        /**
         * Action listener for bookingButton.
         * On clicking the bookingButton, the frame visibility is set to false.
         */
        // action listeners
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        /**
         * Action listener for amenitiesButton.
         * On clicking the amenitiesButton, the view is switched to show the amenities tab.
         * Additionally, styling adjustments are made to the booking button and logoAndButtonPanel is added to the amenitiesPanel.
         */
        amenitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
          
                // add buttonPanel to booking panel
                // Styling adjustments
        EmptyBorder a = new EmptyBorder(0, 33, 0, 226);
        bookingButton.setBorder(a);
        amenitiesPanel.add(logoAndButtonPanel, BorderLayout.NORTH);
                 // Switching view to show amenities tab
                cardLayout.show(mainPanel, "Amenities");

            }
        });

        /**
         * Action listener for tablesButton.
         * On clicking the tablesButton, the view is switched to show the tables panel.
         * Styling adjustments are also made to the booking button and logoAndButtonPanel is added to the tablesPanel.
         */
        tablesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // add buttonPanel to booking panel
                // Styling adjustments
        EmptyBorder a = new EmptyBorder(0, 33, 0, 226);
        bookingButton.setBorder(a);
        tablesPanel.add(logoAndButtonPanel, BorderLayout.NORTH);
                // Switching view to show tables panel
                 cardLayout.show(mainPanel, "Tables");

            }
        });          
            /**
             * Action listener for homeButton.
             * On clicking the homeButton, the view is switched to show the home panel.
             * Styling adjustments are also made to the booking button and logoAndButtonPanel is added to the homePanel.
             */
        // action listener for home panel
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                // Styling adjustments
        EmptyBorder a = new EmptyBorder(0, 33, 0, 74);
        bookingButton.setBorder(a);
        homePanel.add(logoAndButtonPanel, BorderLayout.NORTH);
                // Switching view to show home panel
                cardLayout.show(mainPanel, "Home");
            }
        });
       
        /**
         * Set the main application frame as visible.
         */
        // Make frame visible
        frame.setVisible(true);
    
        /**
         * Creates an administrative frame for restaurant management purposes.
         */
        JFrame adminFrame = new JFrame("Restaurant GUI");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(1280, 720);

        /**
         * Creates a new panel for administrative controls.
         */  
        JPanel adminPanel = new JPanel();
        
        /**
         * Creates password and username text input fields
         * Creates enter and back buttons
        */
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField userName = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(userName);
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField password = new JTextField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);
        JPanel credentialsPanel = new JPanel(new FlowLayout());
        credentialsPanel.add(usernamePanel, BorderLayout.CENTER);
        credentialsPanel.add(passwordPanel);
        JButton enter = new JButton("Enter");
        JButton goBack = new JButton("Go Back");
        credentialsPanel.add(enter);
        credentialsPanel.add(goBack);
        adminPanel.add(credentialsPanel, BorderLayout.CENTER);
        adminFrame.add(adminPanel);
        
        /**
         * Action listener for the adminButton.
         * On button click, the main frame is hidden and the admin frame is displayed centered on the screen.
         */  
        // Implement action listeners to handle button clicks
        adminButton.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
            adminFrame.setVisible(true);
            adminFrame.setLocationRelativeTo(null);
            
        }
        });
        
        /**
         * Action listener for the goBack button.
         * On button click, the admin frame is hidden and the main frame is displayed.
         */
        goBack.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
              adminFrame.setVisible(false);
              frame.setVisible(true);
              
            }
        });

        /**
         * Create and initialize the adminView frame that displays various admin views.
         */
        JFrame adminView = new JFrame("Restaurant GUI");
        JTable customerDetailsJTable = new JTable();
        JTable tableAvJTable = new JTable();
        JTable bookingJTable = new JTable();
        adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminView.setSize(1280, 720);
        JPanel adminViewer = new JPanel(new CardLayout());
        /**
         * Buttons to view customer details, table availability, and booking details.
         */
        JButton checkCustomerDetails  = new JButton("Check Customer Details");
        JButton tableAvailability  = new JButton("Tables ");
        JButton bookingDetails  = new JButton("Booking Details");
        JButton goBack2  = new JButton("Go Back");
        
        // Set up the admin viewer layout and add components
        adminViewer.setLayout(new BorderLayout());
        adminView.add(new JScrollPane(customerDetailsJTable), BorderLayout.EAST);
        adminView.add(new JScrollPane(tableAvJTable), BorderLayout.SOUTH);
        adminView.add(new JScrollPane(bookingJTable), BorderLayout.WEST);
        // Create a button panel and add buttons to it
        JPanel buttonPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkCustomerDetails.setBounds(10, 0, 200, 30);
        tableAvailability.setBounds(300, 0, 200, 30);
        bookingDetails.setBounds(600, 0, 200, 30);
        buttonPanel3.add(checkCustomerDetails);
        buttonPanel3.add(tableAvailability);
        buttonPanel3.add(bookingDetails);
        adminViewer.add(buttonPanel3);
        buttonPanel3.add(goBack2);
        adminView.add(adminViewer);
        
        /**
         * Action listener for the enter button.
         * On button click, validates the username and password for admin login.
         * If credentials match, the admin frame is hidden and the admin view is displayed.
         * Else, displays an error message.
         */
        enter.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            String adminU = userName.getText();
            String adminP = password.getText();
            if (adminU.equalsIgnoreCase("admin")&& adminP.equalsIgnoreCase("Bowser")){
                adminFrame.setVisible(false);
                adminView.setLocationRelativeTo(null);
                adminView.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(adminFrame,"Sorry Worng Username or Password. Please Try again");
            }
           
        
        }
        });

        /**
         * Action listener for the goBack2 button.
         * On button click, the admin view is hidden and the admin frame is displayed.
         */
        goBack2.addActionListener(new ActionListener() {
      
            public void actionPerformed(ActionEvent e){
              adminView.setVisible(false);
              adminFrame.setVisible(true);
             
            }
        });

        /**
         * Action listener for the checkCustomerDetails button.
         * On button click, retrieves the customer details from the database and sets the data to the customerDetailsJTable.
         */
        checkCustomerDetails.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = Database.getCustomerDetailsModel();
                
                    customerDetailsJTable.setModel(model);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });

        /**
         * Action listener for the tableAvailability button.
         * On button click, retrieves table availability details from the database and sets the data to the tableAvJTable.
         */
        tableAvailability.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = Database.getTableAvailabilityModel();
                     // Print model to console to verify
               

                        // Set Model to JTable
                    tableAvJTable.setModel(model);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });
        
        /**
         * Action listener for the bookingDetails button.
         * On button click, retrieves booking details from the database and sets the data to the bookingJTable.
         */
        bookingDetails.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
                try {
                    DefaultTableModel model = Database.bookingDetails();
                
                    bookingJTable.setModel(model);
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while fetching customer details.");
                }
                
                adminView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminView.setVisible(true);
            }

        });
        
        /**
         * Initialize the customerViewFrame, set its properties, and add components for capturing customer booking details.
         */
        JFrame customerViewFrame = new JFrame("Restaurant GUI");
        customerViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerViewFrame.setSize(1500, 1000);

        JPanel customerPanel = new JPanel();
        JButton bookNow = new JButton("Reserve now");
        JButton goBack3 = new JButton("Go Back");
        customerPanel.setLayout(new FlowLayout());
        JTable tableAv2JTable = new JTable();
        JPanel buttonPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField firstName, lastName, email, time;
        JDateChooser checkInDate, checkOutDate;
      
        JComboBox<String> tableType;
        JTextArea message;

        customerPanel.add(new JLabel("First Name: "));
        firstName = new JTextField();
        firstName.setColumns(20);
        customerPanel.add(firstName);

        customerPanel.add(new JLabel("Last Name: "));
        lastName = new JTextField();
        lastName.setColumns(20);
        customerPanel.add(lastName);

        customerPanel.add(new JLabel("Email: "));
        email = new JTextField();
        email.setColumns(25);
        customerPanel.add(email);

       

        customerPanel.add(new JLabel("Date: "));
        checkInDate = new JDateChooser();
        checkInDate.setPreferredSize(new Dimension(150,25));
        Date today = new Date();
        checkInDate.setMinSelectableDate(today);
        customerPanel.add(checkInDate);

        customerPanel.add(new JLabel("Time: "));
        time = new JTextField();
        time.setColumns(20);
        checkOutDate = new JDateChooser();
        checkOutDate.setPreferredSize(new Dimension(150,25));
        checkOutDate.setMinSelectableDate(new Date(today.getTime() + (1000 * 60 * 60 * 24)));
        customerPanel.add(time);

        customerPanel.add(new JLabel("Table Type: "));
        tableType = new JComboBox<>(new String[]{"Sit by the bar", "Table for two", "Group", "Party"});
        customerPanel.add(tableType);

        customerPanel.add(new JLabel("Message: "));
        message = new JTextArea(3, 50);
        customerPanel.add(message);
        
        customerViewFrame.add(new JScrollPane(tableAv2JTable), BorderLayout.SOUTH);
        buttonPanel4.add(bookNow);
        buttonPanel4.add(goBack3);
        customerPanel.add(buttonPanel4);
        customerViewFrame.add(customerPanel);

        /**
         * Action listener for the bookingButton.
         * On button click, retrieves table availability details from the database and displays the customer booking form.
         */
        bookingButton.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            try {
            DefaultTableModel model = Database.getTableAvailabilityModel();

                // Set Model to JTable
            tableAv2JTable.setModel(model);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            customerViewFrame.add(customerPanel);
            customerViewFrame.setVisible(false);
            customerViewFrame.setLocationRelativeTo(null);
            customerViewFrame.setVisible(true);
            
        }
        });

        /**
         * Action listener for the bookNow button.
         * On button click, processes the booking request based on the provided customer details.
         */
        bookNow.addActionListener(new ActionListener()  {
        // Code to handle admin actions
        public void actionPerformed(ActionEvent e){
            // Check if all necessary fields are filled out by user
            // Validate that all required fields are filled out by user
            if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || email.getText().isEmpty()
                    
                    || checkInDate.getDate() == null 
                    || tableType.getSelectedItem().toString().isEmpty()){
                // If not, show a message dialog prompting the user to fill all fields
                JOptionPane.showMessageDialog(frame, "All fields must be filled!");

                //Clear all fields
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                
                checkInDate.setDate(null);
                checkOutDate.setDate(null);
                tableType.setSelectedIndex(-1);
                message.setText("");

            } else {
                String checkIn = new SimpleDateFormat("MM/dd/yyyy").format(checkInDate.getDate());
               
               

                tableType1String = tableType.getSelectedItem().toString();
                
                checkIn1String = checkIn;
                time1 = time.getText();
                
                email1String = email.getText();
                firstName1String = firstName.getText();
                lastName1String = lastName.getText();
                message1String = message.getText();
                // Create Guest, Reservation, and Payment objects based on form data
                Guest G = new Guest(firstName1String, lastName1String, email1String);
                int adults1 ;
                if (adults != null) {
                    adults1 = Integer.parseInt(adults);
                } else {
                    // Handle the null case, maybe set a default value or throw an exception
                    adults1 = 0;
                }

                int children1 ;
                if (children != null) {
                    children1 = Integer.parseInt(children);
                } else {
                    // Handle the null case, maybe set a default value or throw an exception
                    children1 = 0;
                }
                Reservation R = new Reservation(adults1, children1, checkIn1String, time1, tableType1String, message1String);
                Payment P = new Payment();
                String bill;
                try {
                    bill = P.calculateBill(R);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    String message = Restaurant.reserveTable(G, tableType1String, checkIn1String, time1, email1String, bill);
                    if (message == null){
                        JOptionPane.showMessageDialog(frame, "Sorry, tables not available!");
                        customerViewFrame.add(customerPanel);
                        customerViewFrame.setVisible(true);
                    }
                    else if (message != null){
                        Restaurant.reserveTable1(G, tableType1String, checkIn1String, time1, email1String,message1String);
                        JOptionPane.showMessageDialog(frame, message);
                        customerViewFrame.add(customerPanel);
                        customerViewFrame.setVisible(true);
                    }
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                //Clear all fields
                firstName.setText("");
                lastName.setText("");
                email.setText("");
               
                checkInDate.setDate(null);
                checkOutDate.setDate(null);
                tableType.setSelectedIndex(-1);
                message.setText("");

                try {
                    DefaultTableModel model = Database.getTableAvailabilityModel();

                    // Set Model to JTable
                    tableAv2JTable.setModel(model);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                // Configure the visibility and position of the customer view frame
                customerViewFrame.add(customerPanel);
                customerViewFrame.setVisible(false);
                customerViewFrame.setLocationRelativeTo(null);
                customerViewFrame.setVisible(true);

                }
            }
        });

        /**
         * Action listener for the goBack3 button.
         * On button click, hides the customer view frame and shows the main frame.
         */
        goBack3.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
              customerViewFrame.setVisible(false);
              frame.setVisible(true);
            }
          });

          /**
         * Initializes and attaches an action listener to the cancelReservationButton.
         * This action listener prompts the user to input their table number and attempts to cancel their reservation.
         */
        cancelReservationButton.addActionListener(new ActionListener()  {
            // Code to handle admin actions
            public void actionPerformed(ActionEvent e){
                // Prompt user for table number
              String tableNum = JOptionPane.showInputDialog(frame,"Enter You're Table Number Please"); 

              // Validate the entered table number
              if (tableNum != null && !tableNum.trim().isEmpty()) { 
                // Check if tableNum is not empty after trimming whitespace
                try {
                    tableNumber = Integer.parseInt(tableNum);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "Invalid Table Number. Please enter a valid number.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please Enter A Table Number");
            }
             // Attempt to cancel table reservation using the table number and display the outcome to the user
              try {
                  String cancelMessage = Restaurant.cancelTable(tableNumber);
                  JOptionPane.showMessageDialog(frame, cancelMessage);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
          });
    }

        /**
         * Method to apply hover effects to buttons.
         * 
         * @param title The text to be displayed on the button.
         * @param c     The foreground color when the mouse hovers over the button.
         * @return JButton The styled button with hover effects.
         */
    // Buttons styling on hover
    private static JButton buttonStyling(String title, Color c) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JButton button = new JButton(title);
        button.setBackground(c);
        button.setForeground(Color.WHITE);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setOpaque(true);
                button.setForeground(c);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(c);
                button.setForeground(Color.WHITE);
            }
        });
        return button;
    }
}



