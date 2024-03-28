import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screen extends JFrame {


    JPanel theFFPanel = new JPanel(); JLabel theFFLabel = new JLabel(); JLabel theServiceLabel = new JLabel();
    JPanel theServicePanel = new JPanel(); JPanel foodPanel = new JPanel(); JPanel fluidPanel = new JPanel();
    JTextField hotDogTextField = new JTextField();  JTextField steakTextField = new JTextField();
    JTextField hamburgerTextField = new JTextField(); JTextField pizzaTextField = new JTextField();
    JLabel hotDogTextLabel = new JLabel(); JLabel steakTextLabel = new JLabel(); JLabel hamburgerTextLabel = new JLabel();
    JLabel pizzaTextLabel = new JLabel(); JLabel foodTextLabel = new JLabel();
    JLabel mojitoTextLabel = new JLabel(); JLabel milkshakeTextLabel = new JLabel(); JLabel cappuccinoTextLabel = new JLabel();
    JLabel iceTeaTextLabel = new JLabel(); JLabel fluidTextLabel = new JLabel();
    JTextField mojitoTextField = new JTextField(); JTextField milkshakeTextField = new JTextField(); JTextField cappuccinoTextField = new JTextField();
    JTextField iceTeaTextField = new JTextField(); JPanel sumPanel = new JPanel();
    JLabel foodsPriceTextLabel = new JLabel(); JLabel fluidsPriceTextLabel = new JLabel(); JLabel sumPriceTextLabel = new JLabel();
    JTextField foodsPriceTextField = new JTextField(); JTextField fluidsPriceTextField = new JTextField();
    JTextField totalPriceTextField = new JTextField(); JPanel billPanel = new JPanel();
    double foodsTotalPrice , fluidsTotalPrice , totalPrice = 0;
    double hotDogPrice = 3; double steakPrice = 8; double hamburgerPrice = 4.5; double pizzaPrice = 4;
    double mojitoPrice = 2.5; double milkshakePrice = 3; double cappuccinoPrice = 4; double iceTeaPrice = 2;
    JTextArea billTextArea = new JTextArea();
    public Screen(){

        Border border = BorderFactory.createLineBorder(Color.black,3);

        this.setTitle("Restaurant Billing Menu"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application (DO_NOTHING_ON_CLOSE çarpıya bassak da uygulama kapanmaz)
        this.setResizable(false); //prevent frame from being resized
        this.setSize(740,550); //sets the x-dimension, and y-dimension of frame
        this.setLayout(null);
        this.setLocationRelativeTo(null);  //sets the window at center
        this.setLocation(getX(), getY());

        //FF panel
        theFFPanel.setBackground(new Color(0xFA863333, true));
        theFFPanel.setBounds(0, 0, 80, 512);
        theFFPanel.setBorder(border);
        theFFPanel.setLayout(null);

        //FF label
        theFFLabel.setText(("<HTML>T<br>H<br>E<br> <br>F<br>&<br>F</HTML>"));
        theFFLabel.setFont(new Font("Times New Roman", Font.PLAIN ,45));
        theFFLabel.setBounds(25,0,40,512);
        theFFLabel.setForeground(new Color(0xFFFFFFFF, true)); //set font color of text (yazı rengi),

        theFFPanel.add(theFFLabel);

        //Service panel
        theServicePanel.setBackground(new Color(0xFA863333, true));
        theServicePanel.setBounds(649, 0, 75, 512);
        theServicePanel.setBorder(border);
        theServicePanel.setLayout(null);

        //Service label
        theServiceLabel.setText(("<HTML>S<br>E<br>R<br>V<br>I<br>C<br>E</HTML>"));
        theServiceLabel.setFont(new Font("Times New Roman", Font.PLAIN ,45));
        theServiceLabel.setBounds(20,0,40,512);
        theServiceLabel.setForeground(new Color(0xFFFFFFFF, true)); //set font color of text (yazı rengi)

        theServicePanel.add(theServiceLabel);

        // Create a DocumentFilter to restrict input to numbers and a dot
        ((AbstractDocument) hotDogTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) steakTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) hamburgerTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) pizzaTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) mojitoTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) milkshakeTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) cappuccinoTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) iceTeaTextField.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        //FOOD PANEL
        showFoodPanel();

        //FLUID PANEL
        showFluidPanel();

        //SUM PANEL
        showSumPanel();

        //BILL PANEL
        showBillPanel();

        JButton sumButton = new JButton("SUM");
        sumButton.setForeground(new Color(0xFF000000, true));  //yazının rengi
        sumButton.setBackground(Color.white); //butonun arkaplan rengi
        sumButton.setFont(new Font("Ariel",Font.BOLD,15)); //yazı fontu(times new roman vb) , kalın,altıçizili/italik vb., yazı boyutu
        sumButton.setBounds(13,30,100,200);
        sumButton.setFocusable(false);

        JButton billButton = new JButton("BILL");
        billButton.setForeground(new Color(0xFF000000, true));  //yazının rengi
        billButton.setBackground(Color.white); //butonun arkaplan rengi
        billButton.setFont(new Font("Ariel",Font.BOLD,15)); //yazı fontu(times new roman vb) , kalın,altıçizili/italik vb., yazı boyutu
        billButton.setBounds(13,275,100,200);
        billButton.setFocusable(false);

        //the panel that contains SUM , BILL , NEW BILL , CLOSE buttons
        JPanel operationsPanel = new JPanel();
        operationsPanel.setLayout(null);
        operationsPanel.setBounds(520,0,125,512);
        operationsPanel.setBorder(border);
        operationsPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFA863333, true),4));

        operationsPanel.add(sumButton);
        operationsPanel.add(billButton);


        sumButton.addActionListener(e-> handleButtonClick(sumButton));
        billButton.addActionListener(e-> handleButtonClick(billButton));


        this.add(theServicePanel);
        this.add(theFFPanel);
        this.add(foodPanel);
        this.add(fluidPanel);
        this.add(sumPanel);
        this.add(billPanel);
        this.add(operationsPanel);
        this.setVisible(true);

    }
    public void handleButtonClick(JButton button){
        if(button.getText().equals("SUM")){
            try{
                int numberOfHotDogs = Integer.parseInt(hotDogTextField.getText()); int numberOfSteaks = Integer.parseInt(steakTextField.getText());
                int numberOfHamburgers = Integer.parseInt(hamburgerTextField.getText());  int numberOfPizzas = Integer.parseInt(pizzaTextField.getText());
                int numberOfMojitos = Integer.parseInt(mojitoTextField.getText()); int numberOfMilkshakes = Integer.parseInt(milkshakeTextField.getText());
                int numberOfCappuccinos = Integer.parseInt(cappuccinoTextField.getText()); int numberOfIceTeas = Integer.parseInt(iceTeaTextField.getText());

                foodsTotalPrice = hotDogPrice*numberOfHotDogs + hamburgerPrice*numberOfHamburgers + steakPrice*numberOfSteaks + pizzaPrice*numberOfPizzas;
                fluidsTotalPrice = mojitoPrice*numberOfMojitos + milkshakePrice*numberOfMilkshakes + cappuccinoPrice*numberOfCappuccinos + iceTeaPrice*numberOfIceTeas;
                totalPrice = foodsTotalPrice + fluidsTotalPrice;

                foodsPriceTextField.setText("$ " + foodsTotalPrice);
                fluidsPriceTextField.setText("$ " + fluidsTotalPrice);
                totalPriceTextField.setText("$ " + totalPrice);
            }catch (Exception e){

            }

        }else if(button.getText().equals("BILL")){

            billTextArea.setText("");

            Calendar t = Calendar.getInstance();
            t.getTime();
            SimpleDateFormat T = new SimpleDateFormat("HH:mm:ss");
            T.format(t.getTime());
            SimpleDateFormat D = new SimpleDateFormat("dd:MM:yyyy");
            D.format(t.getTime());

            int billID = 111 + (int)(Math.random() * 55);

            billTextArea.append("\n\n" + "  Thanks for visiting\n  ***********************\n  Bill ID: " + billID + "\n\n  Date: " + D.format(t.getTime()) +
                    "\n\n" +  "  Time: " + T.format(t.getTime()) +
                    "\n  ***********************\n  Price for Food: " + foodsPriceTextField.getText() + "\n\n  Price for Fluids: " + fluidsPriceTextField.getText() +
                    "\n\n  Total Bill: " + totalPriceTextField.getText() + "\n  ***********************");


        }
    }
    public void showFoodPanel(){
        //FOOD PANEL
        // Border redBorder = BorderFactory.createLineBorder(new Color(0xFA863333, true));
        foodPanel.setLayout(null);
        foodPanel.setBounds(85,0,210,250);
        foodPanel.setForeground(Color.white);
        foodPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFA863333, true),4));

        //hot dog text label and text field
        //hot dog text label:
        hotDogTextLabel.setText("HOT DOG");
        hotDogTextLabel.setBounds(10,10,75,50);
        hotDogTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        hotDogTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //hot dog text field:
        hotDogTextField.setText("0");
        hotDogTextField.setBounds(120,10,75,46);
        hotDogTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        hotDogTextField.setFont(new Font("Arial", Font.BOLD ,15));


        //STEAK text label and text field
        //STEAK text label:
        steakTextLabel.setText("STEAK");
        steakTextLabel.setBounds(10,60,75,50);
        steakTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        steakTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //STEAK text field:
        steakTextField.setText("0");
        steakTextField.setBounds(120,60,75,46);
        steakTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        steakTextField.setFont(new Font("Arial", Font.BOLD ,15));


        //HAMBURGER text label and text field
        //HAMBURGER text label:
        hamburgerTextLabel.setText("HAMBURGER");
        hamburgerTextLabel.setBounds(10,106,100,50);
        hamburgerTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        hamburgerTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //HAMBURGER text field:
        hamburgerTextField.setText("0");
        hamburgerTextField.setBounds(120,106,75,46);
        hamburgerTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        hamburgerTextField.setFont(new Font("Arial", Font.BOLD ,15));


        //PIZZA text label and text field
        //PIZZA text label:
        pizzaTextLabel.setText("PIZZA");
        pizzaTextLabel.setBounds(10,156,100,50);
        pizzaTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        pizzaTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //PIZZA text field:
        pizzaTextField.setText("0");
        pizzaTextField.setBounds(120,156,75,46);
        pizzaTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        pizzaTextField.setFont(new Font("Arial", Font.BOLD ,15));


        //FOOD text label:
        foodTextLabel.setText("FOOD");
        foodTextLabel.setBounds(68,200,100,50);
        foodTextLabel.setForeground(new Color(0x000000)); //set font color of text (yazı rengi)
        foodTextLabel.setFont(new Font("Arial", Font.BOLD ,25)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //adding components to FOOD PANEL
        foodPanel.add(hotDogTextLabel); foodPanel.add(steakTextLabel); foodPanel.add(hamburgerTextLabel);
        foodPanel.add(pizzaTextLabel) ;foodPanel.add(foodTextLabel); foodPanel.add(hotDogTextField);
        foodPanel.add(steakTextField); foodPanel.add(hamburgerTextField); foodPanel.add(pizzaTextField);
    }
    public void showFluidPanel(){
        //FLUID PANEL
        fluidPanel.setLayout(null);
        fluidPanel.setBounds(85,262,210,250);
        fluidPanel.setForeground(Color.white);
        fluidPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFA863333, true),4));

        //MOJITO text label and text field
        //MOJITO text label:
        mojitoTextLabel.setText("MOJITO");
        mojitoTextLabel.setBounds(10,10,75,50);
        mojitoTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        mojitoTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //MOJITO text field:
        mojitoTextField.setText("0");
        mojitoTextField.setBounds(120,10,75,46);
        mojitoTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        mojitoTextField.setFont(new Font("Arial", Font.BOLD ,15));

        //MILKSHAKE text label and text field
        //MILKSHAKE text label:
        milkshakeTextLabel.setText("MILKSHAKE");
        milkshakeTextLabel.setBounds(10,56,90,50);
        milkshakeTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        milkshakeTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //MILKSHAKE text field:
        milkshakeTextField.setText("0");
        milkshakeTextField.setBounds(120,60,75,46);
        milkshakeTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        milkshakeTextField.setFont(new Font("Arial", Font.BOLD ,15));

        //CAPPUCCINO text label and text field
        //CAPPUCCINO text label:
        cappuccinoTextLabel.setText("CAPPUCCINO");
        cappuccinoTextLabel.setBounds(10,106,100,50);
        cappuccinoTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        cappuccinoTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //CAPPUCCINO text field:
        cappuccinoTextField.setText("0");
        cappuccinoTextField.setBounds(120,106,75,46);
        cappuccinoTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        cappuccinoTextField.setFont(new Font("Arial", Font.BOLD ,15));

        //ICE TEA text label and text field
        //ICE TEA text label:
        iceTeaTextLabel.setText("ICE TEA");
        iceTeaTextLabel.setBounds(10,156,102,50);
        iceTeaTextLabel.setForeground(new Color(0xFA863333)); //set font color of text (yazı rengi)
        iceTeaTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu

        //ICE TEA text field:
        iceTeaTextField.setText("0");
        iceTeaTextField.setBounds(120,156,75,46);
        iceTeaTextField.setHorizontalAlignment(JTextField.CENTER); // Set horizontal alignment to center
        iceTeaTextField.setFont(new Font("Arial", Font.BOLD ,15));


        //FLUID text label:
        fluidTextLabel.setText("FLUID");
        fluidTextLabel.setBounds(68,200,100,50);
        fluidTextLabel.setForeground(new Color(0x000000)); //set font color of text (yazı rengi)
        fluidTextLabel.setFont(new Font("Arial", Font.BOLD ,25)); //yazı fontu(times new roman) , altıçizili/italik vb. , yazı boyutu


        //adding components to FLUID PANEL
        fluidPanel.add(mojitoTextLabel); fluidPanel.add(mojitoTextField); fluidPanel.add(milkshakeTextField);
        fluidPanel.add(milkshakeTextLabel) ;fluidPanel.add(cappuccinoTextLabel); fluidPanel.add(cappuccinoTextField);
        fluidPanel.add(iceTeaTextLabel); fluidPanel.add(iceTeaTextField); fluidPanel.add(fluidTextLabel);

    }
    public void showSumPanel(){
        //sum panel
        sumPanel.setLayout(null);
        sumPanel.setBounds(300,0,210,160);
        sumPanel.setForeground(Color.white);
        sumPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFA863333, true),4));

        //foods price text label and text field:
        foodsPriceTextLabel.setText("FOOD'S PRICE");
        foodsPriceTextLabel.setForeground(new Color(0xFA863333, true));
        foodsPriceTextLabel.setBounds(10,20,120,20);
        foodsPriceTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //text field yazı tipi,şekli,sizeı

        foodsPriceTextField.setText("0");
        foodsPriceTextField.setBounds(130,10,60,40);
        foodsPriceTextField.setHorizontalAlignment(JTextField.CENTER); //text fielda yazılanlar ortalanarak yazılır
        foodsPriceTextField.setFont(new Font("Arial", Font.BOLD ,15)); //text field yazı tipi,şekli,sizeı
        foodsPriceTextField.setEditable(false); foodsPriceTextField.setFocusable(false);

        //fluids price text label and text field:
        fluidsPriceTextLabel.setText("FLUID'S PRICE");
        fluidsPriceTextLabel.setForeground(new Color(0xFA863333, true));
        fluidsPriceTextLabel.setBounds(10,70,120,20);
        fluidsPriceTextLabel.setFont(new Font("Arial", Font.BOLD ,15)); //text field yazı tipi,şekli,sizeı

        fluidsPriceTextField.setText("0");
        fluidsPriceTextField.setBounds(130,60,60,40);
        fluidsPriceTextField.setHorizontalAlignment(JTextField.CENTER); //text fielda yazılanlar ortalanarak yazılır
        fluidsPriceTextField.setFont(new Font("Arial", Font.BOLD ,15)); //text field yazı tipi,şekli,sizeı
        fluidsPriceTextField.setEditable(false); fluidsPriceTextField.setFocusable(false);

        //sum price text label and text field:
        sumPriceTextLabel.setText("TOTAL PRICE");
        sumPriceTextLabel.setForeground(new Color(0xFF000000, true));
        sumPriceTextLabel.setBounds(10,116,120,20);
        sumPriceTextLabel.setFont(new Font("Arial", Font.BOLD ,17)); //text field yazı tipi,şekli,sizeı

        totalPriceTextField.setText("0");
        totalPriceTextField.setBounds(130,106,60,40);
        totalPriceTextField.setHorizontalAlignment(JTextField.CENTER); //text fielda yazılanlar ortalanarak yazılır
        totalPriceTextField.setFont(new Font("Arial", Font.BOLD ,15)); //text field yazı tipi,şekli,sizeı
        totalPriceTextField.setEditable(false); totalPriceTextField.setFocusable(false);


        sumPanel.add(foodsPriceTextLabel); sumPanel.add(foodsPriceTextField); sumPanel.add(fluidsPriceTextLabel); sumPanel.add(fluidsPriceTextField);
        sumPanel.add(sumPriceTextLabel); sumPanel.add(totalPriceTextField);


    }
    public void showBillPanel(){
        //BILL PANEL:
        billPanel.setLayout(null);
        billPanel.setBorder(BorderFactory.createLineBorder(new Color(0xFA863333, true),4));//çerçevenin kalınlığını da belirtebiliriz bu kodla
        billPanel.setBounds(300,170,210,342);

        billTextArea.setBounds(5,5,200,330);
        billTextArea.setFont(new Font("Monospaced", Font.BOLD ,12)); //text field yazı tipi,şekli,sizeı

        billPanel.add(billTextArea);

    }

    public static void main(String[] args) {

        try {
            // Use either light or dark theme
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        new Screen();
    }
}

//creating the class for the text fields to accept only number or dots
class NumericDocumentFilter extends DocumentFilter {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
        sb.insert(offset, text);

        if (isValid(sb.toString())) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, text);

        if (isValid(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValid(String input) {
        return input.matches("[0-9]*\\.?[0-9]*");
    }
}
