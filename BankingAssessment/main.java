/**
 * Write a description of class main here.
 *
 * Harvey Chamberlain
 * 25/3/2025
 */
import java.io.File;;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class main
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<Customer> customerList = new ArrayList<Customer>(); //Create arraylist to store customer info during the day
        customerList.add(createCustomer()); //add new customer to the arraylist
        //System.out.println(customerList.get(0).Name);          
        customerList.get(0).addCustomerAccount(createAccount());
        
        System.out.println(customerList.get(0).accountList.get(0).accountType);
        System.out.println(customerList.get(0).accountList.get(0).displayBalance());
        customerList.get(0).accountList.get(0).Deposit(10.0);
        System.out.println(customerList.get(0).accountList.get(0).displayBalance());
        customerList.get(0).accountList.get(0).Withdraw(5.0);
        System.out.println(customerList.get(0).accountList.get(0).displayBalance());
        
        boolean running = true;
        File myFile = new File("bankData.csv");
        
        
        // try { 
            // FileWriter myWriter = new FileWriter(myFile);
            // myWriter.write(keyboard.nextLine());  
            
            // myWriter.flush();  
            // myWriter.close();
        // } catch(IOException e) {
            // System.out.println(e);
            // System.out.println("There was an error writing to the file");
        // }
        
        try {
            Scanner myReader = new Scanner(myFile);
            ArrayList<String> fileNames = new ArrayList<String>();
            
            while(myReader.hasNextLine()){
                myReader.useDelimiter(","); //seperates the informaion in the file by comma
                 while (myReader.hasNext()) {
                    fileNames.add(myReader.next());
                }
            }

            //build customer
            for (int i=0; i<fileNames.size(); i++){
                System.out.println(fileNames.get(i));
            }
            
            Customer fileCustomer = new Customer(); 
            fileCustomer.Name = fileNames.get(0); //gets each element of the arrayList startring from 0
            fileCustomer.Address = fileNames.get(1);
            
            Account fileAccount = new Account();
            fileAccount.accountNumber = fileNames.get(2);
            fileAccount.accountType = fileNames.get(3);
            Double accountBalance = Double.parseDouble(fileNames.get(4)); //converts the string to a double so that the maths in the account class works for the balance
            fileAccount.currentBalance = accountBalance;
            
            fileCustomer.addCustomerAccount(fileAccount);
            
            customerList.add(fileCustomer); //add the customer in the file to the customerList arraylist    
        } catch(IOException e) {
            System.out.println(e);
            System.out.println("There was an error reading from the file");
        }
        
        while(running){
            
        }
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
    
    public static Account createAccount(){ //this method is to create accounts with a number and type.
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Input account number");
        Account account1 = new Account();   
        account1.accountNumber = keyboard.nextLine();
        
        System.out.println("Select an option for account type"); //Switch statement to select different account types
        System.out.println("(1) - Everyday"); 
        System.out.println("(2) - Savings"); 
        System.out.println("(3) - Current");
        
        int choice = keyboard.nextInt();
        
        switch (choice){
            case 1: //Everyday   
                System.out.println("Everyday");
                EverydayAccount everyday = new EverydayAccount();
                account1 = everyday;
                break;
            
            case 2: //Savings
                System.out.println("Savings"); 
                break;
                
            case 3: //Current
                System.out.println("Current");
                break;
        }
        return account1;
    }
}
