import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTutorial {
    public static void main(String[] args) {
        List<String> names =new ArrayList<>();
        names.add("Ramazan");
        names.add("Don");
        names.add("Alekhya");
        names.add("Ram");
        names.add("Adam");

        long b=names.stream().filter(s->s.startsWith("A")).count();
                System.out.println(b);
                names.stream().forEach(a-> System.out.println(a));
                names.stream().filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
      
               Stream.of("Ramna","ali");
               
    }
    @Test
    public void streamCollect(){
      List<String>ls=  Stream.of("Ramazan","Dob","Alekya","adaM","rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));


        //print unique number
        // sort the array -3 rd index

        List<Integer> values= Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer>li=values.stream().distinct().sorted().collect(Collectors.toList());
            // distinct() ---> make unique nu,ber in array
        System.out.println(li.get(2));
    }

}
