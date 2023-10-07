public class LogAnalyzer {
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer() {
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData() {
        while (reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts() {
        System.out.println("Hr: Count");
        for (int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Return the number of accesses recorded in the log
     * file.
     */
    // 4.73 and 4.74
    public int numberOfAccesses() {
		int total = 0;
		for (int hour=0; hour < hourCounts.length; hour++) {
			// Add the value in each element of hourCounts // to total
			total += hourCounts[hour];
		}
		return total;
	}

	/**
	 * return the quietest hour.
	 */
	// 4.76
	public int quietestHour() {
    	int quietesthour = 0;
      	for (int hour=0; hour < hourCounts.length; hour++) {
          	if (hourCounts[hour] < hourCounts[quietesthour]) {
              	quietesthour = hour;
            }
  		}
	  	return quietesthour;
	}

	/**
	 * return the first hour of the busiest 2 hour-period.
	 */
	// 4.78
	public int busiest2HourPeriod() {
		int busiesthour = 0;
		for (int hour=0; hour < hourCounts.length-1; hour++) {
			if ((hourCounts[hour] + hourCounts[hour+1]) > ((hourCounts[busiesthour]) + hourCounts[busiesthour+1])) {
				busiesthour = hour;
			}
		}
		return busiesthour;
	}

	/**
	 * return the busiest hour.
	 */
	// 4.75
	public int busiestHour() {
		int busiesthour = 0;
		// We need to check every element in the array since the last one might be the busiest. Because we know that we only need to check the array
		// once, the for loop is the best choice.
		for (int hour=0; hour < hourCounts.length; hour++) {
			if (hourCounts[hour] > hourCounts[busiesthour]) {
				busiesthour = hour;
			}
		}
		return busiesthour;
	}

	/**
	 * Print the lines of data read by the LogfileReader
	*/
	public void printData() {
		reader.printData();
	}
}
