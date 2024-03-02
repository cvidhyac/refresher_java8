package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalInterfaceAnnotation {


    @FunctionalInterface
    interface Cruncher {
        int crunch(int i, int j);

        default boolean isCrunchy() {
            return true;
        }

        static boolean isCrunchier(Cruncher cruncher, int i, int j) {
            int crunchValue =  cruncher.crunch(i, j);
            return crunchValue > 60;
        }
    }

    public int crunchService(int i, int j, Cruncher cruncher) {
        return cruncher.crunch(i, j);
    }

    static class CruncherImpl implements Cruncher {


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

        Cruncher additionCruncher = Integer::sum;
        boolean additionResults = Cruncher.isCrunchier(additionCruncher, 10, 10);

        log.info("Multiply Crunch Result is :" + multiplyResults);
        log.info("Addition Crunch Result is :" + additionResults);
    }
}
