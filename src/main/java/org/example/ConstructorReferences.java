package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructorReferences {

    public static void main(String[] args) {
        System.out.println("Is the new Array list empty? " + new ConstructorReferences().testArrayListRef().isEmpty());
        System.out.println("Is this arrayList created 2 entries? " +
                new ConstructorReferences().testArrayListWithDefaultEntries("Apple", "Orange").size());
    }

    public List<String> testArrayListWithDefaultEntries(String... values) {
        ArrayListWithEntries<String> listWithEntries = entries -> Arrays.asList(entries);
        return listWithEntries.create(values);
    }

    public ArrayList<String> testArrayListRef() {
        //constructor reference
        ArrayListEmpty<String> arrayOfStrings = ArrayList::new;
        return arrayOfStrings.create();
    }


    interface ArrayListWithEntries<T> {
        List<T> create(String... entries);
    }

    interface ArrayListEmpty<T> {
        ArrayList<T> create();
    }
}
