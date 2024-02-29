package org.example;

public class FunctionalInterfaceAnnotation {


    @FunctionalInterface
    interface Cruncher {
        int crunch(int i, int j);

        default boolean isCrunchy() {
            return true;
        }

        static boolean isCrunchier(Cruncher cruncher, int i, int j) {
            int crunchValue =  cruncher.crunch(i, j);
            if (crunchValue > 60) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public int crunchService(int i, int j, Cruncher cruncher) {
        return cruncher.crunch(i, j);
    }

    class CruncherImpl implements Cruncher {


        @Override
        public int crunch(int i, int j) {
            if (isCrunchy()) {
                return i * j;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        Cruncher multiplicationCruncher = (i, j) -> i * j;
        boolean multiplyResults = Cruncher.isCrunchier(multiplicationCruncher, 8, 8);

        Cruncher additionCruncher = (i, j) -> i + j;
        boolean additionResults = Cruncher.isCrunchier(additionCruncher, 10, 10);

        System.out.println("Multiply Crunch Result is :" + multiplyResults);
        System.out.println("Addition Crunch Result is :" + additionResults);
    }
}
