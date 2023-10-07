/**
 * This is a heater.
 *
 * @author (William Berg)
 * @version (2019-09-19)
 */
public class Heater {
    // instance variables - replace the example below with your own
    private double temperature;
    private double min;
    private double max;
    private double increment;

    /**
     * Constructor for objects of class Heater
     */
    public Heater(double minimum, double maximum) {
        // initialize instance variables
        min = minimum;
        max = maximum;
        increment = 5.0;
        temperature = 15.0;
    }

    /**
     * Return current temperature.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Change the increment value.
     */
    public void setIncrement(double newIncrement) {
		if (newIncrement >= 0) {
			increment = newIncrement;
		} else {
			System.out.println("Invalid increment value");
		}
	}

    /**
     * Decrease the temperature by 5.0
     */
    public void cooler() {
        if (temperature > min) {
        temperature -= increment;
        } else {
            System.out.println("Temperature cannot be decreased any more");
        }
    }

	/**
	 * Increase the temperature by 5.0
	 */
	public void warmer() {
		if (temperature < max) {
			temperature += increment;
		} else {
			System.out.println("Temperature cannot be increased any more");
		}
    }
}
