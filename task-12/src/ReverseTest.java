import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
/**
 * Test class for Reverse.
 *
 * @author William Berg
 * @version 2019-12-04
 */
public class ReverseTest {
    // Arrange
    private int[] oddLengthArray;
    private int[] evenLengthArray;
    private List<Integer> oddLengthList;
    private List<Integer> evenLengthList;
    private int oddLengthSequenceLength;
    private int evenLengthSequenceLength;

    private Reverse reverse;

    @Before
    public void setUp() {
        // Arrange
        reverse = new Reverse();
        oddLengthArray = new int[]{1, 5, 23, -23, 3, 4, 1, -2, 3};
        evenLengthArray = new int[]{3, 123, 4, -2, -512, -3};
        oddLengthList = intArrayToList(oddLengthArray);
        evenLengthList = intArrayToList(evenLengthArray);
        oddLengthSequenceLength = oddLengthArray.length;
        evenLengthSequenceLength = evenLengthArray.length;
    }

    /**
     * Tests for reversed(int[])
     */

    @Test
    public void reversedArrayIsEmptyWhenOriginalIsEmpty() {
        // Arrange
        int[] emptyArray = new int[0];

        // Act
        int[] reversedEmptyArray = reverse.reversed(emptyArray);

        // Assert
        assertThat(reversedEmptyArray.length, equalTo(0));
    }

    @Test
    public void reversedArrayIsSameLengthAsOriginalWhenNonEmpty() {
        // Act
        int[] reversedOddArray = reverse.reversed(oddLengthArray);
        int[] reversedEvenArray = reverse.reversed(evenLengthArray);

        // Assert
        assertThat(reversedOddArray.length, equalTo(oddLengthSequenceLength));
        assertThat(reversedEvenArray.length, equalTo(evenLengthSequenceLength));
    }

    @Test
    public void reversedArrayDoesNotMutateOriginalWhenNonEmpty() {
        // Arrange
        int[] oddArrayCopy = Arrays.copyOf(oddLengthArray, oddLengthSequenceLength);
        int[] evenArrayCopy = Arrays.copyOf(evenLengthArray, evenLengthSequenceLength);

        // Act
        reverse.reversed(oddLengthArray);
        reverse.reversed(evenLengthArray);

        // Assert
        assertArrayEquals(oddArrayCopy, oddLengthArray);
        assertArrayEquals(evenArrayCopy, evenLengthArray);
    }

    @Test
    public void reversedArrayIsReverseOfOriginalWhenNonEmpty() {
        // Act
        int[] reversedOddArray = reverse.reversed(oddLengthArray);
        int[] reversedEvenArray = reverse.reversed(evenLengthArray);

        // Assert
        assertReversed(oddLengthArray, reversedOddArray);
        assertReversed(evenLengthArray, reversedEvenArray);
    }

    @Test
    public void reversedArrayIsEqualToOriginalWhenLengthIsOne() {
        // Arrange
        int[] singleElementArray = {1338};

        // Act
        int[] reversedSingleElementArray = reverse.reversed(singleElementArray);

        // Assert
        assertArrayEquals(singleElementArray, reversedSingleElementArray);
    }

    /**
     * Tests for reversed(List<Integer>)
     */

    @Test
    public void reversedListIsEmptyWhenOriginalIsEmpty() {
        // Arrange
        List<Integer> emptyList = new ArrayList<Integer>();

        // Act
        List<Integer> reversedEmptyList = reverse.reversed(emptyList);

        // Assert
        assertThat(reversedEmptyList.size(), equalTo(0));
    }

    @Test
    public void reversedListIsSameLengthAsOriginalWhenNonEmpty() {
        // Act
        List<Integer> reversedOddList = reverse.reversed(oddLengthList);
        List<Integer> reversedEvenList = reverse.reversed(evenLengthList);

        // Assert
        assertThat(reversedOddList.size(), equalTo(oddLengthSequenceLength));
        assertThat(reversedEvenList.size(), equalTo(evenLengthSequenceLength));
    }

    @Test
    public void reversedListDoesNotMutateOriginalWhenNonEmpty() {
        // Arrange
        List<Integer> oddListCopy = oddLengthList;
        List<Integer> evenListCopy = evenLengthList;

        // Act
        reverse.reversed(oddLengthList);
        reverse.reversed(evenLengthList);

        // Assert
        assertEquals(oddListCopy, oddLengthList);
        assertEquals(evenListCopy, evenLengthList);
    }

    @Test
    public void reversedListIsReverseOfOriginalWhenNonEmpty() {
        // Act
        List<Integer> reversedOddList = reverse.reversed(oddLengthList);
        List<Integer> reversedEvenList = reverse.reversed(evenLengthList);

        // Assert
        assertReversed(oddLengthList, reversedOddList);
        assertReversed(evenLengthList, reversedEvenList);
    }

    @Test
    public void reversedListIsEqualToOriginalWhenLengthIsOne() {
        // Arrange
        List<Integer> singleElementList = new ArrayList<>();
        singleElementList.add(1338);

        // Act
        List<Integer> reversedSingleElementList = reverse.reversed(singleElementList);

        // Assert
        assertEquals(singleElementList, reversedSingleElementList);
    }

    /**
     * Helper methods.
     */

    /**
     * @param array An int array.
     * @return A List copy of array.
     */
    private List<Integer> intArrayToList(int[] array) {
        // This is a Java stream. It is not part of the course, but extra fluff
        // for the interested. It is part of Java 8's half-hearted venture into
        // functional programming.
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    /**
     * @param list An integer List.
     * @return An int array copy of List.
     */
    private int[] integerListToIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * Helper assert methods.
     */

    /**
     * Assert that listA is the reverse of listB.
     * Note that this is a reflexive relation.
     *
     * @param listA A list.
     * @param listB A list.
     */
    private void assertReversed(List<Integer> listA, List<Integer> listB) {
        int[] arrayA = integerListToIntArray(listA);
        int[] arrayB = integerListToIntArray(listB);
        assertReversed(arrayA, arrayB);
    }

    /**
     * Assert that arrayA is the reverse of arrayB.
     * Note that this is a reflexive relation.
     *
     * @param arrayA An array.
     * @param arrayB An array.
     */
    private void assertReversed(int[] arrayA, int[] arrayB) {
        Integer len = arrayA.length;
        for (Integer i = 0; i < len; i++) {
            assertThat(arrayB[len-i-1], equalTo(arrayA[i]));
        }
    }
}
