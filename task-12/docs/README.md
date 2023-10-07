If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**Exercise 1:**

| Size/complexity  |  | log n  | n       | n log n  | n<sup>2</sup>      | n<sup>3</sup>      | 2<sup>n</sup>       | n!        |
|------------------|--|--------|---------|----------|----------|----------|-----------|-----------|
| 1                |  | 0      | 1       | 0        | 1        | 1        | 2         | 1         |
| 10               |  | 3,32   | 10      | 33       | 100      | 1,00E+06 | 1,02E+03  | 3,63E+06  |
| 100              |  | 6,64   | 100     | 664      | 10000    | 1,00E+09 | 1,26E+30  | 9,33E+157 |
| 1000             |  | 9,96   | 1000    | 9966     | 1,00E+06 | 1,00E+12 | 1,00E+301 | 4,00E+2567|
| 10000            |  | 13,29  | 10000   | 132877   | 1,00E+08 | 1,00E+15 | 2,00E+3010| ∞         |
| 100000           |  | 16,61  | 100000  | 1,66E+06 | 1,00E+10 | 1,00E+18 | ∞         | ∞         |
| 1000000          |  | 19,93  | 1000000 | 1,99E+07 | 1,00E+12 | 1,00E+21 | ∞         | ∞         |

**Exercise 2:**

| T(n)    | 1 second | 1 minute | 1 hour   | 1 day    | 1 year   |
|---------|----------|----------|----------|----------|----------|
| log n   | ∞        | ∞        | ∞        | ∞        | ∞        |
| n       | 1,00E+10 | 6,00E+10 | 3,60E+12 | 8,64E+13 | 3,15E+16 |
| n log n | 3,96E+07 | 1,94E+09 | 9,80E+10 | 3,00E+12 | 9,15E+14 |
| n<sup>2</sup>     | 31623    | 2,45E+05 | 1,80E+06 | 9,30E+06 | 1,77E+08 |
| n<sup>3</sup>     | 1000     | 3915     | 15326    | 4,42E+04 | 3,16E+05 |
| 2<sup>n</sup>     | 29,9     | 35,8     | 41       | 46       | 54,8     |
| n!      | 12,29    | 13,86    | 15       | 16,5     | 18,54    |

**Exercise 3:**

List in ascending order base on rate of growth (f4(n) has the slowest rate of growth and f2(n) has the fastest):
f4(n), f3(n), f1(n), f5(n), f2(n) 

The first statemnet is true since it creates an upper bound on the rate of growth of the function, it is not howeer the tightest upper bound like n<sup>2</sup> in the second statement. O(n<sup>25</sup>) would also, according to the definition, create an upper bound and be a valid statement. 
The second statement is also true since the dominating term (in terms of rate of growth) is (n<sup>2</sup>)/2 which can be written as O(n<sup>2</sup>). 
The fourth statement is also true since we can pick a constant m and a constant n0 so that the function f(n) = (n<sup>2</sup>)/2 is always bigger than the function g(n) = n beyond the point n0. 

**Exercise 4:**

Loop1: O(n) <br />
Loop2: O(n) <br />
Loop3: O(n<sup>2</sup>) <br />
Loop4: O(n<sup>2</sup>) <br />
Loop5: O(n<sup>4</sup>) <br />

**Exercise 5:** 


If f(n) = n<sup>3</sup> + 3n<sup>2</sup> + 3n + 1 and g(n) = n<sup>3</sup> , then f(n) = O(g(n)) or f(n) = O(n<sup>3</sup>) because g(n) can be multiplied by a constant c so that it creates an upper bound for f(n) beyond a point on the x-axis n0 (where the x-axis shows the values of n and n0 is a point on that axis). by simplifyig the term (n + 1)<sup>3</sup> we end up with the expression: n<sup>3</sup> + 3n<sup>2</sup> + 3n + 1, which can be simplified to n<sup>3</sup> for larger n:s since that becomes the dominating term in the statement. If we take a look at the graph (graph.png) we can see that the function g(n) = n<sup>3</sup> when scaled by the constant 20, creates an upper bound for the function f(n) beyond (to the right of) the point 0.58 on the x-axis (n0). 

**Exercise 6:**

The basic operation for this algorithm is the A[j] = A[j-1] assignment since it is the dominating operation in the algorithm and the time to execute the operation is constant. 
The time complexity of the algorithm in its implemented form is quadratic O(n<sup>2</sup>). 

**Exercise 7:**

If the collection that is being iterated is already sorted then because of insertion sorts implementation it will only have to scan the collection and determine it to be sorted. This is the best case scenario and yields a time complexity of O(n) for insertion sort. The same is somewhat true for a mostly sorted collection since the insertion sort algorithm won't have to make as many swaps. In the case of seletion sort however it does not matter wether the collection is sorted or not, it will still have a time complexity of O(n<sup>2</sup>). This is because the process of finding the smalles item in one pass through the collection does not give much information about where the smallest item will be on the next pass through. Selection sort therefore always has a time complexity of O(n<sup>2</sup>). Because of this insertion sort is almost always faster than selection sort and should therefore be preferred as a sorting algorithm. 
