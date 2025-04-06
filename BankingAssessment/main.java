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
import java.util.Arrays;
import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<Customer> customerList = new ArrayList<Customer>(); //Create arraylist to store customer info during the day
        
        boolean running = true;
        File myFile = new File("bankData.csv");
        
        try {
            Scanner myReader = new Scanner(myFile);            
            
            while(myReader.hasNextLine()){
                
                
                
                String data = myReader.nextLine();
                List<String> fileNames = Arrays.asList(data.split(","));
                
                Customer fileCustomer = new Customer(); 
                fileCustomer.Name = fileNames.get(0); //gets each element of the arrayList startring from 0
                fileCustomer.Address = fileNames.get(1);
                
                Account fileAccount = new Account();
                fileAccount.accountNumber = fileNames.get(2);
                fileAccount.accountType = fileNames.get(3);
                Double accountBalance = Double.parseDouble(fileNames.get(4)); //converts the string to a double so that the maths in the account class works for the balance
                fileAccount.currentBalance = accountBalance;
            
                fileCustomer.addCustomerAccount(fileAccount);
            
                customerList.add(fileCustomer); //add the customer in the file to the customerList arraylist so that any existing customers can have their info updated   
                
            }
            myReader.close();
            //build customer
            //for (int i=0; i<fileNames.size(); i++){
                //System.out.println(fileNames.get(i));
            //}

        } catch(IOException e) {
            System.out.println(e);
            System.out.println("There was an error reading from the file");
        }
        
        System.out.println("Welcome! would you like to:"); //prompt user to select a function
        System.out.println("(1) - Create account for a new customer"); 
        System.out.println("(2) - Create account for existing customer"); 
        System.out.println("(3) - Close account for existing customer");
        System.out.println("(4) - Access balance of an account");
        System.out.println("(5) - Deposit/withdraw from an account");
        
        if(keyboard.hasNextInt()){
            int selectOption = keyboard.nextInt(); //checks if the input is a number
            keyboard.nextLine(); //clear the enter
            if (selectOption != 1 && selectOption != 2 && selectOption != 3 && selectOption != 4 && selectOption != 5){
                System.out.println("Please enter a valid input"); //if the input is not equal to 1, 2, 3, 4, or 5 print out invalid
            } else {
                switch (selectOption){
                    case 1: 
                        //System.out.println("test1");
                        Customer newCustomer = Customer.createCustomer();
                        Account newAccount = Account.createAccount();
                        newCustomer.addCustomerAccount(newAccount);
                        customerList.add(newCustomer);
                        System.out.println("Account successfully created for " + newCustomer.Name + "!");
                        break;
                        
                    case 2: 
                        System.out.println("Enter the name of the customer you wish to open a new account for:"); 
                        String customerSearch = keyboard.nextLine(); //Search for customer 
                        
                        Customer existingCustomer = new Customer(); //Copy existing customer so that all customer names have one account
                        
                        for (Customer customer : customerList){ 
                            if(customer.Name.equals(customerSearch.trim())){
                                System.out.println("Customer " + customerSearch + " found, input new account details:");
                                
                                existingCustomer.Name = customer.Name;
                                existingCustomer.Address = customer.Address;
                                break; 
                            }
                        }
                        
                        Account existingCustomerNewAccount = Account.createAccount(); //Create a new account for existing customer
                        existingCustomer.accountList.add(existingCustomerNewAccount); //add new account to existing customer 
                        customerList.add(existingCustomer); //add customer to customer list
                        break;
                        
                    case 3:
                        System.out.println("test3");
                        break;
                        
                    case 4: 
                        System.out.println("Enter the customers name you would like to access balance for");
                        customerSearch = keyboard.nextLine(); //Search for customer 
                        for (Customer customer : customerList){ 
                            if(customer.Name.equals(customerSearch.trim())){
                                //in accountList, get the first account in the arrayList and print the balance of it
                                System.out.println("Customer " + customerSearch + " balance is $" + customer.accountList.get(0).displayBalance()); 
                                break; 
                            }
                        }
                        
                        break;
                        
                    case 5:
                        System.out.println("Enter the customers name that you would like to deposit/withdraw money for");
                        customerSearch = keyboard.nextLine(); //Search for customer 
                        System.out.println("Enter the customers account number");
                        String customerAccountSearch = keyboard.nextLine();
                        for (Customer customer : customerList){ 
                            if(customer.Name.equals(customerSearch.trim()) 
                            && customer.accountList.get(0).accountNumber.equals(customerAccountSearch)){
                                //in accountList, get the first account in the arrayList and print the balance of it
                                System.out.println("Customer " + customerSearch + " found");
                                System.out.println("Would you like to:");
                                System.out.println("(1) - Deposit");
                                System.out.println("(2) - Withdraw");
                                
                                int depositOrWithdraw = keyboard.nextInt();
                                
                                keyboard.nextLine();
                                if(depositOrWithdraw != 1 && depositOrWithdraw != 2){
                                    System.out.println("Please enter a valid input");
                                } else {
                                    switch(depositOrWithdraw){
                                        case 1: //deposit
                                        System.out.println("Enter the amount you would like to deposit:");
                                        double depositMoney = keyboard.nextDouble();
                                        customer.accountList.get(0).Deposit(depositMoney);
                                        
                                        case 2: //withdraw
                                        System.out.println("Enter the amount you would like to withdraw:");
                                    }
                                }
                                break; //add this outside the loop for test (2 lines down)
                        }
                        
                }
            }
        }
        }else {
                System.out.println("Input must be a number"); //if the input is not equal to a number print out invalid
        }
        
        
        //customerList.add(createCustomer()); //add new customer to the arraylist
        //System.out.println(customerList.get(0).Name);          
        //customerList.get(0).addCustomerAccount(Account.createAccount());
        
        try { 
            FileWriter myWriter = new FileWriter(myFile);
            //myWriter.write(keyboard.nextLine());  
            
            //write the customerList information into a file
            for (Customer fileCustomer : customerList){ 
                for (Account fileAccount : fileCustomer.accountList){
                    myWriter.write(fileCustomer.Name + "," + fileCustomer.Address + "," + fileAccount.accountNumber + "," + 
                    fileAccount.accountType + "," + fileAccount.currentBalance + "," + "\n");
                }
            }
        
            myWriter.flush();  
            myWriter.close();
            
        } catch(IOException e) {
            System.out.println(e);
            System.out.println("There was an error writing to the file");
        }
        
        while(running){
            
        }
    }
    
    // public static Customer createCustomer(){ //this method prompts the user to input customer information to add the customer to the system
        // Scanner keyboard = new Scanner(System.in);
        
        // System.out.println("Input customer full name"); //prompt user to input customer name
        // Customer customer1 = new Customer();
        // customer1.Name = keyboard.nextLine(); //sets the name as the user input 
        
        // System.out.println("Input customer address"); //prompt user to input customer address 
        // customer1.Address = keyboard.nextLine(); //sets the address as the user input
        
        // return customer1;
    // }
}


