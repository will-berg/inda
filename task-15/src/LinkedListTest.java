import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
/**
 * Abstract test class for Stack implementations.
 *
 * @author Simon Larsén
 * @version 2017-08-20
 */
public class LinkedListTest extends StackTest {

    @Override
    protected Stack<Integer> getIntegerStack() {
        return new LinkedList<Integer>();
    }
}