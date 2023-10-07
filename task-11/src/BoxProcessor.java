import java.util.List;

/**
 * The BoxProcessor class contains methods for searching and
 * sorting the box class.
 * @version  2019-12-02
 * @author William Berg
 */
public class BoxProcessor {
    /**
     * selection sort the array by increasing volume of the boxes.
     * @param array array of Box objects to be sorted.
     */
    public void sort(Box[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    Box temp = array[min];
                    array[min] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * selection sort the list by increasing volume of the boxes.
     * @param list list of Box objects to be sorted.
     */
    public void sort(List<Box> list) {
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(min)) < 0) {
                    Box temp = list.get(min);
                    list.set(min, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    /**
     * @return return the index of the first Box that has the same volume as box, or -1 if there is no such box.
     * @param array array of boxes.
     * @param box Box object.
     */
    public int sequentialSearch(Box[] array, Box box) {
        for (int i = 0; i < array.length; i++) {
            Box comparisonBox = array[i];
            if (comparisonBox.compareTo(box) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return return the index of the first Box that has the same volume as box, or -1 if there is no such box.
     * @param list list of boxes.
     * @param box Box object.
     */
    public int sequentialSearch(List<Box> list, Box box) {
        for (int i = 0; i < list.size(); i++) {
            Box comparisonBox = list.get(i);
            if (comparisonBox.compareTo(box) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return return the index of a Box that has the same volume as box, or -1 if there is no such box.
     * @param array array of boxes.
     * @param box Box object.
     */
    public int binarySearch(Box[] array, Box box) {
        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int comparison = box.compareTo(array[mid]);
            if (comparison == 0) return mid;
            // if the box has smaller volume than the box in the middle of the array
            if (comparison < 0) right = mid - 1;
            if (comparison > 0) left = mid + 1;
        }
        return -1;
    }

    /**
     * @return return the index of a Box that has the same volume as box, or -1 if there is no such box.
     * @param list list of boxes.
     * @param box Box object.
     */
    public int binarySearch(List<Box> list, Box box) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int comparison = box.compareTo(list.get(mid));
            if (comparison == 0) return mid;
            if (comparison < 0) right = mid - 1;
            if (comparison > 0) left = mid + 1;
        }
        return -1;
    }
}
