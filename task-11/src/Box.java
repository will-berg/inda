import java.util.Objects;
/**
 * The Box class models a three-dimensional box
 * @version 2019-12-02
 * @author William Berg
 */
public class Box implements Comparable<Box> {
    private final int height;
    private final int width;
    private final int depth;

    /**
     * Create a new Box with the specified dimensions (height, width, depth).
     *
     * @param height the height of the box
     * @param width the width of the box
     * @param depth the depth of the box
     */
    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Create a copy of box.
     *
     * @param box A Box to copy.
     */
    public Box(Box box) {
        this.height = box.height;
        this.width = box.width;
        this.depth = box.depth;
    }

    /**
     * Get this box's volume
     *
     * @return the box's volume
     */
    public int volume() {
        return height * width * depth;
    }

    /**
     * @return The box's height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return The box's width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The box's depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Defines if two Boxes should be considered equal according to their volume.
     *
     * @param o an object
     * @return true if the given object has equal volume to this Box
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Box)) {
            return false;
        }
        Box other = (Box) o;
        return this.volume() == other.volume();
    }

    /**
     * Defines the hash code of this Box.
     *
     * This is required by the contract of hashCode, which states that if for
     * two objects x and y, x.equals(y) is true,
     * then x.hashCode() == y.hashCode() must also be true. Note that the
     * converse is not necessary, equal hash codes does not imply equality.
     *
     * So, as we override the Object.equals(Object o), we must also override
     * Object.hashCode(). If we do not abide by the contract, data structures
     * that rely on hashes (such as HashMap) will simply not work correctly.
     *
     * Ideally, a small change in an object's state should result in a large
     * change in the hash. Therefore, instead of just returning the volume
     * (which would trivially fulfill the contract), we run the volume through
     * an existing hash function. Of course, just returning the volume directly
     * would also work, just not as well.
     *
     * For a good explanation, see Effective Java Recipe Item 9
     * @return the hash code of this Box
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(volume());
    }

    /**
     * @return a String representation of this Box.
     */
    @Override
    public String toString() {
        return "Box(" + height + ", " + width + ", " + depth + ")";
    }

    /**
     * Compare the volume of boxes. Part of comparable implementation.
     * @param o Box object
     * @return negative, positive or zero integer.
     */
    // exercise 1.
    @Override
    public int compareTo(Box o) {
        if (volume() > o.volume()) return 1;
        if (volume() < o.volume()) return -1;
        return 0;
    }
}
