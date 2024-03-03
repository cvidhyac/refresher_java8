package com.learn.refresher.java;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.learn.refresher.java.Main.GREEN;

@Slf4j
public class Main {

    public static final String GREEN = "green";

    public static void main(String[] args) {

        List<Apple> apples = listApples();

        List<Apple> heavyApples = apples.stream()
                .filter(new AppleComparator()::isHeavyApple)
                .toList();

        List<Apple> greenApples = apples.stream()
                .filter(new AppleComparator()::isGreenApple)
                .toList();

        log.info("Hello world!");
        log.info("Number of green apples" + greenApples.size());
        log.info("Number of heavy apples" + heavyApples.size());
    }


    public static List<Apple> listApples() {
        Apple goldenDelicious = new Apple("golden delicious", GREEN, 250);
        Apple redDelicious = new Apple("red delicious", "red", 180);
        Apple blackLady = new Apple("black lady", "black", 120);
        Apple grannyApple = new Apple("granny apple", GREEN, 250);
        Apple fuji = new Apple("fuji", GREEN, 100);
        Apple mcintosh = new Apple("mcintosh", "red", 250);
        Apple gala = new Apple("gala", "red", 120);
        Apple romeBeauty = new Apple("romeBeauty", GREEN, 210);
        return Arrays.asList(goldenDelicious, redDelicious, blackLady, grannyApple, fuji, mcintosh, gala, romeBeauty);
    }

}

class AppleComparator {

    public boolean isGreenApple(Apple apple) {
        return GREEN.equalsIgnoreCase(apple.getColor());
    }

    public boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public List<Apple> filterApple(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream().filter(predicate).toList();
    }
}

