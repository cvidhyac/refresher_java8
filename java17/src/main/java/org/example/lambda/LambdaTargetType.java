package org.example.lambda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.info(finalEmail);
    }
}
