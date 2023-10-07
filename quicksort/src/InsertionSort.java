/**
 * Class InsertionSort, implements IntSorter and sorts integer
 * arrays using the insertion sort algorithm.
 *
 * @author William Berg
 * @version 2020-02-22
 */
public class InsertionSort implements IntSorter {

    @Override
    public void sort(int[] v) {
        insertionSort(v, 0, v.length-1);
    }

    public static void insertionSort(int[] v, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int j = i;
            while (j > start && v[j-1] > v[j]) {
                int temp = v[j];
                v[j] = v[j-1];
                v[j-1] = temp;
                j = j - 1;
            }
        }
    }
}
