/**
 * Test class for QuicksortFixedPivotInsertion. Extends the IntSorterTest class
 * and provides an overriden method to instantiate the IntSorter.
 */
public class QuicksortFixedPivotInsertionTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }
}
