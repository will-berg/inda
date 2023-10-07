/**
 * Test class for QuicksortFixedPivot. Extends the IntSorterTest class
 * and provides an overriden method to instantiate the IntSorter.
 */
public class QuicksortFixedPivotTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }
}
