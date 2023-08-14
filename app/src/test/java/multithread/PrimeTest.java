package multithread;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.TreeSet;

public class PrimeTest {
    
    @Test
    public void appHasAGreeting() {

        TreeSet<Integer> values = new TreeSet<>();
        values.add(2);
        values.add(3);
        values.add(5);
        values.add(7);
        values.add(11);
        values.add(13);

        TreeSet<Integer> set = new TreeSet<>();
        new Prime(set, 1, 0, 15).run();
        
        assertEquals(values, set);
        
    }
}
