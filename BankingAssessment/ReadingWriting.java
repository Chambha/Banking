
/**
 * Write a description of class ReadingWriting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingWriting
{
    public void writeFile(ArrayList<Customer> customerList, String myFile){
        
        FileWriter myWriter = new FileWriter(myFile);
            //myWriter.write(keyboard.nextLine());  
            
            //write the customerList information into a file
            for (Customer fileCustomer : customerList){ 
                for (Account fileAccount : fileCustomer.accountList){
                    myWriter.write("," + fileCustomer.Name + "," + fileCustomer.Address + "," + fileAccount.accountNumber + "," + fileAccount.accountType + "," + fileAccount.currentBalance);
                }
            }
        
            myWriter.flush();  
            myWriter.close();
    }
}
