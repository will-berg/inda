import java.util.Random;

/**
 * Class QuicksortRandomPivot, implements IntSorter and sorts integer arrays
 * using the quicksort algorithm with a random pivot.
 *
 * @author William Berg
 * @version 2020-02-22
 */
public class QuicksortRandomPivot implements IntSorter {
    private Random r = new Random();

    @Override
    public void sort(int[] v) {
        quicksort(v, 0, v.length-1);
    }

    /**
     * Quicksort with a random pivot, in this case the pivot is randomly
     * chosen to be any element in the array.
     *
     * @param array array to sort.
     * @param start start index of array. 
     * @param end end index of array.
     */
    private void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int randomIndex = r.nextInt(end - start) + start;
            int i = Partition.hPartition(array, start, end, array[randomIndex]);
            quicksort(array, start, i);
            quicksort(array, i+1, end);
        }
    }
}
