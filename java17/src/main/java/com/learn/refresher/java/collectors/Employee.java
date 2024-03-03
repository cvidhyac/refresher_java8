package com.learn.refresher.java.collectors;

import java.util.List;

public record Employee(int id, String name, String department, String city, List<String> food, boolean executive,
                       int rating) {

}
