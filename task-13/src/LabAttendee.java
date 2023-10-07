/**
 *
 * @author (William Berg)
 * @version (2020-01-14)
 */
public class LabAttendee {
    private String name;
    private String id;
    private String number;

    /**
     * Constructor for objects of class LabAttendee
     */
    public LabAttendee(String fullName, String schoolId, String phoneNumber) {
        name = fullName;
        id = schoolId;
        number = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    /**
     * Set a new name for this lab attendee.
     */
    public void changeName(String replacementName) {
        name = replacementName;
    }

    /**
     * Return the login name of this lab attendee. The login name is a combination
     * of the first four characters of the lab attendee's name and the first three
     * characters of their ID number.
     */
    public String getLoginName() {
        return name.substring(0,4) + id.substring(0,3);
    }

    /**
     * Print the lab attendee's name, ID number and phone number to the output terminal.
     */
    public void printPersonalInfo() {
        System.out.println(name + ", School ID: " + id + ", Phone number: " + number);
    }
}
