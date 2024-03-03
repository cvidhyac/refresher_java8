package com.learn.refresher.java;

import java.util.Objects;

public class Apple {
    String name;

    String color;

    int weight;

    public Apple(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple apple)) return false;
        return weight == apple.weight && Objects.equals(name, apple.name) && Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, weight);
    }
}
