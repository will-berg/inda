import java.util.Random;
import java.util.ArrayList;
/**
 * RandomTester
 *
 * @author (William Berg)
 * @version (2019-10-29)
 */
public class RandomTester {
    private Random R1;

    /**
     * constructor for RandomTester
     */
    public RandomTester() {
    	Random R1 = new Random();
	}

    /**
     * print multiple random integer numbers depending on user input.
     * exercise 5.14
     */
    public void printMultiRandom(int howMany) {
        for (int i = 0; i < howMany; i++) {
        	printOneRandom();
    	}
	}

   /**
    * simulates the throwing of a die.
    * exercsie 5.16
    */
    public int throwDice() {
		Random R1 = new Random();
		int randomInteger = R1.nextInt(6)+1;
		return randomInteger;
	}

	/**
	 * generate a random number between 1 and the specified max.
	 * 5.20
	 */
	public int randInRangeMax(int max) {
		Random R1 = new Random();
		return randInRangeMinMax(1, max);
	}

	/**
	 * generate a random number in a specified intervall.
	 * exercise 5.20
	 */
	public int randInRangeMinMax(int min, int max) {
		Random R1 = new Random();
		return R1.nextInt(max+1-min)+min;
	}

		/**
		 * randomly return one of three strings.
		 * exercise 5.18
		 */
		public String getResponse() {
			ArrayList<String> responseList = new ArrayList<String>();
			Random R1 = new Random();
			responseList.add("yes");
			responseList.add("no");
			responseList.add("maybe");
			int index = R1.nextInt(responseList.size());
			return responseList.get(index);
		}

    /**
     * print one random integer number.
     * exercise 5.14
     */
    public void printOneRandom() {
       Random R1 = new Random();
       int randomInteger = R1.nextInt();
       System.out.println(randomInteger);
	}
}
