package org.example;

public class InteritingBehaviours {

    public static void main(String[] args) {
        Car toyotaCar = new Toyota();
        System.out.println(toyotaCar.defaultMakeAndModel());
    }
}

class Car implements Engine, Vehicle {

    public String defaultMakeAndModel() {
        //prints DEFAULT_VEHICLE_MAKE:TOYOTA
        return String.join(":", make(), model());
    }

    @Override
    public String make() {
        //note the syntax
        return Vehicle.super.make();
    }
}

class Toyota extends Car {
    @Override
    public String model() {
        return "TOYOTA";
    }

}

interface Engine {

    default String make() {
        return "DEFAULT_ENGINE_MAKE";
    }
}

interface Vehicle {

    default String make() {
        return "DEFAULT_VEHICLE_MAKE";
    }

    default String model() {
        return "DEFAULT_MODEL";
    }

}