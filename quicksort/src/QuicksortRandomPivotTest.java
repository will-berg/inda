/**
 * Test class for QuicksortRandomPivot. Extends the IntSorterTest class
 * and provides an overriden method to instantiate the IntSorter.
 */
public class QuicksortRandomPivotTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivot();
    }
}
