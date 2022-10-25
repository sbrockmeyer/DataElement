package data_element;
import java.io.*;  
import java.util.Scanner;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.exceptions.CsvException; 

/**
 * Hello world!
 */
public final class App {
    public class Person{

        @CsvBindByPosition(position = 0)
        String name;

        @CsvBindByPosition(position = 3)
        String phone;
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return super.toString();
        }
    }
    
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");

        String line ="";
        String splitBy = ",";

        // Scanner sc = new Scanner (new File("data_element/people-2.to.regex.csv"));
        // sc.useDelimiter(",");
        // while(sc.hasNext()){
        //     System.out.println(sc.next());
        // }
        // sc.close();

        try{
            BufferedReader br = new BufferedReader(new FileReader("data_element/people-2.to.regex.csv"));
            while((line = br.readLine()) != null){
                String[] person = line.split(splitBy);
                System.out.println("Person [First and Last name = " + person[0] + ", Phone Number = " + person[3]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
    public static boolean isPhoneNumber(String maybePhone) {
        // String hardCode = "123-456-7890";
        if (maybePhone == null) {
            return false;
        }
        String regexString = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
        return maybePhone.matches(regexString);
    }
    public static boolean isName(String maybeName){
        if (maybeName == null){
            return false;
        }
        String regex = "([A-Z][a-zA-Z-.']* *)+";
        return maybeName.matches(regex);
    }

}
