package PhoneNumber;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by guangzhouzeng on 2/12/16.
 */
public class PhoneNumberProvider {
    private HashSet<String> regNum;
    private HashSet<String> unregNum;

    PhoneNumberProvider(){
        regNum = new HashSet<>();
        unregNum = new HashSet<>();

        for(int i = 0; i < Math.pow(10, 3); i++){
            for(int j = 0; j < Math.pow(10, 3); j++){
                unregNum.add(createNum(i, j));
            }
        }
    }

    void registerNumber(String number){
        if(isNumberRegistered(number)){
            System.out.println(number + " Already used");
            return;
        }
        if(regNum.add(number) && regNum.contains(number)){
            System.out.println("add " + number + " to Register success!");
        }
        if(unregNum.remove(number) && !unregNum.contains(number)){
            System.out.println("remove " + number + " from Unregister success!");
        }
        System.out.println("registered: " + number);
    }

    void registerNumber(){
        String number = getAvailableNumber();

        if(regNum.add(number) && regNum.contains(number)){
            System.out.println("add " + number + " to Register success!");
        }
        if(unregNum.remove(number) && !unregNum.contains(number)){
            System.out.println("remove " + number + " from Unregister success!");
        }
        System.out.println("registered: " + number);

    }

    void unregisterNumber(String number){
        if(!isNumberRegistered(number)){
            System.out.println("No such number: " + number);
            return;
        }
        regNum.remove(number);
        unregNum.add(number);
        System.out.println("unregistered: " + number);
    }

    boolean isNumberRegistered(String number){
        return regNum.contains(number);
    }

    String getAvailableNumber(){
        Iterator<String> it = unregNum.iterator();
        return it.hasNext() ? it.next() : "fail";
    }

    boolean checkSystemValid(){
        return regNum.size() + unregNum.size() == 1000000;
    }

    private String createNum(int i, int j){
        StringBuilder areaCode = new StringBuilder(String.valueOf(i));
        StringBuilder number = new StringBuilder(String.valueOf(j));
        while(areaCode.length() < 3) areaCode.insert(0, '0');
        while(number.length() < 3) number.insert(0, '0');
        return areaCode.toString() + number.toString();
    }

    public static void main(String[] args){
        PhoneNumberProvider att = new PhoneNumberProvider();
        att.registerNumber("123456");
        System.out.println("---------------------");
        att.registerNumber("123456");
        System.out.println("---------------------");
        att.registerNumber("678901");
        System.out.println("---------------------");
        att.registerNumber();
        System.out.println("---------------------");
        att.registerNumber();
        System.out.println("---------------------");
        att.registerNumber();
        System.out.println("---------------------");
        att.registerNumber();
        System.out.println("---------------------");
        att.registerNumber();
        System.out.println("---------------------");
        att.unregisterNumber("123456");
        System.out.println("---------------------");
        att.unregisterNumber("123456");

        System.out.println(att.checkSystemValid());
    }
}
