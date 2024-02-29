package org.example.lambda;

public class LambdaTargetType {

    public interface Email {
        String constructEmail(String id);
    }

    public String getEmail(String id, Email email) {
        return null;
    }

    public static void main(String[] args) {
        Email email = name -> name + "@gmail.com";
        String finalEmail = new LambdaTargetType().getEmail("hello", id -> id + "@gmail.com");
        System.out.println(finalEmail);
    }
}
