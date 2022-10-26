package data_element;
import java.io.*;  
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

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
        System.out.println("Hello World!");
        Scanner sc = new Scanner (new File("data_element/people-2.to.regex.csv"));
        sc.useDelimiter(",");
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
            br.close();
        sc.close();
    }
    
  
    public boolean isPhoneNumber(String maybePhone) {
        // String hardCode = "123-456-7890";
        if (maybePhone == null) {
            return false;
        }
        String regexString = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
        return maybePhone.matches(regexString);
    }
    public boolean isName(String maybeName){
        if (maybeName == null){
            return false;
        }
        String regex = "([A-Z][a-zA-Z-.']* *)+";
        return maybeName.matches(regex);
    }

}
