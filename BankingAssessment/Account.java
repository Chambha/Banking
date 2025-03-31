
/**
 * Write a description of class Accounts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Account
{
    public String accountNumber;
    public String accountType;
    public double currentBalance;
    
    public Account(){ 
        currentBalance = 0; //initialize balance at 0
    }
    
    public void Withdraw(double withdrawlAmount){ //Create withdrawl function, subtract from current balance
        currentBalance -= withdrawlAmount;
    }
    
    public void Deposit(double depositAmount){ //Create deposit function, add to currentbalance
        currentBalance += depositAmount;
    }
    
    public double displayBalance(){  
        return currentBalance;
    }
}