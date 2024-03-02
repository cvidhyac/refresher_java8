package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ConstructorReferences {

    public static void main(String[] args) {
        log.info("Is the new Array list empty? " + new ConstructorReferences().testArrayListRef().isEmpty());
        log.info("Is this arrayList created 2 entries? " +
                new ConstructorReferences().testArrayListWithDefaultEntries("Apple", "Orange").size());
    }

    public List<String> testArrayListWithDefaultEntries(String... values) {
        ArrayListWithEntries<String> listWithEntries = Arrays::asList;
        return listWithEntries.create(values);
    }

    public List<String> testArrayListRef() {
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
