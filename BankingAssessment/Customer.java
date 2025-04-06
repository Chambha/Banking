
/**
 * Write a description of class Info here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Customer
{
    public String Name;
    public String Address;
    public ArrayList<Account> accountList = new ArrayList<Account>();
    
    public Customer(){
        
    }
    
    public void addCustomerAccount(Account account){
        accountList.add(account);
    }
    
    public static Customer createCustomer(){ //this method prompts the user to input customer information to add the customer to the system
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Input customer full name"); //prompt user to input customer name
        Customer customer1 = new Customer();
        customer1.Name = keyboard.nextLine(); //sets the name as the user input 
        
        System.out.println("Input customer address"); //prompt user to input customer address 
        customer1.Address = keyboard.nextLine(); //sets the address as the user input
        
        return customer1;
    }
}
