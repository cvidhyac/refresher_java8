package org.example.lambda;


public class LambdaScope extends SuperScope {

    String member = "Grandpa";

    interface Family {
        void who(String familyMember);
    }

    public void testMember(String member) {

        Family familyLambda = familyMember -> {
            System.out.println("Local Lambda member" + familyMember);
            System.out.println("Local Lambda member" + member);
            System.out.println("Local Lambda this.member" + this.member);
            System.out.println("Local Lambda super.member" + super.member);
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
