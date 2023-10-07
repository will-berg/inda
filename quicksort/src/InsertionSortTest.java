/**
 * Test class for insertion sort. Extends the IntSorterTest class
 * and provides an overriden method to instantiate the IntSorter.
 */
public class InsertionSortTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new InsertionSort();
    }
}
