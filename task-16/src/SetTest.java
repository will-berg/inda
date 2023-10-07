import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.IntStream;
/**
 * Abstract test class for Set implementations.
 *
 * Implementing test classes must override the getIntegerSet method.
 *
 * @author Simon Larsén
 * @version 2018-12-16
 */
public abstract class SetTest {
    @Rule public Timeout globalTimeout = Timeout.seconds(5); // 5 seconds max per method tested

    private Set<Integer> set;
    private final int CAPACITY = 20;
    private int[] uniqueSetElements;
    protected int[] elementsNotInSet;

    /**
     * Returns an implementation of Set that can hold at least 'minCapacity'
     * Integers.
     *
     * @param minCapacity The least amount of elements the Set must be able to
     * hold.
     * @return An implementation of Set.
     */
    protected abstract Set<Integer> getIntegerSet(int minCapacity);

    @Before
    public void setUp() {
        // Arrange
        set = getIntegerSet(CAPACITY);
        uniqueSetElements =
                new int[] {-234, 32, 443, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -231};
        // Works because all elements in uniqueSetElements are more than 2 values apart
        // -2 as Integer.MIN_VALUE - 1 == Integer.MAX_VALUE because of underflow
        elementsNotInSet = Arrays.stream(uniqueSetElements).map(elem -> elem - 2).toArray();

        for (int elem : uniqueSetElements) {
            set.add(elem);
        }
    }

    @Test
    public void containsIsTrueWhenElementIsInSet() {
        // Arrange
        Arrays
                .stream(uniqueSetElements)
                // Act
                .mapToObj(elem -> set.contains(elem))
                // Assert
                .forEach(contained -> assertThat(contained, is(true)));

        /**
         * Look another stream! How does this work again?
         *
         * Arrays.stream(uniqueSetElements): turns the array into a sequence
         * of values (a stream of values, so to speak)
         *
         * mapToObj(elem -> set.contains(elem)): takes every value (elem) fed in by
         * the stream, computes set.contains(elem) and feeds the results out
         * into a new stream.
         *
         * forEach(contained -> assertThat(contained, is(true))): takes every value
         * (contained) produced by the mapToObj stream, and performs the
         * assertTrue method!
         *
         * For the more iterative mindset, the stream essentially does the same
         * thing as this loop:
         *
         * for (int elem : uniqueSetElements) {
         *     boolean contained = set.contains(elem);
         *     assertThat(contained, is(true));
         * }
         *
         */
    }

    @Test
    public void containsIsFalseWhenElementIsNotInSet() {
        // Arrange
        for (int elem : elementsNotInSet) {
            // Act
            boolean contained = set.contains(elem);
            // Assert
            assertThat(contained, is(false));
        }
    }

    @Test
    public void containsIsFalseForRemovedElements() {
        // Arrange
        for (int elem : uniqueSetElements) {
            // Act
            set.remove(elem);
            boolean contained = set.contains(elem);
            // Assert
            assertThat(contained, is(false));
        }
    }

    @Test
    public void addUniqueElementsIncrementsSize() {
        // Arrange
        // Note how the local set variable shadows the field!
        Set<Integer> set = getIntegerSet(CAPACITY);
        int expectedSize = 0;
        for (int elem : uniqueSetElements) {
            expectedSize++;
            // Act
            set.add(elem);
            // Assert
            assertThat(set.size(), equalTo(expectedSize));
        }
    }

    @Test
    public void addDuplicatesDoesNotIncreaseSize() {
        // Arrange
        int expectedSize = uniqueSetElements.length;
        for (int elem : uniqueSetElements) {
            // Act
            set.add(elem);
        }
        // Assert
        assertThat(set.size(), equalTo(expectedSize));
    }

    @Test
    public void removeElementsInSetDecrementsSize() {
        // Arrange
        int expectedSize = uniqueSetElements.length;
        for (int elem : uniqueSetElements) {
            // Act
            set.remove(elem);
            expectedSize--;
        }
        // Assert
        assertThat(set.size(), equalTo(expectedSize));
    }

    @Test
    public void removeElementsNotInSetDoesNotDecrementSize() {
        // Arrange
        int expectedSize = uniqueSetElements.length;
        for (int elem : elementsNotInSet) {
            // Act
            set.remove(elem);
        }
        // Assert
        assertThat(set.size(), equalTo(expectedSize));
    }

    @Test
    public void removeElementsDoesNotDecrementSizeWhenSetIsEmpty() {
        // Arrange
        Set<Integer> emptySet = getIntegerSet(CAPACITY);
        int expectedSize = emptySet.size();
        for (int elem : uniqueSetElements) {
            // Act
            emptySet.remove(elem);
        }
        // Assert
        assertThat(emptySet.size(), equalTo(expectedSize));
    }

    @Test
    public void addIsTrueWhenElementNotInSet() {
        // Arrange
        Set<Integer> set = getIntegerSet(CAPACITY);
        Arrays
                .stream(uniqueSetElements)
                // Act
                .mapToObj(elem -> set.add(elem))
                // Assert
                .forEach(wasAdded -> assertThat(wasAdded, is(true)));
    }

    @Test
    public void addIsFalseForDuplicates() {
        // Arrange
        Arrays
                .stream(uniqueSetElements)
                // Act
                .mapToObj(elem -> set.add(elem))
                // Assert
                .forEach(wasAdded -> assertThat(wasAdded, is(false)));
    }

    @Test
    public void removeIsTrueWhenElementIsInSet() {
        // Arrange
        Arrays
                .stream(uniqueSetElements)
                // Act
                .mapToObj(elem -> set.remove(elem))
                // Assert
                .forEach(wasRemoved -> assertThat(wasRemoved, is(true)));
    }

    @Test
    public void removeIsFalseWhenElementIsNotInSet() {
        // Arrange
        Arrays
                .stream(elementsNotInSet)
                // Act
                .mapToObj(elem -> set.remove(elem))
                // Assert
                .forEach(wasRemoved -> assertThat(wasRemoved, is(false)));
    }

    @Test
    public void removeIsFalseWhenSetIsEmpty() {
        // Arrange
        Set<Integer> emptySet = getIntegerSet(CAPACITY);
        Arrays
                .stream(uniqueSetElements)
                // Act
                .mapToObj(elem -> emptySet.remove(elem))
                // Assert
                .forEach(wasRemoved -> assertThat(wasRemoved, is(false)));
    }
}