### Deadline:
This work should be completed before the exercise on **Friday 6th December**.
Woohoo! Last assignment of the year :)

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-19/course-instructions#assignments).

### Homework
Study the following from the [course text](https://yourbasic.org/algorithms):

- [How to analyze time complexity: Count your steps](https://yourbasic.org/algorithms/time-complexity-explained/)
- [Big O notation: definition and examples](https://yourbasic.org/algorithms/big-o-notation-explained/)

### Github Task: Time Complexity
Complete all the exercises and do the testing!

Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

#### Exercise 1
To develop a sense of the relationship between problem size and an algorithm's
order of growth, complete the table of running times below (we shall
presume that time is the amount of nanoseconds).

- Logarithmic = log<sub>2</sub>(n)
- Linear = n
- Linearithmic = n log n
- Quadratic = n<sup>2</sup>
- Cubic = n<sup>3</sup>
- Exponential = 2<sup>n</sup>
- Factorial = n!

Assume that logarithms are base 2 when you see log n. Give n with 1-2
significant digits. Also assume that the computer performs **1 operation per
nanosecond**. The middle row has been given to act as guidance!

Use [e-notation](https://en.wikipedia.org/wiki/Scientific_notation#E-notation)
for large values (e.g. `3e9` instead of `3*10^9` or `3000000000`)

Absolutely humongous numbers can be rounded off to infinity. Copy the html code
from the 1 hour cell of `logn` in [Exercise 2](#exercise-2) if you want the
actual symbol, or just write `inf`!

| Size / complexity |     log n     |       n       |    n log n    |  n<sup>2</sup>   |  n<sup>3</sup>   |   2<sup>n</sup>  |      n!          |
|-------------------|---------------|---------------|---------------|------------------|------------------|------------------|------------------|
| 1                 |               |               |               |                  |                  |                  |                  |
| 10                |               |               |               |                  |                  |                  |                  |
| 100               |               |               |               |                  |                  |                  |                  |
| 1000              | 9.966         | 1000          | 9966          | 1e6              | 1e9              | 1e301            | 4e2567           |
| 10000             |               |               |               |                  |                  |                  |                  |
| 100000            |               |               |               |                  |                  |                  |                  |
| 1000000           |               |               |               |                  |                  |                  |                  |

[Wolfram Alpha](https://www.wolframalpha.com) is an excellent calculator. For
example, `factorial(100)` will calculate `100!`, and `log2(1000)` will
calculate the base `n` logarithm of 1000 (e.g. replace `n` with `2` for
base 2).

#### Exercise 2
Let T(n) be the time in nanoseconds (1e-9 seconds) to solve a given
problem of size n with a certain algorithm. For each function T(n) and for each
time t in the table, give the largest value of n, for which the algorithm can
solve the problem in time t.

Use [e-notation](https://en.wikipedia.org/wiki/Scientific_notation#E-notation)
for large values (e.g. `3e9` instead of `3*10^9` or `3000000000`)

Absolutely humongous numbers can be rounded off to infinity. Copy the html code
from the 1 hour cell of `logn` if you want the actual symbol, or just write
`inf`!

| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         |          |          | &#x221e; |          |          |
| n             |          |          | 3.6e12   |          |          |
| n log n       |          |          | 9.8e10   |          |          |
| n<sup>2</sup> |          |          | 1.8e6    |          |          |
| n<sup>3</sup> |          |          | 15326    |          |          |
| 2<sup>n</sup> |          |          | 41       |          |          |
| n!            |          |          | 15       |          |          |

> **Assistant's note:** Solving for n in an equation on the form `n*log(n) = x`
> is not possible arithmetically. For the mathematically inclined, the solution
> is approximated by `n = e^W(x)`, where `W` is the
> [Lambert W function](https://en.wikipedia.org/wiki/Lambert_W_function). For
> the _less_ mathematically inclined (like this humble assistant), the
> solution is given by typing `n*log2(n) = x, solve for n` into
> [Wolfram Alpha](https://www.wolframalpha.com) :D.

#### Exercise 3
Arrange the functions in the following list in ascending order based on their
rate of growth. That is, the function f(n) should come before the function g(n)
in the list if f(n) is O(g(n)).

f1(n) = n<sup>1.5</sup>

f2(n) = 10<sup>n</sup>

f3(n) = n log n

f4(n) = n + 100

f5(n) = 2<sup>n</sup>

Which of the following statements are true? Justify your answer.

n (n + 1) / 2 = O(n<sup>3</sup>)

n (n + 1) / 2 = O(n<sup>2</sup>)

n (n + 1) / 2 = Θ(n<sup>3</sup>)

n (n + 1) / 2 = Ω(n)

#### Exercise 4
Give a tight O-estimation, as a function of n, of the worst case time
complexity of the following five loops:

```
Algorithm Loop1(n):
   a = 0
   for i = 1 to n
      a += i

Algorithm Loop2(n):
   b = 1
   for i = 1 to 4n
      b++

Algorithm Loop3(n):
   c = 1
   for i = 1 to n^2
      c--

Algorithm Loop4(n):
   d = 5
   for i = 1 to 3n
      for j = 1 to i
         d = d + j

Algorithm Loop5(n):
   e = 5
   for i = 1 to n^2
      for j = 1 to i
         e = e + j
```

### Exercise 5
Explain why (n+1)<sup>3</sup> is O(n<sup>3</sup>). Use the following
definition: f(n) is O(g(n)) if there exists positive constants c and
n<sub>0</sub> such that f(n) &le; c &times; g(n) for all n &ge; n<sub>0</sub>.

#### Exercise 6
The following algorithm reverses a collection.  Answer the following:

- What is the basic operation for this algorithm?
- Describe the time complexity of this algorithm

```python
Reverse (A):
   # Input: an array A storing n elements.
   # Output: the same array with the elements in reversed order.
   for i = 1 to n-1
       x = A[i]
       for j = i down to 1
           A[j] = A[j-1]
       A[0] = x
```

Design a linear time O(n) algorithm to reverse a collection and implement two
versions in Java, the first with arrays and the second with lists.  

Your implementation should count the number of basic operations to ensure that
the complexity is O(n) for a given collection of size n. Please implement
the two methods in the code skeleton in [`src/Reverse.java`](src/Reverse.java)
(and don't forget to remove the exceptions that are currently thrown!).
See the [Testing](#testing) section for instructions on how to test your
implementations.

> **Assistant's requirement:** Both versions of `reversed` should return a
> reversed _copy_ of the argument, and are _not_ allowed to mutate the
> argument.

#### Exercise 7
Insertion Sort and Selection Sort have similar worst case runtime complexity
O(n<sup>2</sup>).  Explain:

- How they differ in best case (a sorted collection) and mostly sorted case in
  terms of the runtime complexity of each algorithm, and
- Which should be preferred as a sorting algorithm with justification.

### Testing
For this week's testing, you have been provided with a test skeleton with
implementations of tests for `Reverse.reversed(int[])`. Read through
the tests and make sure you understand what they do, and then implement
all of the tests for `Reverse.reversed(List<Integer>)`. The test class
is located in [`src/ReverseTest.java`](src/ReverseTest.java).
As usual, all of the tests that you need to implement hava a _fail_ statement
in them that looks like this:

```java
fail("Not implemented!");
```

Remove these and implement the tests!

### Grading Criteria
Each week we will communicate grading criteria through the [issue tracker](../../issues/). Grading criteria set the basic standards for a pass, komp or fail, so it is essential you review them each week. These will change over time as your skills develop, so make sure you read the grading criteria issue carefully and tick off all the requirements.
