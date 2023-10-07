import java.util.Random;

/**
 * Same as QuicksortFixedPivotInsertion but with a random pivot.
 *
 * @author William Berg
 * @version 2020-02-22
 */
public class QuicksortRandomPivotInsertion implements IntSorter {
    private Random r = new Random();

    @Override
    public void sort(int[] v) {
        quicksort(v, 0, v.length-1);
    }

    /**
     * Quicksort with a random pivot, in this case the pivot is randomly
     * chosen to be any element in the array. The method cuts off to
     * insertion sort for small sub-arrays with size less than 20.
     *
     * @param array array to sort.
     * @param start start index of array.
     * @param end end index of array.
     */
    private void quicksort(int[] array, int start, int end) {
        if (end - start < 20) {
            InsertionSort.insertionSort(array, start, end);
        }
        else if (start < end) {
            int randomIndex = r.nextInt(end - start) + start;
            int i = Partition.hPartition(array, start, end, array[randomIndex]);
            quicksort(array, start, i);
            quicksort(array, i+1, end);
        }
    }
}
