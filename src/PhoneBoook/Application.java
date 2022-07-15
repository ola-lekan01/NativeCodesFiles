package Chapter7.PhoneBoook;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static final Scanner input = new Scanner(System.in);

    static ArrayList<String> names = new ArrayList<>();

    static ArrayList<String> addresses = new ArrayList<>();
    static ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> tel = new ArrayList<>();


    public static void contactBook(){
        name();
        address();
        telephone();
        email();
        saveContact();
    }

    public static void addNew(){
        name();
        address();
        telephone();
        email();
        saveContact();
        addNewContact();
    }

    public static String getUserInput(){
        return input.nextLine();
    }

    public static void name(){
        System.out.println("Name: ");
        names.add(getUserInput());
    }
    static void address(){
        System.out.println("Address: ");
        addresses.add(getUserInput());
    }

    public static void email(){
        System.out.println("Email: ");
        emails.add(getUserInput());
    }

    public static void telephone() {
        System.out.println("Enter Phone Number: ");
        tel.add(getUserInput());
    }
    public static void saveContact(){
        System.out.println("Press Yes to save contact to Memory");

        switch (getUserInput()) {
            case "Yes" -> {
                System.out.println("Contact saved Successfully");
                addNewContact();
            }
            default -> {
                System.out.println("Contact Not yet Saved, Please try again");
                saveContact();
            }
        }
    }


    public static void addNewContact(){
        System.out.println("Press Yes to Add a New Contact to phone Memory or No to Proceed: ");
        switch (getUserInput()) {
            case "Yes" -> addNew();
            default -> printContact();
        }
    }

    public static void printContact() {

        for (int index = 0; index < names.size() ; index++){
            System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n");

            System.out.printf(" Name: %s%n " , names.get(index));
            System.out.printf("Address: %s%n " , addresses.get(index));
            System.out.printf("Telephone: %s%n " , tel.get(index));
            System.out.printf("Email: %s%n " , emails.get(index));

            System.out.printf("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = %n%n");

        }
    }
}
