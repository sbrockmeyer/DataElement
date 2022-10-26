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
    }
    
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */

    public static void main(String[] args) throws Exception{

        String line ="";
        String splitBy = ",";
        String[] person;

        try{
            BufferedReader br = new BufferedReader(new FileReader("data_element/people-2.to.regex.csv"));
            while((line = br.readLine()) != null){
                person = line.split(splitBy);
                isValid(person[0]);
                // System.out.println(person[3]);
                // System.out.println("Person [First and Last name = " + person[0] + ", Phone Number = " + person[3]);
            }
        
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }

    public static boolean isValid(String regex) {
        if (regex == null) {
            return false;
        }

        // System.out.println(regex2);

        // String thing = regex + " " + regex2;

        
        String regexString = "([A-Z][a-zA-Z-.']* *)+|[0-9]{3}-[0-9]{3}-[0-9]{4}";
        // System.out.println(thing.matches(regexString));
        // System.out.println(thing.matches(regexString));
        System.out.println(regex.matches(regexString));
        return regex.matches(regexString);
    }
    

}
