/**
 * Generate a Star Wars name.
 *
 * @author (William Berg)
 * @version (2019-10-31)
 */
public class NameGenerator {
    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator() {}

    /**
     * generates a Star Wars name.
     */
    public void generateStarWarsName(String lastName, String firstName, String mothersName, String homeTown) {
        String a = lastName.substring(0, 3);
        String b = firstName.substring(0, 2);
        String c = mothersName.substring(0, 2);
        String d = homeTown.substring(0, 3);
        String starWarsFirstName = a+b;
        String starWarsLastName = c+d;
        System.out.println(starWarsFirstName + " " + starWarsLastName);
    }
}
