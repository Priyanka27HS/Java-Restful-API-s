package Restful_APIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sampleTest {

    public static void main(String args[]) {

        List<String> names = Arrays.asList("Avacado", "Banana", "Orange");

        List<String> customName = new ArrayList<>();
        for(String s : names) {
            String newName = s + " Fruit";
            customName.add(newName);
        }
        System.out.println("Before :" + names);
        System.out.println("After :" + customName);
    }

}
