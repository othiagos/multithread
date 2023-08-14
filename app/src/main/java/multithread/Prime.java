package multithread;

import java.util.SortedSet;

public class Prime implements Runnable {
    private SortedSet<Integer> primeNumberSet;
    private Integer threadNumber;
    private Integer start;
    private Integer end;

    private static Integer END_COUNT = null;

    public Prime(SortedSet<Integer> set, int threadNumber, int start, int end) {
        this.primeNumberSet = set;
        this.threadNumber = threadNumber;
        this.start = start;
        this.end = end;

        if (END_COUNT == null) {
            END_COUNT = 0;
        }
    }

    public SortedSet<Integer> getPrimeNumberSet() {
        return primeNumberSet;
    }

    public Integer getThreadNumber() {
        return threadNumber;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    private boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {

        while (getStart() <= getEnd()) {
            if (isPrime(start)) {
                getPrimeNumberSet().add(start);
            }

            this.start += threadNumber;
        }

        END_COUNT++;

        if (END_COUNT == getThreadNumber()) {
            System.out.println(getPrimeNumberSet());
        }
    }
}
