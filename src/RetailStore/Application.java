package Chapter7.RetailStore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Application {

    private static final Scanner input = new Scanner(System.in);
    private static final Date date = new Date();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static double subTotal = 0;
    private static double discounts;
    static String [] names = new String[10];

    static double payment;
    static ArrayList<String> items = new ArrayList<>();
    static ArrayList<Double> quantities = new ArrayList<>();
    static ArrayList<Double> costs = new ArrayList<>();


    public static void eRetailStore(){
        customerName();
        takingOrders();
        generateInvoice();
        footer();

    }

    public static String getInput(){
        return input.nextLine();
    }

    public static double getInt(){
        return input.nextDouble();
    }

    public static void customerName(){

        System.out.println("Whats the Customer Name: ");
        names[0] = getInput();

    }
    public static void takingOrders(){
        System.out.println("What did the customer buy: ");
        items.add(getInput());

        System.out.println("How many pieces: ");
        quantities.add(getInt());

        System.out.println("How Much per Unit: ");
        costs.add(getInt());

        addMoreItems();
    }

    public static void addMoreItems(){
        System.out.println("Add More Items: ");
        getInput();

        switch (getInput()) {
            case "Yes" -> takingOrders();
            case "No" -> cashierInfo();
        }
    }

    public static void cashierInfo(){
        System.out.println("What is your Name: ");
        names[1] = getInput();

        System.out.println("How much discount will he get: ");
        discounts = getInt();
    }

    public static void generateInvoice() {
        System.out.printf("%n%s%n%s%n%s%n%s%n",
                "Stop n Shop",
                "Main Branch",
                "Location: Freedom Way, Freedom Estate, Lagos State",
                "Tel: +234(0) 806 958 0949");

        System.out.println(dateFormat.format(date));
        System.out.printf("Cashier Name: %s%n", names[1]);
        System.out.printf("Customer Name: %s%n", names[0]);
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n%30s%10s%10s%15s%n",
                "ITEM", "QTY", "Price", "Total(NGN)");
        System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - %n");

        for (int index = 0; index < costs.size(); index++) {
            double total = quantities.get(index) * costs.get(index);
            subTotal += total;
            System.out.printf("%30s%10.2f%10.2f%15.2f%n", items.get(index), quantities.get(index), costs.get(index), total);
        }

        System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - %n");
        System.out.printf("%50s%15.2f%n%50s%15.2f%n%50s%15.2f%n" ,"Sub-Total" ,subTotal , "Discount" ,calculateDiscount() , "VAT@ 17.5%" , calculateVAT());
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =%n");

        System.out.printf( "%50s%15.2f%n" ,"Bill Total: " , finalBill());
    }
    public static void footer(){
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =%n%n");
        System.out.printf("%50s%15.2f%n" ,"THIS IS NOT A RECEIPT KINDLY PAY:" , finalBill());
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =%n%n");

        System.out.println("How much did the customer Pay: ");
        payment = input.nextInt();
        if (payment >= finalBill()) {
            generateReceipts();
        }
        else {
            System.out.println("Please Make a Valid payment Equal or More than the amount Charged");
            generateInvoice();
        }
    }

    public static double setBillTotal(){

        return subTotal - calculateDiscount();
    }

    public static double finalBill(){
        return setBillTotal() + calculateVAT();

    }
    public static double calculateVAT(){
        return (17.50 / 100) * subTotal;
    }

    public static double calculateDiscount(){
        double discountPrice;
        discountPrice = discounts /100 * subTotal;
        return discountPrice;
    }

    public static double balancePayment(){
        double balance;
        balance = payment - finalBill();
        return balance;
    }
    public static void generateReceipts(){
        System.out.printf("%n%s%n%s%n%s%n%s%n",
                "Stop n Shop",
                "Main Branch",
                "Location: Freedom Way, Freedom Estate, Lagos State",
                "Tel: +234(0) 806 958 0949");

        System.out.println(dateFormat.format(date));
        System.out.printf("Cashier Name: %s%n", names[1]);
        System.out.printf("Customer Name: %s%n", names[0]);
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n%30s%10s%10s%15s%n",
                "ITEM", "QTY", "Price", "Total(NGN)");
        System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - %n");

        for (int index = 0; index < costs.size(); index++) {
            double total = quantities.get(index) * costs.get(index);

            System.out.printf("%30s%10.2f%10.2f%15.2f%n", items.get(index), quantities.get(index), costs.get(index), total);
        }

        System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - %n");
        System.out.printf("%50s%15.2f%n%50s%15.2f%n%50s%15.2f%n" ,"Sub-Total" ,subTotal , "Discount" ,calculateDiscount() , "VAT@ 17.5%" , calculateVAT());
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =%n");

        System.out.printf( "%50s%15.2f%n" ,"Bill Total: " , finalBill());

        System.out.printf("%50s%15.2f%n" , "Amount Paid: " , payment);
        System.out.printf("%50s%15.2f%n","Balance: " ,  balancePayment());
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =%n%n");
        System.out.printf("%50s%n%n" , "THANKS FOR YOUR PATRONAGE");
        System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =%n%n");
    }
}
