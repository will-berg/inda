import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
/**
 * A class for reversing List and array types.
 *
 * @author William Berg
 * @version 2019-12-04
 */
public class Reverse {
    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */
    public int[] reversed(int[] array) {
        int[] arrayClone = array.clone();
        int n = arrayClone.length;
        for (int i= 0; i < n/2; i++) {
            int temp = arrayClone[i];
            arrayClone[i] = arrayClone[n-i-1];
            arrayClone[n-i-1] = temp;
        }
        return arrayClone;
    }

    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */
    public List<Integer> reversed(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>();
        listCopy.addAll(list);
        int n = listCopy.size();
        for (int i = 0; i < n/2; i++) {
            int temp = listCopy.get(i);
            listCopy.set(i, listCopy.get(n-i-1));
            listCopy.set(n-i-1, temp);
        }
        return listCopy;
    }
}
