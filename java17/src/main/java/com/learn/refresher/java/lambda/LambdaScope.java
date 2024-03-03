package com.learn.refresher.java.lambda;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaScope extends SuperScope {

    String member = "Grandpa";

    interface Family {
        void who(String familyMember);
    }

    public void testMember(String member) {

        Family familyLambda = familyMember -> {
            log.info("Local Lambda member" + familyMember);
            log.info("Local Lambda member" + member);
            log.info("Local Lambda this.member" + this.member);
            log.info("Local Lambda super.member" + super.member);
        };
        familyLambda.who(member);
    }

    public static void main(String[] args) {
        new LambdaScope().testMember("Son");
    }
}

abstract class SuperScope {
    String member = "Godfather";
}
