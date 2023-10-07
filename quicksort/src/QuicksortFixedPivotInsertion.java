/**
 * Class QuicksortFixedPivotInsertion, implements IntSorter and sorts integer arrays using
 * the quicksort algorithm with a fixed pivot and cut-off to insertion sort at k.
 * Sub-arrays that contain at most k elements are sorted with insertion sort.
 *
 * @author William Berg
 * @version 2020-02-22
 */
public class QuicksortFixedPivotInsertion implements IntSorter {

    @Override
    public void sort(int[] v) {
        quicksort(v, 0, v.length-1);
    }

    /**
     * Quicksort with a fixed pivot, in this case the pivot is always the last
     * element in the array. When the array to be sorted has length less than 100,
     * the array is sorted using insertion sort.
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
            int middle = start + (end - start)/2;
            int i = Partition.hPartition(array, start, end, array[middle]);
            quicksort(array, start, i);
            quicksort(array, i+1, end);
        }
    }
}
