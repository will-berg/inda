import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Stefan Nilsson
 * @version 2011-02-07
 */
public final class TimingExample {
    /**
     * If you're using a JVM with just-in-time compilation,
     * chanses are that the first reported time is much
     * larger than the rest: during most of the first
     * invocation of the sum() method, the code has yet
     * to be compiled and optimized.
     */
    public static void main(String[] args) {
        final int reps = 100;
        final int n = 1000000;
        final Stopwatch clock = new Stopwatch();
        ArrayList runTimeValues = new ArrayList();
        long total = 0;
        Data d = new Data(n, n, Data.Order.ASCENDING);
        int[] data;
        QuicksortFixedPivot sort = new QuicksortFixedPivot();

        for (int i = 0; i < reps; i++) {
            data = d.get();

            clock.reset().start();
            {
                sort.sort(data);
            }
            long time = clock.stop().nanoseconds();

            if (i > 1) {
                System.out.printf("Time to run quicksort(%d): %d ns%n", n, time);
                runTimeValues.add(time);
                total += time;
            }
        }
        long maximumTime = (long) Collections.max(runTimeValues);
        long minimumTime = (long) Collections.min(runTimeValues);
        total = total - maximumTime - minimumTime;
        long averageTime = total/(reps-4);

        System.out.println("maximum time: " +maximumTime + " ns");
        System.out.println("minimum time: " +minimumTime + " ns");
        System.out.println("Average time: " +averageTime + " ns");
    }
}
