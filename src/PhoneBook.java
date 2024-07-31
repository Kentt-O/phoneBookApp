import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class PhoneBook {
    private static ArrayList<String []> myPhoneBook = new ArrayList<>();
        public static void main(String[] args) {
            mainMenu();
    }

    private static void mainMenu(){
            String prompt = """
                    1 -> Add contact
                    2 -> Remove contact
                    3 -> Search contact by phone number
                    4 -> Search contact by first name
                    5 -> Search contact by last name
                    6 -> View all contact
                    7 -> Exit program
                    """;
            String userResponse = input(prompt);
            switch(userResponse){
                case "1" -> addContact();
                case "2" -> removeContact();
                case "3" -> searchContactByPhoneNumber();
                case "4" -> searchContactByfirstName();
                case "5" -> searchContactBylastName();
                case "6" -> viewAllContact();
                case "7" -> System.exit(77);
                default -> mainMenu();

            }

    }
    private static void checkAllContact(){
        for(String [] contact : myPhoneBook){
            displayArray(contact);
        }
    }

    private static void displayArray(String[] prompt){
        System.out.println(Arrays.toString(prompt));
    }

    private static void addContact(){
        String firstName = input("Enter first name");
        String lastName = input("Enter last name");
        String phoneNumber = input("Enter phone number");
        String[] newContact = new String[]{firstName, lastName, phoneNumber};

        validateContactBeforeStoring(newContact);
        myPhoneBook.add(newContact);
        mainMenu();

    }

    private static void validateContactBeforeStoring(String [] validatingContact){
            String phoneNumber = validatingContact[2];
            String found = "false";
            for(String [] contact : myPhoneBook){
                for (String element : contact){
                    if(element.equals(phoneNumber)){
                        found = "true";
                    }
                }
            }
            if(found.equals("true"))addContact();
    }

    private static void removeContact(){
        String contactToBeRemoved = input("Enter the contact you wish to remove");
        for (String[] contact : myPhoneBook){
            for (String element : contact){
                if(contactToBeRemoved.equals(contactToBeRemoved))myPhoneBook.remove(contact);
            }
            break;
        }
        mainMenu();
    }
    private static void searchContactByPhoneNumber(){
        String collectPhoneNumber = input("Enter the phone number to search for");
        for(String[] contact : myPhoneBook){
            for(String element : contact){
                if(element.equals(collectPhoneNumber)){
                    displayArray(contact);
                }
            }
        }
    }
    private static void  searchContactByfirstName(){
        String collectContactFirstName = input("Enter first name");
        for (String[] contact : myPhoneBook){
            for (String element : contact){
                if(element.equals(collectContactFirstName)){
                    displayArray(contact);
                }
            }
        }
        mainMenu();
    }
    private static void searchContactBylastName(){
        String collectContactLastName = input("Enter last name");
        for (String[] contact: myPhoneBook){
            for(String element: contact){
                if (element.equals(collectContactLastName)){
                    displayArray(contact);
                }
            }
        }
        mainMenu();
    }
    private static void viewAllContact(){
        checkAllContact();
    }
    private static String input(String prompt){
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }

}
