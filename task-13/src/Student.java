
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 *
 * @author William Berg
 * @version 2020-01-15
 */
public class Student extends LabAttendee {
    private int credits;

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String schoolId, String phoneNumber) {
        super(fullName, schoolId, phoneNumber);
        credits = 0;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints) {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits() {
        return credits;
    }
}
