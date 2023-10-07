import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListProcessor {
    public static void main(String[] args) {
        ListProcessor L = new ListProcessor();
        L.arraySequence(5, 2);
    }

    /**
     * Return integer values in the range of the given parameter.
     * @param from starting int value
     * @param to last int value
     * Exercise 1.
     */
    public int[] arraySequence(int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("Invalid values");
        }
        int[] B = new int[to-from];{}
        for (int i=0; i<B.length; i++) {
            B[i] = from;
            from++;
        }
        return B;
    }

    /**
     * Return integer values in the range of the given parameter.
     * @param from starting int value
     * @param to last int value
     * Exercise 1.
     */
    public List<Integer> listSequence(int from, int to) {
        List<Integer> A1 = new ArrayList<>();
        if (from == to) {
            return A1;
        }
        if (to < from) {
            throw new IllegalArgumentException("Invalid values");
        }
        for (int i = from; i < to; i++) {
            A1.add(i);
        }
        return A1;
    }

    /**
     * Shuffle the list that is given in the parameter and then return it.
     * @param numbers array.
     * Exercise 2.
     * @return shuffled int array.
     */
    public int[] shuffled(int[] numbers) {
        Random R = new Random();
        int[] numbersCopy = numbers.clone();
        int index = 0;
        while (index<numbers.length) {
            // making sure that the random index stays the same throughout the loop
            int randomIndex = R.nextInt(numbers.length);
            // storing the element to switch
            int storedElement = numbersCopy[index];
            numbersCopy[index] = numbersCopy[randomIndex];
            numbersCopy[randomIndex] = storedElement;
            index++;
        }
        return numbersCopy;
    }

    /**
     * Shuffle the list that is given in the parameter and then return it.
     * @param numbers ArrayList.
     * Exercise 2.
     * @return shuffled int ArrayList.
     */
    public List<Integer> shuffled(List<Integer> numbers) {
        Random R2 = new Random();
        // make a copy of the numbers list to mutate.
        List<Integer> numbersCopy = new ArrayList<>();
        List<Integer> numbersCopy2 = new ArrayList<>();
        numbersCopy2.addAll(numbers);
        for (int i=0; i<numbers.size(); i++) {
            int randomIndex = R2.nextInt(numbersCopy2.size());
            // add random element to the end of numbersCopy from numbersCopy2
            numbersCopy.add(numbersCopy2.get(randomIndex));
            // remove the added element from numbersCopy2 so that it can't be added again
            numbersCopy2.remove(randomIndex);
        }
        return numbersCopy;
    }

    /**
     * Return the sum of a given list of numbers.
     * @param numbers integer array of numbers.
     * @return the sum of the list.
     * Exercise 3.
     */
    public int sumIterative(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        int sum = 0;
        int index = 0;
        while (index < numbers.length) {
            sum = sum + numbers[index];
            index++;
        }
        return sum;
    }

    /**
     * Return the sum of a given list of numbers.
     * @param numbers ArrayList of numbers.
     * @return the sum of the list.
     * Exercise 3.
     */
    public int sumIterative(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

    /**
     * Return the sum of a given list of numbers by adding them recursively.
     * @param numbers array of numbers.
     * @return the sum of the array.
     * Exercise 4.
     */
    public int sumRecursive(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        // Last element in numbers array + last element in new numbers array (that is one element shorter).
        return numbers[numbers.length-1] + sumRecursive(Arrays.copyOf(numbers, numbers.length-1));
    }

    /**
     * Return the sum of a given list of numbers by adding them recursively.
     * @param numbers ArrayList of numbers.
     * @return the sum of the ArrayList.
     * Exercise 4.
     */
    public int sumRecursive(List<Integer> numbers) {
        if (numbers.size()==0) {
            return 0;
        }
        return numbers.get(numbers.size()-1) + sumRecursive(numbers.subList(0, numbers.size()-1));
    }
}
