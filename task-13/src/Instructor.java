
/**
 *
 * @author (William Berg)
 * @version (2020-01-15)
 */
public class Instructor extends LabAttendee {
    private int salary;

    /**
     * Constructor for objects of class Instructor
     */
    public Instructor(String fullName, String schoolId, String phoneNumber) {
        super(fullName, schoolId, phoneNumber);
        salary = 3000;
    }

    public void changeSalary(int difference) {
        salary += difference;
    }

    public int getSalary() {
        return salary;
    }
}
