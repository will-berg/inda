### Deadline:
This is a two week assignment with two deadlines:

* Implementation: **Friday 28th February**
* Evaluation: **Friday 13th March**

Work for both weeks will be stored in this repository.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-19/course-instructions#assignments).

### Homework
Study the following course literature:

* [Quicksort Optimizations](https://yourbasic.org/golang/quicksort-optimizations/)
    - **IMPORTANT:** The pseudo code in the above text may be a bit difficult
      to interpret if you have not programmed in Go. Please see
      [this supplement](https://gits-15.sys.kth.se/inda-19/extra-reading-material/blob/master/quicksort/README.md)
      that contains rewritten pseudocode along with some practical tips.

### Overview
There's a lot of information in this repo. Here's an overview of what you need
to accomplish (and submit) for each of the weeks:

* Week 1
    - An insertion sort implementation of the `IntSorter` interface.
    - Four quicksort implementations, detailed in [Variations of Quicksort](#variations-of-quicksort)
    - Test classes for all five production classes, using inheritance to avoid
      test duplication.
    - At least one implementation must be submitted to, and pass, Kattis. At
      least one successful submission id must be pushed to the repo.
* Week 2
    - A class to create runtime tests for the report (this class you will have
      to design yourself).
    - A fancy report.

### Week 1 - Implementing Quicksort
In the first week, you will implement the Quicksort algorithm, as well as
several variations of the basic algorithm. Once you have implemented your set
of algorithms, you can test them by using Kattis.

#### Sort Interface
Each Quicksort algorithm variation should be a single class that implements the
[IntSorter](src/IntSorter.java) interface:

```java
public interface IntSorter {
    /**
     * Sorts the array into ascending numerical order.
     */
    void sort(int[] v);
}
```

This will make it easier to run repeated tests and measurements on different
versions of your algorithms during the empirical evaluation.

##### Warmup
Create an insertion sort implementation of `IntSorter` called `InsertionSort`
as a warmup. If you have already implemented insertion sort, you may reuse your
earlier implementation.  If you have not, this is the algorithm:

```python
Insertion Sort (A)
------------------
1   for i = 1 to A.length - 1
2       j = i
3       while j > 0 and A[j-1] > A[j]
4           temp = A[j]
5           A[j] = A[j-1]
6           A[j-1] = temp
7           j = j - 1
```

It is strongly recommended that you have a look at the
[testing section](#testing) before moving on to implementing quicksort.

#### Variations of Quicksort
Implement four variations of the Quicksort algorithm:

* `QuicksortFixedPivot` - uses a fixed pivot
* `QuicksortRandomPivot` - uses a randomly selected pivot
* `QuicksortFixedPivotInsertion` - fixed pivot with cut-off to insertion sort
  at k.  Instead of stopping the recursion when the sub array only has at most
  one element, implement a version where sub arrays that contain at most `k`
  elements are sorted with insertion sort. `k` can be decided by
  experimentation.
* `QuicksortRandomPivotInsertion` - as above, but with a random pivot

> **Assistant's requirement:** Be very careful in getting the names of the
> classes right, _including capitalization_. For example, it should be
> `QuicksortFixedPivot`, and not `quicksortFixedPivot` or `QuickSortFixedPivot`
> or `quicksortfixedPivot` or ... you get the point.

> **Assistant's requirement** You will probably find that you duplicate some
> code when writing the different Quicksort implementations. Make this
> duplication minimal. It's not okay to have four exact duplicates of the same
> partitioning algorithm.

#### Testing
For the testing this week, you are left to stand pretty much on your own legs.
Draw inspiration from the previous weeks' test suites
([you can find all of them here](https://gits-15.sys.kth.se/inda-19/testing)) if
you find that you have trouble getting started. The important thing here is to
make a good attempt at creating a manageable test suite, it is more important
that you structure it well than that you cover every single corner case
imaginable.

* You have been given a skeleton for an abstract test class called
  [IntSorterTest](src/IntSorterTest.java).
    - For the most basic configuration, **put all your tests in IntSorterTest.**
    - Use the `getIntSorter()` method to instantiate an `IntSorter`.
    - For each of your implementations, extend the test class with an
      implementing test class (e.g. with `QuicksortFixedPivotTest`) and
      implement the `getIntSorter()` method.
    - This is almost identical to the test layout of `week-18` (the graph
      project). Have a look at how `HashGraphTest` and `MatrixGraphTest` extend
      `GraphTest` if you feel lost.
* **Optionally**, feel free to make a more elaborate setup, for example with a
  more specialized abstract test class for the quicksort implementations.
* The sorting tests in week 11's `BoxProcessorTest` may prove helpful. Have a
  look at them if you are feeling lost.
* You will want to test the following types of arrays:
    - Arrays of even and odd length
    - Sorted in ascending order
    - Sorted in descending order (reversed)
    - Random
    - All elements equal
    - Very large arrays (you may want to exclude insertion sort from some of
      these)
    - Use the provided [Data](src/Data.java) class to generate these arrays!
      The main method in said class has some examples of how to use it.

> **Assistant's requirement:** Test class design is as important as production
> class design. You are _not_ allowed to have duplicated tests, use inheritance
> (draw inspiration from the previous weeks) to avoid this. **All test classes
> must inherit from IntSorterTest.**

#### Kattis Test
In addition to the unit tests you write yourself, you should also submit _at
least one_ of your implementations to Kattis. You **absolutely have to register for the DD1338 course** and then submit your solution. Failure to do so will result in kompleterring.

Kattis will test both that your
implementations are correct, and how fast they run (_...perhaps you can become
the champion of inda-19..._). _Note that the run times on Kattis can differ
quite between different runs on the same code, especially if you have randomisation!_

One of the main problems we have with Java is that the **default I/O will be slow**. To make this faster, we can use the [`Kattio`](src/Kattio.java) class provided to significantly speed things up.

> **Assistant's note:** It is really important to realise that we are abusing the constructor here just to overcome the slow I/O used by default on this task. You can still submit your Quicksort submission without using Kattio, but you will incur a time cost of about 2 seconds for I/O. Note, you must submit the Kattio.java file along with your QuickSort.java file when submitting, otherwise an error will occur.

Here is a skeleton `QuickSort` class to give you an idea how to use `Kattio`:

```java
import java.io.IOException;

class QuickSort implements IntSorter {

    public QuickSort() throws IOException {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of elements to sort
        int[] v = new int[n];
        int i = 0;
        // read in problem array
        while (io.hasMoreTokens()) {
            v[i++] = io.getInt();
        }
        sort(v);
        // output sorted array as solution
        for (int k : v) {
            io.println(k);
        }
        io.close();
        System.exit(0);
    }

    public void sort(int[] v) {
        // implement this!
    }
}
```

#### Kattis Submission

**Submit your implementation [here](https://kth.kattis.com/courses/DD1338/algdat19)**. Please note this link may not yet be active, but just check back later. Remember to register for DD1338 in order for your submission to be valid.

**Once you have a successful run, please copy the submission ID and put it in the [docs/submission.txt](docs/submission.txt) file.** There are no limits on the number of submissions, so you can try out your different variations of Quicksort.

### Week 2 - Empirical Evaluation
In the second week, you will perform an empirical evaluation of your
implementation and produce a short report.

#### Timing Execution
The class [StopWatch](src/Stopwatch.java) implements a simple stopwatch for
timing execution. Its usage can be seen in the
[TimingExample](src/TimingExample.java) class.  Run `TimingExample` and pay
attention to the results.  You should notice that the result varies. Modify
`TimingExample` so that it:

* Discard results that are anomalous or affected by JVM warmup
* Finds the average for `n` experiments
* Prints the minimum, mean (average) and maximum times

> **Assistant's note:** A common error is to sort the same array over and over,
> without considering that it will actually be sorted after the first time
> around.  Make sure to utilize the `Data.get()` method properly to get a new
> copy of the array for each sort.

#### Evaluating Sorting Algorithms
The `Data` class has been provided for you to generate different datasets for
evaluating your variations of the Quicksort algorithm. Read the source code to
become familiar on how it is to be used. You should gather results for the
following tests, according to the table template below. Make sure you use the
method you developed above to ensure the results are more accurate and try to
control variables in the computing environment as much as possible.

* Test 1: Random Data
* Test 2: Sorted Data
* Test 3: Reversed Data
* Test 4: Equal Data

Example table of execution time costs for different algorithms and problem
sizes (produce one table per test):

| Test 1: Random Data |               |                          |               |
| ------------------  | ------------- | ------------------------ | ------------- |
| Problem Size        | InsertionSort | Quicksort Variations 1-4 | Arrays.sort † |
| 100                 |               |                          |               |
| 1000                |               |                          |               |
| 10000               |               |                          |               |
| 100000              |               |                          |               |
| 1000000             |               |                          |               |

> **Assistant's note:** For some of the tests, insertion sort will take a
> _very_ long time to run to completion on large porblem sizes. It is fine to
> point out these test cases with a motivation for why they are slow, and put
> something like a few dashes in that cell instead of an execution time.

> **Assistant's other note:** That's _one column per quicksort variation_, not
> one aggregated column for all of them.

† [Arrays.sort(int[] a)](https://zgrepcode.com/java/openjdk/10.0.2/java.base/java/util/arrays.java#L-144)
is from the Java standard library, and for your interest, it also uses
Quicksort, but with a dual-pivot variation with lots of optimisations :-)

#### Report
Finally, you should prepare a short report. The report will contain the
following sections (a template can be found in `docs`):

1. Origins, characteristics and complexity of Quicksort algorithm
2. Explanation of each Quicksort variation you implemented
3. Explanation of each test you performed and how you ensured accurate results
4. Presentation of results using tables and appropriate charts for all tests
5. Discussion of your findings
