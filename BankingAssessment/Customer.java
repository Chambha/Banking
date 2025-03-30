
/**
 * Write a description of class Info here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

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
}
