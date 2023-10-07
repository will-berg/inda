/**
 * Test class for QuicksortRandomPivotInsertion. Extends the IntSorterTest class
 * and provides an overriden method to instantiate the IntSorter.
 */
public class QuicksortRandomPivotInsertionTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivotInsertion();
    }
}
