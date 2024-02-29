package org.example.lambda;

public class MethodReferences {

    public static void main(String[] args) {

        System.out.println("Is Classic Movie? " + new MethodReferences().testClassicMovie(1890));
        System.out.println("Is Top10 Movie? " + new MethodReferences().testTop10Movie(5));
    }

    public boolean testClassicMovie(int movieId) {
        //With static method
        IMovie iClassicMovieLambda = MethodReferences::isClassicMovie;
        return iClassicMovieLambda.check(movieId);
    }

    public boolean testTop10Movie(int ranking) {
        //Method reference on instance variable
        IMovie iTop10Movie = new MethodReferences()::isTop10Movie;
        return iTop10Movie.check(ranking);
    }
    interface IMovie {
        boolean check(int value);
    }

    public boolean isTop10Movie(int ranking) {
        return ranking > 0 && ranking < 10;
    }
    public static boolean isClassicMovie(int movieId) {
        return  movieId> 100? true: false;
    }

}
