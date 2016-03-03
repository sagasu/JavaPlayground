package haMap;

import java.util.Date;
import java.util.WeakHashMap;

public class WeakHaMap {
    public static void main(String[] args){
        WeakHashMap<Person, PersonMetaData> whm = new WeakHashMap<Person, PersonMetaData>();
        Person m = new Person();
        whm.put(m, new PersonMetaData());

        PersonMetaData p  = whm.get(m);
        System.out.println(p);

        m = null;
        System.gc();

        if(whm.containsValue(p)){
            System.out.println("Still contains key");
        }else{
            System.out.println("key is gone");
        }
    }
}

final class Person{}

class PersonMetaData {
    Date date;

    PersonMetaData(){
        date = new Date();
    }

    @Override
    public String toString(){
        return "PersonMetaData {" +
                "date=" + date +
                "}";
    }
}