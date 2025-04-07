
/**
 * Write a description of class Accounts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Account
{
    public String accountNumber;
    public String accountType;
    public double currentBalance;
    
    public Account(){ 
        currentBalance = 0; //initialize balance at 0
    }
    
    public void Withdraw(double withdrawlAmount){ //Create withdrawl function, subtract from current balance
        boolean successfulWithdrawl = true;
        if (accountType == "Current Account" && currentBalance-withdrawlAmount > -1000 
        && withdrawlAmount < 5000.01){
            successfulWithdrawl = true;
        } 
        
        if (accountType != "Current Account" && currentBalance-withdrawlAmount < 0 && withdrawlAmount < 5000.01){
            successfulWithdrawl = true;
        }
        
        if (successfulWithdrawl){
            currentBalance -= withdrawlAmount;
        
            System.out.println("Withdrawl of $" + withdrawlAmount + " was successful!");
            System.out.println("New balance is $" + displayBalance());
        } else {
            System.out.println("Withdrawl unsuccessful");
        }
    }
        
        public void Deposit(double depositAmount){ //Create deposit function, add to currentbalance
        currentBalance += depositAmount;
        
        System.out.println("deposit of $" + depositAmount + " was successful!");
        System.out.println("New balance is $" + displayBalance());
    }
    
    public double displayBalance(){  
        return currentBalance;
    }
    
    public void everydayAccount() {
        this.accountType = "Everyday Account";
    }
    
    public void savingsAccount(){
        this.accountType = "Savings Account";
    }
    
    public void currentAccount() {
        this.accountType = "Current Account";
    }
    
    public static Account createAccount(){
        Scanner keyboard = new Scanner(System.in);
                
        System.out.println("Input account number");
        Account account1 = new Account();  
        //account1.accountNumber = keyboard.nextLine();
        String accountNumberInput = keyboard.nextLine(); //User inputs account number
        
        System.out.println("Select an option for account type."); //Switch statement to select different account types
        System.out.println("(1) - Everyday"); 
        System.out.println("(2) - Savings"); 
        System.out.println("(3) - Current");
        
        if(keyboard.hasNextInt()){
            int choice = keyboard.nextInt(); //checks if the input is a number
            keyboard.nextLine(); //clear the enter
            if (choice != 1 && choice != 2 && choice != 3){
                System.out.println("Please enter a valid input"); //if the input is not equal to 1, 2, or 3, print out invalid
            } else {
                switch (choice){
                    case 1: //Everyday   
                        System.out.println("Everyday");
                        account1.everydayAccount(); //if "Everyday" is selected, account type is set to Everyday
                        break;
            
                    case 2: //Savings
                        System.out.println("Savings"); 
                        account1.savingsAccount(); //if "Savings" is selected, account type is set to Savings
                        break;
                
                    case 3: //Current
                        System.out.println("Current");
                        account1.currentAccount(); //if "Current" is selected, account type is set to Current
                        break;
                }
            }
            } else {
                System.out.println("Input must be a number"); //if the input is not equal to a number print out invalid
        }
        account1.accountNumber = accountNumberInput;
        return account1;  
    }
}