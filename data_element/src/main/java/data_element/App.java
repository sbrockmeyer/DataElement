package data_element;
import java.io.*;  
import java.util.Scanner; 


public final class App {
    public class Person {
        String name;
        String phone;
    }
    
    private App() {
    }

    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner (new File("data_element/people-2.to.regex.csv"));
        sc.useDelimiter(",");
        while(sc.hasNext()){
            //System.out.println(sc.next());

        }
        sc.close();
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
