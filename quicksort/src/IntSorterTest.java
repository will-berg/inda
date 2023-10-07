import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Abstract test class for  implementations.
 *
 * Implementing test classes must override the getIntSorter method.
 *
 * @author Simon Larsén
 * @version 2018-01-16
 */
public abstract class IntSorterTest {
    /**
     * Returns an implementation of the IntSorter interface. Extending classes
     * must override this method.
     *
     * @return An implementation of Set.
     */
    protected abstract IntSorter getIntSorter();

    private int[] evenLengthArray;
    private int[] oddLengthArray;
    private int[] ascendingOrderArray;
    private int[] descendingOrderArray;
    private int[] equalElementsArray = {1,1,1,1,1,1,1,1,1,1,1};
    private int[] largeArray;

    @Before
    public void setUp() {
        Data d = new Data(20, 20, Data.Order.RANDOM);
        evenLengthArray = d.get();

        Data d1 = new Data(19, 19, Data.Order.RANDOM);
        oddLengthArray = d1.get();

        Data d2 = new Data(20, 20, Data.Order.ASCENDING);
        ascendingOrderArray = d2.get();

        Data d3 = new Data(20, 20, Data.Order.DESCENDING);
        descendingOrderArray = d3.get();

        Data d4 = new Data(100000, 100000, Data.Order.RANDOM);
        largeArray = d4.get();
    }

    @Test
    public void arrayOfEvenLengthIsSortedCorrectly() {
        int[] actual = evenLengthArray;
        int[] expected = actual.clone();

        Arrays.sort(expected);
        getIntSorter().sort(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void ascendingOrderArrayIsSortedCorrectly() {
        int[] actual = ascendingOrderArray;
        int[] expected = actual.clone();

        Arrays.sort(expected);
        getIntSorter().sort(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void arrayOfOddLengthIsSortedCorrectly() {
        int[] actual = oddLengthArray;
        int[] expected = actual.clone();

        Arrays.sort(expected);
        getIntSorter().sort(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void descendingOrderArrayIsSortedCorrectly() {
        int[] actual = descendingOrderArray;
        int[] expected = actual.clone();

        Arrays.sort(expected);
        getIntSorter().sort(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void equalElementsArrayIsSortedCorrectly() {
        int[] actual = equalElementsArray;
        int[] expected = actual.clone();

        Arrays.sort(expected);
        getIntSorter().sort(actual);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void largeArrayIsSortedCorrectly() {
        int[] actual = largeArray;
        int[] expected = actual.clone();

        Arrays.sort(expected);
        getIntSorter().sort(actual);

        assertThat(actual, equalTo(expected));
    }
}
