/**
 * Partition class, used for the partitioning process in the different
 * quicksort variations.
 *
 * @author William Berg
 * @version 2020-02-22
 */
public class Partition {

    public static int lPartition(int[] array, int start , int end, int pivot) {
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                arraySwap(array, j, i);
                i++;
            }
        }
        arraySwap(array, i, end);
        return i;
    }

    public static int hPartition(int[] array, int start, int end, int pivot) {
        int i = start - 1;
        int j = end + 1;
        while (true) {
            do {
                i = i +1;
            } while (array[i] < pivot);
            do {
                j = j -1;
            } while (array[j] > pivot);
            if (i < j) {
                arraySwap(array, i, j);
            } else {
                return j;
            }
        }
    }

    /**
     * Swap element at position i with element in position j in the array a.
     *
     * @param a the array which the elements are in.
     * @param i index position of first element to be swapped.
     * @param j index position of second element to be swapped.
     */
    public static void arraySwap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
