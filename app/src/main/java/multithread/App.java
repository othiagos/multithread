package multithread;

import java.lang.Thread;
import java.util.concurrent.ConcurrentSkipListSet;

public class App {
    public static void main(String[] args) {

        if (args.length > 1) {
            ConcurrentSkipListSet<Integer> primerNumberSet = new ConcurrentSkipListSet<>();
            int processorsThreadNumber = Runtime.getRuntime().availableProcessors();
            
            for (int threadIndex = 0; threadIndex < processorsThreadNumber; threadIndex++) {
                Runnable obj = new Prime(
                    primerNumberSet,
                    processorsThreadNumber,
                    Integer.parseInt(args[0]) + threadIndex,
                    Integer.parseInt(args[1])
                );

                new Thread(obj).start();
            }
        }
        else {
            System.out.println("Few arguments!");
        }
    }
}