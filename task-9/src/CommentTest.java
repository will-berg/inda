import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (William Berg)
 * @version (2019-11-14)
 */
public class CommentTest {
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    // 7.18
    public void testAuthorAndRatingStorage()
    {
        Comment comment1 = new Comment("William", "nice", 5);
        assertEquals("William", comment1.getAuthor());
        assertEquals(5, comment1.getRating());
    }

    @Test
    // 7.18
    public void testUpvote()
    {
        Comment comment2 = new Comment("William", "good", 5);
        comment2.upvote();
        assertEquals(1, comment2.getVoteCount());
    }

    @Test
    // 7.18
    public void testDownvote()
    {
        Comment comment1 = new Comment("William", "bad", 1);
        comment1.downvote();
        assertEquals(-1, comment1.getVoteCount());
    }
}



