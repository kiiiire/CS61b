package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void randomizedCall () {
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0) {
                    int lastVal = L.getLast();
                    System.out.println(lastVal);
                }
            } else if (operationNumber == 3) {
                //removeLast
                if (L.size() > 0) {
                    int removeVal = L.removeLast();
                    System.out.println(removeVal);
                }
            }
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> porblem = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                porblem.addLast(randVal);
                Assert.assertEquals(L.size(),porblem.size());
            } else if (operationNumber == 1) {
                // size
                if (L.size() == 0){
                    continue;
                }
                int Last = L.getLast();
                int ProblemLast = porblem.getLast();
                Assert.assertEquals(Last, ProblemLast);
            } else if (operationNumber == 2) {
                if (L.size() == 0){
                    continue;
                }
                int LastOfL = L.getLast();
                int LastOfB = porblem.getLast();
                Assert.assertEquals(LastOfL,LastOfB);

            }
        }
    }

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> porblem = new BuggyAList<>();

        correct.addLast(10);
        correct.addLast(20);
        correct.addLast(30);

        porblem.addLast(10);
        porblem.addLast(20);
        porblem.addLast(30);

        assert(correct.size() == porblem.size());

        assert (correct.removeLast() == porblem.removeLast());
        assert (correct.removeLast() == porblem.removeLast());
        assert (correct.removeLast() == porblem.removeLast());


    }
}